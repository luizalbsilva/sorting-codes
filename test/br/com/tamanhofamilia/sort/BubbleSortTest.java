package br.com.tamanhofamilia.sort;

public class BubbleSortTest extends SortBaseTest {
	public BubbleSortTest() {
		super(new BubbleSort<>( Comparable.sortInteger));
	}
}
