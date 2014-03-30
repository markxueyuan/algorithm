
public class Counter {
	public String name;
	public int num;
	
	public Counter(String id){
		name = id;
		num = 0;
	}
	
	public void increment(){
		num++;
	}
	
	public int tally(){
		return num;
	}
	
	public String pp(){
		return name;
	}
	
	public static void main(String[] args){
		Counter heads;
		Counter tails;
		heads = new Counter("heads");
		tails = new Counter("tails");
		
		heads.increment();
		heads.increment();
		tails.increment();
		System.out.println(heads.tally() - tails.tally());
	}
}
