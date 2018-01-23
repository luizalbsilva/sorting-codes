package br.com.tamanhofamilia.sort;

import java.util.List;

/*
 * A primeira posição é cambiada com o menor valor, a segunda
 * posição é cambiada pelo segundo menor valor, e assim
 * por diante. 
 */

public class SelectionSort<T> implements Sortable<T> {
	private final Comparable<T> comparable;

	public SelectionSort(Comparable<T> comparable) {
		this.comparable = comparable;
	}

	@Override
	public void sort(List<T> dados) {
		for(int x = 0; x< dados.size()-1; x++) {
			T menor = dados.get(x);
			int index = x;
			
			for(int y = x+1; y < dados.size(); y++) {
				T val = dados.get(y);
				if (comparable.compare(menor, val)<0) {
					index = y;
					menor = val;
				}
			}
			
			if (x!=index) {
				dados.set(index, dados.get(x));
				dados.set(x, menor);
			}
		}
		
	}
}
