package festival03;

import java.util.Iterator;

/*
 * 思路 :
 * 
 * 用数组实现的栈拷贝功能很简单，下面说一下用链表实现如何拷贝
 * 基本思路是遍历链表中的每个结点，并将其 push 到新的 栈中
 * 原栈为 
 * 栈顶 4 -> 3 -> 2 -> 1 -> 0 栈底
 * 假如直接用 top 开始依次拷贝，我们只能得到一个逆序的副本
 * 栈顶 0 -> 1 -> 2 -> 3 -> 4 栈底
 * 因此我们准备一个逆序的迭代器，在对原栈的遍历中，就可以从栈底元素开始 push 到新栈
 * 从而得到
 * 新栈栈顶 4 -> 3 -> 2 -> 1 -> 0
 * 以下是双向链表的实现
 * 
 * 来源：https://github.com/YangXiaoHei/Algorithms/blob/master/Ch_1_3_Bags_Queues_And_Stacks/Practise_1_3_12.java
 */
public class DoubleNodeStack<Item> implements Iterable<Item>{
	//被实例化的次数
	private static int counter = 0;
	//private final int id = counter++;
	//双向链表
	@SuppressWarnings("hiding")
	class DoubleNode<Item>{
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
	}
	//栈顶
	private DoubleNode<Item> top = null;
	//入栈
	public void push(Item item){
		if(top == null)
			top = new DoubleNode<Item>(item);
		else{
			DoubleNode<Item> oldTop = top;
			top = new DoubleNode<Item>(item);
			top.next = oldTop;
			oldTop.prev = top;
		}
		
	}
	//出栈
	public Item pop(){
		if(isEmpty()){
			throw new RuntimeException("empty stack!");
		}
		Item item  = top.item;
		top = top.next;
		top.prev = null;
		return item;
		
	}
	//栈是否为空
	public boolean isEmpty(){
		return top == null;
	}
	
	
	@Override
	public Iterator<Item> iterator() {
		return new normalIterator();
	}
	
	private class normalIterator implements Iterator<Item>{
		
		private DoubleNode<Item> currentNode = top;
		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public Item next() {
			Item item = currentNode.item;
			currentNode = currentNode.next;
			return item;
		}
	}
	
	//将栈的迭代器设置为逆向迭代器
	public Iterable<Item> reverse() {
			return new reverseIteration();
	}
	
	private class reverseIteration implements Iterable<Item>{
		@Override
		public Iterator<Item> iterator() {
			return new reverseIterator();
		}
	}
	
	private class reverseIterator implements Iterator<Item>{
		private DoubleNode<Item> currentNode = firstNodeTolastNode(top);
				
		@Override
		public boolean hasNext() {
			return currentNode != null;
		}
		
		@Override
		public Item next() {
			Item item = currentNode.item;
			currentNode = currentNode.prev;
			return item;
		}
		//由首结点返回尾结点
		public DoubleNode<Item> firstNodeTolastNode(DoubleNode<Item> node){
			while(node.next!=null)
				node = node.next;
			return node;
		}

	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("=== Stack [" + counter + "] ===\n");
		for(Item t : this)
			sb.append(t + "\n");
		sb.append("=== Bottom ===\n");
		return sb.toString();
	}
	
	//复制得栈的副本
	public static <Item> DoubleNodeStack<Item> copy(DoubleNodeStack<Item> source){
		DoubleNodeStack<Item> copy = new DoubleNodeStack<Item>();
		counter++;
		for(Item item : source.reverse())
			copy.push(item);
		return copy;
	}
}
