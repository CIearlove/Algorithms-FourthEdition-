package festival01;

import edu.princeton.cs.algs4.StdOut;

public class TestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequentialSearchST<String,Integer> st = new SequentialSearchST<String,Integer>();
		String[] example = {"S","E","A","R","C","H","E","X","A","M","P","L","E"};
		//将键值对存入表中
		for(int i=0;i<example.length;i++){
			st.put(example[i],i);
		}
		
		//获取表中所有键对应的值
		for(String s :st.keys()){
			StdOut.print(s+":"+st.get(s)+", ");
		}
		StdOut.println();
		
		//从表中删去键“L”、“E”
		st.delete("L");
		st.delete("E");
		for(String s :st.keys()){
			StdOut.print(s+":"+st.get(s)+", ");
		}
		StdOut.println();
		
		//键“L”、“E”在表中是否有对应的值
		StdOut.println("L contained "+st.contains("L"));
		StdOut.println("E contained "+st.contains("E"));
		
		//表是否为空
		StdOut.println("ST is empty? "+st.isEmpty());
		
		//表中键值对的数量
		StdOut.println("ST's elements amount: "+st.size());
	}

}
