package br.com.tamanhofamilia.sort;

import java.util.List;

/*
 * Compara cada item com seu vizinho, até que todos estejam ordenados. 
 */
public class BubbleSort<T> implements Sortable<T> {
	private final Comparable<T> comparador;
	
	public BubbleSort(Comparable<T> comparador) {
		this.comparador = comparador;
	}
	
	@Override
	public final void sort(List<T> dados ) {
		boolean repetir = false;
		
		if (dados.size() > 1)
			do {
				repetir = false;
				for(int x=1;x < dados.size(); x++)
					if (comparador.compare(dados.get(x-1), dados.get(x)) < 0) {
						T tmp = dados.get(x-1);
						dados.set(x-1, dados.get(x));
						dados.set(x, tmp);
						repetir = true;
					}
			} while(repetir);
	}

}
