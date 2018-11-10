package io.demo4;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dancheng on 2018/11/5.
 * 字符输入流读取文本文件，所有字符输入流的超类
 * 	java.io.Reader
 * 	作用：专门读取文本文件
 *
 * 读取方法：read()
 * 	int read() 读取1个字符
 * 	int read(char[] c) 读取字符数组
 *
 * 	Reader类是抽象类，找到子类对象FileReader
 * 	构造方法：绑定数据源
 * 	参数：
 * 		File 类型对象
 * 		String 对象
 */
public class ReaderDemo {
	public static void main(String []args) throws IOException {
		FileReader fr = new FileReader("D:\\task\\test\\1.txt");
		int len = 0;
		while((len = fr.read()) != -1){
			System.out.print((char)len);
		}
		fr.close();
	}
}
