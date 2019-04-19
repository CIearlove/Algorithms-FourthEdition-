package festival01;

import festival03.Queue;

/**
 * ������������Ķ��ֲ���
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
		//Key���͵�Comparable���������
		keys = (Key[]) new Comparable[1];
		//Value���͵�Object���������
		values = (Value[]) new Object[1];
	}
	/**
	 * ���������С
	 * @param newSize �����µĴ�С
	 */
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
	 * ����ֵ�Դ������
	 * @param key ��
	 * @param val ֵ
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
		if(N==keys.length){
			resize(N<<1);//��N�Ķ����Ʊ�ʾ����һλ
		}
		
		int rank = rank(key);
		//key�����ڱ���ʱ
		if(rank<N && key.compareTo(keys[rank]) == 0){
			values[rank] = val;
			return;
		}
		//key�������ڱ���ʱ
		for(int i=N;i>rank;i--){
			keys[i] = keys[i-1];
			values[i] = values[i-1];
		}
		keys[rank] = key;
		values[rank] = val;
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
		
		if(i<N && keys[i].compareTo(key) == 0){
			//�ҵ�����Ӧ��ֵ
			return values[i];
		}
		return null;
	}
	
	/**
	 * �ӱ���ɾȥ��key�������Ӧ��ֵ��
	 * @param key ��
	 */
	public void delete(Key key){
		//����Ϊ��ʱ������
		if(key==null)
			return;
		
		int rank = rank(key);
		//key�����ڱ���ʱ
		if(rank<N && key.compareTo(keys[rank]) == 0){
			for(int i=rank;i<N;i++){
				keys[i] = keys[i+1];
				values[i] = values[i+1];
			}
			N--;
		}
		//��������������������
		if(N>=0 && N == keys.length >> 2)
			resize(keys.length >> 1);
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
		return keys[0];
		
	}
	
	/**
	 * ���ļ�
	 * @return ���ļ�
	 */
	public Key max(){
		return keys[N-1];
		
	}
	/**
	 * С�ڵ���key������
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
		//rankȡ[1,N-1]ʱ
		if(key.compareTo(keys[rank]) == 0){
			return keys[rank];
		}
		else
			return keys[rank-1];
			
	}
	/**
	 * ���ڵ���key����С��
	 * @param key
	 */
	public Key ceiling(Key key){
		if(key==null)
			return null;
		
		int i = rank(key);
		return i == N ? null:keys[i];
	}
	/**
	 * С��key�ļ�������
	 * ������д��ڸü���rank����Ӧ���ظü���λ�ã�Ҳ���Ǳ���С�����ļ���������
	 * ������в����ڸü���rank��������Ӧ�÷��ر���С�����ļ�������
	 * @param key
	 * @return С��key�ļ�������
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
				//������д��ڸü���rank����Ӧ���ظü���λ�ã�Ҳ���Ǳ���С�����ļ�������
				return mid;
		}
		//������в����ڸü���rank��������Ӧ�÷��ر���С�����ļ�������
		return lo;
	}
	/**
	 * ����Ϊk�ļ�
	 * @param k��ȡֵ��Χ[0,N-1]
	 * @return ����Ϊk�ļ�
	 */
	public Key select(int k){
		return keys[k];
	}
	/**
	 * ɾ����С�ļ�
	 */
	public void deleteMin(){
		delete(min());
	}
	/**
	 * ɾ�����ļ�
	 */
	public void deleteMax(){
		delete(max());
	}
	/**
	 * [lo...hi]֮���������(���ű��еļ�)
	 * @param lo ��ʼ�ļ�
	 * @param hi �����ļ�
	 * @return [lo...hi]֮���������
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
	 * [lo...hi]֮������м���������
	 * @return [lo...hi]֮������м�
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
	 * ���е����м��ļ��ϣ�������
	 * @return ���е����м��ļ���
	 */
	public Iterable<Key> keys(){
		return keys(min(),max());
		
	}
}
