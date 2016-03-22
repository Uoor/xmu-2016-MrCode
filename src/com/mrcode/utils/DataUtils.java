package com.mrcode.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;





/**
 * 
 * @author 羽中
 *
 */
public class DataUtils {
	//通过map集合构建hql条件语句
	public static String getHql(Map<String, Object> map) {
		StringBuffer hql = new StringBuffer();
		if(map == null||map.size()==0){
			return " where 1=1 ";
		}
		if(map.size() > 0){
			hql.append(" where ");
		}
		List<String> removes = new ArrayList<String>();
		for (Entry<String,Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if(value == null || value.toString().trim().equals("") || value.toString().trim().equals("null")){
				removes.add(key);
				continue;
			}
			if(key.indexOf("|") > 0){
				String[] keys = key.split("\\|");
				if(keys[1].equals("in")){
					hql.append(keys[0] + " in (" + value.toString() + ") and ");
					removes.add(key);
				}else if(keys[1].equals(Const.NULL)){
					hql.append(keys[0] + " =null and ");
					removes.add(key);
				}else if(keys[1].equals(Const.BLANK)){
					hql.append(keys[0] + " ='' and ");
					removes.add(key);
				}else if(keys[1].equals("like")){
					if(StringUtils.isNotEmpty(value.toString()))
						hql.append(keys[0]+" like '%"+ value.toString() + "%' and ");
					removes.add(key);
				}else{
					hql.append(keys[0] +" "+ keys[1]+":" + keys[0].replaceAll("\\.", "_") + " and ");
				}
			}else{
				hql.append(key + "=:" + key.replaceAll("\\.","_") + " and ");  
			}
			
		}
		if(map.size() > 0){
			hql.replace(hql.lastIndexOf("and"), hql.length(), "");
		}
		for(String remove : removes){
			map.remove(remove);
		}
		return hql.toString();
	}
	/**
	 * 通过数组构造where语句
	 * @param params
	 * @return
	 */
	public static String getHql(Object...params) {
		StringBuffer hql = new StringBuffer();
		if(params == null || params.length == 0){
			return " where 1=1 ";
		}
		if(params.length > 0){
			hql.append(" where ");
		}
		for (Object obj : params) {
			String str = obj.toString();
			if(str.indexOf("|")>0){
				String[] arrs = str.split("\\|");
				hql.append(arrs[0]+" "+arrs[1]+"? ");
			}else{
				hql.append(str+" =? ");
			} 
			hql.append(" and ");
		}
		hql.replace(hql.lastIndexOf("and"), hql.length(), "");
		return hql.toString();
	}
	 
	public static Map<String, Object> getMap(Object... params) {
		if (params.length == 0 || params.length % 2 != 0) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < params.length; i = i + 2) {
			if (params[i + 1] != null&& !params[i + 1].toString().trim().equals("")&& !params[i + 1].toString().trim().equals("null"))
				map.put(params[i].toString(), params[i + 1]);
		}
		return map;

	}
	/**
	 * 变换数组的形式
	 * 如[1,2,5,6]变为1,2,5,6
	 * @param ids
	 * @return
	 */
	public static String arrayTransfer(int[] ids) {
		System.out.println("DataUtils.arrayTransfer()");
		if(ids!=null&&ids.length!=0){
			
			StringBuffer str = new StringBuffer("");
			for (int i = 0; i < ids.length; i++) {
				str.append(ids[i]+",");
			}
			//System.out.println(str.toString().substring(0, str.toString().length()-1));
			return str.toString().substring(0, str.toString().length()-1);
			
		}
		return "";
	}
	
}
