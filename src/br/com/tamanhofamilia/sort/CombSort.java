package br.com.tamanhofamilia.sort;

import java.util.List;

/*
 * Variação de BubbleSort, só que, ao invés de ordenar com seus vizinhos imediatos, realiza a ordenação
 * com um GAP, calculado entre cada iteração.
 * Inicialmente o GAP corresponde a 1/1.247330950103979 do tamanho da lista, e a cada iteração o GAP 
 * diminui na mesma razão, até o mínimo de 1.
 */

public class CombSort<T> implements Sortable<T>{
	private static double FATOR = 1.247330950103979;
	
	private final Comparable<T> comparable;

	public CombSort(Comparable<T> comparable) {
		this.comparable = comparable;
	}

	@Override
	public void sort(List<T> dados) {
		int gap = dados.size();
		boolean terminou = false;
		
		
		while(! terminou) {
			if (gap == 1) terminou = true;
			gap =(int) (gap / FATOR);
			if (gap<1) gap = 1;
			
			for(int inicio = 0, comparado = gap;comparado<dados.size(); comparado++, inicio++) {
				T dataInicial = dados.get(inicio);
				T dataFinal = dados.get(comparado);
				if (comparable.compare(dataInicial, dataFinal)<0) {
					dados.set(inicio, dataFinal);
					dados.set(comparado, dataInicial);
					terminou = false;
				}
			}
		};
	}
	
	
}
