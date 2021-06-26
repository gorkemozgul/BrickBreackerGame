
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collections;
import java.util.List;

import javax.swing.*;




public class userInterface extends JFrame implements ActionListener {
	

	JPanel panel = new backgroundImage();
	
	
	JButton newgameButton;
	JButton optionsButton; 
	JButton scoreButton; 
	JButton helpButton ;
	JButton aboutButton;
	JButton exitButton;
	
	
	public userInterface() {
		super("ARKANOID GAME");
		super.setDefaultCloseOperation(super.EXIT_ON_CLOSE);
		super.setVisible(true);
		panel.setLayout(null);
		add(panel);
		
		 newgameButton = new JButton("New Game");
		 optionsButton = new JButton("Options");
		 scoreButton = new JButton("Score");
		 helpButton = new JButton("Help");
		 aboutButton = new JButton("About");
		 exitButton = new JButton("Exit");
		
		newgameButton.setBounds(230,  40, 173, 84);
		optionsButton.setBounds(230, 200, 173, 84);
		scoreButton.setBounds(230, 360, 173, 84);
		helpButton.setBounds(230, 520, 173, 84);
		aboutButton.setBounds(230, 680, 173, 84);
		exitButton.setBounds(230, 840, 173, 84);

		
		newgameButton.setForeground(Color.black);
		optionsButton.setForeground(Color.black);
		scoreButton.setForeground(Color.black);
		helpButton.setForeground(Color.black);
		aboutButton.setForeground(Color.black);
		exitButton.setForeground(Color.black);
		
		panel.add(newgameButton);
		panel.add(optionsButton);
		panel.add(scoreButton);
		panel.add(helpButton);
		panel.add(aboutButton);
		panel.add(exitButton);
		
		
		
		
		newgameButton.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				int level =1;
				
				JFrame newgame = new JFrame();
				Game Game=new Game(level);
				Game.setLevel(level);
				newgame.setBounds(10,10,700,600);
				newgame.setLocation(800, 400);
				newgame.setTitle("Arkanoid Game");
				newgame.setResizable(false);
				newgame.setVisible(true);
				newgame.add(Game);
				
				newgame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				newgame.addWindowListener(new WindowAdapter() {
			        @Override
			        public void windowClosing(WindowEvent e) {
			            Game.stopTimer();
			        }       
			    });
				
				
				
				
			}
			
			
			
			
			
		});
		optionsButton.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				
				JFrame options_frame = new JFrame("OPTIONS");
				options_frame.setBounds(10,10,400,300);
				options_frame.setLocation(800, 600);
				options_frame.setResizable(false);
				options_frame.setVisible(true);
				JPanel options_panel = new backgroundImage();
				JButton level1_button = new JButton("LEVEL 1");
				JButton level2_button = new JButton("LEVEL 2");
				JButton level3_button = new JButton("LEVEL 3");
				options_panel.add(level1_button);
				options_panel.add(level2_button);
				options_panel.add(level3_button);
				options_frame.add(options_panel);
				options_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				level1_button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int level=1;
						
						JFrame level_1 = new JFrame();
						Game Game=new Game(level);
						Game.setLevel(level);
						level_1.setBounds(10,10,700,600);
						level_1.setTitle("Arkanoid Game");
						level_1.setResizable(false);
						level_1.setVisible(true);
						level_1.add(Game);	
						level_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						level_1.addWindowListener(new WindowAdapter() {
					        @Override
					        public void windowClosing(WindowEvent e) {
					            Game.stopTimer();
					        }

					    });
			
					}	
				});
				level2_button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						int level=2;
						JFrame level_2 = new JFrame();
						Game Game=new Game(level);
						Game.setScore(120);
						Game.setBricks(32);
						Game.setLevel(level);
						level_2.setBounds(10,10,700,600);
						level_2.setTitle("Arkanoid Game");
						level_2.setResizable(false);
						level_2.setVisible(true);
						level_2.add(Game);
						level_2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						level_2.addWindowListener(new WindowAdapter() {
					        @Override
					        public void windowClosing(WindowEvent e) {
					            Game.stopTimer();
					        }

					    });
					}	
				});
				
				level3_button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						int level=3;
						JFrame level_3 = new JFrame();
						Game Game=new Game(level);
						Game.setScore(280);
						Game.setBricks(32);
						Game.setLevel(level);
						level_3.setBounds(10,10,700,600);
						level_3.setTitle("Arkanoid Game");
						level_3.setResizable(false);
						level_3.setVisible(true);
						level_3.add(Game);
						level_3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						level_3.addWindowListener(new WindowAdapter() {
					        @Override
					        public void windowClosing(WindowEvent e) {
					            Game.stopTimer();
					        }

					    });
					}	
				});
				
			
				
			}
			
			
			
			
			
		});
		
		
		
		
		
		scoreButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String output="";
				Game show_scores = new Game(1);
				List<Integer>list=show_scores.getScoresList();
				Collections.sort(list);
				for (int i = 0; i < list.size(); i++) {
		           String every_score=list.get(i).toString();
		           
		            output += every_score+"\n";
		        }
				JOptionPane.showMessageDialog(null,"Score:"+output);
				show_scores.stopTimer();
				
			}
			
		});
	
		
			
		
		
		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ""
						+ "WHAT IS ARKANOID AND HOW TO PLAY IT: \n"
						+ "Arkanoid consists of bouncing ball between a player-controlled platform on the bottom of the screen and a stacks of blocks. \n"
						+ "As the ball bounces on the block, they begin to break, granting the player points based on the color of said blocks. The objective is to break every single block on each level in order to advance to the next.\n\n\n"
						+ "PRESS RIGHT AND LEFT KEY FOR MOVEMENT OF THE PADDLE \n"
						+ "TRY TO BREAK BRICKS TO MOVE ON TO THE NEXT LEVEL \n"
						+ "GOOD LUCK!","GUIDE TO PLAY",JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		aboutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ""
						+ "Student Name: Görkem Özgül\n"
						+ "Student No: 20190702020\n"
						+ "Student Email: gorkem.ozgul@std.yeditepe.edu.tr\n"
						+ "","About Student",JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userInterface.this.setVisible(false);
			}
		});
		
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	


	



	
	

}
