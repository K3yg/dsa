import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;

public class ValidadorHTML {
    private static final String[] TAGS_SINGLETON = {
        "meta", "base", "br", "col", "command", "embed", "hr", 
        "img", "input", "link", "param", "source", "!doctype"
    };
    
    private JFrame janela;
    private JTextField campoCaminhoArquivo;
    private JTextArea areaResultado;
    private JButton botaoAnalisar;
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ValidadorHTML().inicializar();
        });
    }
    
    private void inicializar() {
        janela = new JFrame("Validador de HTML");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(600, 500);
        
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel painelEntrada = new JPanel(new BorderLayout(5, 5));
        painelEntrada.add(new JLabel("Arquivo:"), BorderLayout.WEST);
        campoCaminhoArquivo = new JTextField();
        painelEntrada.add(campoCaminhoArquivo, BorderLayout.CENTER);
        
        botaoAnalisar = new JButton("Analisar");
        botaoAnalisar.addActionListener(this::acaoAnalisar);
        painelEntrada.add(botaoAnalisar, BorderLayout.EAST);
        
        painel.add(painelEntrada, BorderLayout.NORTH);
        
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        painel.add(new JScrollPane(areaResultado), BorderLayout.CENTER);
        
        janela.add(painel);
        janela.setVisible(true);
    }
    
    private void acaoAnalisar(ActionEvent e) {
        String caminho = campoCaminhoArquivo.getText().trim();
        if (caminho.isEmpty()) {
            JOptionPane.showMessageDialog(janela, "Informe o caminho do arquivo!");
            return;
        }
        
        try {
            validarHTML(caminho);
        } catch (Exception ex) {
            areaResultado.setText("Erro: " + ex.getMessage());
        }
    }
    
    private void validarHTML(String caminho) throws Exception {
        PilhaLista<String> pilha = new PilhaLista<>();
        ListaEncadeada<String> tags = new ListaEncadeada<>();
        
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminho))) {
            String linha;
            int numeroLinha = 0;
            
            while ((linha = leitor.readLine()) != null) {
                numeroLinha++;
                linha = linha.trim();
                if (linha.isEmpty()) continue;
                
                int posicao = 0;
                while (posicao < linha.length()) {
                    int inicioTag = linha.indexOf('<', posicao);
                    if (inicioTag == -1) break;
                    
                    int fimTag = linha.indexOf('>', inicioTag);
                    if (fimTag == -1) {
                        throw new Exception("Tag não fechada na linha " + numeroLinha);
                    }
                    
                    String conteudo = linha.substring(inicioTag + 1, fimTag).trim();
                    posicao = fimTag + 1;
                    
                    if (conteudo.startsWith("!--") || conteudo.startsWith("!DOCTYPE")) continue;
                    
                    String nomeTag = extrairNomeTag(conteudo);
                    if (nomeTag.isEmpty()) continue;
                    
                    if (conteudo.startsWith("/")) {
                        validarTagFechamento(pilha, nomeTag, numeroLinha);
                    } else {
                        processarTagAbertura(pilha, nomeTag);
                    }
                    tags.inserir(nomeTag.toLowerCase());
                }
            }
            
            validarTagsNaoFechadas(pilha);
            exibirResultadoOrdenado(tags);
        }
    }
    
    private String extrairNomeTag(String conteudo) {
        int espaco = conteudo.indexOf(' ');
        if (espaco != -1) {
            return conteudo.substring(0, espaco).replace("/", "");
        }
        return conteudo.replace("/", "");
    }
    
    private boolean ehSingleton(String tag) {
        for (String singleton : TAGS_SINGLETON) {
            if (singleton.equalsIgnoreCase(tag)) return true;
        }
        return false;
    }
    
    private void validarTagFechamento(PilhaLista<String> pilha, String tag, int numeroLinha) throws Exception {
        String tagFechamento = tag.toLowerCase();
        if (pilha.estaVazia()) {
            throw new Exception("Erro linha " + numeroLinha + ": </" + tagFechamento + "> sem abertura correspondente");
        }
        
        String esperada = pilha.pop().toLowerCase();
        if (!esperada.equals(tagFechamento)) {
            throw new Exception("Erro linha " + numeroLinha + ": Esperado </" + esperada + "> mas encontrado </" + tagFechamento + ">");
        }
    }
    
    private void processarTagAbertura(PilhaLista<String> pilha, String tag) {
        if (!ehSingleton(tag)) {
            pilha.push(tag.toLowerCase());
        }
    }
    
    private void validarTagsNaoFechadas(PilhaLista<String> pilha) throws Exception {
        if (!pilha.estaVazia()) {
            StringBuilder sb = new StringBuilder("Tags não fechadas:\n");
            while (!pilha.estaVazia()) {
                sb.append("</").append(pilha.pop()).append(">\n");
            }
            throw new Exception(sb.toString());
        }
    }
    
    private void exibirResultadoOrdenado(ListaEncadeada<String> tags) {
        String[] arrayTags = converterParaArray(tags);
        
        OrdenacaoQuickSort<String> quicksort = new OrdenacaoQuickSort<>();
        quicksort.setInfo(arrayTags);
        quicksort.ordenar();
        
        areaResultado.setText("Documento HTML válido!\n\nTags ordenadas:\n");
        contarEExibirOcorrencias(quicksort.getInfo());
    }
    
    private String[] converterParaArray(ListaEncadeada<String> lista) {
        String[] array = new String[lista.obterComprimento()];
        for (int i = 0; i < array.length; i++) {
            array[i] = lista.obterNo(i).getInfo();
        }
        return array;
    }
    
    private void contarEExibirOcorrencias(String[] tags) {
        if (tags.length == 0) return;
        
        int contador = 1;
        String atual = tags[0];
        
        for (int i = 1; i < tags.length; i++) {
            if (tags[i].equals(atual)) {
                contador++;
            } else {
                areaResultado.append(String.format("%-15s: %d ocorrências\n", atual, contador));
                atual = tags[i];
                contador = 1;
            }
        }
        areaResultado.append(String.format("%-15s: %d ocorrências\n", atual, contador));
    }
}

// Implementações das estruturas de dados
class PilhaLista<T> {
    private ListaEncadeada<T> lista = new ListaEncadeada<>();

    public void push(T info) {
        lista.inserir(info);
    }

    public T pop() {
        T valor = peek();
        lista.retirar(valor);
        return valor;
    }

    public T peek() {
        if (lista.estaVazia()) {
            throw new RuntimeException("Pilha vazia");
        }
        return lista.getPrimeiro().getInfo();
    }

    public boolean estaVazia() {
        return lista.estaVazia();
    }
}

class ListaEncadeada<T> {
    private NoLista<T> primeiro;

    public void inserir(T info) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        primeiro = novo;
    }

    public NoLista<T> obterNo(int index) {
        NoLista<T> atual = primeiro;
        for (int i = 0; atual != null && i < index; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    public int obterComprimento() {
        int contador = 0;
        NoLista<T> atual = primeiro;
        while (atual != null) {
            contador++;
            atual = atual.getProximo();
        }
        return contador;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void retirar(T valor) {
        NoLista<T> anterior = null;
        NoLista<T> atual = primeiro;
        
        while (atual != null && !atual.getInfo().equals(valor)) {
            anterior = atual;
            atual = atual.getProximo();
        }
        
        if (atual != null) {
            if (anterior == null) {
                primeiro = atual.getProximo();
            } else {
                anterior.setProximo(atual.getProximo());
            }
        }
    }
}

class NoLista<T> {
    private T info;
    private NoLista<T> proximo;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoLista<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoLista<T> proximo) {
        this.proximo = proximo;
    }
}

abstract class OrdenacaoAbstract<T extends Comparable<T>> {
    protected T[] info;

    public void setInfo(T[] info) {
        this.info = info;
    }

    public T[] getInfo() {
        return info;
    }

    public void trocar(int a, int b) {
        T temp = info[a];
        info[a] = info[b];
        info[b] = temp;
    }

    public abstract void ordenar();
}

class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {
    @Override
    public void ordenar() {
        quickSort(0, info.length - 1);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionar(inicio, fim);
            quickSort(inicio, pivo - 1);
            quickSort(pivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        T pivo = info[inicio];
        int i = inicio;
        int j = fim + 1;

        while (true) {
            do i++; while (i <= fim && info[i].compareTo(pivo) < 0);
            do j--; while (j >= inicio && info[j].compareTo(pivo) > 0);
            if (i >= j) break;
            trocar(i, j);
        }
        trocar(inicio, j);
        return j;
    }
}