//PropertiesDemo.java

import java.io.*;
import java.util.*;

public class PropertiesDemo{
	public static void main(String[] args) throws Exception{
		InputStream is = null;
		Properties props = null;
		OutputStream os = null;
		is = new FileInputStream("jdbc.properties");
		props = new Properties();
		props.load(is);
		System.out.println(props.getProperty("url"));
		System.out.println(props.getProperty("username"));
		System.out.println(props.getProperty("password"));
		os = new FileOutputStream("jdbc.properties");
		//props.setProperty("101","raja");
		//props.store(os,"written by hk");
		Enumeration e = props.propertyNames();
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
	}
}