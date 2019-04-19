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
		 * 统计文本中单词数、不同的单词数
		 * @param file 装有字符串的文本
		 * @param minLen 单词长度
		 * @throws FileNotFoundException
		 */
		public void initialization(File file,int minLen) throws FileNotFoundException{
			Scanner input = new Scanner(file);
			while(input.hasNext()){
				
				//构造符号表并统计频率
				String word = input.next();
				//忽略较短的单词,不加入符号表中
				if(word.length()<minLen)
					continue;
				
				numberOfWords++;
				if(!st.contains(word)){
					//符号表中没有该键
					st.put(word, 1);
					differentWords++;
				}
				else
					//符号表中已经有该键
					st.put(word, st.get(word)+1);
			}
			
			input.close();
		}
		/**
		 * 找出出现频率最高的单词
		 * @return 单词
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

