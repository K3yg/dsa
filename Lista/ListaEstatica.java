package Lista;
public class ListaEstatica extends IndexOutOfBoundsException {
    private int[] info;
    private int tamanho;

    public int getTamanho() {
        return tamanho;
    }

    public ListaEstatica() {
        this.tamanho = 0;
        this.info = new int[10];
    }

    public void redimensionar() {
      int novaLista[] = new int[this.info.length + 10];
      for (int i = 0; i < this.info.length; i++) {
          novaLista[i] = this.info[i];
      }
      this.info = novaLista;
    }

    public void inserir(int valor) {
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

    public int buscar(int valor) {
      for (int i = 0; i < this.tamanho; i++) {
          if (this.info[i] == valor) {
              return i;
          }
      }
      return -1;
    }

    public void retirar(int valor) {
      int posicao = buscar(valor);
      if (posicao != -1) {
        for (int i = posicao; i < this.tamanho - 1; i++) {
          // Move os elementos para a esquerda
          //ex: [1, 2, 3, 4] retirar(2) => [1, 3, 4, 4]
          this.info[i] = this.info[i + 1];
        }
        this.tamanho--;
      }
    }
  
    public void liberar() {
      this.info = new int[10];
      this.tamanho = 0;
    }

    public int obterElemento(int posicao) {
      if (posicao >= 0 && posicao < this.tamanho) {
        return this.info[posicao];
      } else {
        throw new IndexOutOfBoundsException("Posição inválida");
      }
    }

    public boolean estaVazia() {
      return this.tamanho == 0;
    }
}