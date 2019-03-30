package festival03;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
/*
 * ˼· :
 * 
 * �����ʵ��ʮ�ּ򵥣��ڴν�˵���ɱ������ʵ�ַ�ʽ
 * 
 * ����ʼ��ʹ�� head �� tail ��������������ָ��ͷԪ�ص�ǰһ����λ��βԪ�صĺ�һ����λ
 * �� pushLeft ʱ����� head < 0, ˵������Ѿ�û�������Ԫ���ˣ���ʱ�������ݲ�����
 * ��ʹ��Ԫ�غ�Ǩ�Ƶ��������е�Ԫ��һ�飬λ���������������
 * pushRight  ������Ȼ
 * 
 * �� popLeft �� popRight ����ʱ������������Ԫ�ظ����������鳤�ȵ��ķ�֮һ��
 * ��ô���ǽ���������Ϊԭ�ȵ�һ�룬��������Ԫ���Ƶ��������������
 * 
 * ��Դ��https://github.com/YangXiaoHei/Algorithms/blob/master/Ch_1_3_Bags_Queues_And_Stacks/Practise_1_3_33.java
 */
public class ResizingArrayDeque<Item> implements Iterable<Item> {
	private Item[] items = (Item[]) new Object[2];//queue entries
	private int head = 0;
	private int tail = 1;
	private int size;//size
	
	/**
	 * ˫������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return size==0;
	}
	/**
	 * ˫������е�Ԫ������
	 * @return
	 */
	public int size(){
		return size;
	}
	/**
	 * ��������һ����Ԫ��
	 * @param item
	 */
	public void pushLeft(Item item){
		if(head<0)
			pushResize(items.length*2,true);
		size++;
		items[head--] = item;
		StdOut.println(this);
	}
	/**
	 * ���Ҷ����һ����Ԫ��
	 * @param item
	 */
	public void pushRight(Item item){
		if (tail == items.length)
			pushResize(items.length * 2, false);
		size++;
		items[tail++] = item;
		StdOut.println(this);
	}
	/**
	 * �����ɾ��һ��Ԫ��
	 * @return
	 */
	public Item popLeft(){
		return null;
		
	}
	/**
	 * ���Ҷ�ɾ��һ��Ԫ��
	 * @return
	 */
	public Item popRight(){
		return null;
		
	}
	
	/*
	 * i supposed that pop or push from right or left are occurred in equal chance
	 * so every time i resized the array to a larger or smaller size
	 * i would like to make all the elements centered in the new array
	 */
	@SuppressWarnings("unchecked")
	void pushResize(int newsize, boolean left) {
		Item[] newItems = (Item[])new Object[newsize];
		int index = Math.abs(newsize - size - 1) / 2;
		int cur = left ? index + 1 : index;
		for(int i = head + 1; i < tail; i++)
			newItems[cur++] = items[i];
		head = left ? index : index - 1;
		tail = left ? index + size + 1 : index + size;
		items = newItems;
	}
	
	void popResize(int newsize) {
		Item[] newItems = (Item[])new Object[newsize];
		int index = Math.abs(newsize - size) / 2;
		int cur = index;
		for(int i = head + 1; i < tail; i++)
			newItems[cur++] = items[i];
		head = index - 1;
		tail = index + size;
		items = newItems;
	}
	
	public String toString() {
		if (isEmpty()) return "[empty]";
		StringBuilder sb = new StringBuilder();
		sb.append("|");
		for(int i = 0; i < items.length; i++)
			sb.append(String.format("%3s |", items[i] == null ? 
					" " : items[i].toString()));
		sb.append(String.format("      <<<<< head : %d tail : %d >>>>>>", head, tail));
		return sb.toString();
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
