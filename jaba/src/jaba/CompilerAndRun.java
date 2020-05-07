package jaba;

import java.io.BufferedReader;
import java.io.FileReader;

public class CompilerAndRun {
	
	public static void _run(String path) {
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String str; 
			while ((str = br.readLine()) != null) {
				String[] fgString = str.split("\\r?\\n");
				for (int i = 0; i < fgString.length; i++) {
					//System.out.println(fgString[i]);
					main.runcomm(fgString[i]);
				}
				//System.out.print(str);
			}
			br.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("编译运行失败了,以上是错误内容！");
			System.out.println("如果你经过检查您的代码并没出错，那么请截图反馈给Reiz");
		}
	}
}