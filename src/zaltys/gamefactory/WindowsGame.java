package zaltys.gamefactory;

import zaltys.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class WindowsGame extends JFrame implements Game {
	private static final long serialVersionUID = 1L;

	private GameMap map = new GameMap();
	private Snake snake = new Snake(Direction.RIGHT,
										new Coord(10,10),
										new Coord(9,10),
										new Coord(8,10),
										new Coord(7,10),
										new Coord(6,10));
	
	GameRules gameRules = new GameRules(snake, map);
	
	SwingGameRenderer swingRenderer;
	
	public WindowsGame() throws IOException{
		super.setPreferredSize(new Dimension(800,800));
		super.pack();
		super.setVisible(true);
		
		super.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		super.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e){
				onUserInput(KeyEvent.getKeyText(e.getKeyCode()));
			}
		});
		
		swingRenderer = new SwingGameRenderer(map, snake);
		
		Timer timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onTimer();
			}
		});
		timer.setRepeats(true);
		timer.start();
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		
		swingRenderer.render(g);
	}
	
	public void onUserInput(String keyText) {
		gameRules.decideDirection(keyText.toLowerCase().charAt(0));
	}
	
	public void onTimer(){
		gameRules.onTimer();
		
		repaint();
	}

	@Override
	public void run() throws Exception {
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				try {
					new WindowsGame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
