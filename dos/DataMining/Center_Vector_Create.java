package test;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

//轨迹聚类
public class Center_Vector_Create {
	
	//主函数,生成中心向量
	public static void main(String[] args) {
		String file = "E:/use_imfor.csv";
		Map userMap = readCsvFile(file);
		Map userMap1 = new HashMap();
		Set<Entry> entrySet = userMap.entrySet();
		Set<Entry> entrySet1 = userMap1.entrySet();
		String uname = "";
		String track = "";
		String track1 = "";
		String[] traArr = null;
		int i = 0;

		//将轨迹转换得到userMap1
		for(Entry entry : entrySet)
		{
			Set traSet = new HashSet();
			track1 ="";
			uname = entry.getKey().toString();
			track = entry.getValue().toString().split("\t")[0];
			if(track.contains(",0"))
				track = track.substring(0, track.indexOf(",0"));
			traArr = track.split(",");
			for(String site : traArr)
				traSet.add(site);
			if(traArr.length<5)
			{
				for(i = 1;i<=traSet.size();++i)
				{
					track1 = track1 + ","+i;
				}
				for(i=1;i<=5-traSet.size();++i)
				{
					track1 = track1 + ",1";
				}
				track1 = track1.substring(1);
			}
			else
			{
				for(i = 1;i<=traSet.size();++i)
				{
					track1 = track1 + ","+i;
				}
				for(i=1;i<=5-traSet.size();++i)
				{
					track1 = track1 + ",1";
				}
				track1 = track1.substring(1);
			}

			userMap1.put(uname, track1);
		}
		
		
		
		//随机取两条EditDistance>=3的轨迹，作为初始中心轨迹
		String tra1 = "";
		String tra2 = "";
		while(EditDistance(tra1,tra2)<3)
		{
			// 从userMap1中随机取两个username1,username2
			int count = 0;
			String username1 = "";
			String username2 = "";

			//随机取两条轨迹
		    String[] userArr = (String[]) userMap1.keySet().toArray(new String[0]); 
		    Random random1 = new Random();
		    String randomUser1 = userArr[random1.nextInt(userArr.length)];
		    tra1 = userMap1.get(randomUser1).toString();
		    
		    Random random2 = new Random();
		    String randomUser2 = userArr[random2.nextInt(userArr.length)];
		    tra2 = userMap1.get(randomUser2).toString();

//			System.out.println("tra1:"+tra1);
//			System.out.println("tra2:"+tra2);
		}
		
		//更新中心向量（循环4次）
		int n=5;
		while(n>0)
		{
			
			//每次循环聚类并更新中心向量
			Map classMap = new HashMap();
			for (Entry entry : entrySet1) {
				uname = entry.getKey().toString();
				track = entry.getValue().toString();
				if(EditDistance(track, tra1) < EditDistance(track, tra2))
					classMap.put(uname, 1);
				else 
					classMap.put(uname, 2);
			}
             //更新中心向量
			int max1 = 0;
			int max2 = 0;
			Map countMap1 = new HashMap();
			Map countMap2 = new HashMap();
			Set<Entry> newEntrySet = classMap.entrySet();
			for (Entry entry : newEntrySet)
			{
				if(entry.getValue().equals(1))
				{
					track = userMap1.get(entry.getKey().toString()).toString();
					if(!countMap1.containsKey(track))
					{
						countMap1.put(track, 0);
					}
					else
					{
						countMap1.put(track, Integer.parseInt(countMap1.get(track).toString())+1);
					}
					System.out.println("countMap1.size:"+countMap1.size());
				}
				
				else if(entry.getValue().equals(2))
				{
					track = userMap1.get(entry.getKey().toString()).toString();
					if(!countMap2.containsKey(track))
					{
						countMap2.put(track, 0);
					}
					else
					{
//						System.out.println("track"+track);
//						System.out.println(countMap1.get(track).toString());
						countMap2.put(track, Integer.parseInt(countMap2.get(track).toString())+1);
					}
					System.out.println("countMap2.size:"+countMap2.size());
				}
			}
			
			Set<Entry> newEntrySet1 = countMap1.entrySet();
			Set<Entry> newEntrySet2 = countMap2.entrySet();
			int count1;
			int count2;
			String maxTrack1 = "";
			String maxTrack2 = "";
			for (Entry entry : newEntrySet1 )
			{
				count1 = Integer.parseInt(entry.getValue().toString());
				//System.out.println("count1:"+count1);
				if(count1>max1)
				{
					
					max1 = count1;
					maxTrack1 = entry.getKey().toString();
				}
			}
			for (Entry entry : newEntrySet2 )
			{
				count2 = Integer.parseInt(entry.getValue().toString());
//				System.out.println("count2:");
				if(count2>max2)
				{
					max2 = count2;
					maxTrack2 = entry.getKey().toString();
				}
			}
			
			--n;
			
			//输出中心向量
			System.out.println("maxTrack1"+maxTrack1);	
			System.out.println("maxTrack2"+maxTrack2);	
			System.out.println("----------------------");
		}

		//printMap(classMap);
	}
    
	
	//读取用户文件的函数
	public static Map readCsvFile(String filePath) {
		try {
			Map userMap = new HashMap();
			int i = 0;
			int row = 0;
			String username = "";
			String geo = "";
			String room = "";
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(new DataInputStream(new FileInputStream(file)),
						encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					row++;
					String[] lineArr = lineTxt.split(",");
					if (lineTxt.contains("order")) {
						username = lineArr[0];
					} else if (lineTxt.contains("geog")) {
						if (lineArr.length <= 6) {
							for (i = 1; i < lineArr.length; ++i) {
								geo = geo + "," + lineArr[i];
							}
							for (i = 1; i <= 6 - lineArr.length; ++i) {
								geo = geo + "," + "0";
							}
						} else {
							for (i = lineArr.length - 5; i <= lineArr.length - 1; ++i) {
								geo = geo + "," + lineArr[i];
							}
						}
						geo = geo.substring(1);
					} else if (lineTxt.contains("room")) {
						for (i = 1; i < lineArr.length; ++i) {
							room = room + "," + lineArr[i];
						}
						room = room.substring(1);
					}
					if (row % 3 == 0) {
						userMap.put(username, geo + "\t" + room);
						geo = "";
						room = "";
					}
				}
				read.close();
				return userMap;
			} else {
				System.out.println("找不到指定的文件");
				return null;
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
			return null;
		}
	}
	
	//打印用户类别的函数
	public static void printMap(Map map) {
		Set<Entry> entryseSet = map.entrySet();
		for (Entry entry : entryseSet) {
			System.out.println("用户:"+entry.getKey() + "\t类别:" + entry.getValue());
		}
	}

	//求两个用户之间的轨迹距离的函数（递归）
	public static int EditDistance(String Tr1, String Tr2) {
		String[] TrArr1 = Tr1.split(",");
		String[] TrArr2 = Tr2.split(",");
		String Tr1FirstRest = "";
		String Tr2FirstRest = "";
		if (Tr1.equals(""))// if |Tr1|==0
		{
			if (!Tr2.equals("")) {
				return TrArr2.length;
			} else {
				return 0;
			}
		}
		if (Tr2.equals(""))// if |Tr2|==0
		{

			if (!Tr1.equals("")) {
				return TrArr1.length;
			} else {
				return 0;
			}
		}
		if (Tr1.contains(","))
			Tr1FirstRest = Tr1.substring(Tr1.indexOf(",") + 1);
		else
			Tr1FirstRest = "";
		if (Tr2.contains(","))
			Tr2FirstRest = Tr2.substring(Tr2.indexOf(",") + 1);
		else
			Tr2FirstRest = "";
		if (TrArr1[0].equals(TrArr2[0]))// if first(Tr1)==first(Tr2)
		{
			return EditDistance(Tr1FirstRest, Tr2FirstRest);
		} else// otherwise
		{
			return Min(EditDistance(Tr1FirstRest, Tr2FirstRest) + 1, EditDistance(Tr1FirstRest, Tr2) + 1,
					EditDistance(Tr1, Tr2FirstRest) + 1);
		}
	}

	
	private static int Min(int i, int j, int k) {
		int min = 10000;
		if (i < min)
			min = i;
		if (j < min)
			min = j;
		if (k < min)
			min = k;
		return min;
	}
}
