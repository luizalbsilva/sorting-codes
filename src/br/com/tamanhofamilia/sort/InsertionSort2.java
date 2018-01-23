package br.com.tamanhofamilia.sort;

import java.util.List;

/*
 * Inicia a varredura da lista, cambiando o item pelo anterior sempre que o anterior estiver fora 
 * de ordem. 
 */

public class InsertionSort2<T> implements Sortable<T> {
	private Comparable<T> comparable;

	public InsertionSort2(Comparable<T> comparable) {
		this.comparable = comparable;
	}

	@Override
	public void sort(List<T> dados) {
		outter:for(int x=1; x<dados.size(); x++) {
			for (int y=x; y>0; y--) {
				T atual = dados.get(y);
				T anterior = dados.get(y-1);
				if (comparable.compare(atual, anterior) > 0) {
					dados.set(y, anterior);
					dados.set(y-1, atual);					
				}
				else
					continue outter;
			}
		}
	}
}
