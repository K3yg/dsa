public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica();
        for (int i = 1; i < 5; i++) {
            lista.inserir(i*5);
        }
        System.out.print("Após a inserção dos valores, temos: ");
        System.out.println(lista);

        System.out.println("Tamanho da lista: " + lista.getTamanho());

        System.out.println("Buscando o valor 15 na lista: " + lista.buscar(15));
        System.out.println("Buscando o valor 30 na lista: " + lista.buscar(30));

        lista.retirar(10);

        System.out.print("Após a retirada do valor 10, temos: ");
        System.out.println(lista);

        System.out.println("Tamanho da lista: " + lista.getTamanho());

        ListaEstatica lista2 = new ListaEstatica();
        for (int i = 1; i < 16; i++) {
            lista2.inserir(i);
        }

        System.out.print("Após a inserção dos valores, temos: ");
        System.out.println(lista2);

        System.out.println("Tamanho da lista: " + lista2.getTamanho());

        lista2.liberar();

        System.out.print("Após a liberação da lista, temos: ");
        System.out.println(lista2 + "[vazia]");
        System.out.println("Está vazia?  " + lista2.estaVazia());

        System.out.println("Obtendo o valor na posição 3: " + lista.obterElemento(2));
        System.out.println("Obtendo o valor na posição 5 (não existe): " + lista.obterElemento(5));

        // fix > create Test cases
        @Test
        public void testarObterElemento() {
           lista.inserir(5);
           lista.inserir(10);
           lista.inserir(15);
            
            try {
               lista.obterElemento(5);
               fail();
            } catch (IndexOutOfBoundsException e){
                // passou o teste, já que ao obter um elemento que não existe
                // retornou erro
            };
        }

    }
}
