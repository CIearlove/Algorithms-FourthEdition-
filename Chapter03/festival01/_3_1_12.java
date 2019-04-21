package festival01;

import edu.princeton.cs.algs4.StdOut;
import festival03.Queue;

public class _3_1_12 {

	public static class BinarySearchST_3_1_12<Key extends Comparable<Key>,Value>{
		
		private class Item<Key extends Comparable<Key>,Value>{
			Key key;
			Value val;
			
			public Item(Key key,Value val){
				this.key = key;
				this.val = val;
			}
		}
		
		private Item<Key,Value>[] key_valuePairs;
		private int N;
		
		public BinarySearchST_3_1_12(){
			this.key_valuePairs = new Item[1];
		}
		
		public BinarySearchST_3_1_12(Item<Key,Value>[] items){
			this.key_valuePairs = items;
			merge(this.key_valuePairs);
		}
		
		public void merge(BinarySearchST_3_1_12<Key, Value>.Item<Key, Value>[] key_valuePairs2) {
			
		}

		/**
		 * 调整数组大小
		 * @param newSize 数组新的大小
		 */
		private void resize(int newSize) {
			Item<Key,Value>[] temp = new Item[newSize];
			
			for(int j=0;j<N;j++){
				temp[j] = key_valuePairs[j];
			}
			key_valuePairs = temp;
		}
		
		/**
		 * 将键值对存入表中
		 * @param item 保存键和值的item对象
		 */
		public void put(Key key,Value val){
			//键为空，返回
			if(key == null) return;
			
			//值为空，将键key从表中删除
			if(val == null){
				delete(key);
				return;
			}
			
			//数组满时，扩容
			if(N==key_valuePairs.length){
				resize(N<<1);//将N的二进制表示左移一位
			}
			
			int rank = rank(key);
			//key存在于表中时
			if(rank<N && key.compareTo(key_valuePairs[rank].key) == 0){
				key_valuePairs[rank].val = val;
				return;
			}
			
			//key不存在于表中时
			for(int i=N;i>rank;i--){
				key_valuePairs[i] = key_valuePairs[i-1];
			}
			key_valuePairs[rank] = new Item<Key,Value>(key,val);
			N++;
		}

		/**
		 * 获取键key对应的值
		 * 若键key不存在则返回null
		 * @param key 键
		 * @return 键key对应的值,若键key不存在则返回null
		 */
		public Value get(Key key) {
			//符号表为空时
			if(isEmpty())
				return null;
			//小于key的键的数量，无论key在不在表中
			int i = rank(key);
			
			if(i<N && key_valuePairs[i].key.compareTo(key) == 0){
				//找到键对应的值
				return key_valuePairs[i].val;
			}
			return null;
		}
		
		/**
		 * 小于key的键的数量
		 * 如果表中存在该键，rank（）应返回该键的位置，也就是表中小于它的键的数量；
		 * 如果表中不存在该键，rank（）还是应该返回表中小于它的键的数量
		 * @param key
		 * @return 小于key的键的数量
		 */
		private int rank(Key key) {
			int lo=0,hi=N-1;
			while(lo<=hi){
				int mid = lo+(hi-lo)/2;
				int cmp = key.compareTo(key_valuePairs[mid].key);
				if(cmp<0)
					hi = mid-1;
				else if(cmp>0)
					lo = mid+1;
				else
					//如果表中存在该键，rank（）应返回该键的位置，也就是表中小于它的键的数量
					return mid;
			}
			//如果表中不存在该键，rank（）还是应该返回表中小于它的键的数量
			return lo;
		}
		/**
		 * 从表中删去键key（及其对应的值）
		 * @param key 键
		 */
		public void delete(Key key) {
			//当键为空时，返回
			if(key==null)
				return;
			
			int rank = rank(key);
			//key存在于表中时
			if(rank<N && key.compareTo(key_valuePairs[rank].key) == 0){
				for(int i=rank;i<N;i++){
					key_valuePairs[i] = key_valuePairs[i+1];
				}
				N--;
			}
			//若满足缩容条件，缩容
			if(N>=0 && N == key_valuePairs.length >> 2)
				resize(key_valuePairs.length >> 1);
		}
		
		/**
		 * 表是否为空
		 * @return 是返回true，否则返回false
		 */
		public boolean isEmpty(){
			return N==0;
		}
		/**
		 * 表中的键值对数量
		 * @return 键值对数量
		 */
		public int size(){
			return N;
		}
		/**
		 * 最小的键
		 * @return 最小的键
		 */
		public Key min(){
			return key_valuePairs[0].key;
			
		}
		
		/**
		 * 最大的键
		 * @return 最大的键
		 */
		public Key max(){
			if(N==0)
				return null;
			return key_valuePairs[N-1].key;
		}
		/**
		 * 键key在表中是否有对应的值
		 * @param key 键
		 * @return 是返回true，否则返回false
		 */
		public boolean contains(Key key){
			if(get(key)!=null)
				return true;
			return false;
		}
		/**
		 * [lo...hi]之间的所有键，已排序
		 * @return [lo...hi]之间的所有键
		 */
		public Iterable<Key> keys(Key lo,Key hi){
			Queue<Key> q = new Queue<Key>();
			for(int i=rank(lo);i<rank(hi);i++){
				q.enqueue(key_valuePairs[i].key);
			}
			if(contains(hi))
				q.enqueue(key_valuePairs[rank(hi)].key);
			return q;
		}
		/**
		 * 表中的所有键的集合，已排序
		 * @return 表中的所有键的集合
		 */
		public Iterable<Key> keys(){
			return keys(min(),max());
			
		}
	}
	
	public static void main(String[] args) {
		
		BinarySearchST_3_1_12<String,Integer> st = new BinarySearchST_3_1_12<String,Integer>();
		String[] example = {"S","E","A","R","C","H","E","X","A","M","P","L","E"};
		//将键值对存入表中
		for(int i=0;i<example.length;i++){
			st.put(example[i],i);
		}
		/*
		//将表中的键值对删除
		for(int i=0;i<example.length;i++){
			st.delete(st.max());
		}
		*/
		//获取表中所有键对应的值
		for(String s :st.keys()){
			StdOut.print(s+":"+st.get(s)+", ");
		}
		StdOut.println();
		
		//从表中删去键“L”、“E”
		st.delete("L");
		st.delete("E");
		for(String s :st.keys()){
			StdOut.print(s+":"+st.get(s)+", ");
		}
		StdOut.println();
		
		//键“L”、“E”在表中是否有对应的值
		StdOut.println("L contained "+st.contains("L"));
		StdOut.println("E contained "+st.contains("E"));
		
		//表是否为空
		StdOut.println("ST is empty? "+st.isEmpty());
		
		//表中键值对的数量
		StdOut.println("ST's elements amount: "+st.size());
		
	}
}
