package net.mmyz.ld;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;



@SuppressWarnings("serial")
public class About extends JDialog{	
	private JPanel contentPane;
	
	
	
	public About(){
		setTitle("\u5173\u4E8E");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0, 300, 300);
		setLocationRelativeTo(contentPane);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5DE5\u5177\u540D\uFF1Apa");
		
		JLabel label = new JLabel("\u5DE5\u5177\u7248\u672C\uFF1A2.0.0");
		
		JLabel lblNewLabel_1 = new JLabel("\u7248\u672C\uFF1A2.4");
		
		JLabel lblapacheCommonsIo = new JLabel("\u8C03\u7528\u7B2C\u4E09\u65B9\u5E93\uFF1AApache Commons IO");
		
		JLabel lbllockoct = new JLabel("\u4F5C\u8005\uFF1ALockoct");
		
		JLabel lblqqcom = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A825300455@qq.com");
		JButton button = new JButton("\u786E \u5B9A");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				close();
			}
		});
		
		JPanel panel = new JPanel(){
			protected void paintComponent(java.awt.Graphics g) {
				super.paintComponent(g);
				Image image = null;
				try {
					image=ImageIO.read(new File("resource/icon.jpg"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				g.drawImage(image, 0, 0,null);
			};
		};
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(label)
						.addComponent(lblapacheCommonsIo)
						.addComponent(lblNewLabel_1)
						.addComponent(lbllockoct)
						.addComponent(lblqqcom))
					.addGap(22))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(103)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
					.addGap(105))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(label)
					.addGap(18)
					.addComponent(lblapacheCommonsIo)
					.addGap(6)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(lbllockoct)
					.addGap(18)
					.addComponent(lblqqcom)
					.addGap(43)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(7))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(172))
		);
		contentPane.setLayout(gl_contentPane);

	}
	private void close(){
		this.dispose();
	}
}
