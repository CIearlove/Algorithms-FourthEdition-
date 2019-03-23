package festival03;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_28 {
	/**
	 * ˼�룺
	 * ��������Ϊ�������뷽��
	 * ��¼�����е�һ�����max����¼ʣ�µ�����cur��
	 * ��¼cur������ֵ���Ľ��curMax
	 * ��max���ý���ֵ��curMax���õĽ���ֵ���бȽϣ����ϴ�ֵ�Ľ������ø���max
	 * ����max
	 * @author Administrator
	 * 
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
		//����
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
		
		Node<Integer> header = new Node<Integer>(0,null);
		Node<Integer> node1 = new Node<Integer>(10,null);
		Node<Integer> node2 = new Node<Integer>(20,null);
		Node<Integer> node3 = new Node<Integer>(30,null);
		Node<Integer> node4 = new Node<Integer>(40,null);
		Node<Integer> node5 = new Node<Integer>(50,null);
		
		header.next = node1;
		node1.next = node2;
		//node2.next = node3;
		//node3.next = node4;
		//node4.next = node5;
		
		printList(header);
		
		System.out.println(max(header).item);
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
	
	public static <Item> Node<Item> max(Node<Item> beg){
		Node<Item> max = beg;
		Node<Item> cur = beg.next;
		if(cur != null){
			Node<Item> curMax = max(cur);
			max = max.compareTo(curMax) == 1 ? max:curMax;
		}
		else
			return max;
		return max;
	}
}
