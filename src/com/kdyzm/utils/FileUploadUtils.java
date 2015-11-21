package com.kdyzm.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 * 文件上传的工具类
 * @author kdyzm
 *
 */
public class FileUploadUtils {
	/**
	 * 保存文件到指定的位置
	 * 注意保存的方法的问题
	 * @param sourceFile
	 * @param infactFileName 
	 * @return
	 */
	public static File saveUploadFileToDestDir(File sourceFile, String infactFileName){
		SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd");
		Date date=new Date();
		File dir=new File(ServletActionContext.getServletContext().getRealPath("/upload")+sdf.format(date));
		if(!dir.exists()){
			dir.mkdir();
		}
		String []arrFileNames=infactFileName.split("\\.");
		
		String lastFileName=arrFileNames[arrFileNames.length-1];
		File destFile=new File(dir,UUID.randomUUID().toString().replaceAll("-", "")+"."+lastFileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			System.out.println("保存文件失败！");
		}
		return destFile;
	}
}
