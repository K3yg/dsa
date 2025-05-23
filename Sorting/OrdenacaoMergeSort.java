package Sorting;

public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {
    @Override
    public void ordenar() {
        if (info == null || info.length <= 1) {
            return;
        }
        mergeSort(0, info.length - 1);
    }
    
    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, fim, meio);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void merge(int inicio, int fim, int meio) {
        T[] aux = (T[]) new Comparable[fim - inicio + 1];
        int i = inicio;
        int j = meio + 1;
        int k = 0;
        
        while (i <= meio && j <= fim) {
            if (info[i].compareTo(info[j]) <= 0) {
                aux[k++] = info[i++];
            } else {
                aux[k++] = info[j++];
            }
        }
        
        while (i <= meio) {
            aux[k++] = info[i++];
        }
        
        while (j <= fim) {
            aux[k++] = info[j++];
        }
        
        for (i = inicio, k = 0; i <= fim; i++, k++) {
            info[i] = aux[k];
        }
    }
}