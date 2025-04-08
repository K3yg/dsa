package PilhaEstatica;

public interface Pilha<T> {
  public void push(T info);
  public T pop();
  public T peek();
  public Boolean estaVazia();
  public void liberar();
}
