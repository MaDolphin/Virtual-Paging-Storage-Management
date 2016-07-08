package OS_Frm;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MyFrm extends JFrame{
	JTextField blank0,blank1,blank2,blank3,blank4,blank5,blank6,blank7,blank8,blank9;
	JTextField blank_0,blank_1,blank_2,blank_3,blank_4,blank_5,blank_6,blank_7,blank_8,blank_9;
	JTextField blank00,blank01,blank02,blank10,blank11,blank20;
	JButton button1,button2,button3,button4;
	Pro pro=new Pro();
	Lru [] lru =new Lru[3];
	public static int block=10;
	public MyFrm(){  
		JPanel jp=(JPanel)this.getContentPane();
		jp.setLayout(new BorderLayout(10,3));	
		JPanel p1_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1_1.add(new JLabel("进程号："));
		p1_1.add(blank00 = new JTextField(5));
		p1_1.add(new JLabel("程序页个数："));
		p1_1.add(blank01 = new JTextField(5));
		p1_1.add(new JLabel("物理块大小："));
		p1_1.add(blank02 = new JTextField(5));
		p1_1.add(button1 = new JButton("确定分配"));
		JPanel p1_2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1_2.add(new JLabel("进程号："));
		p1_2.add(blank10 = new JTextField(5));
		p1_2.add(new JLabel("逻辑地址(D)："));
		p1_2.add(blank11 = new JTextField(5));
		p1_2.add(button2 = new JButton("确定添加"));
		JPanel p1_3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1_3.add(new JLabel("进程号："));
		p1_3.add(blank20 = new JTextField(5));
		p1_3.add(new JLabel(" "));
		p1_3.add(new JLabel(" "));
		p1_3.add(button3 = new JButton("确定释放"));
		JPanel p2 = new JPanel(new GridLayout(6,1,0,0));  
		p2.add(new JLabel("进程初始化:"));
		p2.add(p1_1);
		p2.add(new JLabel("进程序列:"));
		p2.add(p1_2);
		p2.add(new JLabel("释放进程:"));
		p2.add(p1_3);
		JPanel p3 = new JPanel(new GridLayout(12,2,10,0));
		p3.add(new JLabel("内存块容量为10"));
		p3.add(new JLabel("物理地址(H)"));
		p3.add(blank0 = new JTextField("-1"));
		p3.add(blank_0 = new JTextField(""));
		p3.add(blank1 = new JTextField("-1"));
		p3.add(blank_1 = new JTextField(""));
		p3.add(blank2 = new JTextField("-1"));
		p3.add(blank_2 = new JTextField(""));
		p3.add(blank3 = new JTextField("-1"));
		p3.add(blank_3 = new JTextField(""));
		p3.add(blank4 = new JTextField("-1"));
		p3.add(blank_4 = new JTextField(""));
		p3.add(blank5 = new JTextField("-1"));
		p3.add(blank_5 = new JTextField(""));
		p3.add(blank6 = new JTextField("-1"));
		p3.add(blank_6 = new JTextField(""));
		p3.add(blank7 = new JTextField("-1"));
		p3.add(blank_7 = new JTextField(""));
		p3.add(blank8 = new JTextField("-1"));
		p3.add(blank_8 = new JTextField(""));
		p3.add(blank9 = new JTextField("-1"));   
		p3.add(blank_9 = new JTextField(""));
		p3.add(button4 = new JButton("清空内存"));	
		jp.add(p2,BorderLayout.WEST);
		jp.add(p3,BorderLayout.CENTER); 
		
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					switch(Integer.valueOf(blank00.getText())){
						case 0:
							if(block>Integer.valueOf(blank02.getText())){
								if(lru[0]==null){
									lru[0]=new Lru(Integer.valueOf(blank01.getText()),Integer.valueOf(blank02.getText()));
									block=block-Integer.valueOf(blank02.getText());
									for(int i=0;i<lru[0].disk.length;i++){
										initColour(lru[0].disk[i],Color.RED);
									}
									break;
								}else{
									JOptionPane.showMessageDialog(null,"该进程已存在");
									break;
								}
							}
							else {
								JOptionPane.showMessageDialog(null,"物理块资源不足");
								break;
							}
						case 1:
							if(block>Integer.valueOf(blank02.getText())){
								if(lru[1]==null){
									lru[1]=new Lru(Integer.valueOf(blank01.getText()),Integer.valueOf(blank02.getText()));
									block=block-Integer.valueOf(blank02.getText());
									for(int i=0;i<lru[1].disk.length;i++){
										initColour(lru[1].disk[i],Color.GREEN);
									}
									break;
								}else{
									JOptionPane.showMessageDialog(null,"该进程已存在");
									break;
								}
							}
							else {
								JOptionPane.showMessageDialog(null,"物理块资源不足");
								break;
							}
						case 2:
							if(block>Integer.valueOf(blank02.getText())){
								if(lru[2]==null){
									lru[2]=new Lru(Integer.valueOf(blank01.getText()),Integer.valueOf(blank02.getText()));
									block=block-Integer.valueOf(blank02.getText());
									for(int i=0;i<lru[2].disk.length;i++){
										initColour(lru[2].disk[i],Color.YELLOW);
									}
									break;
								}else{
									JOptionPane.showMessageDialog(null,"该进程已存在");
									break;
								}
							}
							else {
								JOptionPane.showMessageDialog(null,"物理块资源不足");
								break;
							}
					}
				}catch(Exception e1){
					
				}
			}

		});
		
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					int[] print=new int[4];
					int[] temp=new int[2];
					int[] get =new int[3];
					temp=pro.change(Integer.valueOf(blank11.getText()));
					if(lru[Integer.valueOf(blank10.getText())].len>Integer.valueOf(blank11.getText())){
						switch(Integer.valueOf(blank10.getText())){
							case 0:print[0]=0;get=lru[0].Skip(temp);break;
							case 1:print[0]=1;get=lru[1].Skip(temp);break;
							case 2:print[0]=2;get=lru[2].Skip(temp);break;
						}
						print[1]=get[0];
						print[3]=get[2];
						print[2]=pro.updateMemory(get[0], get[1], get[2]);
						memoryList(print);
					}
					else{
						JOptionPane.showMessageDialog(null,"超出程序大小");
					}
				}catch(Exception e1){
					
				}
			}
		});
		
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					switch(Integer.valueOf(blank20.getText())){
						case 0:pro.deleteMemory(lru[0].disk);release(lru[0].disk);lru[0]=null;break;
						case 1:pro.deleteMemory(lru[1].disk);release(lru[1].disk);lru[1]=null;break;
						case 2:pro.deleteMemory(lru[2].disk);release(lru[2].disk);lru[2]=null;break;
					}
				}catch(Exception e1){
					
				}
			}
		});
		
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					for(int i=0;i<3;i++){
						if(lru[i]!=null){
							if(lru[i].disk!=null){
								pro.deleteMemory(lru[i].disk);
								release(lru[i].disk);
								lru[i]=null;
							}
						}
					}
				}catch(Exception e1){
					
				}
			}
		});
	} 
	
	public void release(int[] temp){
		for(int i=0;i<temp.length;i++){
			switch(temp[i]){
				case 0:blank0.setText("-1");blank_0.setText("");blank0.setBackground(Color.WHITE);break;
				case 1:blank1.setText("-1");blank_1.setText("");blank1.setBackground(Color.WHITE);break;
				case 2:blank2.setText("-1");blank_2.setText("");blank2.setBackground(Color.WHITE);break;
				case 3:blank3.setText("-1");blank_3.setText("");blank3.setBackground(Color.WHITE);break;
				case 4:blank4.setText("-1");blank_4.setText("");blank4.setBackground(Color.WHITE);break;
				case 5:blank5.setText("-1");blank_5.setText("");blank5.setBackground(Color.WHITE);break;
				case 6:blank6.setText("-1");blank_6.setText("");blank6.setBackground(Color.WHITE);break;
				case 7:blank7.setText("-1");blank_7.setText("");blank7.setBackground(Color.WHITE);break;
				case 8:blank8.setText("-1");blank_8.setText("");blank8.setBackground(Color.WHITE);break;
				case 9:blank9.setText("-1");blank_9.setText("");blank9.setBackground(Color.WHITE);break;
			}
			block++;
		}
	}
	
	public void memoryList(int[] out){
		switch(out[3]){
			case 0:blank0.setText(out[0]+"-"+out[1]);blank_0.setText(Integer.toHexString(out[2])+"H");break;
			case 1:blank1.setText(out[0]+"-"+out[1]);blank_1.setText(Integer.toHexString(out[2])+"H");break;
			case 2:blank2.setText(out[0]+"-"+out[1]);blank_2.setText(Integer.toHexString(out[2])+"H");break;
			case 3:blank3.setText(out[0]+"-"+out[1]);blank_3.setText(Integer.toHexString(out[2])+"H");break;
			case 4:blank4.setText(out[0]+"-"+out[1]);blank_4.setText(Integer.toHexString(out[2])+"H");break;
			case 5:blank5.setText(out[0]+"-"+out[1]);blank_5.setText(Integer.toHexString(out[2])+"H");break;
			case 6:blank6.setText(out[0]+"-"+out[1]);blank_6.setText(Integer.toHexString(out[2])+"H");break;
			case 7:blank7.setText(out[0]+"-"+out[1]);blank_7.setText(Integer.toHexString(out[2])+"H");break;
			case 8:blank8.setText(out[0]+"-"+out[1]);blank_8.setText(Integer.toHexString(out[2])+"H");break;
			case 9:blank9.setText(out[0]+"-"+out[1]);blank_9.setText(Integer.toHexString(out[2])+"H");break;
		}
	}
	
	public void initColour(int n,Color c){
		switch(n){
			case 0:blank0.setBackground(c);break;
			case 1:blank1.setBackground(c);break;
			case 2:blank2.setBackground(c);break;
			case 3:blank3.setBackground(c);break;
			case 4:blank4.setBackground(c);break;
			case 5:blank5.setBackground(c);break;
			case 6:blank6.setBackground(c);break;
			case 7:blank7.setBackground(c);break;
			case 8:blank8.setBackground(c);break;
			case 9:blank9.setBackground(c);break;
		}
	}
	
	public static void main(String[] args){
		MyFrm frame = new MyFrm();
		frame.setTitle("虚拟分页存储管理模拟--LRU");
		frame.setSize(750,350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	} 
}