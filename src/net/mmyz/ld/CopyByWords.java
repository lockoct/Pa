package net.mmyz.ld;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

public class CopyByWords {

	public  static void Copy(String[] words,String disk,String opath) {		

		//判断是否餐在盘符用的
		boolean is = false;
		//用于获取根目录下所有文件对象
		File[] rootAllDir = null;

		//判断文件对象是否能记录如目标文件对象中
		boolean canBeRecorded = false;
		//存储目标文件对象
		ArrayList<File>aimDir = new ArrayList<File>();


		do {
			//判断D盘是否存在
			is = new File(disk+"/").exists();
			if (is == true) {
				//存放D盘文件夹列表
				rootAllDir = new File(disk+"/").listFiles();
				for (int i = 0; i < rootAllDir.length; i++) {
					for (int j = 0; j < words.length; j++) {
						if(rootAllDir[i].getName().indexOf(words[j]) == -1){
							System.out.println("文件对象"+i+"不存在"+words[j]);
							canBeRecorded = false;
							break;
						}else{
							System.out.println("文件对象"+i+"存在"+words[j]+"!!!!!!!!!!!!!!!!!!!");
							canBeRecorded = true;
						}
					}
					if (canBeRecorded == true) {
						aimDir.add(new File(disk+"/"+rootAllDir[i].getName()+"/优秀作品"));
					}
				}
				int k = 0;
				while (k<aimDir.size()) {
					if (aimDir.get(k).exists() == true) {
						System.out.println("目标对象"+k+"存在！进入下层判断");
						System.out.println(aimDir.get(k).getAbsolutePath());
						if (aimDir.get(k).isDirectory() == true) {
							System.out.println("目标对象"+k+"是文件夹");
							k++;
						}else {
							System.out.println("目标对象"+k+"不是文件夹，不能要");
							aimDir.remove(k);
						}
					}else {
						System.out.println("目标对象"+k+"不存在！");						
						aimDir.remove(k);
					}
				}
				if (aimDir.size() == 0) {
					//如果目标对象没有符合的，就重新回到第一层循环开始判断
					is=false;
					System.out.println("没有符合的目标对象，重新判断");
				}
			}else{
				System.out.println("不存在盘符");
			}
		} while (is == false);
		//输出文件夹opath

		File toDir = new File(opath+"/done");
		if (toDir.exists() == false) {
			toDir.mkdir();
		}
		System.out.println("开始扒取！");
		try {
			//复制文件夹
			for (int i = 0; i < aimDir.size(); i++) {
				FileUtils.copyDirectory(aimDir.get(i), toDir);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("扒取完成！");
	}
}

