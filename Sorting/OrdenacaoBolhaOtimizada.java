package Sorting;
public class OrdenacaoBolhaOtimizada<T extends Comparable<T>> extends OrdenacaoAbstract<T> {
    @Override
    public void ordenar() {
        if (info == null || info.length <= 1) {
            return;
        }
        
        boolean trocou;
        for (int i = info.length - 1; i >= 1; i--) {
            trocou = false;
            for (int j = 0; j < i; j++) {
                if (info[j].compareTo(info[j + 1]) > 0) {
                    trocar(j, j + 1);
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
    }
}