import Pilha.PilhaLista.PilhaLista;

public class Main {
    public static void main(String[] args) {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
        
        System.out.println(pilha);

        pilha.pop();

        System.out.println(pilha);


    }
}
