package festival03;
import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{
	private class Node{
		Item item;
		Node next;
	}
	
	private Node first;//队列的开头
	private Node last;//队列的结尾
	private int N;//元素数量
	
	public Queue(){
	}

	public void enqueue(Item item){
		 Node oldlast = last;
		 last = new Node();
		 last.item = item;
		 last.next = null;
		 
		 if(isEmpty()){
			first = last;
		 }else{
			 oldlast.next = last;
		 }
		 N++;
	}
	public Item dequeue(){
		Item item  = first.item;
		first = first.next;
		if(isEmpty())
			last = null;
		N--;
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
		@Override
		public boolean hasNext() {
			
			return currentNode!=null;
		}

		@Override
		public Item next() {
			Item item = currentNode.item;
			currentNode = currentNode.next;
			return item;
		}
		
	}
}
