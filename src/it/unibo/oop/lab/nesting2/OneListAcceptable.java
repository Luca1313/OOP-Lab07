package it.unibo.oop.lab.nesting2;

import java.util.LinkedList;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T>{

	private List<T> list;
	
	public Acceptor<T> acceptor() {
		return this.new UseAcceptor<T>();
	}
	
	private class UseAcceptor<T> implements Acceptor<T>{
		
		private List<T> lastList = new LinkedList<T>();

		public void accept(T newElement) throws ElementNotAcceptedException {
			this.lastList.add(newElement);
			if (!OneListAcceptable.this.list.contains(newElement)) {
				throw new ElementNotAcceptedException("Invalid element!!");
			}
		}

		public void end() throws EndNotAcceptedException {
			if (! OneListAcceptable.this.list.equals(this.lastList)) {
				throw new EndNotAcceptedException();
			}
		}
		
	}
	
	public OneListAcceptable(List<T> newList) {
		this.list = new LinkedList<T>();
		for (T object : newList) {
			this.list.add(object);
		}
	}
}
