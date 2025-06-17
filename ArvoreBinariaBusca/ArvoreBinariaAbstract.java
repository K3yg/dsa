package ArvoreBinariaBusca;

public abstract class ArvoreBinariaAbstract<T> {
    protected NoArvoreBinaria<T> raiz;

    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

    public boolean pertence(T info) {
        return buscar(info) != null;
    }

    public String toString() {
        return toString(this.raiz);
    }

    private String toString(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        return "<" + no.getInfo() + toString(no.getEsquerda()) + toString(no.getDireita()) + ">";
    }

    public int contarNos() {
        return contarNos(this.raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }

    public abstract NoArvoreBinaria<T> buscar(T info);
}
