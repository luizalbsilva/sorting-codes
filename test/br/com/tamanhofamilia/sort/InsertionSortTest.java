package br.com.tamanhofamilia.sort;

public class InsertionSortTest extends SortBaseTest {
	public InsertionSortTest() {
		super(new InsertionSort<>(Comparable.sortInteger));
	}

}
