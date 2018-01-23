package br.com.tamanhofamilia.sort;

import java.util.List;

/*
 * Escolhe-se um número como pivot, e vai-se cambiando sua posição de modo com que
 * os números menores sejam enviados para a esquerda, e os maiores para a direita.
 * Recursivamente, envia a lista de menores e maiores para o mesmo processo, até 
 * que a lista esteja ordenada
 */

public class QuickSort<T> implements Sortable<T> {
	private Comparable<T> comparable;

	public QuickSort(Comparable<T> comparable) {
		this.comparable = comparable;
	}

	@Override
	public void sort(List<T> dados) {
		if (dados.size() > 1)
			sort(dados, 0, dados.size()-1);
	}

	private void sort(final List<T> dados, final int inicio, final int fim) {
		int pivotPos = inicio, loPos = inicio, hiPos = fim;
		T pivot = dados.get(pivotPos);
		
		while (pivotPos != loPos || pivotPos != hiPos) {
			while(hiPos > pivotPos) {
				T atual = dados.get(hiPos);
				if (comparable.compare(pivot, atual)<=0) {
					dados.set(pivotPos, atual);
					dados.set(hiPos, pivot);
					pivotPos = hiPos;
					break;
				}
				hiPos--;
			}
			while(loPos < pivotPos) {
				T atual = dados.get(loPos);
				if (comparable.compare(pivot, atual)>=0) {
					dados.set(pivotPos, atual);
					dados.set(loPos, pivot);
					pivotPos = loPos;
					break;
				}
				loPos++;
				
			}
		}
		if (pivotPos - inicio > 2)
			sort(dados, inicio, pivotPos-1);
		if(fim - pivotPos > 2)
			sort(dados, pivotPos+1, fim);
	}
}
