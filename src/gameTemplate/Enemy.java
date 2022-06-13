package gameTemplate;

import java.awt.Rectangle;

class Enemy extends Rectangle {
	static final int MAXENEMIES = 50;
	int speed = 3;
	int dmg = 15; //damage

	//This is needed for the player class????
	Enemy(int x, int y, int w, int h) {		
		this.x = x; 
		this.y = y;
		width = w;
		height = h;
	}

	 // They start above the top of screen (-50 to -150)
	Enemy() {
		this.x = (int) (Math.random()*(AnimationGame.panW-15)) + 30; 
		this.y = (int) (Math.random()*200) - 250;
		width = height = 15;
		speed =  (int) (Math.random()*4)+1;
	}
}