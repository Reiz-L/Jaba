package jaba;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("+-----------------+");
		System.out.println("|Jaba 张浩扬与你同在|");
		System.out.println("|当前版本:1.0.0|");
		System.out.println("|输入help来获取帮助|");
		System.out.println("+-----------------+");
		while (true) {
			System.out.print(">>>");
			Scanner scan = new Scanner(System.in);
			String str1 = scan.next();
			
			if (str1.equals("help")) {
				System.out.println("jaba指令帮助:\n 输出一行字符串:printf?[String|int|float]\n 打开UI:OnUI\n 信息框:info?[String|version]\n 字符串转换为二进制:ejz?[String]\n 显示版本:version\n 当前时间:time\n 退出:exit");
			}
			else if (str1.contentEquals("exit")) {
				System.out.println("\njaba已退出!");
				System.exit(0);
			}
			else if(str1.equals("OnUI")) {
				UI.OnUI();
			}
			else if (str1.equals("version")) {
				System.out.println("当前jaba版本:1.0.0\n编译时间:2020/5/3");
			}
			else if (str1.equals("time")) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
				sdf.setLenient(false);
				
				System.out.println("现在时间:" + sdf.format(new Date()));
			}
			
			if (str1.contains("print?")) {
				String strArr[] = str1.split("\\?");
				System.out.println(strArr[1]);
			}
			else if (str1.contains("ejz?")) {
				String strArr[] = str1.split("\\?");
				System.out.println("已经将" + strArr[1] + "转换成二进制");
				 char[] strChar=strArr[1].toCharArray();
				    String result="";
				    for(int i=0;i<strChar.length;i++){
				        result +=Integer.toBinaryString(strChar[i])+ " ";
				    }
				    System.out.println("结果:"+result);
				System.out.println("--------------------------------------");
			}
			else if (str1.contains("info?")) {
				String strarString[] = str1.split("\\?");
				if (strarString[1].equals("version")) {
					UI.OnUI();
					UI.ver();
				}
				else {
					UI.OnUI();
					UI.info(strarString[1]);
				}
			}
		}
		
	}

}
