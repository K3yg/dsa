package MapaDispersao;

import Lista.ListaEncadeada.ListaEncadeada;
import Lista.ListaEncadeada.NoLista;

public class MapaDispersao<T> {
  private ListaEncadeada<NoMapa<T>>[] info;

  public MapaDispersao(int tamanho) {
    this.info = new ListaEncadeada[tamanho];
  }

  private int calcularHash(int chave) {
    return chave % this.info.length;
  }

  public void inserir(int chave, T dado) {
    int indice = calcularHash(chave);
    if (info[indice] == null) {
      info[indice] = new ListaEncadeada<>();
    }

    NoMapa<T> novo = new NoMapa<>(chave, dado);

    NoLista<NoMapa<T>> existente = info[indice].buscar(novo);
    if (existente != null) {
      existente.getInfo().setValor(dado);
    } else {
      info[indice].inserir(novo);
    }
  }

  public T buscar(int chave) {
    int indice = calcularHash(chave);
    if (info[indice] != null) {
      NoMapa<T> procurado = new NoMapa<>(chave, null);
      NoLista<NoMapa<T>> resultado = info[indice].buscar(procurado);
      if (resultado != null) {
        return resultado.getInfo().getValor();
      }
    }
    return null;
  }

  public double calcularFatorCarga() {
    int elementos = 0;
    for (ListaEncadeada<NoMapa<T>> lista : info) {
      if (lista != null) {
        elementos += lista.obterComprimento();
      }
    }
    return (double) elementos / info.length;
  }
}
