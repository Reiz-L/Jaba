package jaba;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class JbIDE extends JFrame{
	public int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	public int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	public String pathString;
	JMenuBar jmb;
	JMenu jm;
	JMenu jm1;
	JMenu jmf;
	JMenu jcodeMenu;
	JMenuItem jmi; JMenuItem jmi1; JMenuItem jmi2; JMenuItem jmi3;
	JMenuItem jm1i1;
	JMenuItem jmfi;
	JMenuItem jcItem; JMenuItem jcItem1;
	JPanel cPanel;
	FileDialog fdg;
	FileDialog sfdg;
	//JTextArea cTextArea;
	TextArea cArea;
	public static void IDEUI() {
		new JbIDE();
	}
	
	public JbIDE(){
		this.setBounds(screenWidth / 2  - 400, screenHeight /2 - 300, 800, 600);
		this.setTitle("*JbIDE - Untitle.jb*");
		BufferedImage img = null;
		try {
			URL fileURL = this.getClass().getResource("/resources/icon.png");
			img = ImageIO.read(fileURL);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		this.setIconImage(img);
		jmb = new JMenuBar();
		jm = new JMenu("文件");
		jm1 = new JMenu("调试");
		jmf = new JMenu("编辑");
		jcodeMenu = new JMenu("源码");
		jm1i1 = new JMenuItem("保存并运行");
		jmi = new JMenuItem("打开");/*打开*/  jmi1 = new JMenuItem("保存");/*/保存*/ jmi2 = new JMenuItem("关闭"); /*关闭*/jmi3 = new JMenuItem("另存为");
		jmfi = new JMenuItem("字体设置");
		jcItem = new JMenuItem("插入 print?[String]"); jcItem1 = new JMenuItem("插入time");
		cPanel = new JPanel();
		//cTextArea = new JTextArea();
		
		cPanel.setBounds(0, 0, 780, 580);
		cPanel.setLayout(new BorderLayout());
		Dimension di = cPanel.getSize();
		
		cArea = new TextArea();
		cArea.setBounds(0, 0, di.width,di.height);
		cPanel.add(cArea);
		
		this.setJMenuBar(jmb);
		jmb.add(jm); jmb.add(jm1); jmb.add(jmf); jmb.add(jcodeMenu);
		jm.add(jmi); jm.add(jmi1); jm.add(jmi2);
		jm1.add(jm1i1);
		jmf.add(jmfi);
		jcodeMenu.add(jcItem); jcodeMenu.add(jcItem1);
		this.add(cPanel);
		this.setVisible(true);
		//窗口事件监听
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e)
			{
				Object options[] = {"退出","退出并保存","取消"};
				int result1 = JOptionPane.showOptionDialog(JbIDE.this, "你确定要退出JbIDE吗?\n请确认是否要保存您的文件?", "确定退出?", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (e.getWindow() == JbIDE.this) {
					if (result1 == 0) {
						JbIDE.this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
					else if (result1 == 1) {
						JOptionPane.showMessageDialog(null, "已经保存并退出");
						JbIDE.this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						pathString = null;
						System.out.println(">>>");
					}
					else if (result1 == 2) {
						JbIDE.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				}
				
			}
		});
		//打开文件
		jmi.addActionListener(new ActionListener() { //这是点击打开文件
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (cArea.getText().equals("")) {//判断编辑框为空
					fileDialog();
				}
				else {
					Object optObject[] = {"确定","保存再打开","取消"};
					int result2 = JOptionPane.showOptionDialog(JbIDE.this, "您的文件尚未保存，是否继续打开其他文件?", "确定?", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE, null, optObject, optObject[0]);
					if (result2 == 0) {//继续打开
						pathString = "";
						fileDialog();
					}else if (result2 == 1) {//保存并打开
						SavejbFile(pathString);
						fileDialog();
					}else if (result2 == 2) {//取消
						return;
					}
				}
				
			}
		});
		//字体设置
		jmfi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				int i;
				String fontString = (String) JOptionPane.showInputDialog(null, "请输入需要切换的字体,确保你的系统有安装这个字体","输入字体名",JOptionPane.PLAIN_MESSAGE,null,null,"宋体");
				String fontSizeint = (String) JOptionPane.showInputDialog(null, "请输入需要的字体大小","字体大小",JOptionPane.PLAIN_MESSAGE,null,null,"14");
				JOptionPane.showMessageDialog(null, "你选择了字体:" + fontString + "\n字体大小:" + fontSizeint + "\n\n菜单被编辑框挡住了？请调整一下窗口大小就行了");
				i = Integer.parseInt(fontSizeint);
				cArea.setFont(new Font(fontString, Font.PLAIN, i));
			}
		});
		//关闭文件
		jmi2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				pathString = "";
				setTitle("JbIDE - *.jb");
				cArea.setText("");
				
			}
		});
		
		jmi3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				saveAs();
			}
		});
		
		jm1i1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//String strR = pathString.replaceAll("//", "\\");
				SavejbFile(pathString);
				System.out.println("正在运行:" + pathString);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				CompilerAndRun._run(pathString);
			}
		});
		
		jcItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String yuanlaiString = cArea.getText();
				cArea.setText(yuanlaiString + "print?String\n");
			}
		});
		
		jcItem1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String ylString = cArea.getText();
				cArea.setText(ylString + "time\n"); 
			}
		});
	}
	

	public void fileDialog() {
		fdg = new FileDialog(JbIDE.this,"打开jb文件",FileDialog.LOAD);
		fdg.setVisible(true);
		String fileName = fdg.getFile();
		String dirName = fdg.getDirectory();
		if(dirName==null || fileName==null){ //文件是否能用？
            return;
        }
		File file=new File(dirName,fileName);
		try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			String line;
            StringBuilder text = new StringBuilder();
            while((line=br.readLine()) != null){
                text.append(line);
                text.append("\r\n");
            }
            cArea.setText(text.toString());
            pathString = dirName + fileName;
            System.out.println("\nIDE打开文件:" + pathString);
            setTitle("JbIDE - "+ pathString);
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public void SavejbFile(String Filename) {
		if (Filename == null) {
			saveAs();
		}else {
			try {
				FileWriter fw = new FileWriter(new File(Filename));
				String str = cArea.getText();
				fw.write(str);
				fw.close();
				JOptionPane.showMessageDialog(null, "文件保存完成!!!");
				
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "保存文件的时候发生了错误", "错误", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
	}
	
	public void saveAs() {//另存为
		JOptionPane.showMessageDialog(null, "检测到你没有打开一个文件\n请选择保存路径!");
		sfdg = new FileDialog(JbIDE.this,"选择一个文件夹",FileDialog.SAVE);
		sfdg.setVisible(true);
		String dirString = sfdg.getDirectory();
		String fiString = sfdg.getFile();
		if (dirString == null || fiString == null) {
			return;
		}
		File file = new File(dirString,fiString);
		try {
			FileWriter fw = new FileWriter(file);
			String str = cArea.getText();
			fw.write(str);
			fw.close();
			JOptionPane.showMessageDialog(null, "文件保存完成!!!");
			pathString = dirString + fiString;
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "保存文件的时候发生了错误", "错误", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
