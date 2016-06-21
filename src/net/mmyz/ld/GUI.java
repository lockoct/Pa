package net.mmyz.ld;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JScrollPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1891517206078795155L;
	private JPanel contentPane;
	private JTextField wordInputTextField;
	private JTextField outPutPath;
	private JRadioButton absolutePathInput;
	private JRadioButton wordSearch;
	private JFileChooser chooser;
	private String opath;
	private String ipath;
	private JButton addButton;
	private JButton deleteButton;
	private JFormattedTextField absolutePathTextField;
	private JComboBox<String> comboBox;
	private DefaultListModel<String> dlm;
	private JList<String> wordList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("pa");
		
		
		chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 581, 485);
		setLocationRelativeTo(contentPane);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u64CD\u4F5C");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u8BBE\u7F6E\u8F93\u51FA\u4F4D\u7F6E");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = chooser.showSaveDialog(GUI.this);
				if (value == JFileChooser.APPROVE_OPTION) {
					opath = chooser.getSelectedFile().getAbsolutePath();
					outPutPath.setText(opath);
				}
				
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5173\u95ED");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u5E2E\u52A9");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u4F7F\u7528\u65B9\u6CD5");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Use frame = new Use();
				frame.setModal(true);
				frame.setVisible(true);
			}
		});
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5173\u4E8E");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				About frame = new About();
				frame.setModal(true);
				frame.setVisible(true);
			}
		});
		menu_1.add(menuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u529F\u80FD\u9009\u62E9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label = new JLabel("\u6252\u53D6\u76D8\u7B26\uFF1A");
		
		comboBox = new JComboBox<String>();
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"C:", "D:", "E:", "F:", "G:", "H:", "I:", "J:", "K:"}));
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel label_4 = new JLabel("\u8F93\u51FA\u8DEF\u5F84\uFF1A");
		
		outPutPath = new JTextField();
		outPutPath.setColumns(10);
		
		JButton browseButton = new JButton("\u6D4F\u89C8");
		browseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int value = chooser.showSaveDialog(GUI.this);
				if (value == JFileChooser.APPROVE_OPTION) {
					opath = chooser.getSelectedFile().getAbsolutePath();
					outPutPath.setText(opath);
				}
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("\u542F\u52A8");
		//启动扒取程序
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				beforeStart();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 494, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(outPutPath, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(browseButton)
							.addGap(18)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
							.addGap(10))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(outPutPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(browseButton)
						.addComponent(label)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
		);
		
		absolutePathInput = new JRadioButton("\u5B8C\u6574\u8DEF\u5F84");
		absolutePathInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				absolutePathTextField.setForeground(Color.BLACK);
				absolutePathTextField.setEditable(true);
				
				wordInputTextField.setEnabled(false);
				addButton.setEnabled(false);
				deleteButton.setEnabled(false);
				wordList.setEnabled(false);
			}
		});


		absolutePathInput.setSelected(true);
		
		wordSearch = new JRadioButton("\u5173\u952E\u5B57\u68C0\u7D22");
		wordSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wordInputTextField.setEnabled(true);
				addButton.setEnabled(true);
				deleteButton.setEnabled(true);
				wordList.setEnabled(true);
				
				absolutePathTextField.setForeground(Color.GRAY);
				absolutePathTextField.setEditable(false);
			}
		});
		
		ButtonGroup rbg = new ButtonGroup();
		
		rbg.add(absolutePathInput);
		rbg.add(wordSearch);
		
		JLabel label_1 = new JLabel("\u6E90\u8DEF\u5F84\uFF1A");
		
		JLabel label_2 = new JLabel("\u5982\u679C\u4F60\u8BB0\u4F4F\u4E86\u5B8C\u6574\u8DEF\u5F84\uFF0C\u8BF7\u9009\u62E9\u6B64\u9879\uFF0C\u9009\u62E9\u6B64\u9879\u65F6\"\u6252\u53D6\u76D8\u7B26\"\u9009\u9879\u5C06\u4E0D\u4F1A\u88AB\u4F7F\u7528\u3002");
		
		absolutePathTextField = new JFormattedTextField();
		absolutePathTextField.addMouseListener(new MouseAdapter() {
				int a = 0;
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if (a == 0) {
						absolutePathTextField.setText("");
						absolutePathTextField.setForeground(Color.BLACK);
						a++;
					}
				}
			});

		absolutePathTextField.setForeground(Color.GRAY);
		absolutePathTextField.setText("\u4F8B\u5982: J:\\\u9AD8\u4E8CDV2014\\\u4F18\u79C0\u4F5C\u54C1");
		absolutePathTextField.setName("");
		absolutePathTextField.setToolTipText("");
		
		dlm = new DefaultListModel<String>();
		dlm.addElement("高二");
		dlm.addElement("DV");
		dlm.addElement("2014");
		
		wordInputTextField = new JTextField();
		wordInputTextField.setEnabled(false);
		wordInputTextField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		JLabel label_3 = new JLabel("\u6DFB\u52A0\u5173\u952E\u5B57\uFF1A");
		
		addButton = new JButton("\u6DFB\u52A0");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String input = wordInputTextField.getText();
				boolean isSame = false;
				
				for (int i = 0; i < dlm.getSize(); i++) {
					if (input.equals(dlm.get(i)) == true) {
						isSame = true;
						break;
					}
				}
				if (isSame == true) {
						try {
							AudioPlayer.player.start(new AudioStream(
									new FileInputStream("C:/Windows/Media/Windows Foreground.wav")));
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
							System.out.println("找不到系统声音");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(GUI.this, "不能再添加相同的关键词", "操作违规", JOptionPane.ERROR_MESSAGE);
				}else if (input.equals("") == true) {
					Toolkit.getDefaultToolkit().beep();
				}else if (input.indexOf(" ") != -1) {
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(GUI.this, "关键词加入空格，请注意！", "注意", JOptionPane.WARNING_MESSAGE);
					dlm.addElement(input);	
					wordList.setModel(dlm);
				}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//判断文件中是否含有(/ \ ? " < > : |)字符，将来会用正则表达式
				else if (input.indexOf("/") != -1) {
					JOptionPane.showMessageDialog(GUI.this, "文件名不能有/", "操作违规", JOptionPane.WARNING_MESSAGE);
				}else if (input.indexOf("\\") != -1) {
					JOptionPane.showMessageDialog(GUI.this, "文件名不能有\\", "操作违规", JOptionPane.WARNING_MESSAGE);
				}else if (input.indexOf("?") != -1) {
					JOptionPane.showMessageDialog(GUI.this, "文件名不能有?", "操作违规", JOptionPane.WARNING_MESSAGE);
				}else if (input.indexOf("\"") != -1) {
					JOptionPane.showMessageDialog(GUI.this, "文件名不能有\"", "操作违规", JOptionPane.WARNING_MESSAGE);
				}else if (input.indexOf("<") != -1) {
					JOptionPane.showMessageDialog(GUI.this, "文件名不能有<", "操作违规", JOptionPane.WARNING_MESSAGE);
				}else if (input.indexOf(">") != -1) {
					JOptionPane.showMessageDialog(GUI.this, "文件名不能有>", "操作违规", JOptionPane.WARNING_MESSAGE);
				}else if (input.indexOf(":") != -1) {
					JOptionPane.showMessageDialog(GUI.this, "文件名不能有:", "操作违规", JOptionPane.WARNING_MESSAGE);
				}else if (input.indexOf("|") != -1) {
					JOptionPane.showMessageDialog(GUI.this, "文件名不能有|", "操作违规", JOptionPane.WARNING_MESSAGE);
				}	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
				else{
					dlm.addElement(input);	
					wordList.setModel(dlm);
				}
				wordInputTextField.setText("");
			}
		});
		addButton.setEnabled(false);
		
		deleteButton = new JButton("\u5220\u9664");
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (wordList.isSelectionEmpty() == true) {
					Toolkit.getDefaultToolkit().beep();
				}else {
					dlm.remove(wordList.getSelectedIndex());
					wordList.setModel(dlm);
				}
			}
		});
		deleteButton.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("\u5982\u679C\u4F60\u4E0D\u8BB0\u5F97\u8DEF\u5F84\u4E86\uFF0C\u53EF\u4EE5\u586B\u5199\u5173\u952E\u5B57\uFF0C\u5DE5\u5177\u5C06\u81EA\u52A8\u67E5\u627E\u76F8\u5173\u6587\u4EF6\u5939");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(absolutePathInput)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(21)
									.addComponent(label_1)
									.addGap(10)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 396, Short.MAX_VALUE)
										.addComponent(absolutePathTextField, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(wordSearch))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(wordInputTextField, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
											.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
												.addComponent(addButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)))
					.addGap(1))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(absolutePathInput)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(absolutePathTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(56)
							.addComponent(label_2)))
					.addGap(11)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(wordSearch)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(wordInputTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(addButton)
							.addGap(18)
							.addComponent(deleteButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel))
		);
		
		wordList = new JList<String>(dlm);
		wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		wordList.setForeground(Color.BLACK);
		wordList.setEnabled(false);
		wordList.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(wordList);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	private void beforeStart(){
		//选择完整路径输入时执行
		if (absolutePathInput.isSelected() == true) {
			//处理输入路径
			ipath = absolutePathTextField.getText();
			if (absolutePathTextField.getText().equals("") == true) {
				//便于调试
				System.out.println("ipath"+"    路径只有盘符");
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(GUI.this, "我不允许你扒取整个盘符", "操作违规", JOptionPane.WARNING_MESSAGE);
			}else {
				ipath = ipath.replace("\\", "/");
				//便于调试
				System.out.println(ipath);
				if (opath != null) {
					//处理输出路径
					opath = outPutPath.getText();
					opath = opath.replace("\\", "/");
					//便于调试
					System.out.println(opath);
					if (ipath.indexOf("例如") != -1) {
						System.out.println("没有输入路径");
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(GUI.this, "必须设定输入路径", "操作违规", JOptionPane.WARNING_MESSAGE);					
						absolutePathInput.setText("");
						}else{
							this.dispose();
							CopyByPath.Copy(ipath, opath);							
						}
				}else {
					System.out.println("没有输出路径");
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(GUI.this, "必须设定输出路径", "操作违规", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		//选择关键字搜索时执行
		else if (wordSearch.isSelected() == true) {
			if (wordList.getModel().getSize() != 0) {
				String[] words =  new String[wordList.getModel().getSize()];
				for (int i = 0; i < wordList.getModel().getSize(); i++) {
					words[i] = wordList.getModel().getElementAt(i);
					//便于调试
					System.out.println(words[i]);
				}
				String disk = comboBox.getSelectedItem().toString();
				System.out.println(disk);
				if (opath != null) {
					//处理输出路径
					opath = outPutPath.getText();
					opath = opath.replace("\\", "/");
					//便于调试
					System.out.println(opath);				
					this.dispose();
					CopyByWords.Copy(words, disk, opath);
				}else {
					System.out.println("没有输出路径");
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(GUI.this, "必须设定输出路径", "操作违规", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				try {
					AudioPlayer.player.start(new AudioStream(
							new FileInputStream("C:/Windows/Media/Windows Foreground.wav")));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
					System.out.println("找不到系统声音");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(GUI.this, "没有关键词，无法启动！", "操作违规", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
