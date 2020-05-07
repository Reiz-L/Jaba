package jaba;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;

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
		this.setTitle("Jaba �ź�������ͬ��");
		this.setResizable(false);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("resources/icon.png"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		this.setIconImage(img);
		jl = new JLabel("Jaba �ź�������ͬ��");
		jl.setBounds(137, 94, 250, 25);
		jl1 = new JLabel("��ǰJaba�汾:1.0.2");
		jl1.setBounds(137, 119, 250, 25);
		jl2 = new JLabel("���ֻ��رմ��ھ������Ͻǹر�");
		jl2.setBounds(137, 144, 250, 25);
		//Buttons
		jb = new JButton("������Ϣ");
		jb.setBounds(137, 198, 100, 25);
		jb1 = new JButton("�򿪹���");
		jb1.setBounds(137, 230, 100, 25);
		jb2 = new JButton("�ر�Jaba");
		jb2.setBounds(137, 260, 100, 25);
		jb3 = new JButton("��IDE");
		jb3.setBounds(137, 320, 100, 25);
		compileButton = new JButton("����");
		compileButton.setBounds(245, 290, 80, 25);
		
		this.add(jl);
		this.add(jl1);
		this.add(jl2);
		this.add(jb);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		compileField = new JTextField("����������Ҫ������ļ���");
		compileField.setBounds(90, 290, 150, 30);
		this.add(compileField);
		this.add(compileButton);
		this.setVisible(true);
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("resources/12869.png"));
			System.out.println("successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("δ�ҵ�logoͼƬ,��ȷ��Ŀ¼���Ƿ����res�ļ���");
			JOptionPane.showMessageDialog(null, "δ�ҵ�logoͼƬ,��ȷ��Ŀ¼���Ƿ����res�ļ���");
			Object[] options = {"���������ļ�","ȡ��"};
			int _result = JOptionPane.showOptionDialog(this, "�Ƿ�ǰ���������������ļ���", "�Ƿ�����", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if (_result == 0) {
				System.out.println("ǰ������:https://github.com/Reiz-L/Jaba");
				System.out.println("���û�п�ʼ��ת���븴�Ƶ��������ת");
			}
			else if (_result == 1) {
				System.out.println("�û�ȡ�����������˳�...");
				System.exit(0);
			}
		}
		jl4 = new JLabel(new ImageIcon(image));
		getContentPane().add(jl4);
		jl4.setBounds(168, 0, image.getWidth(), image.getHeight());
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				JOptionPane.showMessageDialog(null, "Jaba��jvav�ĸĽ��汾������jvav\n�� 2020 �� 14 �� 64 ��ķ��а������ �ź��� Jaba ��ɡ�\n" + 
						"�µ������� �ź��� Jaba SE ���Э�� ����ǰ�� �ź��� Jvav ����кܴ���졣\n ���������ĳЩ���ʹ�ã��������ʹ�úͿ���ʹ�ã���\n��������ǰ�� �ź��� Jvav ��ɻ����Ȩ������ʹ�ÿ��ܻ᲻��֧�֡� �������غ�ʹ�ô˲�Ʒ֮ǰ�����Ķ���� ���ڴ˴��鿴����������\n" + 
						"\n" + 
						"����ͨ���ͳɱ��� Jaba SE ���� �����ҵ��ɺͼ���֧�֡�\n" + 
						"\n" + 
						"�ź��� ���� jdk.Jaba.net �Ŀ�Դ GPL ������ṩ�����µ� OpenBDK ���а档", "����Jaba", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				try {
					URI url = new URI("https://github.com/Reiz-L/Jaba");
					Desktop.getDesktop().browse(url);
					System.out.println("����ǰ������ https://github.com/Reiz-L/Jaba...");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("jaba UI & Core�ر�");
				System.exit(0);
			}
		});
		
		compileButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if (!compileField.getText().equals("")) {
					System.out.println("���ڱ���:" + compileField.getText() + "\n����ɹ�!!!");
					CompilerAndRun._run(compileField.getText());
				}
				else {
					JOptionPane.showMessageDialog(null, "��û����д����ļ���,�޷����룡","����",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				JbIDE.IDEUI();
			}
		});
	}
	
	public static void info(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public static void ver() {
		JOptionPane.showMessageDialog(null, "��ǰjaba�汾:1.0.2");
	}
}