package festival01;

import edu.princeton.cs.algs4.StdOut;
/**
 * 首先，找到数组中最小的那个元素，将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）。
 * 接着，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。
 * 如此往复，直到将整个数组排序。
 * 
 * 交换元素的代码写在内循环之外，每次交换都能排定一个元素，因此交换的总次数是N。
 * 对于长度为N的数组，选择排序大约需要N^2/2次比较。
 * 
 * 运行时间和输入无关：为了找出最小的元素而扫描一遍数组并不能为下一遍扫描提供什么信息。
 * 数据移动是最少的：交换次数和数组大小是线性关系。
 * @author Administrator
 *
 */
public class Selection {
	/**
	 * 排序代码
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		
		for(int i=0;i<a.length;i++){
			//将a[i]和a[i+1..a.length]中最小的元素交换
			int minIndex = i;
			for(int j=i+1;j<a.length;j++)
				if(less(a[j],a[minIndex]))//比较
					minIndex = j;
			exch(a,i,minIndex);//交换
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
	 * 从标准输入读取字符串，将它们排序并输出
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a = "1#2#3#4".split("#");
		sort(a);
		if(isSorted(a)){
			show(a);
		}
	}
}
