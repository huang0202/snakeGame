package moonsnke;

import javax.swing.JFrame;

public class Msnake {

	public static void main(String[] args) {
		//创建一个窗口
		JFrame frame = new JFrame();
		frame.setBounds(10, 10, 900, 700);
		//是否让用户可以拖动
		frame.setResizable(false);  
		//点击关闭
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//在窗口上显示一层布
		frame.add(new MPanel());
		 
		//让窗口显示
		frame.setVisible(true);

	}

}
