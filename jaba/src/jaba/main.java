package jaba;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;
/*
 * ����������ʱ��û��
 * �´���ʱ������
 * jaba 1.0.2
 * ���һ�θ���:2020/5/4 20:08
 * */
public class main {
	public static void main(String[] args) {
		String cfString =  System.getProperty("Compile.file");
		if (cfString == null) {
	    	System.out.println("δ֪����");
		}else {
			System.out.println("���ڱ�������:" + cfString);
			CompilerAndRun._run(cfString);
			System.out.println("�������н���!!");
		}

		// TODO �Զ����ɵķ������
		System.out.println("+-----------------+");
		System.out.println("|Jaba �ź�������ͬ��      ");
		System.out.println("| jvav �� jaba����:�ź���");
		System.out.println("| jvav������:Reiz   ");
		System.out.println("|��ǰ�汾:1.0.2    ");
		System.out.println("|����help����ȡ����    ");
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
			System.out.println("jabaָ�����:\n ���һ���ַ���:print?[�ַ���|����|С��(������)]\n ��UI:OnUI\n ��Ϣ��:info?[�ַ���|version]\n �ַ���ת��Ϊ������:ejz?[�ַ���]\n ��ʾ�汾:version\n ��ǰʱ��:time \n �����ļ�:run?[�ļ�·��]\n ���Դ�IDE:IDE   IDE���ļ�:IDE?[�ļ�]\n �˳�:exit");
		}
		else if (str1.contentEquals("exit")) {
			System.out.println("\njaba���˳�!");
			System.exit(0);
		}
		else if(str1.equals("OnUI")) {
			UI.OnUI();
		}
		else if (str1.equals("version")) {
			System.out.println("��һ��jaba�汾:1.0.0\n����ʱ��:2020/5/3");
			System.out.println("��ǰ:1.0.2\n����ʱ��:2020/5/7");
		}
		else if (str1.equals("time")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
			sdf.setLenient(false);
			
			System.out.println("����ʱ��:" + sdf.format(new Date()));
		}
		else if (str1.equals("IDE")) {
			System.out.println("���ڴ�Jaba IDE...");
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
			System.out.println("�Ѿ���" + strArr[1] + "ת���ɶ�����");
			 char[] strChar=strArr[1].toCharArray();
			    String result="";
			    for(int i=0;i<strChar.length;i++){
			        result +=Integer.toBinaryString(strChar[i])+ " ";
			    }
			    System.out.println("���:"+result);
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
				System.out.println("err:�ļ�������Ϊ��");
			}
		}
		
		else if (str1.contains("IDE?")) {
			String strArr[] = str1.split("\\?");
			if (!strArr[1].equals("")) {
				
			}else {
				System.out.println("����:���ܴ򿪵��ļ�");
			}
		}
	}

}