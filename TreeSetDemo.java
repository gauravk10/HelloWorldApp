import java.util.*;

public class TreeSetDemo{
	public static void main(String[] args){
		TreeSet ts = new TreeSet();
		ts.add("A");
		ts.add("a");
		ts.add("B");
		ts.add("Z");
		ts.add(new Integer(10));
		//ts.add(null);
		System.out.println(ts);
	}
}