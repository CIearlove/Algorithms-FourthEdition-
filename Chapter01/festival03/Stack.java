package festival03;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
	private class Node{
		Item item;
		Node next;
	}
	
	private Node first;//ջ����������Ԫ�أ�
	private int N;//Ԫ������
	
	public Stack(){
	}
	public void push(Item item){
		//��ջ�����Ԫ��
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	public Item peek(){
		return first.item;
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
		@Override
		public boolean hasNext() {
			
			return currentNode != null;
		}

		@Override
		public Item next() {
			Item item = currentNode.item;
			currentNode = currentNode.next;
			return item;
		}

		
	}
}
