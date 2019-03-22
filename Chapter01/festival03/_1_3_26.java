package festival03;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_26 {

	/**
	 * 思路：
	 * 使用一个虚拟的头结点指向作为参数传入的结点
	 * 从虚拟的头结点开始逐项检查
	 * 最后返回该虚拟头结点的后序
	 * @param args
	 */
	public static void main(String[] args) {
		Node<String> header = new Node<String>("0",null);
		Node<String> node1 = new Node<String>("10",null);
		Node<String> node2 = new Node<String>("10",null);
		Node<String> node3 = new Node<String>("10",null);
		Node<String> node4 = new Node<String>("10",null);
		Node<String> node5 = new Node<String>("50",null);
		
		header.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		printList(header);
		Node<String> removedList = removeAll(header,"10");
		printList(removedList);
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
	
	public static <Item> Node<Item> removeAll(Node<Item> beg,Item key){
		if(beg==null)
			throw new IllegalArgumentException("链表为空。");
		//为链表构造一个头结点，新链表为cur
		//不必考虑头结点的item值
		Node<Item> header = new Node<Item>(key,beg);
		Node<Item> cur = header;
		while(cur.next!=null){
			if(cur.next.item.equals(key)){
				cur.next = cur.next.next;
				continue;
			}
			cur = cur.next;
		}
		return header.next;
	}
}
