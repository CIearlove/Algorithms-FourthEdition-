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
	 * 在指定结点之前插入新结点
	 * @param item 新结点的item域
	 * @return 新结点的引用
	 */
	public DoubleNode<Item> insertBefore(Item item){
		DoubleNode<Item> newNode = new DoubleNode<Item>(item,this.prev,this);
		if(this.prev != null)//本结点不为头结点	
			this.prev.next = newNode;
		this.prev = newNode;
		return newNode;
	}
	/***
	 * 在指定结点之后插入新结点
	 * @param item 新结点的item域
	 * @return 新结点的引用
	 */
	public DoubleNode<Item> insertAfter(Item item){
		DoubleNode<Item> newNode = new DoubleNode<Item>(item,this,this.next);
		if(this.next != null)//本结点不为尾结点	
			this.next.prev = newNode;
		this.next = newNode;
		return newNode;
	}
	/**
	 * 删除结点本身（不是删除内存中的结点，还存在内存中）
	 * @return
	 */
	public Item deleteNode(){
		
		Item item = this.item;
		if(this.prev!=null)//不为头结点
			this.prev.next = this.next;
		if(this.next!=null)//不为尾结点
			this.next.prev = this.prev;
		//this.prev = null;
		//this.next = null;
		return item;
		
	}
	/**
	 * 通过链表中某一结点，顺序遍历链表
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
	 * 查找链表中指定结点
	 * @param item 指定结点的item域
	 * @return 指定结点的引用
	 */
	public DoubleNode<Item> search(Item item){
		DoubleNode<Item> current = this;
		//找到链表头
		while(current.prev!=null){
			current = current.prev;
		}
		//顺序遍历链表
		while(current!=null){
			if(current.item.equals(item))
				return current;
			current = current.next;
		}
		return null;
		
	}
	/**
	 * 在指定结点之前插入新结点
	 * @param beg 链表中某一结点的引用
	 * @param item1 指定结点的item域
	 * @param item2 新结点的item域
	 */
	public static <Item> void insertBefore(DoubleNode<Item> beg,Item item1,Item item2){
		//找到指定结点的引用
		DoubleNode<Item> current = beg.search(item1);
		current.insertBefore(item2);
	}
	/**
	 * 在指定结点之后插入新结点
	 * @param beg 链表中某一结点的引用
	 * @param item1 指定结点的item域
	 * @param item2 新结点的item域
	 */
	public static <Item> void insertAfter(DoubleNode<Item> beg,Item item1,Item item2){
		//找到指定结点的引用
		DoubleNode<Item> current = beg.search(item1);
		current.insertAfter(item2);
	}
	/**
	 * 在表头插入结点
	 * @param beg 链表中某一结点的引用
	 * @param item 新结点的item域
	 */
	public static <Item> void insertAsFirst(DoubleNode<Item> beg,Item item){
		DoubleNode<Item> current = beg;
		//找到头结点
		while(current.prev!=null){
			current = current.prev;
		}
		current.insertBefore(item);
	}
	/**
	 * 在表尾插入结点
	 * @param beg 链表中某一结点的引用
	 * @param item 新结点的item域
	 */
	public static <Item> void insertAsLast(DoubleNode<Item> beg,Item item){
		DoubleNode<Item> current = beg;
		//找到尾结点
		while(current.next!=null){
			current = current.next;
		}
		current.insertAfter(item);
	}
	/**
	 * 删除表头结点
	 * @param beg 链表中某一结点的引用
	 * @return
	 */
	public static <Item> Item deleteFirst(DoubleNode<Item> beg){
		DoubleNode<Item> current = beg;
		//找到头结点
		while(current.prev!=null){
			current = current.prev;
		}
		return current.deleteNode();
		
	}
	/**
	 * 删除表尾结点
	 * @param beg 链表中某一结点的引用
	 * @return
	 */
	public static <Item> Item deleteLast(DoubleNode<Item> beg){
		DoubleNode<Item> current = beg;
		//找到尾结点
		while(current.next!=null){
			current = current.next;
		}
		return current.deleteNode();
		
	}
	/**
	 * 删除指定结点
	 * @param beg 链表中某一结点的引用
	 * @param item 待删除结点的item域
	 * @return
	 */
	public static <Item> Item remove(DoubleNode<Item> beg,Item item){
		//找到指定结点的引用
		DoubleNode<Item> current = beg.search(item);
		if (current == null) return null;
		return current.deleteNode();
		
	}
}
