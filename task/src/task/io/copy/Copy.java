package io.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by dancheng on 2018/11/5.
 * 将数据源D:\task\test\c.txt
 * 复制到D:\task\test\d.txt
 * 字节输入流，绑定数据源
 * 字节输出流，绑定数据目的
 *
 * 输入，读取1个字节
 * 输出，写1个字节
 */
public class Copy {
	public static void main(String []args){
		//定义两个流对象
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try{
			fis = new FileInputStream("D:\\task\\test\\c.txt");
			fos = new FileOutputStream("D:\\task\\test\\d.txt");
			//字节输入流
			int len = 0;
			while((len = fis.read()) != -1){
				fos.write(len);
			}
		} catch (IOException e){
			System.out.println(e);
			throw new RuntimeException("复制失败");
		} finally {
			try{
				if(fos != null)
					fos.close();
			} catch (IOException e) {
				System.out.println(e.toString());
				throw new RuntimeException("释放资源失败");
			} finally {
				try{
					fis.close();
				} catch (IOException e) {
					System.out.println(e.toString());
					throw new RuntimeException("释放资源失败");
				}
			}
		}
	}


}
