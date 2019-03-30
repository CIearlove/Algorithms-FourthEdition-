package festival03;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
/*
 * 思路 :
 * 
 * 链表的实现十分简单，在次仅说明可变数组的实现方式
 * 
 * 我们始终使用 head 和 tail 两个变量，用于指向头元素的前一个槽位和尾元素的后一个槽位
 * 当 pushLeft 时，如果 head < 0, 说明左侧已经没法再添加元素了，此时进行扩容操作，
 * 并使新元素和迁移到新数组中的元素一块，位于整个数组的中央
 * pushRight  操作亦然
 * 
 * 当 popLeft 或 popRight 操作时，如果操作后的元素个数等于数组长度的四分之一，
 * 那么我们将数组缩减为原先的一半，并将所有元素移到整个数组的中央
 * 
 * 来源：https://github.com/YangXiaoHei/Algorithms/blob/master/Ch_1_3_Bags_Queues_And_Stacks/Practise_1_3_33.java
 */
public class ResizingArrayDeque<Item> implements Iterable<Item> {
	private Item[] items = (Item[]) new Object[2];//queue entries
	private int head = 0;
	private int tail = 1;
	private int size;//size
	
	/**
	 * 双向队列是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size==0;
	}
	/**
	 * 双向队列中的元素数量
	 * @return
	 */
	public int size(){
		return size;
	}
	/**
	 * 向左端添加一个新元素
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
	 * 向右端添加一个新元素
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
	 * 从左端删除一个元素
	 * @return
	 */
	public Item popLeft(){
		return null;
		
	}
	/**
	 * 从右端删除一个元素
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
