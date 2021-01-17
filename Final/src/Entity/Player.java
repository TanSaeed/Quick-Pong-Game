package Entity;

import java.awt.Color;
import java.awt.Graphics;

import Main.GamePanel;

public abstract class Player {
	private int x;
	private int y;
	private int dy;
	private int width;
	private int height;
	private int score;
	
	GamePanel gp;
	
	public Player(GamePanel gp) {
		this.gp = gp;
		
		this.y = 200;
		this.dy = 20;
		this.width = 10;
		this.height = 60;
		this.score = 0;
	}
	
	public void moveUp() {
		if (y > 0) 
			y -=dy;
	}
	public void moveDown() {
		if (y < (gp.WINDOW_HEIGHT - height))
			y += dy;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}
	
///////////////////////////////////////////////////////
		public int getX() {
		return x;
		}
		
		public void setX(int x) {
		this.x = x;
		}
		
		public int getY() {
		return y;
		}
		
		public void setY(int y) {
		this.y = y;
		}
		
		public int getWidth() {
		return width;
		}
		
		public void setWidth(int width) {
		this.width = width;
		}
		
		public int getHeight() {
		return height;
		}
		
		public void setHeight(int height) {
		this.height = height;
		}
		
		public int getScore() {
		return score;
		}
		
		public void addPoint() {
		this.score++;
		
		}
			}
