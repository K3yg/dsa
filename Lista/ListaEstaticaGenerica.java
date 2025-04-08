package Lista;
public class ListaEstaticaGenerica<T> {
  private T[] info;
  private int tamanho;

  @SuppressWarnings("unchecked")
  public ListaEstaticaGenerica() {
      this.tamanho = 0;
      this.info = (T[]) new Object[10];
  }

  public void inserir2(int posicao, T valor) {
    if (posicao < 0 || posicao > this.tamanho) {
        throw new IndexOutOfBoundsException("Posição inválida");
    }
    if (this.tamanho == this.info.length) {
        redimensionar();
    }
    for (int i = this.tamanho; i > posicao; i--) {
        this.info[i] = this.info[i - 1];
    }
    this.info[posicao] = valor;
    this.tamanho++;
}

  public int getTamanho() {
      return tamanho;
  }

  @SuppressWarnings("unchecked")
  public void redimensionar() {
      T[] novaLista = (T[]) new Object[this.info.length + 10];
      for (int i = 0; i < this.info.length; i++) {
          novaLista[i] = this.info[i];
      }
      this.info = novaLista;
  }

  public void inserir(T valor) {
      if (this.tamanho == this.info.length) {
          redimensionar();
      }
      this.info[this.tamanho] = valor;
      this.tamanho++;
  }

  public void exibir() {
      for (int i = 0; i < this.tamanho; i++) {
          System.out.print(this.info[i] + " ");
      }
  }

  public String toString() {
      String listaToString = "";
      for (int i = 0; i < this.tamanho; i++) {
          if (i == this.tamanho - 1) {
              listaToString += this.info[i];
          } else {
              listaToString += this.info[i] + ", ";
          }
      }
      return listaToString;
  }

  public int buscar(T valor) {
      for (int i = 0; i < this.tamanho; i++) {
          if (this.info[i].equals(valor)) {
              return i;
          }
      }
      return -1;
  }

  public void retirar(T valor) {
      int posicao = buscar(valor);
      if (posicao != -1) {
          for (int i = posicao; i < this.tamanho - 1; i++) {
              // Move os elementos para a esquerda
              // ex: [1, 2, 3, 4] retirar(2) => [1, 3, 4, 4]
              this.info[i] = this.info[i + 1];
          }
          this.tamanho--;
      }
  }

  @SuppressWarnings("unchecked")
  public void liberar() {
      this.info = (T[]) new Object[10];
      this.tamanho = 0;
  }

  public T obterElemento(int posicao) {
      if (posicao >= 0 && posicao < this.tamanho) {
          return this.info[posicao];
      } else {
          throw new IndexOutOfBoundsException("Posição inválida");
      }
  }

  public boolean estaVazia() {
      return this.tamanho == 0;
  }

  public void inverter() {
      for (int i = 0; i < this.tamanho / 2; i++) {
          T aux = this.info[i];
          this.info[i] = this.info[this.tamanho - 1 - i];
          this.info[this.tamanho - 1 - i] = aux;
      }
  }
}
