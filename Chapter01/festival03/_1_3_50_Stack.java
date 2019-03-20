package festival03;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
/**
 * ˼·��
 * ��һ����������¼push������pop���������Ĵ�����
 * �ڴ���������ʱ������ֵ��¼��Iterator��һ��ʵ�������С�
 * ��ÿ�ε���hasNext������next����֮ǰ������ֵ�Ƿ����˱仯������仯���׳��쳣��
 * @author Administrator
 *
 * @param <Item>
 */
public class _1_3_50_Stack<Item> implements Iterable<Item>{
	private class Node{
		Item item;
		Node next;
	}
	
	private Node first;//ջ����������Ԫ�أ�
	private int N;//Ԫ������
	private int pushOrPopCount;//��¼push��pop�����Ĵ���
	
	public _1_3_50_Stack(){
	}
	public void push(Item item){
		//��ջ�����Ԫ��
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
		pushOrPopCount++;
	}
	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		pushOrPopCount++;
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
		private int operationCount = pushOrPopCount;
		@Override
		public boolean hasNext() {
			if(operationCount != pushOrPopCount)
				throw new ConcurrentModificationException("�ڵ������г���push��pop����.");
			else		
				return currentNode != null;
		}

		@Override
		public Item next() {
			if(operationCount != pushOrPopCount)
				throw new ConcurrentModificationException("�ڵ������г���push��pop����.");
			else{
				Item item = currentNode.item;
				currentNode = currentNode.next;
				return item;
			}
		}
	}
}
