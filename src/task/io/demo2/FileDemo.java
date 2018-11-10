package io.demo2;

import java.io.File;

/**
 * Created by dancheng on 2018/11/5.
 * 对一个目录下的所有内容，进行完全的遍历
 */
public class FileDemo {
	public static void main(String []args){
		File dir = new File("D:\\task\\test");
		getAllDir(dir, 0);
	}

	/**
	 * 定义方法，实现目录的全遍历
	 */
	public static void getAllDir(File dir, int level){
		//调用方法listFiles()对目录dir进行遍历
		File[] fileArr = dir.listFiles();
		for(File f : fileArr){
			for(int i = 0; i < level; i++){
				System.out.print(" ");
			}
			System.out.println("|-" + f.getName());
			if(f.isDirectory()){
				getAllDir(f, level + 1);
			}

		}
	}
}
