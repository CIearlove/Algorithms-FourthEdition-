package festival01;

import edu.princeton.cs.algs4.StdOut;
/**
 * ϣ�������ǻ��ڲ��������һ���������ʶ�����Ľ������ģ�
 * 1.���������ڶԼ����Ѿ��ź�������ݲ���ʱ��Ч�ʸߣ�
 * 2.��������ÿ��ֻ�ܽ������ƶ�һλ��
 * 
 * ����˼�룺
 * ���������������зָ�����ɸ������зֱ����ֱ�Ӳ������򣬴����������еļ�¼����������ʱ���ٶ�ȫ���¼��������ֱ�Ӳ�������
 * 
 * �㷨���裺
 * 1.ѡ��һ����������t1 t2 ...... tk,����ti>tk,tk=1;
 * 2.���������и���k�������н���k������;
 * 3.ÿ�����򣬸��ݶ�Ӧ������ti�������������зָ�����ɸ�����Ϊm�������У��ֱ�Ը������н���ֱ�Ӳ�������
 * @author Administrator
 *
 */
public class Shell {
	/**
	 * �������
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		//����1,4,13,40,121,364,1093...
		int increment = 1;
		while(increment<a.length/3){
			increment = 3*increment+1;
		}

		while(increment>=1){
			//System.out.println(increment);
			//ÿ�����򣬸��ݶ�Ӧ������increment�������������зָ�����ɸ������У��ֱ�Ը������н���ֱ�Ӳ�������
			for(int i=increment;i<a.length;i++){
				for(int j=i; j>=increment && less(a[j],a[j-increment]); j=j-increment){
					exch(a,j,j-increment);
				}
			}
			increment = increment/3;//������
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
	 * �������е�Ԫ�ؽ���λ��
	 * @param a ����a
	 * @param i Ԫ���±�i
	 * @param j Ԫ���±�j
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
	 * �ӱ�׼�����ȡ�ַ������������������
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] a = {12,10,8,6,4,2,0};
		sort(a);
		if(isSorted(a)){
			show(a);
		}
	}
}
