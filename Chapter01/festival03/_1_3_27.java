package festival03;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_27 {

	/**
	 * 思想：
	 * 
	 * @author Administrator
	 * 假设头结点元素为最大，依次往后检查各项结点的元素值，如果比当前记录的最大元素值大，将max指向元素值大的结点。
	 * @param <Item>
	 */
	static class Node<Item> implements Comparable<Node<Item>>{
		Item item;
		Node<Item> next;
		
		Node(Item item){
			this.item = item;
			this.next = null;
		}
		Node(Item item,Node<Item> next){
			this.item = item;
			this.next = next;
		}
		@Override
		public int compareTo(Node<Item> o) {
			if((int)item > (int)(o.item))
				return 1;
			else if((int)item > (int)(o.item))
				return 0;
			else
				return -1;
		}
		
	}
	
	public static void main(String[] args) {
		
		Node<Integer> header = new Node<Integer>(60,null);
		Node<Integer> node1 = new Node<Integer>(10,null);
		Node<Integer> node2 = new Node<Integer>(20,null);
		Node<Integer> node3 = new Node<Integer>(30,null);
		Node<Integer> node4 = new Node<Integer>(40,null);
		Node<Integer> node5 = new Node<Integer>(50,null);
		
		Node<Double> node6 = new Node<Double>(40.0,null);
		Node<Double> node7 = new Node<Double>(50.0,null);
		Node<Double> node8 = new Node<Double>(60.0,null);
		Node<Double> node9 = new Node<Double>(70.0,null);
		
		header.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		
		printList(header);
		printList(node6);
		
		System.out.println(max(header));
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
	
	public static <Item> int max(Node<Item> beg){
		Node<Item> max = beg;
		Node<Item> cur = beg.next;
		while(cur!=null){
			if(max.compareTo(cur)<0)
				max=cur;
			cur = cur.next;
		}
		return (int) max.item;
	}
}
