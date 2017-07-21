package com.github.tij4.chap11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class ReversibleArrayList<T> extends ArrayList<T>{
	public ReversibleArrayList(Collection<T> c){
		super(c);
	}
	/*
	public Iterable<T> reversed(){
		return new Iterable<T>(){
			public Iterator<T> iterator(){
				return new Iterable<T>(){
					int current = size() -1;
					public boolean hasNext(){
						return current>-1;
					}
					public T next(){
						return get(current--);
					}
					public void remove(){
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}*/
}
public class AdapterMethodIdiom {

}
