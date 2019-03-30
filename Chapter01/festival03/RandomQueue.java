package festival03;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;
/**
 * ɾ��һ��Ԫ��ʱ���������ĳ��Ԫ�أ�������0��N-1֮�䣩��ĩλԪ�أ�����ΪN-1����λ�ã�Ȼ��ɾ��������ĩλԪ�ء�
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
	//ɾ�����������һ��Ԫ�أ�ȡ���Ҳ��Żأ�
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
	//�������һ��Ԫ�ص���ɾ������ȡ���ҷŻأ�
	public Item sample(){
		if(isEmpty())
			throw new RuntimeException("Queue is empty");
		int r = StdRandom.uniform(N);
		return a[r];
	}
	/**
	 * ����СΪN��=max��ջ�ƶ���һ���µĴ�СΪmax��������
	 * head = 0;tail = N.
	 * ���˼�����ˮƽ
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
