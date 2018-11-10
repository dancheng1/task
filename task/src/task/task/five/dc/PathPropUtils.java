package task.five.dc;

import task.five.common.Configuration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by dancheng on 2018/11/10.
 */
public class PathPropUtils extends Configuration {

	public static Result changPath(String str){
		Result result = new Result();
		List<String> list = new ArrayList<String>();
		Properties prop = null;
		try{
			prop = new Properties();
			InputStream is = new FileInputStream(pathUrl);
			prop.load(is);
		} catch (IOException e) {
			System.out.println(e);
			throw new RuntimeException("");
		}
		if(str.length() >= 1 && str.charAt(0) == '/'){
			String tmp = str.substring(1, str.length());
			String[] temp = tmp.split("/");
			StringBuffer sb = new StringBuffer();
			sb.append(prop.getProperty("ROOT"));
			for(String s : temp){
				if(!(s == null || s.equals(" ")))
					sb.append("\\" + s);
			}
			File file = new File(sb.toString());
			if(file.exists()){
				if(file.isDirectory()){
					BufferedWriter bfw = null;
					BufferedReader bfr = null;
					try {
						bfw = new BufferedWriter(new
								FileWriter(resource + "temptemptemptemp.properties"));
						bfr = new BufferedReader(new
								FileReader(pathUrl));
						String line = bfr.readLine();
						bfw.write(line.substring(0, line.indexOf('=') + 1));
						bfw.write(sb.toString().replace("\\", "\\\\") + "\r\n");

						line = bfr.readLine();
						bfw.write(line.substring(0, line.indexOf('=') + 1));
						if(str.trim().length() == 1)
							bfw.write("/\r\n");
						else
							bfw.write(file.getName() + "\r\n");
						line = bfr.readLine();
						bfw.write(line);
						bfw.flush();
					} catch (IOException e){
						e.printStackTrace();
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
							}
						}
					}
					File f = new File(pathUrl);
					f.delete();
					try {
						bfw = new BufferedWriter(new
								FileWriter(pathUrl));
						bfr = new BufferedReader(new
								FileReader(resource + "temptemptemptemp.properties"));
						String line = null;
						while((line = bfr.readLine()) != null){
							bfw.write(line + "\r\n");
						}
						bfw.flush();
					} catch (IOException e){
						e.printStackTrace();
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
							}
						}
					}
					File f1 = new File(resource + "temptemptemptemp.properties");
					f1.delete();
				} else {
					list.add("-bash: cd: " + str + ": Not a directory\n");
				}
			} else {
				list.add("-bash: cd: " + str + ": No such file or directory\n");
			}
		} else if(str.length() >= 1 && str.charAt(0) == '-'){

		} else {
			if(str.length() >= 2 && (str.charAt(0) == '.' && str.charAt(1) == '/')){

			}
		}
		result.setList(list);
		return result;
	}

	/**
	 * 初始化
	 */
	public static void init(){
		BufferedWriter bfw = null;
		try {
			bfw = new BufferedWriter(new
					FileWriter(pathUrl));
			bfw.write("currentPath=" + ROOTPath + "\r\n");
			bfw.write("showPath=/\r\n");
			bfw.write("ROOT=" + ROOTPath + "\r\n");
			bfw.flush();
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				if(bfw != null)
					bfw.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

}
