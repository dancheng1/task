package io.demo3;

/**
 * Created by dancheng on 2018/11/5.
 * 字节输出流
 * 	java.io.OutputStream 所有字节输出流的超类
 * 	作用：从java程序，写出文件
 * 	字节：这样流每次只操作文件中的1个字节
 * 	写任意文件
 *
 * 	方法都是写文件的方法
 * 	write(int b) 写入1个字节
 * 	write(byte[] b) 写入一个字节数组
 * 	write(byte[] b, int, int) 写入一个数组和从那个位子开始写几个
 * 	close() 关闭流对象，释放与此流相关的资源
 *
 * 	流对象，操作文件的时候，自己不做，依赖操作系统
 */
public class OutputStreamDemo {

}
