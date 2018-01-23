package br.com.tamanhofamilia.sort;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

public abstract class SortBaseTest {
	/** Vários items */
	protected final List<Integer> multiItemList = new ArrayList<>() {
		private static final long serialVersionUID = 1L;
		{
			add(8);
			add(3);
			add(2);
			add(7);
			add(1);
			add(9);
			add(4);
			add(6);
			add(5);
			add(0);
		}};
	
	/** Lista com apenas um  item */
	protected final List<Integer> oneItemList = new ArrayList<>() {
		private static final long serialVersionUID = 1L;
		{
			add(8);
		}};
	
	/** Lista sem itens */
	protected final List<Integer> emptyList = new ArrayList<>();
	
	/** Rotina de ordenação */
	protected final Sortable<Integer> sorter;
	
	/**
	 * Ajusta a rotina de ordenação
	 * @param sorter
	 */
	public SortBaseTest(Sortable<Integer> sorter) {
		this.sorter = sorter;
	}
	
	/** Testa com vários itens */
	@Test
	public void sortTestVariousItems() {
		sorter.sort(multiItemList);
		
		IntStream.range(0,10).forEach(v -> assertEquals(v, multiItemList.get(v).intValue()));
	}
	
	/** Testa com um item */
	@Test
	public void sortOneItem() {
		sorter.sort(oneItemList);		
	}
	
	/** Testa com uma lista vazia */
	@Test
	public void sortEmptyList() {
		sorter.sort(emptyList);		
	}
	
	/** Testa com uma lista vazia */
	@Test(expected=NullPointerException.class)
	public void sortNullList() {
		sorter.sort(null);		
	}
}
