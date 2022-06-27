package geometryDash;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import java.awt.*;

public class Player extends Rectangle {

	int x = 300;
	int y = 410;
	int width = 40;
	int height = 40;
	int jumpSpeed = 0;
	int gravity = 10;
	boolean isJumping = false;
	
	Timer jumpTimer = new Timer(25, new JumpTimer());

	BufferedImage playerSprite = MainGame.loadImage("images/player.png");
	BufferedImage shipSprite = MainGame.loadImage("images/ship.png");

	void jump() {
		isJumping = true;
	}

	void movePlayer() {
		if (isJumping) {			
//			System.out.println("Jump!");
			jumpTimer.start();
		}
	}
	
	class JumpTimer implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
//			y -= jumpStrength;
//			jumpStrength -= gravity;
//			System.out.println(jumpStrength);
			
//			if (y >= 410) {
//				y = 410;
//				jumpTimer.stop();
//			}
		}
	}
}