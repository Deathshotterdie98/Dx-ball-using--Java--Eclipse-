package maingame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Mainmenu  {
	
	JButton b1;
	JFrame f;
	JPanel p;
	JLabel l;
	 
	void go()
	{	 	 
		 ImagePanel panel = new ImagePanel(new ImageIcon("Pics/Background1.jpg").getImage());  
		 
		 MyClass m=new MyClass();
			
		 
			JFrame frame = new JFrame();  
		    frame.getContentPane().add(panel);  
		    frame.pack();  
		    frame.setVisible(true);
		    frame.setLocationRelativeTo(null);
	     
		    b1=new JButton("click me");
		    
		    
		  //  panel.add(b1);
		    //frame.add(b1);
	     //  b1.setContentAreaFilled(true);
	 
	       
		   frame.add(b1);
	       frame.add(BorderLayout.CENTER,b1);
	       b1.setSize(10, 30);
	       
	  
	       
	
	   
	   //	panel.add(BorderLayout.EAST,b2);
	       b1.addActionListener(m);
	       b1.setVisible(true);
	
	}
	
	
	
	void game_run()       // function for calling the main game from actionperformed
	{
		new Dxball().go();
	}
	
}
class MyClass implements ActionListener {

	public void actionPerformed(ActionEvent e){
   
   // new Mainmenu().game_run(); 
	
	
    String choice = e.getActionCommand();
    JOptionPane.showMessageDialog(null, "You have clicked: "+choice);
    System.out.println("clicked");
  }

}

class ImagePanel extends JPanel 
{
	private Image img;
	BufferedImage imagePerson;
	
    public 	ImagePanel(Image img)
    {
    	this.img = img;  
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));  
        setPreferredSize(size);  
        setMinimumSize(size);  
        setMaximumSize(size);  
        setSize(size);  
        setLayout(null);  
    }
    public ImagePanel(String img)
    {
    	this(new ImageIcon(img).getImage());
    }
    public void paint(Graphics g)
   {
    	g.drawImage(img, 0, 0, null);
    }
	
	
		
 /*   protected void paintComponent(Graphics g) {   // .gif file supports in thhis code

        
        try {
            imagePerson = ImageIO.read(new File("Pics/animation.gif"));
        } catch (IOException e) {
            imagePerson = null;
        }

        g.drawImage(imagePerson, 200,0, null);
    }
*/
}



/*
public class Sample extends JPanel {

   
	private static final long serialVersionUID = 1L;

	public void Sample() {
        JPanel p = new JPanel();

        JLabel lab1 = new JLabel("User Name", JLabel.LEFT);
        p.setLayout(new FlowLayout());
        p.add(lab1 = new JLabel("add JLabel"));
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.getContentPane().add(new Sample());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
*/