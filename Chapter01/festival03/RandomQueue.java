package festival03;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;
/**
 * 删除一个元素时，随机交换某个元素（索引在0和N-1之间）和末位元素（索引为N-1）的位置，然后删除并返回末位元素。
 * @author Administrator
 *
 * @param <Item>
 */
public class RandomQueue<Item> implements Iterable<Item> {
	private Item[] a;//queue entries
	private int head,tail,N;//size
	
	public RandomQueue(int cap){
		a = (Item[])new Object[cap];
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void enqueue(Item item){
		if(N == a.length){
			resize(2*a.length);
		}
		a[tail] = item;
		tail = (tail + 1) % a.length;
		N++;
	}
	//删除并随机返回一个元素（取样且不放回）
	public Item dequeue(){
		if(isEmpty())
			throw new RuntimeException("Queue is empty");
		int r = StdRandom.uniform(N);
		
		Item temp = a[r];
		a[r] = a[--tail];
		a[tail] = temp;
		a[tail] = null;
		N--;
		
		if(N>=0 && N == a.length/4){
			resize(a.length/2);
		}
		return temp;
	}
	//随机返回一个元素但不删除它（取样且放回）
	public Item sample(){
		if(isEmpty())
			throw new RuntimeException("Queue is empty");
		int r = StdRandom.uniform(N);
		return a[r];
	}
	/**
	 * 将大小为N《=max的栈移动到一个新的大小为max的数组中
	 * head = 0;tail = N.
	 * 这个思想很有水平
	 * @param max
	 */
	private void resize(int max){
		
		Item[] temp = (Item[])new Object[max];
		if(!isEmpty()){
			int cur = head, k = 0;
			do{
				temp[k++] = a[cur];
				cur = (cur+1)%a.length;
			}while(cur != tail);
		}
	
		head = 0;
		tail = N;
		a = temp;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
