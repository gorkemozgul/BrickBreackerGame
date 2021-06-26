
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public  class Game extends JPanel implements KeyListener,ActionListener{
	private boolean isPlaying =false;
	public int score=0;
	public static int level=1;
	public int lives=3;
	public List<Integer> scores;
	Sound soundEffect=new Sound();
	
	private LevelMaker bricks;
	
	
	 Image backgroundImage;
	 ImageIcon myBackgroundIcon;
	
	
	
	private int brickCount =24;//ALL Bricks in specific LEVEL
	private Timer timer;
	
	private int xRange=310;
	private int Radius = 21;//Ball Radius
	
	private int ballX=350;//BALL Positions
	private int ballY=350;//
	
	private double dx=-3.1;
	private double dy=-2.6;
	private int Width=550;
	
	public Game(int level) {
	
		scores = new ArrayList<Integer>(10);
		myBackgroundIcon=new ImageIcon(getClass().getResource("background.jpg"));
		backgroundImage =myBackgroundIcon.getImage(); 
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		bricks = new LevelMaker(3,8,level);
		timer = new Timer(5,this);
		timer.start();
		
	}
	public void paint(Graphics g) {
		//DRAW BACKGROUND
		  g.drawImage(backgroundImage, 0, 0, null);
		
		//DRAW MAP
		bricks.draw((Graphics2D)g);
		
		
		//DRAW SCORE,LEVEL,LIVES
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD,25));
		g.drawString("Score: "+score,10,30);
		g.drawString("Lives :"+lives,570,30);
		g.drawString("Level :"+level,280,30);
		
		//BALL
		g.setColor(Color.white);
		g.fillOval(ballX, ballY, Radius, Radius);
		
		//PADDLE
		g.setColor(Color.CYAN);
		g.fillRect(xRange, Width, 100, 8);
		

		
		if(brickCount<=0) {
			isPlaying=false;
			dx=0;
			dy=0;
			if(score==120) {
				timer.stop();
				soundEffect.playSound("soundEffects/succes.wav");

				g.setColor(Color.white);
				g.setFont(new Font("TimesRoman",Font.BOLD,30));
				g.drawString("Congratulations!",260,300);
					
				g.setFont(new Font("TimesRoman",Font.BOLD,30));
				g.drawString("Press Enter for level 2",260,360);
				level=2;
				
				
			}
			if(score==280) {
				soundEffect.playSound("soundEffects/succes.wav");
				timer.stop();
				g.setColor(Color.white);
				g.setFont(new Font("TimesRoman",Font.BOLD,30));
				g.drawString("Congratulations!",260,300);
				
				g.setFont(new Font("TimesRoman",Font.BOLD,30));
				g.drawString("Press Enter for level 3",260,360);
				level=3;
				
			}
			if(score==520) {
				soundEffect.playSound("soundEffects/succes.wav");
				timer.stop();
				scores.add(score);
				g.setColor(Color.white);
				g.setFont(new Font("TimesRoman",Font.BOLD,30));
				g.drawString("YOU WON!",260,300);
				g.drawString("Score: "+ score,260,330);
				
				g.setFont(new Font("TimesRoman",Font.BOLD,30));
				g.drawString("Press Enter for restart game",260,360);
				level=1;
				
			}
		
			
		}
		
		
		if(ballY>550) {
			dy=-dy;
			if(lives>0) {
				soundEffect.playSound("soundEffects/loseHealth.wav");
				lives--;
			}
		}
		
		if(lives==0) {
			isPlaying=false;
			scores.add(score);
			dx=0;
			dy=0;
			g.setColor(Color.white);
			g.setFont(new Font("TimesRoman",Font.BOLD,30));
			g.drawString("GAME OVER",250,300);
			g.drawString("Score:"+score,250,350);
		
			
			g.setFont(new Font("TimesRoman",Font.BOLD,30));
			g.drawString("Press Enter to restart",250,400);
			level=1;	
		}
		
		g.dispose();
		
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_D) {
			if(xRange>=550) 
			{
				xRange=600;
			}
			else 
			{
				isPlaying=true;
				xRange+=25;
				
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_A) {
			if(xRange<10) 
			{
				xRange=10;
			}
			else 
			{
				isPlaying=true;
				xRange-=25;
				
			}
			
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(!isPlaying) {
				isPlaying=true;
				ballX=350; 
				ballY=350;
				if(level==1) {
					if(lives==0)
						timer.stop();
					timer.start();
					score=0;
					lives=3;
					dx=-3.05;
					 dy=-3.2;
					xRange=310;
					brickCount=24;
					bricks =new LevelMaker(3,8,1);
					repaint();
				}
				
				if(level==2) {
					timer.start();
					dx=-3.05;
					dy=-3.2;
					xRange=310;
					brickCount=32;
					bricks =new LevelMaker(3,8,2);
					repaint();
					
				}
				if(level==3) {
					timer.start();
					dx=-3.05;
					dy=-3.2;
					xRange=310;
					brickCount=48;
					bricks =new LevelMaker(3,8,3);
					repaint();
					
				}
				
				
			}
			
		}
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(isPlaying) {
			
			Rectangle ball_collision = new Rectangle(ballX,ballY,Radius,Radius);//collider for ball
			Rectangle paddle_collision= new Rectangle(xRange,Width,120,8);//collider for paddle
			
			
			if(ball_collision.intersects(paddle_collision)) {//collision for ball and paddle
				dy = -dy;
			}
			 for(int i =0; i<bricks.layout.length;i++) {
				 
				for(int j=0;j<bricks.layout[0].length;j++) {
					
					if(bricks.layout[i][j]>0){//if brick still there
						
						int brickX=j*bricks.brickRange+70;
						int brickY=i*bricks.brickHeight+50;
						
						int brickWidth=bricks.brickRange;
						int brickHeight=bricks.brickHeight;
						
						Rectangle rect = new Rectangle(brickX,brickY,brickWidth,brickHeight);
						Rectangle brick_collision = rect;
						
						if(ball_collision.intersects(brick_collision)) {//collision for ball and brick
							soundEffect.playSound("soundEffects/bing.wav");
							score+=5;
							brickCount--;
							bricks.setHitpoint(bricks.layout[i][j], i, j);
							bricks.layout[i][j]--;
							
							
							
							if(ballX+15<=ball_collision.x||ballX+1>=brick_collision.x+brick_collision.width){
								dx = -dx;
							}
							else {
								dy=-dy;
							}
							break ;
							
						}
					}
				}
				
			}
			
			ballX+=dx;
			ballY+=dy;
			
			if(ballX<0) {
				dx = -dx;
			}
			if(ballY<0) {
				dy = -dy;
			}
			if(ballX>680) {
				dx = -dx;
			}
		}
		
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	

	@Override
	public void keyReleased(KeyEvent e) {}

	public List<Integer> getScoresList() {
	       return scores;
	   }
	public void setLevel(int level_c) {
		level=level_c;
		
	}
	public void stopTimer() {
	    timer.stop();
	}
	public void setScore(int value) {
		score=value;
		
	}
	public void setBricks(int totalbrick) {
		brickCount=totalbrick;
	}
	
	

}
