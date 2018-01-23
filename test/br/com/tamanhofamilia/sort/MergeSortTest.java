package br.com.tamanhofamilia.sort;

public class MergeSortTest extends SortBaseTest {

	public MergeSortTest() {
		super(new MergeSort<>(Comparable.sortInteger));
	}
}
