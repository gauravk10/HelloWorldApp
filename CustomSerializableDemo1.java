//customized serialization for data loss

import java.io.*;

class UserCredential implements Serializable {

	String username;
	transient String password;
	transient int pincode;

	UserCredential(String username,String password,int pincode) {
		this.username = username;
		this.password = password;
		this.pincode = pincode;
		System.out.println("UserCredential:: 2-param constructor");
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {	//callback method
		oos.defaultWriteObject();
		String encpwd = "123" + password;
		oos.writeObject(encpwd);
		int encpincode = 4444 + pincode;
		oos.writeInt(encpincode);
	}

	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {	//callback method
		ois.defaultReadObject();
		String encpwd =  (String)ois.readObject();
		password = encpwd.substring(3);
		int encpincode = ois.readInt();
		pincode =  encpincode - 4444;
	}
}

public class CustomSerializableDemo1 {

	public static void main(String[] args) throws Exception {
		UserCredential user1 = new UserCredential("raja","rani",1234);
		System.out.println("username ::" + user1.username + "\tpassword ::" + user1.password + "\tpincode ::" + user1.pincode);
		//serialization
		FileOutputStream fos = new FileOutputStream("userinfo.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(user1);
		//deserialization
		System.out.println("after deserialization");
		FileInputStream fis = new FileInputStream("userinfo.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		UserCredential user2 = (UserCredential) ois.readObject();
		System.out.println("username ::" + user2.username + "\tpassword ::" + user2.password + "\tpincode ::" + user2.pincode);
	}
}