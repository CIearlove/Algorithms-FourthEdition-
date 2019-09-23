package festival02;

import edu.princeton.cs.algs4.StdOut;

/**
 * ʵ�ֹ鲢�������һ�ַ������ȹ鲢��Щ΢�����飬Ȼ���ٳɶԹ鲢�õ��������顣
 * ���ڳ���ΪN���������飬�Ե����ϵĹ鲢������Ҫ1/2N*log2N��N*log2N�αȽϣ�����������6*N*log2N�Ρ�
 * @author Administrator
 *
 */
public class MergeDownToTop {
	
	private static Comparable[] aux;//�����鲢����ĸ�������
	/**
	 * �������
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];//һ���Է���ռ�
		mergeSort(a);
	}
	
	private static void mergeSort(Comparable[] a) {
		//����lgN�������鲢
		int N = a.length;
		for(int sz=1;sz<N;sz=sz*2){//������Ĵ�С
			for(int lo=0;lo<N-sz;lo+=sz*2){//����������
				merge(a,lo,lo+sz-1,Math.min(lo+2*sz-1, N-1));
			}
		}
	}
	
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		//��a[lo..mid]��a[mid+1..hi]�鲢
		int i=lo,j=mid+1;
		Comparable[] aux = new Comparable[a.length];
		
		for(int k=lo;k<=hi;k++){//��a[lo..hi]���Ƶ�aux[lo..hi]
			aux[k] = a[k];
		}
		
		for(int k=lo;k<=hi;k++){//�鲢�ص�a[lo..hi]
			if(i>mid) //�����þ���ȡ�Ұ�ߵ�Ԫ�أ�
				a[k] = aux[j++];
			else if(j>hi) //�Ұ���þ���ȡ���ߵ�Ԫ�أ�
				a[k] = aux[i++];
			else if(less(aux[j],aux[i])) //�Ұ�ߵĵ�ǰԪ��С�����ߵĵ�ǰԪ�أ�ȡ�Ұ�ߵ�Ԫ�أ�
				a[k] = aux[j++];
			else //�Ұ�ߵĵ�ǰԪ�ش��ڵ������ߵĵ�ǰԪ�أ�ȡ���ߵ�Ԫ�أ�
				a[k] = aux[i++];
		}
	}
	
	/**
	 * ��Ԫ�ؽ��бȽ�
	 * @param v
	 * @param w
	 * @return
	 */
	public static  boolean less(Comparable v,Comparable w) {
		return v.compareTo(w) < 0;
		
	}
	/**
	 * ��Ԫ�ؽ���λ��
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void exch(Comparable[] a,int i,int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	/**
	 * �ڵ����д�ӡ����
	 * @param a
	 */
	public static void show(Comparable[] a) {
		for(int i=0;i<a.length;i++)
			StdOut.print(a[i]+" ");
		StdOut.println();
	}
	/**
	 * ��������Ԫ���Ƿ�����
	 * @param a
	 * @return
	 */
	public static boolean isSorted(Comparable[] a) {
		for(int i=1;i<a.length;i++)
			if(less(a[i],a[i-1]))
				return false;
		
		return true;
	}
	
	public static void main(String[] arg){
		Comparable[] a = {'E','E','G','M','R','A','C','E','R','T'};
		int lo=0,hi=a.length-1,mid=(lo+hi)/2;
		sort(a);
		if(isSorted(a)){
			show(a);
		}
	}
}
