package io.demo1;

import java.io.File;

/**
 * Created by dancheng on 2018/11/5.
 * list
 * listFiles
 */
public class FileDemo {
	public static void main(String []args){
		function_1();
	}

	/**
	 * File类的获取功能
	 * File[] listFile()
	 * 获取到，File构造方法中封装的路径中的文件和文件夹名（遍历一遍）
	 * 返回文件目录的全路径
	 */
	public static void function_1(){
		File file = new File("D:\\task\\test");
		File[] fileArr = file.listFiles();
		for(File f : fileArr){
			System.out.println(f);
		}
	}

	/**
	 * File获取功能
	 * String[] list[]
	 * 获取到，File构造方法中封装的路径中的文件和文件夹名（遍历一遍）
	 * 返回只有文件或文件夹的名字
	 */
	public static void function(){
		File file = new File("D:\\task\\test");
		String[] strArr = file.list();
		System.out.println(strArr.length);
		for(String s : strArr){
			System.out.println(s);
		}
	}
}
