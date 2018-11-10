package io.demo;

import java.io.File;

/**
 * Created by dancheng on 2018/11/2.
 * File类的判断功能
 */
public class FileDemo4 {
	public static void main(String []args){
		function_1();
	}

	/**
	 * boolean isDirectory()
	 * 判断File构造函数中封装的路径是不是文件夹
	 * 如果是文件夹，返回true，不是文件夹返回false
	 *
	 * boolean isFile()
	 * 判断File构造函数中封装的路径是不是文件
	 */
	public static void function_1(){
		File file = new File("D:\\task\\test");
		if(file.exists()){
			boolean b = file.isDirectory();
			System.out.println(b);
		}
	}

	/**
	 * File的判断功能
	 * boolean exists()
	 * 判断File构造函数方法中封装的路径是否存在
	 * 如果存在就返回true，不存在返回false
	 */
	public static void function(){
		File file = new File("D:\\adasd");
		boolean b = file.exists();
		System.out.println(b);
	}
}
