package io.demo3;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by dancheng on 2018/11/5.
 * 构造方法：为这个数据流对象绑定数据源
 * 参数：
 * 	File 类型对象
 * 	String 对象
 * 输入流读取文件的步骤：
 * 1.创建字节输入流的子类的对象
 * 2.调用读取方法read读取
 * 3.关闭资源
 *
 * read()方法，
 * 	read()执行一次，就会自动读取下一个字节
 * 	返回值，返回的是读取到的字节，读取到结尾返回-1
 */
public class FileInputStreamDemo {
	public static void main(String []args) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\task\\test\\a.txt");
		//读取一个字节
		int len = 0;
		while((len = fis.read()) != -1){
			System.out.print((char)len);
		}

		fis.close();
	}
}
