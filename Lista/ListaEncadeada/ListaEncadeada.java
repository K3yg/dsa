package Lista.ListaEncadeada;
public class ListaEncadeada<T> {
  private NoLista<T> primeiro;

  public ListaEncadeada() {
    this.primeiro = null;
  }
   
  public NoLista<T> getPrimeiro() {
    return this.primeiro;
  }

  public void inserir(T info){
    NoLista<T> novoNoLista = new NoLista<>();
    novoNoLista.setInfo(info);
    novoNoLista.setProximo(primeiro);
    this.primeiro = novoNoLista;
  }

  public boolean estaVazia(){
    return this.primeiro == null;
  }

  public NoLista<T> buscar(T valor){
    NoLista<T> p = this.primeiro;
    while (p != null) {
      if (p.getInfo() == valor) {
        return p;  
      }
      p = p.getProximo();
    }
    return null;
  }

  public void retirar(T valor){
    NoLista<T> anterior = null;
    NoLista<T> p = primeiro;

    while (p != null && p.getInfo() != valor) {
      anterior = p;
      p = p.getProximo();
    }
    if (p != null && p == this.primeiro) {
      this.primeiro = p.getProximo();
    } else {
      anterior.setProximo(p.getProximo());
    }
  }

  public void exibir(){
    NoLista<T> p = this.primeiro;
    while (p != null) {
      System.out.println(p.getInfo());
      p = p.getProximo();
    }
  }

  public int obterComprimento(){
    int comprimento = 0;
    NoLista<T> p = this.primeiro;
    while (p != null) {
      comprimento++;
      p = p.getProximo();
    }
    return comprimento;
  }

  public NoLista<T> obterNo(int index){
    int comprimento = obterComprimento();
    if (index < 0 || index > comprimento-1) {
      throw new IndexOutOfBoundsException("Posição inválida");
    }

    NoLista<T> p = this.primeiro;
    int contador = 0;
    while (p != null) {
      if (contador == index){
        return p;
      }
      contador++;
      p = p.getProximo(); 
    }
    throw new IndexOutOfBoundsException("Posição inválida");
  }
  
  public String toString(){
    if (primeiro == null) return "";

    NoLista<T> p = primeiro;
    String resultado = p.getInfo().toString();
    p = p.getProximo();

    while (p != null) {
        resultado += ", " + p.getInfo();
        p = p.getProximo();
    }

    return resultado;
  }

  public ListaEncadeada<T> criarInvertida(){
    ListaEncadeada<T> invertida = new ListaEncadeada<>();
    NoLista<T> p = this.primeiro;

    while (p != null) {
      invertida.inserir(p.getInfo());
      p = p.getProximo();
    }

    return invertida;
  }

}
