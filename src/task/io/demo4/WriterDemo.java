package io.demo4;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by dancheng on 2018/11/5.
 * 字符输出流
 * 	java.io.Write 所有字符输出流的超类
 * 写文件，只能写文本文件
 *
 * 写的方法write
 * 	write(int c) 写一个字符
 * 	write(char[] c) 写字符数组
 * 	write(char[] c, int, int) 字符数组一部分，开始索引，写几个
 * 	write(String s) 写入字符串
 *
 * 	write类的子类对象FileWriter
 * 	构造方法：写入的数据目的
 * 		File类型对象
 * 		String文件名
 *
 * 	字符输出流写数据的时候，必须要运行一个功能，刷新功能
 * 	flush()
 */
public class WriterDemo {
	public static void main(String []args) throws IOException {
		FileWriter fw = new FileWriter("D:\\task\\test\\1.txt");
		//写1个字符
		fw.write("100");
		fw.flush();
		fw.close();
	}
}
