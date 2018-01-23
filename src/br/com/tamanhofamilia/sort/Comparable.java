package br.com.tamanhofamilia.sort;

public interface Comparable<T> {
	int compare(T val1, T val2);
	
	public static final Comparable<Integer> sortInteger = (a,b) -> b.intValue() - a.intValue();
}
