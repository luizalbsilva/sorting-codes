package br.com.tamanhofamilia.sort;

import java.util.List;

/*
 * Variação do InsertSort, mas começa com um GAP que vai diminuindo a cada iteração.
 * O salto obedece a seguinte regra: h(s) = 3h(s-1)+1
 */
public class ShellSort<T> implements Sortable<T> {
	private final Comparable<T> comparable;

	public ShellSort(Comparable<T> comparable) {
		this.comparable = comparable;}

	@Override
	public void sort(List<T> dados) {
		int hiLim = dados.size()-1;
		int salto = calculaSalto(hiLim);
		do {
			salto = (salto-1)/3;
			if (salto < 1) salto = 1;
			
			for(int x=salto; x <= hiLim; x++) {
				for(int y = x - salto; y >= 0; y-=salto) {
					T ant = dados.get(y);
					T post = dados.get(y + salto);
					if (comparable.compare(ant, post)<0) {
						dados.set(y, post);
						dados.set(y+salto, ant);						
					}
				}
			}
		} while(salto>1);
	}

	private int calculaSalto(int size) {
		int h = 1;
		for(;h<size;h = 3*h+1);
		return h;
	}
}
