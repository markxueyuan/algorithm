
public class TryFixedCapacityStackOfStrings {
	public static void main(String[] args){
		FixedCapacityStackOfStrings s;
		s = new FixedCapacityStackOfStrings(100);
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if(!item.equals("-"))
				s.push(item);
			else if(!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}
