package festival03;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item>{

	private Item[] a;//stack entries
	private int N;//size
	
	public ResizingArrayStack(int cap){
		a = (Item[])new Object[cap];
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void push(Item item){
		if(N == a.length){
			resize(2*a.length);
		}
		a[N++] = item;
	}
	public Item pop(){
		Item item = a[--N];
		a[N] = null;//避免对象游离
		if(N>0 && N == a.length/4){
			resize(a.length/2);
		}
		return item;
	}
	/**
	 * 将大小为N《=max的栈移动到一个新的大小为max的数组中
	 * @param max
	 */
	private void resize(int max){
		Item[] temp = (Item[])new Object[max];
		for(int i=0;i<N;i++){
			temp[i] = a[i];
		}
		a = temp;
	}
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	private class ReverseArrayIterator implements Iterator<Item>{

		private int i=N;
		@Override
		public boolean hasNext() {
			return i>0;
		}

		@Override
		public Item next() {
			return a[--i];
		}
	}
}
