package festival03;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_21 {

	/**
	 * 思路：
	 * 遍历链表，若链表结点item值与传入的key值相同，返回true；
	 * 否则返回false。
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
		System.out.println(find(header,""));
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
	
	public static <Item> boolean find(Node<Item> first,Item key){
		if (first == null) 
		    throw new IllegalArgumentException("链表为空。");
		for(Node<Item> x=first;x.next!=null;x=x.next){
			if(x.item == key)
				return true;
		}
		return false;
	}
}
