package com.mrcode.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sun.org.apache.xml.internal.security.utils.Base64;
/**
 * 
 * @author 朱源
 *
 */
public class ImageUtils {

	//保存base64编码图片
		@SuppressWarnings("deprecation")
		public static String saveBase64(String imgFile, String savePath, String filename,Long maxSize) throws Exception{
			if(imgFile==null || imgFile.isEmpty()) return "false";
			if(savePath==null || filename==null) return "false";
			if(maxSize==null) maxSize=1024*1024*30L;
			//若类型不为图片，则不保存
			String type = imgFile.substring(imgFile.indexOf(":")+1, imgFile.indexOf("/"));
			if(type==null || !type.equals("image")) return "false";
			
			//取扩展名
			String ext = imgFile.substring(imgFile.indexOf("/")+1, imgFile.indexOf(";"));
			
			//取出base64编码内容,并保存
			imgFile = imgFile.substring(imgFile.indexOf(",")+1);
			byte[] decoded = Base64.decode(imgFile.getBytes());
			if(decoded.length>maxSize) return "false";
			File dir = new File(savePath);
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			File file = new File(savePath+"\\"+filename+"."+ext);
			FileOutputStream write = new FileOutputStream(file);
			write.write(decoded);
			write.flush();
			write.close();
			return filename+"."+ext;
		}
		
		//保存file类型图片
		public static String save(File imgFile, String savePath, String originName, String filename,Long maxSize) throws Exception{
			
			if(imgFile==null) return "false";
			if(maxSize==null || maxSize.equals(null))
				maxSize=1024*1024*30L;
			
			// 定义一个数组，用于保存可上传的文件类型
			List<String> fileTypes = new ArrayList<String>();
			fileTypes.add("jpg");
			fileTypes.add("jpeg");
			fileTypes.add("png");
			fileTypes.add("bmp");
			// 保存第一张图片
			if (originName!=null && !originName.equals(null) && imgFile.length() <= maxSize) {

				// 获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，最后得到扩展名
				String ext = originName.substring(originName.lastIndexOf(".") + 1,
						originName.length());
				// 对扩展名进行小写转换
				ext = ext.toLowerCase();

				if (fileTypes.contains(ext)) { // 如果扩展名属于允许上传的类型，则创建文件
					//创建保存文件的目录
					File dir = new File(savePath);
					if(dir.exists() == false) {
						dir.mkdirs();
					}
					//将临时文件复制到保存目录下
					String file = savePath +"\\"+ filename+"." + ext;					
					File outputFile = new File(file);
					FileInputStream fis = new FileInputStream(imgFile);
					FileOutputStream fos = new FileOutputStream(outputFile);
					byte[] buffer = new byte[1024];  
					int byteread = -1;
		            while ((byteread = fis.read(buffer)) != -1) {  
		            	fos.write(buffer, 0, byteread);  
		            } 
					
		            fos.flush();
		            fos.close();
		            fis.close();
		            //删除上传图片的临时文件
		            imgFile.delete();
					return filename+"."+ext;
				} else
					return "false";

			} else
				return "false";
		}
}
