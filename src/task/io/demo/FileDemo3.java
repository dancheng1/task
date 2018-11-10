package io.demo;

import java.io.File;

/**
 * Created by dancheng on 2018/11/2.
 */
public class FileDemo3 {
	public static void main(String []args){
		function_3();
	}

	/**
	 * String getParent()
	 * File getParentFile()
	 * 获取父路径
	 */
	public static void function_3(){
		File file = new File("D:\\task\\test\\first.txt");
		System.out.println(file.getParentFile());
	}

	/**
	 * String getAbsolutePath() 返回String对象
	 * File getAbsoluteFile()   返回File对象
	 * 获取决定路径
	 * 写一个相对路径就代表当前文件所在文件路径的位置
	 */
	public static void function_2(){
		File file = new File("src");
		System.out.println(file.getAbsoluteFile());
	}


	/**
	 * long lenght()
	 * File获取文件中的字节数
	 */
	public static void function_1(){
		File file = new File("D:\\task\\test\\first.txt");
		long lenght = file.length();
		System.out.println(lenght);
	}


	/**
	 * File类的获取功能
	 * String getName()
	 * 返回路径中所表示的文件或文件夹的名
	 * 获取路径中最好部分的名字
	 */
	public static void function(){
		File file = new File("D:\\task\\test");
		String name = file.getName();
		System.out.println(name);

		String path = file.getPath();
		System.out.println(path);
	}
}
