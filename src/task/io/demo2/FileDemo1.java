package io.demo2;

import java.io.File;

/**
 * Created by dancheng on 2018/11/5.
 * 遍历目录，获取目录下的所有.java文件
 */
public class FileDemo1 {
	public static void main(String []args){
		File dir = new File("D:\\task\\test");
		getAllJava(dir, 0);
	}

	/**
	 * 定义方法，实现目录的全遍历
	 */
	public static void getAllJava(File dir, int level){
		File[] fileArr = dir.listFiles(new MyFilter());
		for(File f : fileArr){
			for(int i = 0; i < level; i++){
				System.out.print(" ");
			}
			System.out.println("|-" + f.getName());
			if(f.isDirectory()){
				getAllJava(f, level + 1);
			}
		}
	}
}
