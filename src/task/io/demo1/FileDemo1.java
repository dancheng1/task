package io.demo1;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by dancheng on 2018/11/5.
 * 文件获取的过滤器
 * 遍历目录的时候，可以根据需要，只获取满足条件的文件
 * 遍历目录的方法listFiles()重载形式
 * 传递FileFilter接口的实现类
 * 自定义FileFilter接口实现类，重写抽象方法
 * 接口实现类对象传递到遍历方法listFiles
 */
public class FileDemo1 {
	public static String str = "a";
	public static void main(String []args){
		File file = new File("D:\\task\\test");
		File[] fileArr = file.listFiles(new MyFilter());
		for(File f : fileArr){
			System.out.println(f.getName());
		}
	}

	public static void function(){
		File file = new File("D:\\task\\test");
		File[] fileArr = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				System.out.println(str);
				return false;
			}
		});
	}
}
