package festival03;

import edu.princeton.cs.algs4.StdOut;

public class DoubleNode<Item> {
	
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
	/**
	 * ��ָ�����֮ǰ�����½��
	 * @param item �½���item��
	 * @return �½�������
	 */
	public DoubleNode<Item> insertBefore(Item item){
		DoubleNode<Item> newNode = new DoubleNode<Item>(item,this.prev,this);
		if(this.prev != null)//����㲻Ϊͷ���	
			this.prev.next = newNode;
		this.prev = newNode;
		return newNode;
	}
	/***
	 * ��ָ�����֮������½��
	 * @param item �½���item��
	 * @return �½�������
	 */
	public DoubleNode<Item> insertAfter(Item item){
		DoubleNode<Item> newNode = new DoubleNode<Item>(item,this,this.next);
		if(this.next != null)//����㲻Ϊβ���	
			this.next.prev = newNode;
		this.next = newNode;
		return newNode;
	}
	/**
	 * ɾ����㱾������ɾ���ڴ��еĽ�㣬�������ڴ��У�
	 * @return
	 */
	public Item deleteNode(){
		
		Item item = this.item;
		if(this.prev!=null)//��Ϊͷ���
			this.prev.next = this.next;
		if(this.next!=null)//��Ϊβ���
			this.next.prev = this.prev;
		//this.prev = null;
		//this.next = null;
		return item;
		
	}
	/**
	 * ͨ��������ĳһ��㣬˳���������
	 */
	public void print(){
		DoubleNode<Item> current = this;
		while(current.prev!=null){
			current = current.prev;
		}
		while(current.next!=null){
			StdOut.print(current.item+"->");
			current = current.next;
		}
		StdOut.println(current.item);
	}
	/**
	 * ����������ָ�����
	 * @param item ָ������item��
	 * @return ָ����������
	 */
	public DoubleNode<Item> search(Item item){
		DoubleNode<Item> current = this;
		//�ҵ�����ͷ
		while(current.prev!=null){
			current = current.prev;
		}
		//˳���������
		while(current!=null){
			if(current.item.equals(item))
				return current;
			current = current.next;
		}
		return null;
		
	}
	/**
	 * ��ָ�����֮ǰ�����½��
	 * @param beg ������ĳһ��������
	 * @param item1 ָ������item��
	 * @param item2 �½���item��
	 */
	public static <Item> void insertBefore(DoubleNode<Item> beg,Item item1,Item item2){
		//�ҵ�ָ����������
		DoubleNode<Item> current = beg.search(item1);
		current.insertBefore(item2);
	}
	/**
	 * ��ָ�����֮������½��
	 * @param beg ������ĳһ��������
	 * @param item1 ָ������item��
	 * @param item2 �½���item��
	 */
	public static <Item> void insertAfter(DoubleNode<Item> beg,Item item1,Item item2){
		//�ҵ�ָ����������
		DoubleNode<Item> current = beg.search(item1);
		current.insertAfter(item2);
	}
	/**
	 * �ڱ�ͷ������
	 * @param beg ������ĳһ��������
	 * @param item �½���item��
	 */
	public static <Item> void insertAsFirst(DoubleNode<Item> beg,Item item){
		DoubleNode<Item> current = beg;
		//�ҵ�ͷ���
		while(current.prev!=null){
			current = current.prev;
		}
		current.insertBefore(item);
	}
	/**
	 * �ڱ�β������
	 * @param beg ������ĳһ��������
	 * @param item �½���item��
	 */
	public static <Item> void insertAsLast(DoubleNode<Item> beg,Item item){
		DoubleNode<Item> current = beg;
		//�ҵ�β���
		while(current.next!=null){
			current = current.next;
		}
		current.insertAfter(item);
	}
	/**
	 * ɾ����ͷ���
	 * @param beg ������ĳһ��������
	 * @return
	 */
	public static <Item> Item deleteFirst(DoubleNode<Item> beg){
		DoubleNode<Item> current = beg;
		//�ҵ�ͷ���
		while(current.prev!=null){
			current = current.prev;
		}
		return current.deleteNode();
		
	}
	/**
	 * ɾ����β���
	 * @param beg ������ĳһ��������
	 * @return
	 */
	public static <Item> Item deleteLast(DoubleNode<Item> beg){
		DoubleNode<Item> current = beg;
		//�ҵ�β���
		while(current.next!=null){
			current = current.next;
		}
		return current.deleteNode();
		
	}
	/**
	 * ɾ��ָ�����
	 * @param beg ������ĳһ��������
	 * @param item ��ɾ������item��
	 * @return
	 */
	public static <Item> Item remove(DoubleNode<Item> beg,Item item){
		//�ҵ�ָ����������
		DoubleNode<Item> current = beg.search(item);
		if (current == null) return null;
		return current.deleteNode();
		
	}
}
