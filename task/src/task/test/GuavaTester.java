package test;

/**
 * Created by dancheng on 2018/11/1.
 */
public class GuavaTester {
	public static void main(String args[]){
		GuavaTester guavaTester = new GuavaTester();
		Integer a =  null;
		Integer b =  new Integer(10);
		System.out.println(guavaTester.sum(a,b));
	}

	public Integer sum(Integer a, Integer b){
		return a + b;
	}
}
