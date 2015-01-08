
public class ImplementStringMethods {
	
	public static Boolean isParlindrome(String s){
		int N = s.length();
		for(int i = 0; i < N/2; i++)
			if(s.charAt(i) != s.charAt(N-i-1))
				return false;
		return true;
	}
	
	public static String[] extractFileName(String s){
		int dot = s.indexOf(".");
		String[] output = new String[2];
		output[0] = s.substring(0,dot);
		output[1] = s.substring(dot + 1, s.length());
		return output;
	}
	
	public static void searchString(String query){
		while(!StdIn.isEmpty()){
			String s = StdIn.readLine();
			if(s.contains(query)) StdOut.println(s);
		}
	}
	
	public static String[] splitString(){
		String input = StdIn.readAll();
		String[] words = input.split("\\s+");
		return words;
	}
	
	public static boolean isSorted(String[] a){
		for(int i = 1; i < a.length; i++)
			if (a[i-1].compareTo(a[i]) > 0)
				return false;
		return true;
	}
	
	public static void main(String[] args){
		StdOut.println(isParlindrome("I am a ma I"));
		
		String[] a = extractFileName("abc.exe");
		StdOut.println(a[0]);
		StdOut.println(a[1]);
		
		String[] words = splitString();
		for(int i = 0; i< words.length; i++){
			StdOut.println(words[i]);
		}
		StdOut.println(isSorted(words));		
	}
}
