package festival03;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_30 {

	/**
	 * ���⣺��дһ������������һ��������׽����Ϊ�������ƻ��Եؽ�����ת�����ؽ��������׽ڵ㡣
	 * �ݹ�ķ�ʽ��һ�����Ѷȡ�
	 * @param args
	 */
	public static void main(String[] args) {
		Node<String> header = new Node<String>("0",null);
		Node<String> node1 = new Node<String>("10",null);
		Node<String> node2 = new Node<String>("20",null);
		Node<String> node3 = new Node<String>("30",null);
		Node<String> node4 = new Node<String>("40",null);
		Node<String> node5 = new Node<String>("50",null);
		
		header.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		printList(header);
		Node<String> reversedHeader = RecursivelyReverse(header);
		printList(reversedHeader);
		printList(header);
	}
	
	public static <Item> void printList(Node<Item> beg){
		if (beg == null) {
	        StdOut.println("empty list");
	        return;
	    }
		while(beg.next!=null){
			StdOut.print(beg.item + " -> ");
			beg = beg.next;
		}
		StdOut.println(beg.item);
	}
	/**
	 * ������ʽ
	 * @param beg
	 * @return
	 */
	public static <Item> Node<Item> iterativelyReverse(Node<Item> beg){
		Node<Item> reverse = null;
		Node<Item> first = beg;
		Node<Item> second = beg.next;
		
		while(first != null){
			second = first.next;
			first.next = reverse;
			reverse = first;
			first = second;
		}
		return reverse;
	}
	/**
	 * �ݹ鷽ʽ
	 * @param beg
	 * @return
	 */
	public static <Item> Node<Item> RecursivelyReverse(Node<Item> beg){
		Node<Item> first = beg;
		if(first == null)
			return null;
		if(first.next == null)
			return first;
		Node<Item> second = first.next;
		Node<Item> rest = RecursivelyReverse(second);
		second.next = first;
		first.next = null;
		
		return rest;
	}
}
