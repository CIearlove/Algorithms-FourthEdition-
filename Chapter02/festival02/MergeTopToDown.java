package festival02;

import edu.princeton.cs.algs4.StdOut;
/**
 * �鲢����ԭ��
 * Ҫ��һ���������򣬿����ȣ��ݹ�أ������ֳ�����ֱ�����Ȼ�󽫽���鲢������
 * 
 * �Զ����µĹ鲢����
 * ����1�����ڳ���ΪN���������飬�Զ����µĹ鲢������Ҫ1/2N*log2N��N*log2N�αȽϡ�
 * ����2�����ڳ���ΪN���������飬�Զ����µĹ鲢���������Ҫ��������6*N*log2N�Ρ�
 * 
 * �ŵ㣺�����ù鲢���������������������ģ�����飬���ǲ����������ѡ�������������ġ�
 * ȱ�㣺����������ʹ�õĶ���ռ��N�Ĵ�С�����ȡ�
 * @author Administrator
 *
 */
public class MergeTopToDown {
	
	private static Comparable[] aux;//�����鲢����ĸ�������
	/**
	 * �������
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];//һ���Է���ռ�
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		//������a[lo..hi]����
		if(hi<=lo)
			return;
		int mid = lo+(hi-lo)/2;
		sort(a,lo,mid);//����������
		sort(a,mid+1,hi);//���Ұ������
		merge(a,lo,mid,hi);
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
	/**
	 * �鲢
	 * @param a ���鲢����
	 * @param lo ��ʼ�±�
	 * @param mid �м��±�
	 * @param hi �����±�
	 */
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		//��a[lo..mid]��a[mid+1..hi]�鲢
		int i=lo,j=mid+1;
		//Comparable[] aux = new Comparable[a.length];
		
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
	 * �ӱ�׼�����ȡ�ַ������������������
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a = "M#E#R#G#E#S#O#R#T#E#X#A#M#P#L#E".split("#");
		sort(a);
		if(isSorted(a)){
			show(a);
		}
	}
}
