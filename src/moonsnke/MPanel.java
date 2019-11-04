package moonsnke;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MPanel extends JPanel implements KeyListener, ActionListener {
	// ����ͼƬ
	ImageIcon title = new ImageIcon("title.jpg");
	ImageIcon body = new ImageIcon("body.png");
	ImageIcon up = new ImageIcon("up.png");
	ImageIcon down = new ImageIcon("down.png");
	ImageIcon right = new ImageIcon("right.png");
	ImageIcon left = new ImageIcon("left.png");
	ImageIcon food = new ImageIcon("food.png");

	int len = 3;

	int[] snakex = new int[750];
	int[] snakey = new int[750];
	String fx = "R"; // ��ͷ���� L R U D
	boolean isStarted = false; // ��¼��Ϸ״̬

	// ����һ������
	Timer timer = new Timer(100, this);

	// ���캯��
	public MPanel() {
		// ��ʼ������
		initSnake();
		// �ɲ����Ի�ȡ�����¼�
		this.setFocusable(true);
		// ���������¼�
		this.addKeyListener(this);
		// ��������
		timer.start();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // ���ø���
		this.setBackground(Color.white);
		title.paintIcon(this, g, 25, 11);
		g.fillRect(25, 75, 850, 600);
		if (fx.equals("L")) {
			left.paintIcon(this, g, snakex[0], snakey[0]);
		} else if (fx.equals("R")) {
			right.paintIcon(this, g, snakex[0], snakey[0]);
		} else if (fx.equals("U")) {
			up.paintIcon(this, g, snakex[0], snakey[0]);
		} else if (fx.equals("D")) {
			down.paintIcon(this, g, snakex[0], snakey[0]);
		}

		for (int i = 1; i < len; i++) {
			body.paintIcon(this, g, snakex[i], snakey[i]);
		}

		if (!isStarted) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Press Space To Start", 300, 300);
		}
	}

	public void initSnake() {
		len = 3;
		snakex[0] = 100;
		snakey[0] = 100;
		snakex[1] = 50;
		snakey[1] = 100;
		snakex[2] = 75;
		snakey[2] = 100;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	// ���û��˼�
	// VK_SPACE �ո��
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_SPACE) {
			// ������Ϸ
			isStarted = !isStarted;
			repaint();
		}
		if (isStarted) {
			if (keyCode == KeyEvent.VK_RIGHT) {
				if (!fx.equals("L")) {
					fx = "R";
				}
			} else if (keyCode == KeyEvent.VK_LEFT) {
				if (!fx.equals("R")) {
					fx = "L";
				}
			} else if (keyCode == KeyEvent.VK_UP) {
				if (!fx.equals("D")) {
					fx = "U";
				}
			} else if (keyCode == KeyEvent.VK_DOWN) {
				if (!fx.equals("U")) {
					fx = "D";
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	// ʱ�䵽�˾�ִ�еĺ���
	@Override
	public void actionPerformed(ActionEvent e) {
		if (isStarted) {
			for (int i = len - 1; i > 0; i--) {
				snakex[i] = snakex[i - 1];
				snakey[i] = snakey[i - 1];
			}
			if (fx.equals("R")) {
				snakex[0] += 25;
				if (snakex[0] >= 850)
					snakex[0] = 25;
			} else if (fx.equals("L")) {
				snakex[0] -= 25;
				if (snakex[0] <= 25)
					snakex[0] = 850;
			} else if (fx.equals("U")) {
				snakey[0] -= 25;
				if (snakey[0] <= 75)
					snakey[0] = 650;
			} else if (fx.equals("D")) {
				snakey[0] += 25;
				if (snakey[0] >= 650)
					snakey[0] = 75;
			}
			repaint();
		}
		timer.start();
	}
}
