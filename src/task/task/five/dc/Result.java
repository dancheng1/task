package task.five.dc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dancheng on 2018/11/7.
 */
public class Result {

	private List<String> list = new ArrayList<String>();

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void show(){
		if(!list.isEmpty()){
			for (String str : this.list) {
				System.out.print(str);
			}
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(String tmp : list){
			sb.append(tmp + " ");
		}
		return sb.toString();
	}
}