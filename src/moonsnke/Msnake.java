package moonsnke;

import javax.swing.JFrame;

public class Msnake {

	public static void main(String[] args) {
		//����һ������
		JFrame frame = new JFrame();
		frame.setBounds(10, 10, 900, 700);
		//�Ƿ����û������϶�
		frame.setResizable(false);  
		//����ر�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�ڴ�������ʾһ�㲼
		frame.add(new MPanel());
		 
		//�ô�����ʾ
		frame.setVisible(true);

	}

}
