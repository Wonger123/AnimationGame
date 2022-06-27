package geometryDash;

import java.awt.image.BufferedImage;

public class Spike extends Block {

	BufferedImage sprite = MainGame.loadImage("images/spike.png");

	Spike(int a, int b) {
		super(a, b);
	}

	void move() {
		super.move();
	}
}