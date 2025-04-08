package Pilha;

public class PilhaVetor<T> implements Pilha<T> {
  private T[]info;
  private int limite;
  private int tamanho;

  @SuppressWarnings("unchecked")
  public PilhaVetor(int limite) {
    this.info = (T[]) new Object[limite];
    this.limite = limite;
    this.tamanho = 0;
  }

  public void push(T valor) {
    if (this.limite == this.tamanho) {
      throw new PilhaCheiaException();
    }
    info[tamanho] = valor;
    tamanho++;
  }

  public T pop(){
    T valor;
    valor = peek();
    tamanho--;

    return valor;
  }

  public T peek(){
    if (this.estaVazia()) {
      throw new PilhaVaziaException();
    }
    return info[tamanho - 1];
  }

  public Boolean estaVazia(){
    if (tamanho == 0) {
      return true;
    }
    return false;
  }

  public void liberar(){
    while (tamanho > 0){
      pop();
    }
  } 

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < this.tamanho; i++) {
      result.append(this.info[i]);
      if (i < this.tamanho - 1) {
        result.append(", ");
      }
    }
    return result.toString();
  }

  public void concatenar(PilhaVetor<T> p) {
    int tamanhoTotal = this.tamanho + p.tamanho;
    if (tamanhoTotal < this.limite) {
      throw new PilhaCheiaException();
    }
    for(int i = 0; i < p.tamanho; i++) {
      this.push(p.info[i]);
    }

  }
}
