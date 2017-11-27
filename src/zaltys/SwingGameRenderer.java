package zaltys;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SwingGameRenderer {

	
	
	private GameMap map;
	private Snake snake;

	
	private static final int X_OFFSET  = 50;
	private static final int Y_OFFSET  = 50;
	private BufferedImage wallImg;
	
	public SwingGameRenderer(GameMap map, Snake snake) throws IOException {
		this.map = map;
		this.snake = snake;
		
		wallImg = ImageIO.read(new File("C:\\Work\\prj\\vgtu-2017\\wall.png"));
	}

	public void render(Graphics g){
		for (int y=0; y<map.getHeight(); y++){
			for (int x =0 ;x<map.getWidth(); x++){
				if (snake.isMe(x, y)){
					g.fillOval(X_OFFSET+x*10, Y_OFFSET+y*10, 10, 10);
				}else
				if (map.isWall(x, y)){
					drawWallElement(g, y, x);
				}else
				if (map.isApple(x, y)){
					drawApple(g, y, x);
				}else{
					;
				}
			}
			System.out.println();
		}
	}

	private void drawApple(Graphics g, int y, int x) {
		g.fillOval(X_OFFSET+x*10, Y_OFFSET+y*10, 3, 3);
	}

	private void drawWallElement(Graphics g, int y, int x) {
		//g.fillRect(X_OFFSET+x*10, Y_OFFSET+y*10, 10, 10);
		g.drawImage(wallImg, X_OFFSET+x*10, Y_OFFSET+y*10, 10, 10, null);
	}
}
