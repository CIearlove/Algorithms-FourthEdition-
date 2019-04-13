package festival01;

import festival03.Queue;

/**
 * 无序链表中的顺序查找
 * @author Administrator
 *
 */
public class SequentialSearchST<Key,Value> {
	
	private Node first;//链表的首结点
	private int N;//键值对的数量
	
	private class Node{
		//链表结点的定义
		Key key;
		Value val;
		Node next;
		
		public Node(Key key,Value val,Node next){
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	/**
	 * 获取键key对应的值
	 * 若键key不存在则返回null
	 * 
	 * 具体实现：
	 * 遍历链表，用equals（）方法比较需被查找的键和每个结点中的键。
	 * 如果匹配成功我们就返回相应的值，否则我们返回null。
	 * @param key
	 * @return
	 */
	public Value get(Key key){
		Node tra=first;
		while(tra!=null){
			if(tra.key.equals(key)){
				//匹配成功
				return tra.val ;
			}
			tra = tra.next;
		}
		return null;//匹配不成功
	}
	/**
	 * 将键值对存入表中
	 * 若值为空则将键key从表删除（暂未实现）
	 * 
	 * 具体实现：
	 * 遍历链表，用equals（）方法比较需被查找的键和每个结点中的键。
	 * 如果匹配成功我们就用第二个参数指定的值更新和该键相关联的值，
	 * 否则我们就用给定的键值对创建一个新的结点并将其插入链表的开头。
	 * @param key
	 * @param val
	 */
	public void put(Key key,Value val){
		Node tra=first;
		//遍历链表，用equals（）方法比较需被查找的键和每个结点中的键
		while(tra!=null){
			if(tra.key.equals(key)){
				//匹配成功
				tra.val = val;
				return;
			}
			tra=tra.next;
		}
			//匹配不成功
			first = new Node(key,val,first);
			N++;
		
	}
	/**
	 * 从表中删去键key（及其对应的值）
	 * @param key
	 */
	public void delete(Key key){
		Node tra = first;
		//键key对应的结点为首结点时
		if(tra.key.equals(key)){
			first = first.next;
			N--;
			return;
		}
		while(tra.next!=null){
			if(tra.next.key.equals(key)){
				//找到键key对应的结点
				tra.next = tra.next.next;
				N--;
			}
			tra = tra.next;
		}
	}
	/**
	 * 键key在表中是否有对应的值
	 * @param key
	 * @return
	 */
	public boolean contains(Key key){
		Node tra=first;
		//遍历链表，用equals（）方法比较需被查找的键和每个结点中的键
		while(tra!=null){
			if(tra.key.equals(key)){
				//匹配成功
				return true;
			}
			tra=tra.next;
		}
		return false;
	}
	/**
	 * 表是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return N==0;
	}
	/**
	 * 表中的键值对数量
	 * @return
	 */
	public int size(){
		return N;
	}
	/**
	 * 表中的所有键的集合
	 * @return
	 */
	public Iterable<Key> keys(){
		Node tra=first;
		Queue<Key> queue = new Queue<Key>();
		while(tra!=null){
			queue.enqueue(tra.key);
			tra=tra.next;
		}
		return queue;
	}
}
