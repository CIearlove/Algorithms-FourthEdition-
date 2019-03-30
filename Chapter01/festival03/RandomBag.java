package festival03;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;
/**
 * 随机背包：
 * 每次迭代过程，应该随机访问背包中的所有元素。
 * 
 * 思路：
 * 用数组保存所有元素并在迭代器的构造函数中随机打乱它们的顺序。
 * @author Administrator
 *
 * @param <Item>
 */
public class RandomBag<Item> implements Iterable<Item>{

	private Item[] a;//bag entries
	private int N;
	private int head;
	
	public RandomBag(){
		a = (Item[])new Object[1];
	}
	boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	
	public void add(Item item){
		if(N==a.length)
			resize(2*a.length);
		a[head++] = item;
		N++;
	}
	
	private void resize(int cap) {
		Item[] temp = (Item[])new Object[cap];
		for(int i=0;i<N;i++){
			temp[i] = a[i];
		}
		a = temp;
	}
	
	private Item[] randomCopy(){
		Item[] random = (Item[]) new Object[N];
		for(int i=0;i<N;i++){
			random[i] = a[i];
		}
		
		for(int i=0;i<random.length;i++){
			int r = i + StdRandom.uniform(random.length - i);
			Item tmp = random[r];
			random[r] = random[i];
			random[i] = tmp;
		}
		return random;
	}
	@Override
	public Iterator<Item> iterator() {
		return new randomIterator();
	}
	private class randomIterator<Item> implements Iterator<Item>{
		private Item[] randomArray;
		private int index;
		public randomIterator(){
			randomArray = (Item[]) randomCopy();
		}
		@Override
		public boolean hasNext() {
			return index < randomArray.length;
		}

		@Override
		public Item next() {
			return randomArray[index++];
		}
		
	}
}
