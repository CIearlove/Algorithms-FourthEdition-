package festival03;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_20 {
/**
 * 思路：
 * 链表为空或Kth为负数或0时，弹出异常；
 * Kth=1时，返回first.next，相当于删除头结点；
 * 否则就用一个指针cur依次往后移动，如果下一个元素cur.next为null说明Kth越界；
 * 如果下一个元素cur.next就是待删除元素，跳出循环，将当前指针的cur.next 置为 cur.next.next
 * @param args
 */
	public static void main(String[] args) {
		Node<Integer> header = new Node<Integer>(0,null);
		Node<Integer> node1 = new Node<Integer>(10,null);
		Node<Integer> node2 = new Node<Integer>(20,null);
		Node<Integer> node3 = new Node<Integer>(30,null);
		Node<Integer> node4 = new Node<Integer>(40,null);
		Node<Integer> node5 = new Node<Integer>(50,null);
		
		header.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		printList(header);
		header = deleteKthElem(header,4);
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
	
	public static <Item> Node<Item> deleteKthElem(Node<Item> first,int Kth){
		if (first == null || Kth < 1) 
		    throw new IllegalArgumentException("链表为空或Kth为负数或0。");
		else if(Kth == 1){//删除第一个结点
			return first.next;
		}else{
			Node<Item> cur = first;
			while(--Kth > 1){
				cur = cur.next;
				if(cur.next == null)
					throw new RuntimeException("list out of bounds");
			}
			cur.next = cur.next.next;
			return first;
		}
	}
}
