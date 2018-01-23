package br.com.tamanhofamilia.sort;

import java.util.ArrayList;
import java.util.List;

/*
 * Quebra os elementos em partes cada vez menores, ordena essas partes, e deṕois realiza 
 * merge em parte cada vez paiores.
 * 
 *  ex:
 *  9 5 3 1 7
 *  [ 9 5 3 ] [ 1 7 ]
 *  [ [ 9 5 ][ 3 ]] [ 1 7 ]
 *  [ [ 5 9 ][ 3 ]] [ 1 7 ]
 *  -> [ 5 9 ][ 3 ] Merge => [ ]
 *  -> [ 5 9 ][ ] Merge => [ 3 ]
 *  -> [ 9 ][ ] Merge => [ 3 5 ]
 *  -> [ ][ ] Merge => [ 3 5 9 ]
 *  [ 3 5 9 ][ 1 7 ]
 *  -> [ 3 5 9 ][ 1 7 ] Merge => [ ]
 *  -> [ 3 5 9 ][ 7 ] Merge => [ 1 ]
 *  -> [ 5 9 ][ 7 ] Merge => [ 1 3 ]
 *  -> [ 9 ][ 7 ] Merge => [ 1 3 5 ]
 *  -> [ 9 ][ ] Merge => [ 1 3 5 7 ]
 *  -> [ ][ ] Merge => [ 1 3 5 7 9 ]
 *  [ 1 3 5 7 9 ]
 */

public class MergeSort<T> implements Sortable<T>{
	private Comparable<T> comparable;

	public MergeSort(Comparable<T> comparable) {
		this.comparable = comparable;
	}

	@Override
	public void sort(List<T> dados) {
		sort(dados, 0, dados.size()-1);
	}

	private void sort(List<T> dados, final int inicio, final int fim) {
		if (fim - inicio > 1) {
			int medio = (fim+inicio) / 2;
			sort(dados, inicio, medio);
			sort(dados, medio+1, fim);
			
			merge(dados, inicio, medio, fim);
		}
		else if (fim - inicio == 1) {
			T firstData = dados.get(inicio);
			T lastData = dados.get(fim);
			if (comparable.compare(firstData, lastData)<0) {
				dados.set(inicio,lastData);
				dados.set(fim, firstData);
			}
		}
	}

	private void merge(List<T> dados, int inicio, final int limiteMeio, int fim) {
		ArrayList<T> lista = new ArrayList<>(fim-inicio+1);
		int intL1 = inicio, intL2 = limiteMeio +1;
		
		T l1 = dados.get(intL1);
		T l2 = dados.get(intL2);
		
		for(int x = inicio; x<=fim; x++) {
			T menor = null;
			if (l1 == null) menor = l2;
			else if (l2 == null) menor = l1;
			else if (comparable.compare(l1, l2)>0) menor = l1;
			else menor = l2;
			
			if (menor == l1) {
				intL1++;
				l1 = (intL1>limiteMeio) ? null : dados.get(intL1);
			} else {
				intL2++;
				l2 = (intL2>fim) ? null : dados.get(intL2);
			}
			lista.add(menor);
		}
		
		for(int x = inicio; x<=fim; x++) {
			dados.set(x, lista.get(x - inicio));
		}
		
	}
}
