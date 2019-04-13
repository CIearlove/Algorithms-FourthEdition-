package festival01;

import festival03.Queue;

/**
 * ���������е�˳�����
 * @author Administrator
 *
 */
public class SequentialSearchST<Key,Value> {
	
	private Node first;//������׽��
	private int N;//��ֵ�Ե�����
	
	private class Node{
		//������Ķ���
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
	 * ��ȡ��key��Ӧ��ֵ
	 * ����key�������򷵻�null
	 * 
	 * ����ʵ�֣�
	 * ����������equals���������Ƚ��豻���ҵļ���ÿ������еļ���
	 * ���ƥ��ɹ����Ǿͷ�����Ӧ��ֵ���������Ƿ���null��
	 * @param key
	 * @return
	 */
	public Value get(Key key){
		Node tra=first;
		while(tra!=null){
			if(tra.key.equals(key)){
				//ƥ��ɹ�
				return tra.val ;
			}
			tra = tra.next;
		}
		return null;//ƥ�䲻�ɹ�
	}
	/**
	 * ����ֵ�Դ������
	 * ��ֵΪ���򽫼�key�ӱ�ɾ������δʵ�֣�
	 * 
	 * ����ʵ�֣�
	 * ����������equals���������Ƚ��豻���ҵļ���ÿ������еļ���
	 * ���ƥ��ɹ����Ǿ��õڶ�������ָ����ֵ���º͸ü��������ֵ��
	 * �������Ǿ��ø����ļ�ֵ�Դ���һ���µĽ�㲢�����������Ŀ�ͷ��
	 * @param key
	 * @param val
	 */
	public void put(Key key,Value val){
		Node tra=first;
		//����������equals���������Ƚ��豻���ҵļ���ÿ������еļ�
		while(tra!=null){
			if(tra.key.equals(key)){
				//ƥ��ɹ�
				tra.val = val;
				return;
			}
			tra=tra.next;
		}
			//ƥ�䲻�ɹ�
			first = new Node(key,val,first);
			N++;
		
	}
	/**
	 * �ӱ���ɾȥ��key�������Ӧ��ֵ��
	 * @param key
	 */
	public void delete(Key key){
		Node tra = first;
		//��key��Ӧ�Ľ��Ϊ�׽��ʱ
		if(tra.key.equals(key)){
			first = first.next;
			N--;
			return;
		}
		while(tra.next!=null){
			if(tra.next.key.equals(key)){
				//�ҵ���key��Ӧ�Ľ��
				tra.next = tra.next.next;
				N--;
			}
			tra = tra.next;
		}
	}
	/**
	 * ��key�ڱ����Ƿ��ж�Ӧ��ֵ
	 * @param key
	 * @return
	 */
	public boolean contains(Key key){
		Node tra=first;
		//����������equals���������Ƚ��豻���ҵļ���ÿ������еļ�
		while(tra!=null){
			if(tra.key.equals(key)){
				//ƥ��ɹ�
				return true;
			}
			tra=tra.next;
		}
		return false;
	}
	/**
	 * ���Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return N==0;
	}
	/**
	 * ���еļ�ֵ������
	 * @return
	 */
	public int size(){
		return N;
	}
	/**
	 * ���е����м��ļ���
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
