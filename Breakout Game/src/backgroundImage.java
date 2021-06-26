
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;

public class backgroundImage extends JPanel{
	
	Image backgroundImage;

	  public backgroundImage ()  {
		  
		ImageIcon myBackgroundIcon=new ImageIcon(getClass().getResource("background.jpg"));
		
	    backgroundImage =myBackgroundIcon.getImage(); 
	  }
	
	  public void paintComponent(Graphics g) {
	    super.paintComponents(g);
	    g.drawImage(backgroundImage, 0, 0, null);
	  }
	  
}
