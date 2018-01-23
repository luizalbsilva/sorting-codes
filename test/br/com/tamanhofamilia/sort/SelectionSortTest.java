package br.com.tamanhofamilia.sort;

public class SelectionSortTest extends SortBaseTest {
	public SelectionSortTest() {
		super(new SelectionSort<>(Comparable.sortInteger));
	}
}
