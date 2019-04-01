package festival03;

import java.util.Iterator;
/**
 * 队列为空时，不从队列中弹出元素；
 * 队列满时，等队列不满时加入元素；
 * 环式入队列，先进入队列的元素先出队列。
 * @author Administrator
 *
 * @param <Item>
 */
public class RingBuffer_myway<Item> implements Iterable<Item> {
	
	private Item[] a;//queue entries
	private int head,tail,N;//size
	
	public RingBuffer_myway(int cap){
		a = (Item[])new Object[cap];
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	
	public void enqueue(Item item){
		if(size() == a.length){
			System.out.println("Queue is full,unable to enqueue.");
			return ;
		}
		a[tail] = item;
		tail = (tail + 1) % a.length;
		N++;
	}
	
	public Item dequeue(){
		if(isEmpty()){
			System.out.println("Queue is empty,unable to dequeue.");
			return null;
		}
		
		Item item = a[head];
		a[head] = null;
		head = (head + 1) % a.length;
		N--;
		
		return item;
	}
	
	public void printRingBuffer(){
		int cur = head;
		do{
			System.out.print(a[cur]+"->");
			cur = (cur+1) % a.length;
		}while(cur != tail);
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
