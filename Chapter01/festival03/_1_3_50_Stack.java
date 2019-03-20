package festival03;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class _1_3_50_Stack<Item> implements Iterable<Item>{
	private class Node{
		Item item;
		Node next;
	}
	
	private Node first;//栈顶（最近添加元素）
	private int N;//元素数量
	private int pushOrPopCount;//记录push和pop操作的次数
	
	public _1_3_50_Stack(){
	}
	public void push(Item item){
		//向栈顶添加元素
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
		pushOrPopCount++;
	}
	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		pushOrPopCount++;
		return item;
	}
	public boolean isEmpty(){
		return first == null;
	}
	public int size(){
		return N;
	}
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node currentNode = first;
		private int operationCount = pushOrPopCount;
		@Override
		public boolean hasNext() {
			if(operationCount != pushOrPopCount)
				throw new ConcurrentModificationException("在迭代器中出现push或pop操作.");
			else		
				return currentNode != null;
		}

		@Override
		public Item next() {
			if(operationCount != pushOrPopCount)
				throw new ConcurrentModificationException("在迭代器中出现push或pop操作.");
			else{
				Item item = currentNode.item;
				currentNode = currentNode.next;
				return item;
			}
		}
	}
}
