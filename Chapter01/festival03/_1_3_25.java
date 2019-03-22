package festival03;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_25 {
/**
 * ˼·��
 * �ҵ���һ�������β��㣬������ڶ�������ͷ�������
 * @param args
 */
	public static void main(String[] args) {
		
		Node<String> list1 = new Node<String>("0",null);
		Node<String> node1 = new Node<String>("10",null);
		Node<String> node2 = new Node<String>("20",null);
		Node<String> list2 = new Node<String>("0",null);
		Node<String> node4 = new Node<String>("10",null);
		Node<String> node5 = new Node<String>("20",null);
		
		list1.next = node1;
		node1.next = node2;
		list2.next = node4;
		node4.next = node5;
		
		printList(list1);
		printList(list2);
		
		list1 = insertAfter(list1,list2);
		printList(list1);
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
	
	public static <Item> Node<Item> insertAfter(Node<Item> beg1,Node<Item> beg2){
		
		if(beg1 == null && beg2 != null)
			return beg2;
		else if(beg1 != null && beg2 == null)
			return beg1;
		else if(beg1 == null && beg2 == null)
			throw new IllegalArgumentException("��������Ϊ�ա�");
		else{
			Node<Item> cur = beg1;
			while(cur.next!=null){
				cur=cur.next;
			}
			cur.next = beg2;
			return beg1;
		}
	}
}
