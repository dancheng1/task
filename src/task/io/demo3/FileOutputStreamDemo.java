package io.demo3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by dancheng on 2018/11/5.
 * FileOutputStream
 * 写入数据文件，学习父类方法，使用子类对象
 *
 * 子类构造方法：作用：绑定输出的输出目的
 * 	参数：
 * 		File   封装文件
 * 		String 字符串的文件名
 *
 * 流对象使用步骤：
 * 1.创建流的子类对象，绑定数据目的
 * 2.调用流对象的方法write写
 * 3.close释放资源
 *
 * 流对象可以根据路径，创建一个文件，如果文件已经存在了直接覆盖
 */
public class FileOutputStreamDemo {
	public static void main(String []args) throws IOException {
		FileOutputStream fos = new FileOutputStream("D:\\task\\test\\a.txt");
		//流对象的方法write写数据
		fos.write(97);
		byte[] bytes = {65, 66, 67, 68};
		fos.write(bytes);
		fos.write("hello".getBytes());
		//关闭字节流
		fos.close();
	}
}
