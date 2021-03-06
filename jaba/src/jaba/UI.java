package jaba;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UI extends JFrame{
	public int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	public int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	JLabel jl;
	JLabel jl1;
	JLabel jl2;
	JButton jb;
	JButton jb1;
	JButton jb2;
	JButton jb3;
	JLabel jl4;
	JTextField compileField;
	JButton compileButton;

	public static void OnUI() {
		new UI();
	}
	public UI() {
		this.setLayout(null);
		this.setBounds(screenWidth /2 - 250, screenHeight / 2 - 200, 500, 400);
		this.setTitle("Jaba 张浩扬与你同在");
		this.setResizable(false);
		BufferedImage img = null;
		try {
			URL fileURL = this.getClass().getResource("/resources/icon.png");
			img = ImageIO.read(fileURL);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		this.setIconImage(img);
		jl = new JLabel("Jaba 张浩扬与您同在");
		jl.setBounds(137, 94, 250, 25);
		jl1 = new JLabel("当前Jaba版本:1.0.2");
		jl1.setBounds(137, 119, 250, 25);
		jl2 = new JLabel("如果只想关闭窗口就请右上角关闭");
		jl2.setBounds(137, 144, 250, 25);
		//Buttons
		jb = new JButton("更多信息");
		jb.setBounds(137, 198, 100, 25);
		jb1 = new JButton("打开官网");
		jb1.setBounds(137, 230, 100, 25);
		jb2 = new JButton("关闭Jaba");
		jb2.setBounds(137, 260, 100, 25);
		jb3 = new JButton("打开IDE");
		jb3.setBounds(137, 320, 100, 25);
		compileButton = new JButton("编译");
		compileButton.setBounds(245, 290, 80, 25);
		
		this.add(jl);
		this.add(jl1);
		this.add(jl2);
		this.add(jb);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		compileField = new JTextField("在这里输入要编译的文件名");
		compileField.setBounds(90, 290, 150, 30);
		this.add(compileField);
		this.add(compileButton);
		this.setVisible(true);
		BufferedImage image = null;
		try {
			URL fileURL1 = this.getClass().getResource("/resources/12869.png");
			image = ImageIO.read(fileURL1);
			System.out.println("successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("未找到logo图片,请确保目录下是否存在resources文件夹");
			JOptionPane.showMessageDialog(null, "未找到logo图片,请确保目录下是否存在res文件夹");
			Object[] options = {"下载完整文件","取消"};
			int _result = JOptionPane.showOptionDialog(this, "是否前往官网下载完整文件？", "是否下载", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if (_result == 0) {
				System.out.println("前往下载:https://github.com/Reiz-L/Jaba");
				System.out.println("如果没有开始跳转，请复制到浏览器跳转");
			}
			else if (_result == 1) {
				System.out.println("用户取消操作正在退出...");
				System.exit(0);
			}
		}
		jl4 = new JLabel(new ImageIcon(image));
		getContentPane().add(jl4);
		jl4.setBounds(168, 0, image.getWidth(), image.getHeight());
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JOptionPane.showMessageDialog(null, "Jaba是jvav的改进版本，基于jvav\n从 2020 年 14 月 64 起的发行版更改了 张浩扬 Jaba 许可。\n" + 
						"新的适用于 张浩扬 Jaba SE 许可协议 与以前的 张浩扬 Jvav 许可有很大差异。\n 新许可允许某些免费使用（例如个人使用和开发使用），\n而根据以前的 张浩扬 Jvav 许可获得授权的其他使用可能会不再支持。 请在下载和使用此产品之前认真阅读条款。 可在此处查看常见问题解答。\n" + 
						"\n" + 
						"可以通过低成本的 Jaba SE 订阅 获得商业许可和技术支持。\n" + 
						"\n" + 
						"张浩扬 还在 jdk.Jaba.net 的开源 GPL 许可下提供了最新的 OpenBDK 发行版。", "关于Jaba", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				try {
					URI url = new URI("https://github.com/Reiz-L/Jaba");
					Desktop.getDesktop().browse(url);
					System.out.println("正在前往官网 https://github.com/Reiz-L/Jaba...");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("jaba UI & Core关闭");
				System.exit(0);
			}
		});
		
		compileButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (!compileField.getText().equals("")) {
					System.out.println("正在编译:" + compileField.getText() + "\n编译成功!!!");
					CompilerAndRun._run(compileField.getText());
				}
				else {
					JOptionPane.showMessageDialog(null, "你没有填写这个文件名,无法编译！","错误",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JbIDE.IDEUI();
			}
		});
	}
	
	public static void info(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public static void ver() {
		JOptionPane.showMessageDialog(null, "当前jaba版本:1.0.2");
	}
}