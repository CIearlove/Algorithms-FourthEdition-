package festival03;
import java.util.Stack;
import edu.princeton.cs.algs4.*;
public class Evaluate {

	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		
		while(StdIn.hasNextChar()){
			//读取字符，如果是运算符则压入运算符栈
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
				//如果字符为“)”，弹出运算符和操作数，计算结果压入操作数栈
				double value1 = vals.pop();
				double value2 = vals.pop();
				String op = ops.pop();
				if(op.equals("+")) vals.push(value2+value1);
				if(op.equals("-")) vals.push(value2-value1);
				if(op.equals("*")) vals.push(value2*value1);
				if(op.equals("/")) vals.push(value2/value1);
			}
			//读取字符，如果是操作数将其压入操作数栈中
			else vals.push(Double.parseDouble(s));
			*/
			
			
			switch (s){
			case "(": break;
			//读取字符，如果是运算符则压入运算符栈
			case "+": ops.push("+"); break;
			case "-": ops.push("-"); break;
			case "*": ops.push("*"); break;
			case "/": ops.push("/"); break;
			//如果字符为“)”，弹出运算符和操作数，计算结果压入操作数栈
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
