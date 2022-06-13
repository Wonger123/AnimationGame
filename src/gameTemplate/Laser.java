package gameTemplate;

import java.awt.Color;
import java.awt.Rectangle;

class Laser extends Rectangle {
	
	static int speed = -3;
	static Color c = Color.BLACK;
	static final int MAXSHOTS = 7;  //how many on screen
	static final int SHOTDELAY = 100;  //ms
	
	Laser(Player p) {
		x = p.x+p.width/2;
		y = p.y - 10;
		width = 2;
		height = 10;
	}
}