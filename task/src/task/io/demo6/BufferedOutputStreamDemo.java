package io.demo6;

import java.io.*;

/**
 * Created by dancheng on 2018/11/5.
 * 字节输出流的缓冲流
 * 	java.io.BufferedOutputStream 作用：提高原有输出流的写入效率
 * BufferedOutputStream 继承OutputStream
 * 方法，写入write字节，字节数组
 *
 * 构造方法：
 * 	BufferedOutputStream(OutputStream out)
 * 	可以传递任意的字节输出流，传递的是哪个字节流，就对哪个字节流提高效率
 * 	
 * 	FileOutputStream
 */
public class BufferedOutputStreamDemo {
	public static void main(String []args) throws IOException {
		/*BufferedOutputStream bos = new BufferedOutputStream(new
				FileOutputStream("D:\\task\\test\\1.txt"));
		bos.write("hello world".getBytes());
		bos.close();*/

		BufferedInputStream bis = new BufferedInputStream(new
				FileInputStream("D:\\task\\test\\1.txt"));
		byte[] bytes = new byte[10];
		int len = 10;
		while((len = bis.read(bytes)) != -1){
			System.out.print(new String(bytes, 0, len));
		}
		bis.close();
	}







}
