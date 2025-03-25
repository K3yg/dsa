import Lista.ListaDupla.ListaDupla;
import Lista.ListaDupla.NoListaDupla;

public class Main {
    public static void main(String[] args) {
        ListaDupla<Integer> lista = new ListaDupla<>();

        // Inserindo os valores na lista
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        // Buscando os nós antes da liberação
        NoListaDupla<Integer> no5 = lista.buscar(5);
        NoListaDupla<Integer> no10 = lista.buscar(10);
        NoListaDupla<Integer> no15 = lista.buscar(15);
        NoListaDupla<Integer> no20 = lista.buscar(20);

        // Exibindo a lista antes da liberação
        System.out.println("Lista antes da liberação: " + lista);

        // Liberando a lista
        lista.liberar();

        // Verificando se os nós perderam as referências
        System.out.println("Após liberar a lista:");
        System.out.println("No 5: anterior = " + no5.getAnterior() + ", proximo = " + no5.getProximo());
        System.out.println("No 10: anterior = " + no10.getAnterior() + ", proximo = " + no10.getProximo());
        System.out.println("No 15: anterior = " + no15.getAnterior() + ", proximo = " + no15.getProximo());
        System.out.println("No 20: anterior = " + no20.getAnterior() + ", proximo = " + no20.getProximo());

        // Verificando se a lista está vazia
        System.out.println("Lista após liberação: " + lista);

    }
}
