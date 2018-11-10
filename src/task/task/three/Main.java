package task.three;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dancheng on 2018/11/6.
 */
public class Main {

	public static String NATURE = "natureOrder";
	public static String INDEX = "indexOrder";
	public static String CHAR = "charOrder";
	public static String CHARDESC = "charOrderDESC";

	public static void main(String []args){
		long sss = System.currentTimeMillis();
		BufferedWriter bfw = null;
		BufferedReader bfr1 = null;
		BufferedReader bfr2 = null;
		try {
			bfw = new BufferedWriter(new
					FileWriter("attachments\\Question3\\sdxl.txt"));
			bfr1 = new BufferedReader(new
					FileReader("attachments\\Question3\\sdxl_prop.txt"));
			bfr2 = new BufferedReader(new
					FileReader("attachments\\Question3\\sdxl_template.txt"));

			List<Node> listALL = new ArrayList<Node>();
			List<String> listNATURE = null;
			List<String> listINDEX = null;
			List<String> listCHAR = null;
			String line = null;
			int count = 0;
			while((line = bfr1.readLine()) != null){
				Node node = new Node();
				node.id = count++;

				String tmp[] = line.split("\t");
				if(tmp.length != 2)
					throw new RuntimeException("格式有误！");
				node.key = Integer.valueOf(tmp[0].trim());
				node.value = tmp[1].trim();
				listALL.add(node);
			}

			listNATURE = natureL(listALL);
			listINDEX = indexL(listALL);
			listCHAR = charL(listALL);

			while((line = bfr2.readLine()) != null){
				String str = line;
				int start = 0;
				while((start = find(str, start, '$')) != -1){
					StringBuffer sb = new StringBuffer();
					int end = find(str, start, ')');
					int mid = find(str, start, '(');
					sb.append(str.substring(0, start));

					String type = str.substring(start + 1, mid);
					int index = Integer.valueOf(str.substring(mid + 1, end));

					if(type.equals(NATURE))
						sb.append(listNATURE.get(index));
					if(type.equals(INDEX))
						sb.append(listINDEX.get(index));
					if(type.equals(CHAR))
						sb.append(listCHAR.get(index));
					if(type.equals(CHARDESC))
						sb.append(listCHAR.get(listCHAR.size() - index - 1));

					sb.append(str.substring(end + 1, str.length()));
					str = sb.toString();
				}
				bfw.write(str.trim() + "\r\n");
				bfw.flush();
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try{
				if(bfr2 != null)
					bfr2.close();
			} catch (IOException e){
				System.out.println(e);
			} finally {
				try {
					if(bfr1 != null)
						bfr1.close();
				} catch (IOException e) {
					System.out.println(e);
				} finally {
					try{
						if(bfw != null)
							bfw.close();
					} catch (IOException e){
						System.out.println(e);
					}
				}
			}
		}
		long eee = System.currentTimeMillis();
		System.out.println((eee-sss) / 1000 + "." + (eee-sss) % 1000);
	}

	public static int find(String str, int start, char ch){
		for(int i = start; i < str.length(); i++){
			if(str.charAt(i) == ch)
				return i;
		}
		return -1;
	}

	public static List<String> natureL(List<Node> listALL){
		List<String> list = new ArrayList<String>();
		for(Node tmp : listALL){
			list.add(tmp.value);
		}
		return list;
	}

	public static List<String> indexL(List<Node> listALL){
		List<String> list = new ArrayList<String>();
		listALL.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.key - o2.key;
			}
		});
		for(Node tmp : listALL){
			list.add(tmp.value);
		}
		return list;
	}

	public static List<String> charL(List<Node> listALL){
		List<String> list = new ArrayList<String>();
		for(Node tmp : listALL){
			list.add(tmp.value);
		}
		Collections.sort(list);
		return list;
	}

	public static class Node{
		public int id;
		public int key;
		public String value;
	}
}
