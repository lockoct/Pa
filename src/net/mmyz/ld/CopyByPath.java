package net.mmyz.ld;

import java.io.File;

import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class CopyByPath {

	public  static void Copy(String ipath,String opath) {		

		//判断是否在路径用的
		boolean is = false;
		//用于获取目标文件夹对象
		File aimDir = new File(ipath);

		do {
			//判断D盘是否存在
			is = aimDir.exists();
			if (is == false) {
				System.out.println("不存在路径");				
			}
		} while (is == false);

		//输出文件夹opath
		File toDir = new File(opath+"/done");
		if (toDir.exists() == false) {
			toDir.mkdir();
		}
		System.out.println("开始扒取！");
		try {

				FileUtils.copyDirectory(aimDir,toDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("扒取完成！");
	}
}

