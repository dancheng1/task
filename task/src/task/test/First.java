package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dancheng on 2018/11/5.
 */
public class First {
	public static void main(String []args){
		BufferedReader bfr = null;
		try{
			bfr = new BufferedReader(new
					FileReader("D:\\task\\attachments\\Question1\\access.log"));
			String line = null;
			int count = 0;
			while((line = bfr.readLine()) != null){
				count++;
			}
			System.out.println(count);
		} catch (IOException e) {
			System.out.println(e);

		} finally {
			try{
				if(bfr != null)
					bfr.close();
			} catch (IOException e){
				System.out.println(e);
			}
		}
				
	}
}
