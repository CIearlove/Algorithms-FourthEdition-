package festival01;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MyFrequencyCounter{
	
	public static class FrequencyCounter {

		private BinarySearchST<String,Integer> st;
		private int numberOfWords;
		private int differentWords;
		
		public FrequencyCounter(){
			this.st = new BinarySearchST<String,Integer>();
			this.differentWords = 0;
			this.numberOfWords = 0;
		}
		/**
		 * ͳ���ı��е���������ͬ�ĵ�����
		 * @param file װ���ַ������ı�
		 * @param minLen ���ʳ���
		 * @throws FileNotFoundException
		 */
		public void initialization(File file,int minLen) throws FileNotFoundException{
			Scanner input = new Scanner(file);
			while(input.hasNext()){
				
				//������ű�ͳ��Ƶ��
				String word = input.next();
				//���Խ϶̵ĵ���,��������ű���
				if(word.length()<minLen)
					continue;
				
				numberOfWords++;
				if(!st.contains(word)){
					//���ű���û�иü�
					st.put(word, 1);
					differentWords++;
				}
				else
					//���ű����Ѿ��иü�
					st.put(word, st.get(word)+1);
			}
			
			input.close();
		}
		/**
		 * �ҳ�����Ƶ����ߵĵ���
		 * @return ����
		 */
		public String highestFrequencyWord(){
			String max = st.select(0);
			for(String word : st.keys()){
				if(st.get(word)>st.get(max))
					max = word;
			}
			return max;
		}
		
		public int getNumberOfWords() {
			return numberOfWords;
		}
		
		public int getDifferentWords() {
			return differentWords;
		}
		public BinarySearchST<String, Integer> getSt() {
			return st;
		}

	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("data/tale.txt");
		FrequencyCounter fc = new FrequencyCounter();
		fc.initialization(file,10);
		StdOut.println("numberOfWords:"+fc.getNumberOfWords()+"  differentWords:"+fc.getDifferentWords());
		StdOut.println("highestFrequencyWord:"+fc.highestFrequencyWord()+" "+fc.getSt().get(fc.highestFrequencyWord())+"times");
	}

}

