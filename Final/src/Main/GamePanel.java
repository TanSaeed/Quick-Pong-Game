package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Entity.Ball;
import Entity.Player1;
import Entity.Player2;
import Entity.Score;


@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {
	public static final int WINDOW_WIDTH = 400;
	public static final int WINDOW_HEIGHT = 400;
	
	private long startTime = 0;
	private long startTimeDiff = 0;
	private int delay = 2000;
	
	// Thread Variables
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	@SuppressWarnings("unused")
	private double averageFPS;

	// Double Buffering Variables
	private BufferedImage image;
	private Graphics2D g;

	//Game obj
	Ball b;
	Player1 p1;
	Player2 p2;
	Score s;
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setFocusable(true);
		p1 = new Player1(this);
		p2 = new Player2(this);
		b = new Ball(this,p1,p2);
		s = new Score(this, b, p1, p2);
	}// End of constructor method
	
	
	public void addNotify() {
			super.addNotify();
			if (thread == null) {
				thread = new Thread(this);
				thread.start();
			}
			addKeyListener(this);
		} // end of addNotify
	
	
	public void run() {
		running = true;
		image = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		

		long startTime;
		long URDTimeMillis;
		long waitTime;
		long totalTime = 0;
		int frameCount = 0;
		int maxFrameCount = 60;
		long targetTime = 1000 / FPS;
		
		while (running) {
			startTime = System.nanoTime();
			
			gameUpdate();
			gameRender();
			gameDraw();
			
			// slow down speed
			URDTimeMillis = (System.nanoTime() - startTime) / 1000000;
			waitTime = targetTime - URDTimeMillis;
			if (waitTime < 0) {
				waitTime = 5;
			}
			try {
				Thread.sleep(waitTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
			totalTime += System.nanoTime() - startTime;
			frameCount++;
			if (frameCount == maxFrameCount) {
				averageFPS = 1000.0 / ((totalTime / frameCount) / 1000000);
				totalTime = 0;
			}
		}//end of while
	}
	
	
	private void gameUpdate() {
		b.update();
		s.update();
	}// End of gameUpdate method

	
	private void gameRender() {
		//background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		b.draw(g);
		p1.draw(g);
		p2.draw(g);
		s.draw(g);
	}// End of gameRender method

	
	private void gameDraw() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}
	
	public void keyTyped(KeyEvent key) {
	}
	
	public void keyPressed(KeyEvent e) {
		int KeyCode = e.getKeyCode();
		//int p1 = Player1.getY();
		//int p2 = Player2.getY();
		
		//player 1 
		if(KeyCode == KeyEvent.VK_W) {
			p1.moveUp();
		}
		if(KeyCode == KeyEvent.VK_S) {
			p1.moveDown();
		}
				
		//player 2 
		if(KeyCode == KeyEvent.VK_UP) {
			p2.moveUp();
		}
		if(KeyCode == KeyEvent.VK_DOWN) {
			p2.moveDown();
		}
	}
	
	public void keyReleased(KeyEvent key) {
	}

	
} // end of class




