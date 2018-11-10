package task.first;

import java.io.*;
import java.util.*;

/**
 * Created by dancheng on 2018/11/5.
 */
public class Main {
	public static void main(String []args){
		long sss = System.currentTimeMillis();
		BufferedWriter bfw = null;
		BufferedReader bfr = null;
		try{
			bfw = new BufferedWriter(new
					FileWriter("attachments\\Question1\\a.txt"));
			bfr = new BufferedReader(new
					FileReader("attachments\\Question1\\access.log"));
			String line = null;
			int count = 0;
			int getCount = 0;
			int postCount = 0;
			int two_ = 0;
			int three_ = 0;
			Map<String, Integer> map = new HashMap<String, Integer>();
			while((line = bfr.readLine()) != null){
				String str[] = line.split(" ");
				String tmp[] = str[1].split("/");
				count++;
				if(map.containsKey(line)){
					int temp = map.get(line);
					map.remove(line);
					map.put(line, ++temp);
				} else {
					map.put(line, 1);
				}
				if(str[0].equals("GET"))
					getCount++;
				else
					postCount++;
				if(tmp.length == 3){
					two_++;
				} else if(tmp.length == 4){
					three_++;
				}
			}

			//-----------处理数据----------------

			List<Node> listNode = new ArrayList<Node>();
			Set<String> set = map.keySet();
			for(String k : set){
				Node node = new Node();
				node.key = k;
				node.value = map.get(k);
				listNode.add(node);
			}
			listNode.sort(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o2.value - o1.value;
				}
			});

			//-----------输出结果----------------

			StringBuffer sb = new StringBuffer();
			sb.append("请求总量为：" + count + "\r\n");
			sb.append("请求最频繁的10个 HTTP 接口，及其相应的请求数量列表为:\r\n");
			for(int i = 0; i < 10; i++){
				sb.append((i + 1) + "." + listNode.get(i).value + "次，请求路径为：" + listNode.get(i).key + "\r\n");
			}
			sb.append("POST请求量为：" + postCount + "\r\n");
			sb.append("GET请求量：" + getCount + "\r\n");
			sb.append("URI 格式为 /AAA/BBB的请求量：" + two_ + "\r\n");
			sb.append("URI 格式为 /AAA/BBB/CCC的请求量：" + three_ + "\r\n");

			String result = sb.toString();
			bfw.write(result);
			bfw.flush();
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
				}
			}
		}
		long eee = System.currentTimeMillis();
		System.out.println((eee-sss) / 1000 + "." + (eee-sss) % 1000);
	}

	public static class Node{
		String key;
		int value;
	}
}