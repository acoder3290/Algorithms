public class StackEvaluate
{
	public static void main(String[] args){
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();

		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if(s.equals("(")){
				;
			}else if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
				ops.push(s);
			}else if(s.equals(")")){
				String op = ops.pop();
				double v = vals.pop();
				if(op.equals("+")){
					v = vals.pop() + v;
				}else if(op.equals("-")){
					v = vals.pop() - v;
				}else if(op.equals("*")){
					v = vals.pop() * v;
				}else if(op.equals("/")){
					v = vals.pop() / v;
				}
				vals.push(v);
			}else {
				vals.push(Double.parseDouble(s));
			}
		}
		StdOut.println(vals.pop());
	}
}