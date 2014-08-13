public class TestClientFixedCapacityStack
{
	public static void main(String[] args){
		//FixedCapacityStack<String> s = new FixedCapacityStack<String>(100);
		Stack<String> s = new Stack<String>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if(!item.equals("-")) {
				s.push(item);
			}else if(!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + "left on stack)");
	}
}