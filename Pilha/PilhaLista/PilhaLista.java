package Pilha.PilhaLista;

import Lista.ListaEncadeada.ListaEncadeada;
import Pilha.Pilha;

public class PilhaLista<T> implements Pilha<T> {
  private ListaEncadeada<T> lista;

  public PilhaLista(){
    this.lista = new ListaEncadeada<>();
  }

  public void push(T info){
    lista.inserir(info);
  }

  public T pop(){
    T valor;
    valor = peek();
    lista.retirar(valor);

    return valor;
  }

  public T peek(){
    if (lista.estaVazia()) {
      throw new RuntimeException();
    }

    return lista.getPrimeiro().getInfo();
  }

  public Boolean estaVazia(){
    return lista.estaVazia();
  }

  public void liberar(){
    while (!lista.estaVazia()) {
      this.pop();
    }
  }
  
  public String toString() {
    return lista.toString();
  }

}
