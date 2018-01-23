package br.com.tamanhofamilia.sort;

import java.util.List;

/*
 * Heap é uma estrutura binária balanceada, onde seus filhos podem ser maiores 
 * ou menores que o elemento pai. Cada novo elemento colocado a estrutura é testado
 * de forma com que o grafo se alterado para se adaptar, jogando para a parte de cima
 * os menores (ou maiores, dependendo da ordenação desejada).
 */


public class HeapSort<T> implements Sortable<T>{
	private final Comparable<T> comparable;

	public HeapSort(Comparable<T> comparable) {
		this.comparable = comparable;
	}

	@Override
	public void sort(List<T> dados) {
		Heap<T> heap = new Heap<>(comparable);
		dados.forEach(i->heap.add(i));
		T item = heap.remove();
		for(int x=0; item!=null; item = heap.remove(), x++) {
			dados.set(x, item);
		}
	}
}

class Heap<T> {
	private final Comparable<T> comparable;

	private T item;

	private Heap<T> h1, h2, pai;
	private int qtde;

	public Heap(Comparable<T> comparable) {
		this.comparable = comparable;
	}
	
	public Heap(Comparable<T> comparable, T item) {
		this(comparable);
		this.item = item;
		this.qtde = 1;
	}
	
	public Heap(Comparable<T> comparable, Heap<T> pai, T item) {
		this(comparable, item);
		this.pai = pai;
	}
	
	public void add(T item) {
		if (this.item == null)
			this.item = item;
		else if (h1 == null) {
			h1 = new Heap<>(comparable, this, item);
			h1.comparaPai();
		}
		else if (h2 == null) {
			h2 = new Heap<>(comparable, this, item);
			h2.comparaPai();
		}
		else if (h1.qtde > h2.qtde) h2.add(item);
		else h1.add(item);
		qtde++;
	}
	
	public T remove() {
		T item = removeLast();
		T thisItem = this.item;
		if (this.item != null) {
			setItem(item);
		} else
			thisItem = item;
		return thisItem;
	}
	
	private T removeLast() {
		T ultimo;
		if (h2 != null) {
			if (h1.qtde > h2.qtde) {
				ultimo = h1.removeLast();
			} else if (h2.qtde == 1) {
				ultimo = h2.item;
				h2 = null;
			} else {
				ultimo = h2.removeLast();
			}
		} else if(h1 != null) {
			ultimo = h1.item;
			h1 = null;
		} else {
			ultimo = this.item;
			item = null;
		}
		qtde--;
		return ultimo;
	}
	
	private void comparaPai() {
		if ((pai != null)&&(comparable.compare(item, pai.item)>0)) {
			T itemDaqui = this.item;
			this.item = pai.item; 
			pai.item = itemDaqui;
			pai.comparaPai();
		}
	}
	
	private void setItem(T item) {
		this.item = item;
		verificaFilhos();
	}

	private void verificaFilhos() {
		if ((h1!=null)&&(comparable.compare(item, h1.item)<0)) {
			T item = this.item;
			this.item = h1.item;
			h1.setItem(item);
		}
		if ((h2!=null)&&(comparable.compare(item, h2.item)<0)) {
			T item = this.item;
			this.item = h2.item;
			h2.setItem(item);
		}
	}
}