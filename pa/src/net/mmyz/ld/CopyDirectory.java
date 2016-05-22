package net.mmyz.ld;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

public class CopyDirectory {
	//最终目标文件夹
	public static void main(String[] args) {
		String getDirName;
		int j = 0;
		ArrayList<File>aimDir = new ArrayList<>();

		//教室是D盘
		File dir = new File("D:");
		boolean is;
		boolean isExistsAimDir = false;

		File[] allDir = null;

		do {
			//判断D盘是否存在
			is = dir.exists();
			if (is == true) {
				//存放D盘文件夹列表
				allDir = dir.listFiles();
				do {
					for (int i = 0; i < allDir.length; i++) {
						getDirName = allDir[i].getName();
						//检索关键字
						if (getDirName.indexOf("趣味物理实验") != -1){
							if(allDir[i].isDirectory() == true){
								aimDir.add(new File(allDir[i].getAbsolutePath()+"/第六次课冷知识"));
								if (aimDir.get(j).exists() == true) {
									j++;
									isExistsAimDir = true;
								}else {
									aimDir.remove(j);
									System.out.println("不存在第六次课冷知识");
								}
							}else {
								System.out.println("不是文件夹");
							}
						}else {
							System.out.println("不存在趣味物理实验");
						}
					}
				} while (isExistsAimDir == false);
			}else{
				System.out.println("不存在路径");
			}
		} while (is == false);
		//输出文件夹
		//教室是G:/高二《20》/done
		File toDir = new File("G:/高二《20》/done");
		if (toDir.exists() == false) {
			toDir.mkdir();
		}
		try {
			//复制文件夹
			for (int i = 0; i < aimDir.size(); i++) {
				FileUtils.copyDirectory(aimDir.get(i), toDir);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

