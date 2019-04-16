package festival01;

import festival03.Queue;

/**
 * 基于有序数组的二分查找
 * @author Administrator
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>,Value> {
	private Key[] keys;
	private Value[] values;
	private int N;
	
	public BinarySearchST(){
		//Key类型的Comparable对象的数组
		keys = (Key[]) new Comparable[1];
		//Value类型的Object对象的数组
		values = (Value[]) new Object[1];
	}
	
	private void resize(int newSize) {
		Key[] temp1 = (Key[]) new Comparable[newSize];
		Value[] temp2 = (Value[]) new Object[newSize];
		
		for(int j=0;j<N;j++){
			temp1[j] = keys[j];
			temp2[j] = values[j];
		}
		keys = temp1;
		values = temp2;
	}
	/**
	 * 将键值对存入表中
	 * @param key
	 * @param val
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
		if(N==keys.length){
			resize(N<<1);//将N的二进制表示左移一位
		}
		
		int rank = rank(key);
		//key存在于表中时
		if(rank<N && key.compareTo(keys[rank]) == 0){
			values[rank] = val;
			return;
		}
		//key不存在于表中时
		for(int i=N;i>rank;i--){
			keys[i] = keys[i-1];
			values[i] = values[i-1];
		}
		keys[rank] = key;
		values[rank] = val;
		N++;
	}
	
	/**
	 * 获取键key对应的值
	 * 若键key不存在则返回null
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		//符号表为空时
		if(isEmpty())
			return null;
		//小于key的键的数量，无论key在不在表中
		int i = rank(key);
		
		if(i<N && keys[i].compareTo(key) == 0){
			//找到键对应的值
			return values[i];
		}
		return null;
	}
	
	/**
	 * 从表中删去键key（及其对应的值）
	 * @param key
	 */
	public void delete(Key key){
		//当键为空时，返回
		if(key==null)
			return;
		
		int rank = rank(key);
		//key存在于表中时
		if(rank<N && key.compareTo(keys[rank]) == 0){
			for(int i=rank;i<N;i++){
				keys[i] = keys[i+1];
				values[i] = values[i+1];
			}
			N--;
		}
		//若满足缩容条件，缩容
		if(N>=0 && N == keys.length >> 2)
			resize(keys.length >> 1);
	}
	
	/**
	 * 键key在表中是否有对应的值
	 * @param key
	 * @return
	 */
	public boolean contains(Key key){
		if(get(key)!=null)
			return true;
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
	 * 最小的键
	 * @return
	 */
	public Key min(){
		return keys[0];
		
	}
	
	/**
	 * 最大的键
	 * @return
	 */
	public Key max(){
		return keys[N-1];
		
	}
	/**
	 * 小于等于key的最大键
	 * @param key
	 */
	public Key floor(Key key){
		if(key==null)
			return null;
		
		int rank = rank(key);
		
		if(rank==N){
			return keys[rank-1];
		}
		if(rank==0){
			if(key.compareTo(keys[rank]) == 0){
				return keys[rank];
			}
			else
				return null;
		}
		//rank取[1,N-1]时
		if(key.compareTo(keys[rank]) == 0){
			return keys[rank];
		}
		else
			return keys[rank-1];
			
	}
	/**
	 * 大于等于key的最小键
	 * @param key
	 */
	public Key ceiling(Key key){
		if(key==null)
			return null;
		
		int i = rank(key);
		return i == N ? null:keys[i];
	}
	/**
	 * 小于key的键的数量
	 * 如果表中存在该键，rank（）应返回该键的位置，也就是表中小于它的键的数量；
	 * 如果表中不存在该键，rank（）还是应该返回表中小于它的键的数量
	 * @param key
	 * @return
	 */
	public int rank(Key key){
		int lo=0,hi=N-1;
		while(lo<=hi){
			int mid = lo+(hi-lo)/2;
			int cmp = key.compareTo(keys[mid]);
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
	 * 排名为k的键
	 * @param k的取值范围[0,N-1]
	 * @return
	 */
	public Key select(int k){
		return keys[k];
	}
	/**
	 * 删除最小的键
	 */
	public void deleteMin(){
		delete(min());
	}
	/**
	 * 删除最大的键
	 */
	public void deleteMax(){
		delete(max());
	}
	/**
	 * [lo...hi]之间键的数量(符号表中的键)
	 * @param lo
	 * @param hi
	 * @return
	 */
	public int size(Key lo,Key hi){
		if(hi.compareTo(lo)<0)
			return 0;
		else if(contains(hi))
			return rank(hi)-rank(lo)+1;
		else
			return rank(hi)-rank(lo);
	}
	/**
	 * [lo...hi]之间的所有键，已排序
	 * @return
	 */
	public Iterable<Key> keys(Key lo,Key hi){
		Queue<Key> q = new Queue<Key>();
		for(int i=rank(lo);i<rank(hi);i++){
			q.enqueue(keys[i]);
		}
		if(contains(hi))
			q.enqueue(keys[rank(hi)]);
		
		return q;
		
	}
	/**
	 * 表中的所有键的集合，已排序
	 * @return
	 */
	public Iterable<Key> keys(){
		return keys(min(),max());
		
	}
}
