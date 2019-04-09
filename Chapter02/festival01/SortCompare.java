package festival01;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import festival04.Stopwatch;

public class SortCompare {
	/**
	 * 
	 * @param alg �����㷨
	 * @param a �ɱȽϵ�����
	 * @return �������㷨��������ʱ��
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
	 * ʹ�������㷨��T������ΪN����������
	 * @param alg �����㷨
	 * @param T ����ĸ���
	 * @param N ��������ĳ���
	 * @return ��T������ΪN������������Ҫ��ʱ��
	 */
	public static double timeRandomInput(String alg,int T,int N){
		double totalElapsedTime = 0;//�ܻ���ʱ��
		Double[] a = new Double[N];//�����������
		
		for(int t=0;t<T;t++){
			//��ʼ������
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
