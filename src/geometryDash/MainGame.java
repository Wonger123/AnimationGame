package geometryDash;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainGame {

	public static void main(String[] args) {
		new MainGame();
	}

	JFrame frame;
	JPanel drPanel, txtPanel;
	JLabel scoreLabel, highScoreLabel;

	BufferedImage floor, background;

	Player player;
	Block block;
	Spike spike;

	int scoreCounter = 0;
	int highScore = 0;

	Timer timer;

	MainGame() {
		init();
		createAndShowGUI();
	}

	void init() {

	}

	void createAndShowGUI() {
		frame = new JFrame("Geometry Dash");
		frame.setLayout(new BorderLayout(2, 1));
		frame.getContentPane().setBackground(Color.BLACK);

		txtPanel = new JPanel();
		txtPanel.setBackground(Color.LIGHT_GRAY);
		txtPanel.setLayout(new GridLayout(1, 2, 10, 10));

		// score counter
		scoreLabel = new JLabel();
		scoreLabel.setText("Score: " + scoreCounter);
		scoreLabel.setFont(new Font("Pusab", Font.BOLD, 15));
		scoreLabel.setHorizontalAlignment(JLabel.CENTER);
		txtPanel.add(scoreLabel);

		// high score label
		highScoreLabel = new JLabel();
		highScoreLabel.setText("High Score: " + highScore);
		highScoreLabel.setFont(new Font("Pusab", Font.BOLD, 15));
		highScoreLabel.setHorizontalAlignment(JLabel.CENTER);
		txtPanel.add(highScoreLabel);

		drPanel = new DrawingPanel();

		floor = loadImage("images/floor.jpg");
		background = loadImage("images/background.jpg");

		player = new Player();
		block = new Block(500, 410);
		spike = new Spike(460, 410);

		frame.add(txtPanel, BorderLayout.NORTH);
		frame.add(drPanel, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		timer = new Timer(100, new mainTimer());
		timer.start();
	}

	void run() {

	}

	static BufferedImage loadImage(String filename) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null, "An image failed to load: " + filename, "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		// DEBUG
		// if (img == null) System.out.println("null");
		// else System.out.printf("w=%d, h=%d%n", img.getWidth(), img.getHeight());

		return img;
	}

	private class DrawingPanel extends JPanel implements MouseListener {

		DrawingPanel() {
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			// background
			g.drawImage(background, 0, 0, getWidth(), getHeight(), null);

			// floor
			g.drawImage(floor, 0, 450, getWidth(), 500, null);

			// block
			g.drawImage(block.sprite, block.x, block.y, block.width, block.height, null);

			// spike
			g.drawImage(spike.sprite, spike.x, spike.y, spike.width, spike.height, null);
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	class mainTimer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}
}