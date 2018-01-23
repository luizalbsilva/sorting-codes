package br.com.tamanhofamilia.sort;

import java.util.List;

/*
 * Inicia a varredura, procurando um item que seja maior que o próximo vizinho, à esquerda. Se encontra,
 * o vizinho é colocado em seu lugar, e verifica-se novamente se é menor que o à esquerda do anterior, até não seja, 
 * então o valor é posicionado à sua direita.
 * Retorma-se as comparações da posição de onde iniciou-se as troca, até o final da lista.
 */


public class InsertionSort<T> implements Sortable<T> {
	private Comparable<T> comparable;

	public InsertionSort(Comparable<T> comparable) {
		this.comparable = comparable;
	}

	@Override
	public void sort(List<T> dados) {
		outter:for (int x=1;x < dados.size(); x++) {
			T valor = dados.get(x);
			for(int y = x-1; y>=0; y--) {
				T analisado = dados.get(y);
				if (comparable.compare(valor, dados.get(y))>0) {
					dados.set(y+1, analisado);
					if(y==0) {
						dados.set(0, valor);
						continue outter;
					}
				}
				else { 
					if (y < x-1) {
						dados.set(y+1, valor);
					}
					continue outter;
				}
			}
		}
		
	}
}
