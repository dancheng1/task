package io.demo;

import java.io.File;

/**
 * Created by dancheng on 2018/11/2.
 * File类的构造方法
 */
public class FileDemo1 {
	public static void main(String []args){
		function_2();
	}

	/**
	 * File(File parent, String child)
	 * 传递路径，传递一个父类的File类型，子路径的String路径
	 */
	public static void function_2(){
		File parent = new File("D:");
		File file = new File(parent, "task\\attachments\\Question1");
		System.out.println(file);
	}

	/**
	 * File(String parent, String child)
	 * 传递路径，传递字符串的父路径，和字符串的子路径
	 * 好处：可以单独的控制父路径和子路径
	 */
	public static void function_1(){
		File file = new File("D:", "task\\attachments\\Question1");
		System.out.println(file);
	}
	public static void function_11(String child){
		File file = new File("D:", child);
		System.out.println(file);
	}

	/**
	 * File(String pathname)
	 * 传递路径名：可以写到文件夹，也可以写到一个文件
	 * c:\\abc  c:\\abc\\Demo.java
	 * 将路径封装File类型对象
	 */
	public static void function(){
		File file = new File("D:\\task\\attachments\\Question1");
		System.out.println(file);
	}
}
