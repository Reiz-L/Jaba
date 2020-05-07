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
		jm = new JMenu("�ļ�");
		jm1 = new JMenu("����");
		jmf = new JMenu("�༭");
		jcodeMenu = new JMenu("Դ��");
		jm1i1 = new JMenuItem("���沢����");
		jmi = new JMenuItem("��");/*��*/  jmi1 = new JMenuItem("����");/*/����*/ jmi2 = new JMenuItem("�ر�"); /*�ر�*/jmi3 = new JMenuItem("���Ϊ");
		jmfi = new JMenuItem("��������");
		jcItem = new JMenuItem("���� print?[String]"); jcItem1 = new JMenuItem("����time");
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
		//�����¼�����
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e)
			{
				Object options[] = {"�˳�","�˳�������","ȡ��"};
				int result1 = JOptionPane.showOptionDialog(JbIDE.this, "��ȷ��Ҫ�˳�JbIDE��?\n��ȷ���Ƿ�Ҫ���������ļ�?", "ȷ���˳�?", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (e.getWindow() == JbIDE.this) {
					if (result1 == 0) {
						JbIDE.this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
					else if (result1 == 1) {
						JOptionPane.showMessageDialog(null, "�Ѿ����沢�˳�");
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
		//���ļ�
		jmi.addActionListener(new ActionListener() { //���ǵ�����ļ�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if (cArea.getText().equals("")) {//�жϱ༭��Ϊ��
					fileDialog();
				}
				else {
					Object optObject[] = {"ȷ��","�����ٴ�","ȡ��"};
					int result2 = JOptionPane.showOptionDialog(JbIDE.this, "�����ļ���δ���棬�Ƿ�����������ļ�?", "ȷ��?", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE, null, optObject, optObject[0]);
					if (result2 == 0) {//������
						pathString = "";
						fileDialog();
					}else if (result2 == 1) {//���沢��
						SavejbFile(pathString);
						fileDialog();
					}else if (result2 == 2) {//ȡ��
						return;
					}
				}
				
			}
		});
		//��������
		jmfi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				int i;
				String fontString = (String) JOptionPane.showInputDialog(null, "��������Ҫ�л�������,ȷ�����ϵͳ�а�װ�������","����������",JOptionPane.PLAIN_MESSAGE,null,null,"����");
				String fontSizeint = (String) JOptionPane.showInputDialog(null, "��������Ҫ�������С","�����С",JOptionPane.PLAIN_MESSAGE,null,null,"14");
				JOptionPane.showMessageDialog(null, "��ѡ��������:" + fontString + "\n�����С:" + fontSizeint + "\n\n�˵����༭��ס�ˣ������һ�´��ڴ�С������");
				i = Integer.parseInt(fontSizeint);
				cArea.setFont(new Font(fontString, Font.PLAIN, i));
			}
		});
		//�ر��ļ�
		jmi2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				pathString = "";
				setTitle("JbIDE - *.jb");
				cArea.setText("");
				
			}
		});
		
		jmi3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				saveAs();
			}
		});
		
		jm1i1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				//String strR = pathString.replaceAll("//", "\\");
				SavejbFile(pathString);
				System.out.println("��������:" + pathString);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				CompilerAndRun._run(pathString);
			}
		});
		
		jcItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				String yuanlaiString = cArea.getText();
				cArea.setText(yuanlaiString + "print?String\n");
			}
		});
		
		jcItem1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				String ylString = cArea.getText();
				cArea.setText(ylString + "time\n"); 
			}
		});
	}
	

	public void fileDialog() {
		fdg = new FileDialog(JbIDE.this,"��jb�ļ�",FileDialog.LOAD);
		fdg.setVisible(true);
		String fileName = fdg.getFile();
		String dirName = fdg.getDirectory();
		if(dirName==null || fileName==null){ //�ļ��Ƿ����ã�
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
            System.out.println("\nIDE���ļ�:" + pathString);
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
				JOptionPane.showMessageDialog(null, "�ļ��������!!!");
				
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "�����ļ���ʱ�����˴���", "����", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
	}
	
	public void saveAs() {//���Ϊ
		JOptionPane.showMessageDialog(null, "��⵽��û�д�һ���ļ�\n��ѡ�񱣴�·��!");
		sfdg = new FileDialog(JbIDE.this,"ѡ��һ���ļ���",FileDialog.SAVE);
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
			JOptionPane.showMessageDialog(null, "�ļ��������!!!");
			pathString = dirString + fiString;
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "�����ļ���ʱ�����˴���", "����", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
