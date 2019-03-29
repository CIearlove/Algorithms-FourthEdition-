package festival03;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
/**
 * ˫����У���ͬʱ֧����������ӻ�ɾ��Ԫ�ء�
 * @author Administrator
 *
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {
	
	private DoubleNode<Item> first;//���еĿ�ͷ
	private DoubleNode<Item> last;//���еĽ�β
	private int N;//Ԫ������

	/**
	 * ������˫�����
	 */
	public Deque(){}
	/**
	 * ˫������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return N==0;
	}
	/**
	 * ˫������е�Ԫ������
	 * @return
	 */
	public int size(){
		return N;
	}
	/**
	 * ��������һ����Ԫ��
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
	 * ���Ҷ����һ����Ԫ��
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
	 * �����ɾ��һ��Ԫ��
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
				//���������һ�����
				last = null;
			
			N--;
			return item;
		}
	}
	/**
	 * ���Ҷ�ɾ��һ��Ԫ��
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
				//���������һ�����
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
