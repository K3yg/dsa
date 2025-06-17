package ArvoreBinariaBusca;

public class ArvoreBinaria<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {
    public void inserir(T valor) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<>(valor);
        if (raiz == null) {
            raiz = novo;
            return;
        }
        NoArvoreBinaria<T> atual = raiz;
        while (true) {
            if (valor.compareTo(atual.getInfo()) < 0) {
                if (atual.getEsquerda() == null) {
                    atual.setEsquerda(novo);
                    return;
                }
                atual = atual.getEsquerda();
            } else {
                if (atual.getDireita() == null) {
                    atual.setDireita(novo);
                    return;
                }
                atual = atual.getDireita();
            }
        }
    }

    public void remover(T valor) {
        raiz = remover(raiz, valor);
    }

    private NoArvoreBinaria<T> remover(NoArvoreBinaria<T> no, T valor) {
        if (no == null) return null;
        
        if (valor.compareTo(no.getInfo()) < 0) {
            no.setEsquerda(remover(no.getEsquerda(), valor));
        } else if (valor.compareTo(no.getInfo()) > 0) {
            no.setDireita(remover(no.getDireita(), valor));
        } else {
            // Nó encontrado
            if (no.getEsquerda() == null) return no.getDireita();
            if (no.getDireita() == null) return no.getEsquerda();
            
            // Nó com dois filhos
            NoArvoreBinaria<T> sucessor = encontrarMenor(no.getDireita());
            no.setInfo(sucessor.getInfo());
            no.setDireita(remover(no.getDireita(), sucessor.getInfo()));
        }
        return no;
    }

    private NoArvoreBinaria<T> encontrarMenor(NoArvoreBinaria<T> no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }

    @Override
    public NoArvoreBinaria<T> buscar(T valor) {
        NoArvoreBinaria<T> p = raiz;
        while (p != null) {
            if (valor.equals(p.getInfo())) return p;
            if (valor.compareTo(p.getInfo()) < 0) p = p.getEsquerda();
            else p = p.getDireita();
        }
        return null;
    }
}
