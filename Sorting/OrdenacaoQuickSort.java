package Sorting;

public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        if (info == null || info.length <= 1) return;
        quickSort(0, info.length - 1);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(inicio, fim);
            quickSort(inicio, indicePivo - 1);
            quickSort(indicePivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        T pivo = info[inicio];
        int a = inicio;
        int b = fim + 1;

        while (true) {
            // Encontra elemento maior que o pivô
            do {
                a++;
            } while (a <= fim && info[a].compareTo(pivo) < 0);

            // Encontra elemento menor que o pivô
            do {
                b--;
            } while (b >= inicio && info[b].compareTo(pivo) > 0);

            if (a >= b) break;
            trocar(a, b); // Usa o método da classe pai
        }

        // Posiciona o pivô corretamente
        trocar(inicio, b);
        return b;
    }
}