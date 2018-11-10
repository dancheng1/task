package task.second;

import java.io.*;
import java.util.*;

/**
 * Created by dancheng on 2018/11/6.
 */
public class Main {



	public static String PREFIX = "<!--";
	public static String SUFFIX = "-->";
	public static String SCRIPTSTART = "<script>";
	public static String SCRIPTEND = "</script>";
	public static String SPREFIX = "//";

	public static void main(String []args){
		File temp = new File("attachments\\Question2\\validLineCountTEXT.html");
		BufferedWriter bfw = null;
		BufferedReader bfr = null;
		BufferedWriter bfrw = null;
		try{
			bfw = new BufferedWriter(new
					FileWriter(temp));
			bfr = new BufferedReader(new
					FileReader("attachments\\Question2\\StringUtils.java"));
			bfrw = new BufferedWriter(new
					FileWriter("attachments\\Question2\\validLineCount.txt"));

			String line = null;
			//flag标记html代码中是否出现过 <!-- --> 前缀的，true为前文没有出现过，false为出现过
			boolean flag = true;
			//scriptFlag标记着当前是否处于script代码中，true为没有处于script代码块中，false是出于script代码块中
			boolean scriptFlag = true;
			int count = 0;
			while((line = bfr.readLine()) != null){
				if(line.trim().length() != 0){
					StringBuffer sb = new StringBuffer();
					String str = line;
					if(scriptFlag){
						int indexPre = kmp(str, PREFIX);
						int indexSuf = kmp(str, SUFFIX);

						while((indexPre != -1 && flag) || (indexSuf != -1 && !flag)){
							if(flag){
								sb.append(str.substring(0, indexPre));
								flag = !flag;
								str = str.substring(indexPre + 4, str.length());
							} else {
								str = str.substring(indexSuf + 3, str.length());
								flag = !flag;
							}
							indexPre = kmp(str, PREFIX);
							indexSuf = kmp(str, SUFFIX);
						}
						if(flag){
							sb.append(str);
						}
					} else {
						int index = kmp(str, SPREFIX);
						if(index != -1){
							sb.append(str.substring(0, index));
						} else {
							sb.append(str);
						}
						if(kmp(line.trim(), SCRIPTEND) != -1)
							scriptFlag = !scriptFlag;
					}

					String result = sb.toString();
					if(result.trim().length() != 0){
						count++;
						bfw.write(result + "\r\n");
						bfw.flush();
					}
					if(kmp(result, SCRIPTSTART) != -1)
						scriptFlag = !scriptFlag;
				}
			}
			bfrw.write("" + count);
			bfrw.flush();
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try{
				if(bfr != null)
					bfr.close();
			} catch (IOException e){
				System.out.println(e);
			} finally {
				try {
					if(bfw != null)
						bfw.close();
				} catch (IOException e) {
					System.out.println(e);
				} finally {
					try{
						if(bfrw != null)
							bfrw.close();
						boolean b = temp.delete();
						System.out.println(b);
					} catch (IOException e){
						System.out.println(e);
					}
				}
			}
		}
	}

	public static int kmp(String str, String sub) {
		if(str == null || sub == null || str.length() == 0 || sub.length() == 0){
			return -1;
		}
		int j = 0;
		int[] n = next(sub);
		for (int i = 0; i < str.length(); i++) {
			while(j > 0 && str.charAt(i) != sub.charAt(j)){
				j = n[j - 1];
			}
			if(str.charAt(i) == sub.charAt(j)){
				j++;
			}
			if(sub.length() == j){
				int index = i - j + 1;
				return index;
			}
		}
		return -1;
	}

	private static int[] next(String sub) {
		int[] n = new int[sub.length()];
		int x = 0;
		for (int i = 1; i < sub.length(); i++) {
			while (x > 0 && sub.charAt(x) != sub.charAt(x)) {
				x = n[x - 1];
			}
			if (sub.charAt(i) == sub.charAt(x)) {
				x++;
			}
			n[i] = x;
		}
		return n;
	}
}
