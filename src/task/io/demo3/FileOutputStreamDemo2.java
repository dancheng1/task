package io.demo3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by dancheng on 2018/11/5.
 * 文件的续写和换行问题
 * 续写：FileOutputStream构造方法的第二个参数中加入true
 */
public class FileOutputStreamDemo2 {
	public static void main(String []args) {
		File file = new File("D:\\task\\test\\b.txt");
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(file);
			fos.write(100);
		} catch (IOException e){
			System.out.println(e.toString());
		} finally {
			try{
				fos.close();
			} catch (IOException e){
				System.out.println(e.toString());
			}
		}
	}
}
