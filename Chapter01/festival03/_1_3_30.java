package festival03;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_30 {

	/**
	 * 问题：编写一个函数，接受一条链表的首结点作为参数，破坏性地将链表反转并返回结果链表的首节点。
	 * 递归的方式有一定的难度。
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
	 * 迭代方式
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
	 * 递归方式
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
