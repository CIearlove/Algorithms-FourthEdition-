package festival03;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_26 {

	/**
	 * ˼·��
	 * ʹ��һ�������ͷ���ָ����Ϊ��������Ľ��
	 * �������ͷ��㿪ʼ������
	 * ��󷵻ظ�����ͷ���ĺ���
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
			throw new IllegalArgumentException("����Ϊ�ա�");
		//Ϊ������һ��ͷ��㣬������Ϊcur
		//���ؿ���ͷ����itemֵ
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
