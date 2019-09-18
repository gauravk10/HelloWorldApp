import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListDemoApp {

	public void generateWishMessage(){
		//logic
	}

	public static void main(String[] args) {
		System.out.println("main() method is called");
		ArrayList list = new ArrayList();
		System.out.println("initial capacity of list is " + list.size());
		list.add(1);
		list.add("A");
		list.add(true);
		list.add(10);
		System.out.println("initial capacity of list is " + list.size());
		System.out.println(list);
		list.add(1, 6.5);
		System.out.println(list);
		for (Object object : list) {
			System.out.println(object);
		}
		// generic list
		ArrayList<String> nameList = new ArrayList<>();
		nameList.add("raja");
		nameList.add("ramesh");
		nameList.add("rani");
		nameList.add("karan");
		System.out.println(nameList);
		// iterate list using iterator
		Iterator<String> itr = nameList.iterator();
		System.out.println("iterate list using Iterator");
		while (itr.hasNext()) {
			String name = itr.next();
			if (name.equalsIgnoreCase("karan"))
				itr.remove();
		}
		System.out.println(nameList);
		System.out.println("iterate list using ListIterator");
		ListIterator<String> nameListItr = nameList.listIterator();
		while(nameListItr.hasNext()) {
			nameListItr.add("karan");
		}
		System.out.println(nameList);
	}

}
