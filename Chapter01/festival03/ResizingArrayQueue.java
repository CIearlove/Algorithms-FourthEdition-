package festival03;
import java.util.Iterator;
/**
 * ˼·:
 * ��Ҫ��һ������ N��¼Ԫ�ظ���������ÿ�����ʱ�ж�
 * �����ʱN�Ѿ��������鳤�ȣ���ô�ͽ���һ������
 * ��Ҫע����ǰѾ�Ԫ�ذ�Ǩ��������ʱ����Ҫһ��С���ɣ�
 * ��Ϊ�ھ������еĶ��п���ͷԪ�ص���������βԪ�ص�������������ʽ���"
 * @author Administrator
 * 
 * ˼·��Դ��https://github.com/YangXiaoHei/Algorithms/blob/master/Ch_1_3_Bags_Queues_And_Stacks/Practise_1_3_14.java
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
	 * ����СΪN��=max��ջ�ƶ���һ���µĴ�СΪmax��������
	 * head = 0;tail = N.
	 * ���˼�����ˮƽ
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
