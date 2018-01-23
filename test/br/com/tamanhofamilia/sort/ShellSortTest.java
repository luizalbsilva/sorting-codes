package br.com.tamanhofamilia.sort;

public class ShellSortTest extends SortBaseTest {

	public ShellSortTest() {
		super(new ShellSort<>(Comparable.sortInteger));
	}

}
