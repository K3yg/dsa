package Sorting;
public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T> {
    @Override
    public void ordenar() {
        if (info == null || info.length <= 1) {
            return;
        }
        
        for (int i = info.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (info[j].compareTo(info[j + 1]) > 0) {
                    trocar(j, j + 1);
                }
            }
        }
    }
}