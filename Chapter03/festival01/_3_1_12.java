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
		 * ���������С
		 * @param newSize �����µĴ�С
		 */
		private void resize(int newSize) {
			Item<Key,Value>[] temp = new Item[newSize];
			
			for(int j=0;j<N;j++){
				temp[j] = key_valuePairs[j];
			}
			key_valuePairs = temp;
		}
		
		/**
		 * ����ֵ�Դ������
		 * @param item �������ֵ��item����
		 */
		public void put(Key key,Value val){
			//��Ϊ�գ�����
			if(key == null) return;
			
			//ֵΪ�գ�����key�ӱ���ɾ��
			if(val == null){
				delete(key);
				return;
			}
			
			//������ʱ������
			if(N==key_valuePairs.length){
				resize(N<<1);//��N�Ķ����Ʊ�ʾ����һλ
			}
			
			int rank = rank(key);
			//key�����ڱ���ʱ
			if(rank<N && key.compareTo(key_valuePairs[rank].key) == 0){
				key_valuePairs[rank].val = val;
				return;
			}
			
			//key�������ڱ���ʱ
			for(int i=N;i>rank;i--){
				key_valuePairs[i] = key_valuePairs[i-1];
			}
			key_valuePairs[rank] = new Item<Key,Value>(key,val);
			N++;
		}

		/**
		 * ��ȡ��key��Ӧ��ֵ
		 * ����key�������򷵻�null
		 * @param key ��
		 * @return ��key��Ӧ��ֵ,����key�������򷵻�null
		 */
		public Value get(Key key) {
			//���ű�Ϊ��ʱ
			if(isEmpty())
				return null;
			//С��key�ļ�������������key�ڲ��ڱ���
			int i = rank(key);
			
			if(i<N && key_valuePairs[i].key.compareTo(key) == 0){
				//�ҵ�����Ӧ��ֵ
				return key_valuePairs[i].val;
			}
			return null;
		}
		
		/**
		 * С��key�ļ�������
		 * ������д��ڸü���rank����Ӧ���ظü���λ�ã�Ҳ���Ǳ���С�����ļ���������
		 * ������в����ڸü���rank��������Ӧ�÷��ر���С�����ļ�������
		 * @param key
		 * @return С��key�ļ�������
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
					//������д��ڸü���rank����Ӧ���ظü���λ�ã�Ҳ���Ǳ���С�����ļ�������
					return mid;
			}
			//������в����ڸü���rank��������Ӧ�÷��ر���С�����ļ�������
			return lo;
		}
		/**
		 * �ӱ���ɾȥ��key�������Ӧ��ֵ��
		 * @param key ��
		 */
		public void delete(Key key) {
			//����Ϊ��ʱ������
			if(key==null)
				return;
			
			int rank = rank(key);
			//key�����ڱ���ʱ
			if(rank<N && key.compareTo(key_valuePairs[rank].key) == 0){
				for(int i=rank;i<N;i++){
					key_valuePairs[i] = key_valuePairs[i+1];
				}
				N--;
			}
			//��������������������
			if(N>=0 && N == key_valuePairs.length >> 2)
				resize(key_valuePairs.length >> 1);
		}
		
		/**
		 * ���Ƿ�Ϊ��
		 * @return �Ƿ���true�����򷵻�false
		 */
		public boolean isEmpty(){
			return N==0;
		}
		/**
		 * ���еļ�ֵ������
		 * @return ��ֵ������
		 */
		public int size(){
			return N;
		}
		/**
		 * ��С�ļ�
		 * @return ��С�ļ�
		 */
		public Key min(){
			return key_valuePairs[0].key;
			
		}
		
		/**
		 * ���ļ�
		 * @return ���ļ�
		 */
		public Key max(){
			if(N==0)
				return null;
			return key_valuePairs[N-1].key;
		}
		/**
		 * ��key�ڱ����Ƿ��ж�Ӧ��ֵ
		 * @param key ��
		 * @return �Ƿ���true�����򷵻�false
		 */
		public boolean contains(Key key){
			if(get(key)!=null)
				return true;
			return false;
		}
		/**
		 * [lo...hi]֮������м���������
		 * @return [lo...hi]֮������м�
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
		 * ���е����м��ļ��ϣ�������
		 * @return ���е����м��ļ���
		 */
		public Iterable<Key> keys(){
			return keys(min(),max());
			
		}
	}
	
	public static void main(String[] args) {
		
		BinarySearchST_3_1_12<String,Integer> st = new BinarySearchST_3_1_12<String,Integer>();
		String[] example = {"S","E","A","R","C","H","E","X","A","M","P","L","E"};
		//����ֵ�Դ������
		for(int i=0;i<example.length;i++){
			st.put(example[i],i);
		}
		/*
		//�����еļ�ֵ��ɾ��
		for(int i=0;i<example.length;i++){
			st.delete(st.max());
		}
		*/
		//��ȡ�������м���Ӧ��ֵ
		for(String s :st.keys()){
			StdOut.print(s+":"+st.get(s)+", ");
		}
		StdOut.println();
		
		//�ӱ���ɾȥ����L������E��
		st.delete("L");
		st.delete("E");
		for(String s :st.keys()){
			StdOut.print(s+":"+st.get(s)+", ");
		}
		StdOut.println();
		
		//����L������E���ڱ����Ƿ��ж�Ӧ��ֵ
		StdOut.println("L contained "+st.contains("L"));
		StdOut.println("E contained "+st.contains("E"));
		
		//���Ƿ�Ϊ��
		StdOut.println("ST is empty? "+st.isEmpty());
		
		//���м�ֵ�Ե�����
		StdOut.println("ST's elements amount: "+st.size());
		
	}
}
