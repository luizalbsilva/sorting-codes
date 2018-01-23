package br.com.tamanhofamilia.sort;

public class HeapSortTest extends SortBaseTest {

	public HeapSortTest() {
		super(new HeapSort<>(Comparable.sortInteger));
	}

}
