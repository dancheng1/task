package io.demo5;

/**
 * Created by dancheng on 2018/11/5.
 * 转换流
 * 	java.io.InputStreamReader 继承Reader
 * 	字符输入流，读取文本文件
 *
 * 	字节流向字符的桥梁，将字节流转字符流
 *
 *	读取方法：
 *		read() 读取1个字符，读取字符数组
 *	技巧：OutputStreamWriter写了文件
 *		InputStreamReader读取文件
 *
 *	OutputStreamWriter(OutputStream out)所有字节输出流
 *	InputStreamReader(InputStream in)接收所有的字节输入流
 *	InputStreamReader(InputStream in, String charsetName)传递编码表的名字
 */
public class InputStreamReaderDemo {
}
