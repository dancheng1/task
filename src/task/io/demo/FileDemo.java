package io.demo;

import java.io.File;

/**
 * Created by dancheng on 2018/11/2.
 * 将操作系统中的文件，目录（文件夹），路径，封装成File对象
 * 提供方式，操作系统中的内容
 * File与系统无关的类
 * 文件 file
 * 目录 directory
 * 路径 path
 */
public class FileDemo {
	public static void main(String []args){
		//File静态成员变量
		//与系统有关的路径分隔符
		String str = File.pathSeparator;
		System.out.println(str);

		//与系统有关的名称分隔符
		String strse = File.separator;
		System.out.println(strse);
	}
	
}
