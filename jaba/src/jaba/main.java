package jaba;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;
/*
 * 编译现在暂时还没做
 * 下次有时间在做
 * jaba 1.0.2
 * 最后一次更改:2020/5/4 20:08
 * */
public class main {
	public static void main(String[] args) {
		String cfString =  System.getProperty("Compile.file");
		if (cfString == null) {
	    	System.out.println("未知参数");
		}else {
			System.out.println("正在编译运行:" + cfString);
			CompilerAndRun._run(cfString);
			System.out.println("编译运行结束!!");
		}

		// TODO 自动生成的方法存根
		System.out.println("+-----------------+");
		System.out.println("|Jaba 张浩扬与你同在      ");
		System.out.println("| jvav 和 jaba作者:张浩扬");
		System.out.println("| jvav改造者:Reiz   ");
		System.out.println("|当前版本:1.0.2    ");
		System.out.println("|输入help来获取帮助    ");
		System.out.println("+-----------------+");
		while (true) {
			System.out.print(">>>");
			Scanner scan = new Scanner(System.in);
			String str = scan.next();
			runcomm(str);
		}
		
	}
	
	public static void runcomm(String str1) {
		if (str1.equals("help")) {
			System.out.println("jaba指令帮助:\n 输出一行字符串:print?[字符串|整数|小数(浮数点)]\n 打开UI:OnUI\n 信息框:info?[字符串|version]\n 字符串转换为二进制:ejz?[字符串]\n 显示版本:version\n 当前时间:time \n 运行文件:run?[文件路径]\n 打开自带IDE:IDE   IDE打开文件:IDE?[文件]\n 退出:exit");
		}
		else if (str1.contentEquals("exit")) {
			System.out.println("\njaba已退出!");
			System.exit(0);
		}
		else if(str1.equals("OnUI")) {
			UI.OnUI();
		}
		else if (str1.equals("version")) {
			System.out.println("第一个jaba版本:1.0.0\n编译时间:2020/5/3");
			System.out.println("当前:1.0.2\n编译时间:2020/5/7");
		}
		else if (str1.equals("time")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
			sdf.setLenient(false);
			
			System.out.println("现在时间:" + sdf.format(new Date()));
		}
		else if (str1.equals("IDE")) {
			System.out.println("正在打开Jaba IDE...");
			JbIDE.IDEUI();
		}
		
		
		if (str1.contains("print?")) {
			String strArr[] = str1.split("\\?");
			if (strArr[1].equals("[n")) {
				System.out.println("");
			}else {
				System.out.println(strArr[1]);
			}
			
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
		
		else if (str1.contains("run?")) {
			String string1[] = str1.split("\\?");
			if (!string1[1].equals("")) {
				CompilerAndRun._run(string1[1]);
			}
			if (string1[1] == null) {
				System.out.println("err:文件名不能为空");
			}
		}
		
		else if (str1.contains("IDE?")) {
			String strArr[] = str1.split("\\?");
			if (!strArr[1].equals("")) {
				
			}else {
				System.out.println("错误:不能打开的文件");
			}
		}
	}

}