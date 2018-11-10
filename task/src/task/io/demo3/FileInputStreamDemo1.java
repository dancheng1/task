package io.demo3;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by dancheng on 2018/11/5.
 * 读取方法 int read(byte[] b) 读取字节数组
 * 数组作用：缓存的作用，提高效率
 * read方法返回的int，表示什么含义：读取到多少个有效的字节数
 */
public class FileInputStreamDemo1 {
	public static void main(String []args) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\task\\test\\a.txt");
		byte[] b = new byte[1024];
		int len = 0;

		while((len = fis.read(b)) != -1){
			System.out.print(new String(b, 0, len));
		}

		fis.close();
	}
}
