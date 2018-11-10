package io.demo3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by dancheng on 2018/11/5.
 * 文件的续写和换行问题
 * 续写：FileOutputStream构造方法的第二个参数中加入true
 */
public class FileOutputStreamDemo1 {
	public static void main(String []args) throws IOException {
		File file = new File("D:\\task\\test\\b.txt");
		FileOutputStream fos = new FileOutputStream(file, true);
		fos.write("hello\r\n".getBytes());
		fos.write("world".getBytes());
		fos.close();
	}
}
