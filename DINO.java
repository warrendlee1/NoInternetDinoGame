import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class DINO extends GAMEOBJECT {
	BufferedImage dino;
	double dx, dy;
	boolean jumping = false;
	boolean onoroff = false;
	SPRITE s;
	public DINO(int x, int y, int width, int height) {

		dino = this.addImage("dino (1).png");
		s = new SPRITE(dino, 2, 1, 3);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void JUMP() {
		if (MAIN.Keys[KeyEvent.VK_SPACE] && !jumping) {
			this.jumping = true;
			this.dy = -11;
		}
	}

	public void moveAndDraw(Graphics2D win) {
		//super.moveAndDraw(win);
		win.drawImage(s.getCurrentFrame(), null, this.x-40,this.y-40);
		this.JUMP();

		if (this.intersects(MAIN.floor)) {
			this.y = MAIN.floor.y - 46;
			this.jumping = false;
		} else {
			this.dy += GLOBAL.GRAVITY;
		}
		this.y += dy;
	}
}