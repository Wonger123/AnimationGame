package geometryDash;

import java.awt.image.BufferedImage;

public class Block {
	
	int x;
	int y;
	int width = 40;
	int height = 40;
	int vx = 5;
	
	BufferedImage sprite = MainGame.loadImage("images/block.jpg");
	
	Block(int a, int b){
		x = a;
		y = b;
	}
	
	void move() {
		x -= vx;
		if (x + width == 0)
			x = MainGame.PANW;
		collision();
	}
	
	void collision() {
		
	}
}