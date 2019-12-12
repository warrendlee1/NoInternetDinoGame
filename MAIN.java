import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class MAIN extends GameDriverV4 {
	DINO dino;
	CACTUS cactus;
	CACTUSGROUP cactusgroup;
	WORLD world;
	SPLASHPAGE splashpage;
	Rectangle moveBlock1, moveBlock2;
	public static Rectangle floor = new Rectangle(150, GLOBAL.HEIGHT / 3, GLOBAL.WIDTH - 300, 1);
	boolean wentThrough = false;
	SOUND sound = new SOUND();
	
	
	public MAIN() {
		dino 		= new DINO(200, 200, 20, 35);
		world 		= new WORLD();
		cactus 		= new CACTUS(900, 170, 25, 35, -7);
		cactusgroup = new CACTUSGROUP(1200, 170, 60, 25, -7);
		splashpage 	= new SPLASHPAGE();
		moveBlock1 	= new Rectangle(0, 0, 150, 210);
		moveBlock2  = new Rectangle(300,0,600,210);
	}
	
	public void moveTo(int x, int dx, Rectangle r) {
		r.translate(dx, 0);
		if(r.getX() >= x) {
			r.setLocation(x, 0);
		}
	} 
	 
	public void resetGame() {
		cactus.setLocation(900, 170);
		cactusgroup.setLocation(1200, 170);
		cactus.dx = -7;
		cactusgroup.dx = -7;
		splashpage.points = 0;
	}
	

	public void draw(Graphics2D win) {	
		
		if(splashpage.gamestate == 0) {
			
			this.resetGame();
			
			splashpage.backdrop(win);
			win.setColor(Color.BLACK);
			win.fill(floor);
			win.setColor(Color.WHITE);
			win.fill(moveBlock1);
			win.fill(moveBlock2);
			if(Keys[KeyEvent.VK_SPACE]) {
				this.moveTo(700, 10, moveBlock2);
				if(moveBlock2.getX() >= 700) {
					splashpage.gamestate = 1;
				}
			}			
		}
		
		if(splashpage.gamestate == 1) {
			
			//splashpage.backdrop(win);
			world.moveAndDraw(win);
			dino.moveAndDraw(win);
			cactus.moveAndDraw(win);
			cactusgroup.moveAndDraw(win);
			
			win.setColor(Color.BLACK);
			win.fill(floor);
			win.setColor(Color.WHITE);
			win.fill(moveBlock1);
			win.fill(moveBlock2);
			splashpage.backdrop(win);
			if(cactus.reset == true) {
				splashpage.points+= 100;
				sound.PLAY(1);
				if(splashpage.points > 0 && splashpage.points%1000 == 0) {
					cactus.dx -= 1;
					cactusgroup.dx -= 1;
				}
			}
			if(cactusgroup.reset == true) {
				splashpage.points+= 100;
				sound.PLAY(1);
				if(splashpage.points > 0 && splashpage.points%1000 == 0) {
					cactus.dx -= 1;
					cactusgroup.dx -= 1;
				}
			}
			
			if(dino.intersects(cactus)) {
				splashpage.gamestate = 3;
				sound.PLAY(0);
			}
			if(dino.intersects(cactusgroup)) {
				splashpage.gamestate = 3;
				sound.PLAY(0);
			}
		}

		
		if(splashpage.gamestate == 3) {
			splashpage.backdrop(win);
			win.setColor(Color.BLACK);
			win.fill(floor);
			win.setColor(Color.WHITE);
			win.fill(moveBlock1);
			//moveBlock2.setLocation(300,0);
			//win.fill(moveBlock2);
			splashpage.backdrop(win);
			splashpage.gameover(win);
			if(Keys[KeyEvent.VK_ENTER]) {
				if(splashpage.points>= splashpage.highscore) {
					splashpage.highscore = splashpage.points;
				}
				splashpage.gamestate = 0;
			}	
		}
		
	}

	public static void main(String[] args) {
		MAIN main = new MAIN();
		main.start();
	}
}
