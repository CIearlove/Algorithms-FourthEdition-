package festival01;

import edu.princeton.cs.algs4.StdOut;
/**
 * ����Ҫ�����Ĳ�������
 * ����˼�룺
 * ͨ�������������У�����δ�������ݣ��������������дӺ���ǰɨ�裬�ҵ���Ӧλ�ò����롣
 * 
 * �㷨���裺
 * 1.�����������еĵ�һ��Ԫ�ؿ���һ���������У��ѵڶ���Ԫ�ص����һ��Ԫ�ص�����δ�������С�
 * 2.ɨ��δ�������У��ҵ�ÿ��δ����Ԫ��Ӧ���뵽���������е�λ�á�
 * 3.����λ�ú�Ԫ��������ƣ���δ����Ԫ�ز������������С�
 * @author Administrator
 *
 */
public class _2_1_25_Insertion {
		/**
		 * �������
		 * @param a
		 */
		public static void sort(Comparable[] a) {
			for(int i=1;i<a.length;i++){//ɨ��δ��������
				//�������Ԫ��
				Comparable t = a[i];
				//Ӧ�����λ��
				int j;
				for(j=i; j>0 && less(t,a[j-1]); j--){
					a[j] = a[j-1];//���ϴ�Ԫ������һλ
				}
				//���������Ԫ�ز��뵽Ӧ�����λ��
				a[j] = t;
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
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final String alg1 = new String("Insertion");
		final String alg2 = new String("_2_1_25_Insertion");
		
		double t1 = SortCompare.timeRandomInput(alg1,1000,10);
		double t2 = SortCompare.timeRandomInput(alg2,1000,10);
		
		StdOut.printf("%s totalElapsedTime: %.6f\n",alg1,t1);
		StdOut.printf("%s totalElapsedTime: %.6f",alg2,t2);
	}
}
