package geometryDash;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainGame {

	public static void main(String[] args) {
		new MainGame().run();
	}

	static final int PANW = 1000;
	static final int PANH = 600;

	JFrame frame;
	static JPanel drPanel;
	JPanel txtPanel;
	JLabel scoreLabel, highScoreLabel;
	JButton startBtn;

	BufferedImage floor, background;

	Player player;
	Block block;
	Spike spike;

	int scoreCounter = 0;
	int highScore = 0;
	int jumpCounter = 0;

	boolean shipMode = false;

	Timer mainTimer;
	
	MainGame() {
		createAndShowGUI();
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

		// objects
		player = new Player();
		block = new Block(0, 410);
		spike = new Spike(40, 370);
		
		frame.add(txtPanel, BorderLayout.NORTH);
		frame.add(drPanel, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(PANW, PANH);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		mainTimer = new Timer(10, new MainTimer());
	}

	void run() {
		mainTimer.start();
		player.movePlayer();
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

	private class DrawingPanel extends JPanel implements MouseListener, KeyListener {

		DrawingPanel() {
			this.addKeyListener(this);
			this.addMouseListener(this);
			this.setFocusable(true);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			// background
			g.drawImage(background, 0, 0, getWidth(), getHeight(), null);

			// floor
			g.drawImage(floor, 0, 450, getWidth(), 500, null);

			// player
			if (!shipMode) {
				g.drawImage(player.playerSprite, player.x, player.y, player.width, player.height, null);
			} else {
				g.drawImage(player.shipSprite, player.x, player.y, player.width + 5, player.height, null);
			}

			// block
			g.drawImage(block.sprite, block.x, block.y, block.width, block.height, null);

			// spike
			g.drawImage(spike.sprite, spike.x, spike.y, spike.width, spike.height, null);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (!shipMode) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					player.jump();
					jumpCounter = 40;
				}
			} else {
				// ship mode
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (!shipMode) {
				if (e.getKeyCode() == 32) {
					player.jump();
					jumpCounter = 40;
				}
			} else {
				// ship mode
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}

	class MainTimer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			player.movePlayer();

			block.move();
			spike.move();
			collision();
			drPanel.repaint();
		}
	}

	void collision() {

	}
}