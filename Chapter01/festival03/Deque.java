package festival03;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
/**
 * 双向队列，它同时支持在两端添加或删除元素。
 * @author Administrator
 *
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {
	
	private DoubleNode<Item> first;//队列的开头
	private DoubleNode<Item> last;//队列的结尾
	private int N;//元素数量

	/**
	 * 创建空双向队列
	 */
	public Deque(){}
	/**
	 * 双向队列是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return N==0;
	}
	/**
	 * 双向队列中的元素数量
	 * @return
	 */
	public int size(){
		return N;
	}
	/**
	 * 向左端添加一个新元素
	 * @param item
	 */
	public void pushLeft(Item item){
		if(isEmpty()){
			first = new DoubleNode<Item>(item);
			last = first;
		}else{
			DoubleNode<Item> oldFirst = first;
			first = new DoubleNode<Item>(item,oldFirst.prev,oldFirst);
			oldFirst.prev = first;
		}
		N++;
	}
	/**
	 * 向右端添加一个新元素
	 * @param item
	 */
	public void pushRight(Item item){
		if(isEmpty()){
			last = new DoubleNode<Item>(item);
			first = last;
		}else{
			DoubleNode<Item> oldLast = last;
			last = new DoubleNode<Item>(item,oldLast,oldLast.next);
			oldLast.next = last;
		}
		N++;
	}
	/**
	 * 从左端删除一个元素
	 * @return
	 */
	public Item popLeft(){
		
		if(isEmpty()){
			throw new RuntimeException("empty deque!");
		}else{
			Item item = first.item;
			first = first.next;
			if(first!= null)
				first.prev = null;
			else
				//若链表仅有一个结点
				last = null;
			
			N--;
			return item;
		}
	}
	/**
	 * 从右端删除一个元素
	 * @return
	 */
	public Item popRight(){
		if(isEmpty()){
			throw new RuntimeException("empty deque!");
		}else{
			Item item = last.item;
			last = last.prev;
			if(last!=null){
				last.next = null;
			}else
				//若链表仅有一个结点
				first = null;
			
			N--;
			return item;
		}
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void printDeque(){
		DoubleNode<Item> currentNode = first;
		if (isEmpty()) {
	        StdOut.println("empty list");
	        return;
	    }
		while(currentNode.next!=null){
			StdOut.print(currentNode.item + " -> ");
			currentNode = currentNode.next;
		}
		StdOut.println(currentNode.item);
	}
}
