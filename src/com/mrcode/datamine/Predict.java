package com.mrcode.datamine;

public  class Predict {
	
	
	static String tra1 = "1,2,3,1,1";
	static String tra2 = "1,2,3,4,5";

	public static int trafficOrVisit ( String  XX) {
	if(EditDistance(XX, tra1) < EditDistance(XX, tra2)) {
					 //classMap.put(uname, 1); 1表示出差
					return 1;
	}
				else  {
//					classMap.put(uname, 2); 2表示游玩
					return 2;
				}

	}


	//求两个用户之间的轨迹距离的函数（递归）
		//输入为两条用户轨迹向量
		//输出为这两条向量的相似度（越小表示越相似）
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
