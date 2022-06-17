package geometryDash;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends Rectangle {
	
	int x = 300;
	int y = 410;
	int width = 40;
	int height = 40;
	double vy = 0.0;
	boolean isJumping = false;
	
	BufferedImage sprite = MainGame.loadImage("images/player.png");
	
	void jump() {
		isJumping = true;
	}
	
	void movePlayer() {
		if (isJumping) {
			System.out.println("Jump");
			isJumping = false;
		}
	}
}