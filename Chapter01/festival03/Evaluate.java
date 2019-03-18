package festival03;
import java.util.Stack;
import edu.princeton.cs.algs4.*;
public class Evaluate {

	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		
		while(StdIn.hasNextChar()){
			//��ȡ�ַ���������������ѹ�������ջ
			char c = StdIn.readChar();
			String s = Character.toString(c);
			
			if(s.equals("\r")) continue;
			if(s.equals("\n")) break;
			/*
			if(s.equals("(")) continue;
			else if(s.equals("+")) {
				ops.push("+");
				continue;
			}
			else if(s.equals("-")) {
				ops.push("-");
				continue;
			}
			else if(s.equals("*")) {
				ops.push("*");
				continue;
			}
			else if(s.equals("/")) {
				ops.push("/");
				continue;
			}
			else if(s.equals("sqrt")) {
				ops.push("sqrt");
				continue;
			}
			else if(s.equals(")")){
				//����ַ�Ϊ��)��������������Ͳ�������������ѹ�������ջ
				double value1 = vals.pop();
				double value2 = vals.pop();
				String op = ops.pop();
				if(op.equals("+")) vals.push(value2+value1);
				if(op.equals("-")) vals.push(value2-value1);
				if(op.equals("*")) vals.push(value2*value1);
				if(op.equals("/")) vals.push(value2/value1);
			}
			//��ȡ�ַ�������ǲ���������ѹ�������ջ��
			else vals.push(Double.parseDouble(s));
			*/
			
			
			switch (s){
			case "(": break;
			//��ȡ�ַ���������������ѹ�������ջ
			case "+": ops.push("+"); break;
			case "-": ops.push("-"); break;
			case "*": ops.push("*"); break;
			case "/": ops.push("/"); break;
			//����ַ�Ϊ��)��������������Ͳ�������������ѹ�������ջ
			case ")": 
				double value1 = vals.pop();
				double value2 = vals.pop();
				String op = ops.pop();
				/*
				if(op.equals("+")) vals.push(value2+value1);
				if(op.equals("-")) vals.push(value2-value1);
				if(op.equals("*")) vals.push(value2*value1);
				if(op.equals("/")) vals.push(value2/value1);
				*/
				switch (op){
				case "+": vals.push(value2+value1); break;
				case "-": vals.push(value2-value1); break;
				case "*": vals.push(value2*value1); break;
				case "/": vals.push(value2/value1); break;
				}
				break;
			default: vals.push(Double.parseDouble(s));
			}
		}
		StdOut.println(vals.pop());
	}

}
