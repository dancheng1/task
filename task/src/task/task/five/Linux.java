package task.five;

import task.five.common.Configuration;
import task.five.dc.CommandUtils;
import task.five.dc.PathPropUtils;
import task.five.dc.Result;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by dancheng on 2018/11/7.
 */
public class Linux extends Configuration {

	/**
	 * linux系统开启方法
	 */
	public void start() {
		PathPropUtils.init();
		Scanner sc = new Scanner(System.in);
		CommandUtils utils = new CommandUtils();
		String command = null;
		Properties prop = new Properties();
		Properties propPath = new Properties();
		while(true){
			try{
				InputStream is = new FileInputStream(resource + "command.properties");
				prop.load(is);
				InputStream isPath = new FileInputStream(pathUrl);
				propPath.load(isPath);
			} catch (IOException e) {
				System.out.println(e);
				throw new RuntimeException("");
			}
			System.out.print("[root@dancheng " + propPath.getProperty("showPath") + "]# ");
			command = sc.nextLine();
			String commands[] = command.split("\\|");

			Result result = null;
			for(String tmp : commands){
				tmp = tmp.trim();
				String comm[] = tmp.split(" ");
				if(!prop.containsKey(comm[0])){
					System.out.println("-bash: this command not found");
					break;
				} else {
					try{
						StringBuffer sb = new StringBuffer();
						sb.append(prop.getProperty(comm[0]));
						for(int i = 1; i < comm.length; i++)
							sb.append(comm[i] + " ");
						if(result != null)
							sb.append("$_$" + result.toString());
						sb.append(")");
						result = dotMethod(sb.toString(), utils);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			if(commands.length == 1 && command.equals("shutdown")){
				break;
			}
			if(result != null){
				result.show();
			}
		}
	}

	/**
	 * 调用命令函数
	 * @param methodStr
	 * @param obj
	 * @return
	 */
	private Result dotMethod(String methodStr, Object obj) {
		String methodName = methodStr.substring(0, methodStr.indexOf('('));
		String paramStr = methodStr.substring(methodStr.indexOf('(') + 1, methodStr.indexOf(')'));
		Class c = obj.getClass();
		Object result = null;
		try{
			Method method = c.getDeclaredMethod(methodName, String.class);
			method.setAccessible(true);
			result = method.invoke(obj, paramStr);
		} catch (Exception e){
			e.printStackTrace();
		}
		return (Result)result;
	}

}
