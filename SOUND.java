import java.awt.Graphics2D;

public class SOUND extends GameDriverV4{
	SoundDriver sounds;

	public SOUND() {
		String[] filenames = new String[2];
		filenames[0] = "hit.wav";
		filenames[1] = "jump.wav";
		sounds = new SoundDriver(filenames);
	}

	public static void main(String[] args) {
		SOUND game = new SOUND();
		game.start();
		game.setFocusable(true);
	}

	public void PLAY(int x) {
		sounds.play(x);
	}

	public void LOOP(int x) {
		sounds.loop(x);
	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		
	}
}
