package festival03;
import java.util.Iterator;
/**
 * 思路:
 * 需要用一个变量 N记录元素个数，并在每次入队时判断
 * 如果此时N已经等于数组长度，那么就进行一次扩容
 * 需要注意的是把旧元素搬迁到新数组时，需要一点小技巧，
 * 因为在旧数组中的队列可能头元素的索引大于尾元素的索引，“环绕式添加"
 * @author Administrator
 * 
 * 思路来源：https://github.com/YangXiaoHei/Algorithms/blob/master/Ch_1_3_Bags_Queues_And_Stacks/Practise_1_3_14.java
 * @param <Item>
 */
public class ResizingArrayQueue<Item> implements Iterable<Item> {
	private Item[] a;//queue entries
	private int head,tail,N;//size
	
	public ResizingArrayQueue(int cap){
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
	public Item dequeue(){
		if(isEmpty())
			throw new RuntimeException("Queue is empty");
		
		Item item = a[head];
		a[head] = null;
		head = (head + 1) % a.length;
		N--;
		if(N>=0 && N == a.length/4){
			resize(a.length/2);
		}
		return item;
	}
	/**
	 * 将大小为N《=max的栈移动到一个新的大小为max的数组中
	 * head = 0;tail = N.
	 * 这个思想很有水平
	 * @param max
	 */
	private void resize(int max){
		/*
		Item[] temp = (Item[])new Object[max];
		int cur = head, k = 0;
		do{
			temp[k++] = a[cur];
			cur = (cur+1)%a.length;
		}while(cur != tail);
		
		head = 0;
		tail = N;
		a = temp;
		*/
		Item[] temp = (Item[])new Object[max];
		int cur = head, k = 0;
		do{
			temp[k++] = a[cur];
			cur = (cur+1)%a.length;
		}while(cur != tail);
		/*
		for(int i=head,j=0;i<tail;i++){
			temp[j++] = a[i];
			i = (i+1)%a.length;
		}
		*/
		head = 0;
		tail = N;
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
