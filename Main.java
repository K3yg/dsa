import PilhaEstatica.PilhaVetor;

public class Main {
    public static void main(String[] args) {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(6);
        PilhaVetor<Integer> pilha2 = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha2.push(50);
        pilha2.push(40);
        pilha2.push(90);

        pilha.concatenar(pilha2);

        System.out.println(pilha);
    }
}
