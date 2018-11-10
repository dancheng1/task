package task.five.dc;

import task.five.common.Configuration;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by dancheng on 2018/11/7.
 */
public class CommandUtils extends Configuration {

	/**
	 * cd命令处理
	 * @param str
	 * @return
	 */
	public Result cd(String str){
		Result result = new Result();
		List<String> list = new ArrayList<String>();
		if(!(str == null || str.equals(""))){
			PathPropUtils.changPath(str);
		}
		result.setList(list);
		return result;
	}

	/**
	 * ll命令处理
	 * @param str
	 * @return
	 */
	public Result ll(String str) {
		Properties prop = null;
		try{
			prop = new Properties();
			InputStream is = new FileInputStream(pathUrl);
			prop.load(is);
		} catch (IOException e) {
			System.out.println(e);
			throw new RuntimeException("");
		}
		Result result = new Result();
		List<String> tmp = result.getList();
		File file = new File(prop.getProperty("currentPath"));
		File[] fileArr = file.listFiles();
		for(File f : fileArr){
			tmp.add(f.getName() + "\r\n");
		}
		result.setList(tmp);
		return result;
	}

	/**
	 * cat命令处理
	 * @param str
	 * @return
	 */
	public Result cat(String str){
		Process process = new Process(str);
		Result result = new Result();
		for(String s : process.getCommList()){
			System.out.println(s);
		}
		return null;
	}

	/**
	 * shutdown命令处理
	 * @return
	 */
	public Result shutdown(String str){

		return null;
	}

	/**
	 * 处理参数集
	 */
	class Process{
		private int flag = 0;
		private List<String> resultList = null;
		private List<String> commList = null;

		public Process(String str){
			this.resultList = new ArrayList<String>();
			this.commList = new ArrayList<String>();
			String tmp[] = str.split("\\$_\\$");
			if(tmp.length == 2){
				this.flag = 2;
				String result[] = tmp[1].split(" ");
				String comm[] = tmp[0].split(" ");
				resultList.addAll(Arrays.asList(result));
				commList.addAll(Arrays.asList(comm));
			} else {
				this.flag = tmp.length;
				if(tmp.length == 1){
					String comm[] = tmp[0].split(" ");
					commList.addAll(Arrays.asList(comm));
				}
			}
		}

		public void setFlag(int flag) { this.flag = flag; }
		public void setResultList(List<String> resultList) { this.resultList = resultList; }
		public void setCommList(List<String> commList) { this.commList = commList; }
		public int getFlag() { return flag; }
		public List<String> getResultList() { return resultList; }
		public List<String> getCommList() { return commList; }
	}

}

/*Properties prop = null;
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
		}*/
