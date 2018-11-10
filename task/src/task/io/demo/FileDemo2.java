package io.demo;

import java.io.File;
import java.io.IOException;

/**
 * Created by dancheng on 2018/11/2.
 * File类的创建和删除功能
 * 文件或者目录
 */
public class FileDemo2 {
	public static void main(String []args){
		try {
			function_2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * File类的删除功能
	 * boolean delete()
	 * 删除文件或者是文件夹，在File构造函数方法中给出
	 * 删除成功返回真，删除失败返回假
	 * 删除方法不走回收站，直接从硬盘中删除了
	 * 删除有风险，运行需谨慎
	 */
	public static void function_2(){
		File file = new File("D:\\task\\test\\aaa");
		boolean b = file.delete();
		System.out.println(b);
	}


	/**
	 * File创建文件夹的功能
	 * boolean mkdir()
	 * 创建的路径也在File构造方法中给出
	 * 文件夹已经存在了，不在创建返回false
	 */
	public static void function_1(){
		File file = new File("D:\\task\\test\\aaa");
		boolean b = file.mkdir();
		System.out.println(b);
	}

	//创建多级文件夹
	public static void function_11(){
		File file = new File("D:\\task\\test\\a\\b\\c\\d");
		boolean b = file.mkdirs();
		System.out.println(b);
	}


	/**
	 * File创建文件的功能
	 * boolean createNewFile()
	 * 创建文件路径和文件名，在File构造函数中给出
	 * 如果执行创建的文件存在了，就不会在创建了，返回false
	 * 此方法只能创建文件，不能创建文件夹
	 */
	public static void function() throws IOException{
		File file = new File("D:\\task\\test\\first.txt");
		boolean b = file.createNewFile();
		System.out.println(b);
	}
}
