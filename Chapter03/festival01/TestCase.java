package festival01;

import edu.princeton.cs.algs4.StdOut;

public class TestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequentialSearchST<String,Integer> st = new SequentialSearchST<String,Integer>();
		String[] example = {"S","E","A","R","C","H","E","X","A","M","P","L","E"};
		//����ֵ�Դ������
		for(int i=0;i<example.length;i++){
			st.put(example[i],i);
		}
		
		//��ȡ�������м���Ӧ��ֵ
		for(String s :st.keys()){
			StdOut.print(s+":"+st.get(s)+", ");
		}
		StdOut.println();
		
		//�ӱ���ɾȥ����L������E��
		st.delete("L");
		st.delete("E");
		for(String s :st.keys()){
			StdOut.print(s+":"+st.get(s)+", ");
		}
		StdOut.println();
		
		//����L������E���ڱ����Ƿ��ж�Ӧ��ֵ
		StdOut.println("L contained "+st.contains("L"));
		StdOut.println("E contained "+st.contains("E"));
		
		//���Ƿ�Ϊ��
		StdOut.println("ST is empty? "+st.isEmpty());
		
		//���м�ֵ�Ե�����
		StdOut.println("ST's elements amount: "+st.size());
	}

}
