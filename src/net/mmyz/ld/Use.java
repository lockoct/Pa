package net.mmyz.ld;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ComponentOrientation;

@SuppressWarnings("serial")
public class Use extends JDialog {
	private JPanel contentPane;
	
	
	public Use(){
		setResizable(false);
		setTitle("\u4F7F\u7528\u8BF4\u660E");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0, 487, 307);
		setLocationRelativeTo(contentPane);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane.setBounds(5, 5, 461, 241);
		
		
		JButton btnNewButton = new JButton("\u786E \u5B9A");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
		btnNewButton.setBounds(190, 252, 72, 23);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setText("\u9996\u5148\u58F0\u660E:\r\n\u8BF7\u8C28\u614E\u4F7F\u7528\u672C\u5DE5\u5177,\u5982\u4F7F\u7528\u672C\u5DE5\u5177\u9020\u6210\u4E25\u91CD\u540E\u679C,\u8D23\u4EFB\u81EA\u8D1F.\r\n\u8BF7\u4E0D\u8981\u5728\u4F7F\u7528\u672C\u5DE5\u5177\u524D\u5411\u5468\u56F4\u4EBA\u70AB\u8000= =.\r\n\u672C\u5DE5\u5177\u68C0\u6D4B\u51FA\u5E26\u6709\u75C5\u6BD2\u7684dll\u6587\u4EF6\u65F6\u65E0\u6CD5\u6252\u53D6.\r\n\r\n\u4F7F\u7528\u65B9\u6CD5:\r\n1.\u5B8C\u6574\u8DEF\u5F84\u6252\u53D6,\u5982\u679C\u4F60\u8BB0\u5F97\u4F5C\u54C1\u6240\u5728\u4F4D\u7F6E,\u53EF\u4EE5\u76F4\u63A5\u8F93\u5165\u8DEF\u5F84\u5F00\u59CB\u6252\u53D6,\u9009\u62E9\u8FD9\u9879\u529F\u80FD\u65F6,\u6252\u53D6\u76D8\u7B26\u4E2D\u7684\u9009\u9879\u5176\u5B9E\u662F\u6CA1\u7528\u7684.\r\n\r\n2.\u5173\u952E\u5B57\u641C\u7D22\u6252\u53D6,\u5982\u679C\u4F60\u4E0D\u8BB0\u5F97\u5177\u4F53\u8DEF\u5F84,\u800C\u53EA\u662F\u8BB0\u5F97\u6587\u4EF6\u5939\u7684\u5173\u952E\u5B57,\u53EF\u4EE5\u9009\u62E9\u8FD9\u9879\u529F\u80FD,\u5C06\u4F60\u6240\u8BB0\u5F97\u7684\u5173\u952E\u5B57\u6DFB\u52A0\u5230\u641C\u7D22\u5217\u8868\u4E2D,\u540C\u65F6\u5FC5\u987B\u9009\u62E9\u597D\u6252\u53D6\u7684\u76D8\u7B26,\u7A0B\u5E8F\u5C06\u81EA\u52A8\u641C\u7D22\u9009\u62E9\u7684\u76D8\u7B26\u6839\u76EE\u5F55\u4E0B\u7684\u6587\u4EF6\u5939,\u5982\u679C\u6240\u6709\u5173\u952E\u5B57\u90FD\u53EF\u4EE5\u88AB\u68C0\u6D4B\u5230,\u7A0B\u5E8F\u5C06\u5F80\u4E0B\u5224\u65AD\u8BE5\u6587\u4EF6\u5939\u4E2D\u662F\u5426\u8FD8\u5305\u542B\u201C\u4F18\u79C0\u4F5C\u54C1\u201D\u7684\u6587\u4EF6 \u5939,\u5982\u679C\u6709,\u5C06\u5F00\u59CB\u6252\u53D6\u91CC\u9762\u6240\u6709\u7684\u6587\u4EF6\u6216\u6587\u4EF6\u5939,\u5982\u679C\u6CA1\u6709\u5C06\u91CD\u65B0\u5F00\u59CB\u5224\u65AD.\r\n\r\nTips:\r\n1.\u5728\u4E0A\u8BFE\u524D\u5C31\u53EF\u4EE5\u8BBE\u5B9A\u597D\u53C2\u6570,\u542F\u52A8\u672C\u5DE5\u5177,\u7A0B\u5E8F\u5C06\u5728\u540E\u53F0\u8FD0\u884C,\u7B49\u5F85\u76EE\u6807U\u76D8\u51FA\u73B0\u624D\u5F00\u59CB\u6252\u53D6.\r\n2.\u5728\u5173\u952E\u5B57\u641C\u7D22\u4E2D,\u6709\u591A\u4E2A\u542B\u6709\u5168\u90E8\u5173\u952E\u5B57\u7684\u6587\u4EF6\u5939,\u7A0B\u5E8F\u5C06\u628A\u5B83\u4EEC\u5168\u90E8\u6252\u4E0B\u6765.\r\n\r\nBug\u4EE5\u53CA\u5EFA\u8BAE\u53CD\u9988:\r\n\u8BF7\u5C06\u4F60\u7684\u5EFA\u8BAE\u6216\u7A0B\u5E8F\u6240\u51FA\u73B0\u7684\u95EE\u9898\u53CD\u9988\u5230\u90AE\u7BB1\u4E2D.\r\n\r\n\u4F5C\u8005:\r\n\u5373\u5C06\u53D8\u6210\u9AD8\u4E09\u72D7,bug\u548C\u5EFA\u8BAE\u53CD\u9988\u7ED9\u6211,\u6211\u4E5F\u6CA1\u65F6\u95F4\u7EF4\u62A4\u4E86,\u56E0\u6B64\u5C06\u6E90\u7801\u653E\u51FA\u6765,\u6709\u80FD\u529B\u7684\u540C\u5B66\u53EF\u4EE5\u7EE7\u7EED\u4E3A\u8FD9\u4E2A\u5DE5\u5177\u62D3\u5C55\u529F\u80FD\u2026\u2026");
		scrollPane.setViewportView(textArea);
		
		JScrollBar jsb = scrollPane.getVerticalScrollBar();
		jsb.setValue(jsb.getMinimum());
		
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		contentPane.add(scrollPane);
	}
	private void close(){
		this.dispose();
	}
}
