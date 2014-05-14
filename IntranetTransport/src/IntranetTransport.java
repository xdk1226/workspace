import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import MySocket.*;

public class IntranetTransport extends JFrame
{
private  IntranetTransport mf = this;
private JMenuBar jmb  = new JMenuBar();
private JMenu mainop = new JMenu("操作");
private JMenuItem menu_exit = new JMenuItem("退出");

private JMenu help = new JMenu("帮助");
private JMenuItem menu_info = new JMenuItem("软件信息");

private JPanel leftPanel = new JPanel();
private JLabel selfInfoLabel = new JLabel("本机信息",JLabel.CENTER);

private JPanel neiborsPanel = new JPanel();
private JLabel neiborsInfoLabel = new JLabel("邻居信息",JLabel.CENTER);

private DefaultListModel listModel = new DefaultListModel();
private JList neiborsList = new JList(listModel);

private JPanel rigthtPanel = new JPanel();;
private JTextField sendFile = new JTextField("                           ");
private JButton selectFile = new JButton("选择");
private JTextField toHost = new JTextField("*.*.*.*");
private JButton doSend = new JButton("发送");
private JPanel file_select = new JPanel();
private JPanel send_select = new JPanel();
private JPanel send_panel1 = new JPanel();
private JTextArea sendInfo = new JTextArea("Send info");

private MySocket mysock = new MySocket();

void Init()
{
	mf.setSize(750,500);
	
	mainop.add(menu_exit);
	help.add(menu_info);
	
	jmb.add(mainop);
	jmb.add(help);
	mf.setLayout(new GridLayout(1,2));
	mf.setJMenuBar(jmb);
	
	leftPanel.setBackground(Color.LIGHT_GRAY);
	leftPanel.setLayout(new BorderLayout());
	selfInfoLabel.setText( "本机地址："+ mysock.GetLocalHost());
	leftPanel.add(selfInfoLabel, "North");
	
	neiborsPanel.setLayout(new BorderLayout());
	neiborsPanel.add(neiborsInfoLabel,"North");
	for(int i=0; i<10; i++)
	{
		listModel.addElement("*.*.*.*");
	}
	
	neiborsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	neiborsPanel.add(neiborsList,"Center");
	leftPanel.add(neiborsPanel, "Center");
	
	mf.add(leftPanel);
	
	file_select.add(sendFile);
	file_select.add(selectFile);
	
	send_select.add(toHost);
	send_select.add(doSend);
	send_panel1.setLayout(new BorderLayout());
	send_panel1.add(send_select,"North");
	send_panel1.add(sendInfo,"Center");
	
	rigthtPanel.setLayout(new BorderLayout());
	rigthtPanel.add(file_select,"North");
	rigthtPanel.add(send_panel1,"Center");
	mf.add(rigthtPanel);
	
	mf.addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent e) 
		{
			System.exit(0);
		}
	});
	
	
	mf.setVisible(true);
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	IntranetTransport gui = new IntranetTransport(); 
	gui.Init();
}

}
/*
public class IntranetTransport  {
private Frame f = new Frame("内网文件传输工具");
private Panel pleft = new Panel();  //显示界面
private Panel pright = new Panel(); //文件传输操作界面
private Label neighbor = new Label("邻居信息",Label.CENTER);
private Label myselfinfo = new Label("本机信息",Label.CENTER); 
private List neighbors = new List(20);

private MenuBar mb =  new MenuBar(); //菜单栏
private Menu m1 = new Menu("File");  //菜单
private Menu m2 = new Menu("Edit");  //菜单
private Menu m3 = new Menu("Help");   // 菜单
private MenuItem open = new MenuItem("open"); //菜单项
private MenuItem save = new MenuItem("save");//菜单项

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntranetTransport gui = new IntranetTransport(); 
		gui.InitFrame();
	}
	
	public void InitFrame()
	{
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}
		});

//		f.setLayout(new GridLayout(10,5)); 
		f.setSize(750,500);
		
		m1.add(open);
		m1.add(save);
		
		mb.add(m1);
		mb.add(m2);
		mb.setHelpMenu(m3);
		pleft.setBackground(Color.LIGHT_GRAY);
		pleft.setSize(300,500);
	
		pleft.setLayout(new GridLayout(10,1,1,2));
	//
		pleft.add(new Label());
		myselfinfo.setBackground(Color.BLUE);
		pleft.add(myselfinfo);
		
		//neighbor.setLocation(100, 100);
		neighbor.setBackground(Color.green);	
		pleft.add(neighbor);
		
		for(int i=0; i<10; i++)
		{
			neighbors.add("*.*.*.*");
		}
	    	   
		pleft.add(neighbors);
		
		pright.setBackground(Color.GRAY);
		pright.setSize(450,500);
		f.setMenuBar(mb);
		
		f.add(pleft);
		f.add(pright);
		f.setVisible(true);
	}

}
*/