package test;


import java.lang.reflect.Method;

/**
 * Created by dancheng on 2018/11/7.
 */
public class Test {

	public static void main(String[] args) {
		KMP kmp = new KMP();
		try{
			String top = "aaa(12345678)";
			dotMethod(top, kmp);
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
	}


	private static void dotMethod(String methodStr, Object obj) throws Exception {
		//拆解方法字符串，找出方法名
		String methodName = methodStr.substring(0, methodStr.indexOf('('));
		//找出参数
		String paramStr = methodStr.substring(methodStr.indexOf('(') + 1, methodStr.indexOf(')'));
		Class c = obj.getClass();
		Method method = c.getDeclaredMethod(methodName, String.class);
		method.setAccessible(true);
		//注意invoke的参数别写错了，你的方法是什么类型，invoke就传什么类型参数
		Object a = method.invoke(obj, paramStr);
		System.out.println(a);
	}
}
