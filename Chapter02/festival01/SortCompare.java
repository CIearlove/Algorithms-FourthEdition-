package festival01;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import festival04.Stopwatch;

public class SortCompare {
	/**
	 * 
	 * @param alg 排序算法
	 * @param a 可比较的数组
	 * @return 该排序算法运行所需时间
	 */
	public static double time(String alg,Comparable[] a){
		Stopwatch timer = new Stopwatch();
		switch (alg){
			case "Insertion":
				Insertion.sort(a);
				break;
			case "Selection":
				Selection.sort(a);
				break;
			case "Shell":
				Shell.sort(a);
				break;
			case "Merge":
				Merge.sort(a);
				break;
			case "Quick":
				Quick.sort(a);
				break;
			case "Heap":
				Heap.sort(a);
				break;
		}
		return timer.elapsedTime();
	}
	
	/**
	 * 使用排序算法将T个长度为N的数组排序
	 * @param alg 排序算法
	 * @param T 数组的个数
	 * @param N 单个数组的长度
	 * @return 将T个长度为N的数组排序需要的时长
	 */
	public static double timeRandomInput(String alg,int T,int N){
		double totalElapsedTime = 0;//总花费时长
		Double[] a = new Double[N];//待排序的数组
		
		for(int t=0;t<T;t++){
			//初始化数组
			for(int i=0;i<N;i++){
				a[i] = StdRandom.uniform();
			}
			totalElapsedTime += time(alg,a);
		}
		return totalElapsedTime;
	}
	
	public static void main(String[] args){
		final String alg1 = new String("Selection");
		final String alg2 = new String("Insertion");
		
		double t1 = timeRandomInput(alg1,1000,100);
		double t2 = timeRandomInput(alg2,1000,100);
		
		StdOut.printf("%s totalElapsedTime: %.6f\n",alg1,t1);
		StdOut.printf("%s totalElapsedTime: %.6f",alg2,t2);
	}
}
