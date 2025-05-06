package Fila.FilaVetor;
import Fila.Fila;

public class FilaVetor<T> implements Fila<T>{
  private T[] info;
  private int limite;
  private int tamanho;
  private int inicio;

  @SuppressWarnings("unchecked")
  public FilaVetor(int limite) {
    this.info = (T[]) new Object[limite];
    this.limite = limite;
    this.tamanho = 0;
    this.inicio = 0;
  }

  public void inserir(T valor) {
    if (this.limite == this.tamanho) {
      throw new RuntimeException("Fila está cheia");
    }
    int posicao = (inicio + tamanho) % limite;
    info[posicao] = valor;
    tamanho++;
  }

  public T peek() {
    if (this.estaVazia()) {
      throw new RuntimeException("Fila está vazia");
    }
    return info[inicio];
  }

  public T retirar() {
    if (this.estaVazia()) {
      throw new RuntimeException("Fila está vazia");
    }
    T valor = info[inicio];
    inicio = (inicio + 1) % limite;
    tamanho--;
    return valor;
  }

  public boolean estaVazia() {
    return tamanho == 0;
  }

  public void liberar() {
    while (!estaVazia()) {
      retirar();
    }
  }

  public String toString() {
    String result = "";
    for (int i = 0; i < this.tamanho; i++) {
      result += this.info[(inicio + i) % limite];
      if (i < this.tamanho - 1) {
        result += ", ";
      }
    }
    return result;
  }

  public int getLimite() {
    return limite;
  }

}
