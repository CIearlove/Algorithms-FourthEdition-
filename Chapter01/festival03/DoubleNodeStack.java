package festival03;

import java.util.Iterator;

/*
 * ˼· :
 * 
 * ������ʵ�ֵ�ջ�������ܼܺ򵥣�����˵һ��������ʵ����ο���
 * ����˼·�Ǳ��������е�ÿ����㣬������ push ���µ� ջ��
 * ԭջΪ 
 * ջ�� 4 -> 3 -> 2 -> 1 -> 0 ջ��
 * ����ֱ���� top ��ʼ���ο���������ֻ�ܵõ�һ������ĸ���
 * ջ�� 0 -> 1 -> 2 -> 3 -> 4 ջ��
 * �������׼��һ������ĵ��������ڶ�ԭջ�ı����У��Ϳ��Դ�ջ��Ԫ�ؿ�ʼ push ����ջ
 * �Ӷ��õ�
 * ��ջջ�� 4 -> 3 -> 2 -> 1 -> 0
 * ������˫�������ʵ��
 * 
 * ��Դ��https://github.com/YangXiaoHei/Algorithms/blob/master/Ch_1_3_Bags_Queues_And_Stacks/Practise_1_3_12.java
 */
public class DoubleNodeStack<Item> implements Iterable<Item>{
	//��ʵ�����Ĵ���
	private static int counter = 0;
	//private final int id = counter++;
	//˫������
	@SuppressWarnings("hiding")
	class DoubleNode<Item>{
		Item item;
		DoubleNode<Item> prev;
		DoubleNode<Item> next;
		
		DoubleNode(Item item){
			this.item = item;
			this.prev = null;
			this.next = null;
		}
		DoubleNode(Item item,DoubleNode<Item> prev,DoubleNode<Item> next){
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
	}
	//ջ��
	private DoubleNode<Item> top = null;
	//��ջ
	public void push(Item item){
		if(top == null)
			top = new DoubleNode<Item>(item);
		else{
			DoubleNode<Item> oldTop = top;
			top = new DoubleNode<Item>(item);
			top.next = oldTop;
			oldTop.prev = top;
		}
		
	}
	//��ջ
	public Item pop(){
		if(isEmpty()){
			throw new RuntimeException("empty stack!");
		}
		Item item  = top.item;
		top = top.next;
		top.prev = null;
		return item;
		
	}
	//ջ�Ƿ�Ϊ��
	public boolean isEmpty(){
		return top == null;
	}
	
	
	@Override
	public Iterator<Item> iterator() {
		return new normalIterator();
	}
	
	private class normalIterator implements Iterator<Item>{
		
		private DoubleNode<Item> currentNode = top;
		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public Item next() {
			Item item = currentNode.item;
			currentNode = currentNode.next;
			return item;
		}
	}
	
	//��ջ�ĵ���������Ϊ���������
	public Iterable<Item> reverse() {
			return new reverseIteration();
	}
	
	private class reverseIteration implements Iterable<Item>{
		@Override
		public Iterator<Item> iterator() {
			return new reverseIterator();
		}
	}
	
	private class reverseIterator implements Iterator<Item>{
		private DoubleNode<Item> currentNode = firstNodeTolastNode(top);
				
		@Override
		public boolean hasNext() {
			return currentNode != null;
		}
		
		@Override
		public Item next() {
			Item item = currentNode.item;
			currentNode = currentNode.prev;
			return item;
		}
		//���׽�㷵��β���
		public DoubleNode<Item> firstNodeTolastNode(DoubleNode<Item> node){
			while(node.next!=null)
				node = node.next;
			return node;
		}

	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("=== Stack [" + counter + "] ===\n");
		for(Item t : this)
			sb.append(t + "\n");
		sb.append("=== Bottom ===\n");
		return sb.toString();
	}
	
	//���Ƶ�ջ�ĸ���
	public static <Item> DoubleNodeStack<Item> copy(DoubleNodeStack<Item> source){
		DoubleNodeStack<Item> copy = new DoubleNodeStack<Item>();
		counter++;
		for(Item item : source.reverse())
			copy.push(item);
		return copy;
	}
}
