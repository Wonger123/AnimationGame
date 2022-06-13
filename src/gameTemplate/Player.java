package gameTemplate;

//import java.awt.Rectangle;

class Player extends Enemy {

	int health = 100;
	
	Player(){
		this(AnimationGame.panW/2 , AnimationGame.panH-200 , 100, 60);
	}
	
	Player(int x, int y, int w, int h) {
		super(x, y, w, h);
		//change speed here: 
	}
}