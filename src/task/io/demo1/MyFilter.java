package io.demo1;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by dancheng on 2018/11/5.
 * 自定义过滤器
 * 实现FileFilter接口，重写抽象方法
 */
public class MyFilter implements FileFilter{
	@Override
	public boolean accept(File pathname) {
		/**
		 * pathname 接收到的也是文件的全路径
		 * 对路径进行判断，如果是java文件，返回true，不是java文件，返回false
		 * 文件的后缀结尾是.java
		 */
		String name = pathname.getName();
		//判断字符串是不是以java结尾
		return name.endsWith(".java");
	}
}
