package festival01;

import edu.princeton.cs.algs4.StdOut;
/**
 * 不需要交换的插入排序。
 * 基本思想：
 * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 
 * 算法步骤：
 * 1.将待排序序列的第一个元素看作一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 * 2.扫描未排序序列，找到每个未排序元素应插入到有序序列中的位置。
 * 3.将该位置后元素逐个右移，将未排序元素插入有序序列中。
 * @author Administrator
 *
 */
public class _2_1_25_Insertion {
		/**
		 * 排序代码
		 * @param a
		 */
		public static void sort(Comparable[] a) {
			for(int i=1;i<a.length;i++){//扫描未排序序列
				//待插入的元素
				Comparable t = a[i];
				//应插入的位置
				int j;
				for(j=i; j>0 && less(t,a[j-1]); j--){
					a[j] = a[j-1];//将较大元素右移一位
				}
				//将待插入的元素插入到应插入的位置
				a[j] = t;
			}
		}
		/**
		 * 对元素进行比较
		 * @param v
		 * @param w
		 * @return
		 */
		public static  boolean less(Comparable v,Comparable w) {
			return v.compareTo(w) < 0;
			
		}
		/**
		 * 将元素交换位置
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
		 * 在单行中打印数组
		 * @param a
		 */
		public static void show(Comparable[] a) {
			for(int i=0;i<a.length;i++)
				StdOut.print(a[i]+" ");
			StdOut.println();
		}
		/**
		 * 测试数组元素是否有序
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
