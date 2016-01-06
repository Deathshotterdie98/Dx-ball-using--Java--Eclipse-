package maingame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JPanel;
//import javax.swing.Timer;
import javax.swing.JOptionPane;

 

  class Dxball_Level2 extends JFrame   {
	  
	 private static final long serialVersionUID = 1L;
		//JFrame f;
		private static final int HEIGHT=700;
		private static final int WIDTH=1000;
		
		public int  row_number_of_bricks=3;
		public int  column_number_of_bricks=10;		
		
		public  int BRICK_FIRST_X=20;      // x and y coordinate bricks
		public  int BRICK_FIRST_Y=60; 
		
		public int ball_speed_timer=5;
		
		public int total_score;
		
		public int bar_width=120;
		
		public int bar_x_position=460;
		public int bar_y_position=HEIGHT-60;;
		
		public int rocket_left_x_position=460;
		public int rocket_right_x_position=566;
		public int rocket_left_y_position=613;
		public int rocket_right_y_position=613;
		
		public int Life_count=3;
		
		String msg;
		String score;
		boolean gameover=false;
		int score_count=0;
		int signx=-1;
		int signy=-1;
		
		public static boolean isgamestarted=false;
	    
		public static final Image BRICK_IMAGE=new ImageIcon("Pics/brick.jpg").getImage();
		
		public  final Image BACKGROUND_IMAGE=new ImageIcon("Pics/Background3.jpg").getImage();
		
		public  final Image BACKGROUND_IMAGE2=new ImageIcon("Pics/Background3.jpg").getImage();
		
	
		Elements ball;
		//Elements brick;
		Elements bar;
		Elements brick[][];
		
		Elements background;
		Elements background2;
		
		Elements one_life_plus;
		Elements bar_size_increase;
		Elements bar_size_increase2;
		Elements bar_size_decrease;
		Elements game_over_image;
		Elements ball_on_hury;
		
		Elements small_bar1;
		Elements small_bar2;
		Elements small_bar3;
		
		Elements rocket_left;
		Elements rocket_right;
		
		Elements bullet_at_rocket_left;
		Elements bullet_at_rocket_right;
		
	/**
	 * 
	 */
	
	  JFrame f;
	  JButton b;
			
	public Dxball_Level2()
	{
		bar=new Elements("Pics/bar2.png", this.bar_x_position, this.bar_y_position,true);
		
		ball=new Elements("Pics/ball4.jpg", 504, HEIGHT-105,true);
		
		small_bar1=new Elements("Pics/small_bar.png", 704, 10,true);
		
		small_bar2=new Elements("Pics/small_bar.png", 804, 10,true);
		
		small_bar3=new Elements("Pics/small_bar.png", 904, 10,true);
		
		rocket_left=new Elements("Pics/rocket.jpg", this.rocket_left_x_position, this.rocket_left_y_position,true);
		
		rocket_right=new Elements("Pics/rocket.jpg", this.rocket_right_x_position,this.rocket_right_y_position,true);
		
		bullet_at_rocket_left=new Elements("Pics/bullet.png", 466,599,true);
		
		bullet_at_rocket_right=new Elements("Pics/bullet.png", 572,599,true);
			
		background=new Elements(this.BACKGROUND_IMAGE, 0, 0,true);
		
		background2=new Elements(this.BACKGROUND_IMAGE2, 0, 0,true);
		
		one_life_plus=new Elements("Pics/1+.jpg", 504, -30,true);
		
		bar_size_increase=new Elements("Pics/bar_size_increase.png", 200,-30,true);
		
		this.game_over_image=new Elements("Pics/game_over_image.jpg", 400,-30,true);
		
		bar_size_increase2=new Elements("Pics/bar_size_increase2.png", 450,-30,true);
		
	    bar_size_decrease=new Elements("Pics/bar_size_decrease.png", 200,-30,true);
		
		ball_on_hury=new Elements("Pics/ball_on_hury.jpg", 700,-30,true);
		
		this.initializebricks();
		
		
		//brick=new Elements("Pics/brick.jpg", 120, 100,true);
		
	
		f=new JFrame("it a frame");
		b= new JButton("click me");
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.setSize(WIDTH, HEIGHT);
		f.setLocationRelativeTo(null);
		f.setResizable(true);
		//f.setUndecorated(true);
	//	f.setVisible(true);
		
		f.setIconImage(new ImageIcon("Pics/Background3.jpg").getImage());
		
		f.setDefaultLookAndFeelDecorated(true);
		
	    f.add(b);
	    
	
	   
		
		// new JFrame("Game");
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(WIDTH,HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setFocusable(true);
		
		this.setVisible(true);

	
		addKeyListener(new Input(bar,rocket_left,rocket_right,bullet_at_rocket_left,bullet_at_rocket_right));
		
	}
	
	
	
	
	/*                            codes for initializing the bricks by textfield or by map
	static int level_width;
	static int level_height;
	
	
	private void loadLevel(String level_filepath) throws IOException      // 
	{
		
		if(level_filepath==null)
			System.out.print("level not found ");
		ArrayList<String> lines=new ArrayList<String>();
		
		
		BufferedReader br=new BufferedReader(new FileReader(level_filepath));
		String line="";
		while(line!=null){
			line=br.readLine();
			lines.add(line);
			level_width=Math.max(level_width, line.length());
		}
		level_height=lines.size();

		brick=new Elements[level_height][level_width];

		
    	int x=FIRST_X;
    	int y=FIRST_Y;
    	
    	for(int r=0;r<brick.length;r++)
    	{
    		
    		x=FIRST_X;
    		line=lines.get(r);
    		
    		
    		for(int c=0;c<brick[r].length;c++)
    		
    		{
    			if(c<line.length() && line.charAt(c)=='B')
    			brick[r][c]=new Elements("Pics/brick.jpg",x,y,true);
    			else 
    				brick[r][c]=null;
    			x+=brick[r][c].getwidth();
    		}
    		//System.out.println(r);
    		
    		y+=brick[r][0].getHeight();
    	}	
		
	}
	*/
	      
    private void initializebricks()             // brick initialization codes are here
    {
    	int x=BRICK_FIRST_X;
    	int y=BRICK_FIRST_Y;
    		
    	brick=new Elements[row_number_of_bricks][column_number_of_bricks];            // 7 is row number of brick and 10 is column number of brick by changing this we can change brick numbers
    	for(int r=0;r<brick.length;r++)
    	{	
    		x=BRICK_FIRST_X;
    		
    		for(int c=0;c<brick[r].length;c++)
    		{
    			brick[r][c]=new Elements(BRICK_IMAGE,x,y,true);
    			x+=brick[r][c].getwidth();
    		}
    		//System.out.println(r);
    		
    		y+=brick[r][0].getHeight();
    	}
    }
	public boolean barupperintersect()
	{
//		System.out.println("bar x "+bar.x+" bar y "+bar.y+" ball x "+ball.x+" ball y "+ball.y);
		
		if( bar.y<=ball.y+ball.getHeight() && ( (ball.x>=bar.x && ball.x<=bar.x+bar.getwidth()) ||(ball.x+ball.getwidth()>=bar.x && ball.x+ball.getwidth()<=bar.x+bar.getwidth()) )   ){
	     
			Sound.bar_upper_intersect_sound();
			
			//Sound.bartouch_sound();
			System.out.println("upper called"+ signy);
			return true;	
			
		}
		else	
	   return false;	
	}
	public boolean barleftintersect()
	{
		System.out.println("barleft" + signy);
		if(/*signx==1 && signy==1 &&*/ ball.y+ball.getHeight()>=bar.y && ball.x+ball.getwidth()==bar.x)
		{		Sound.bar_left_intersect_sound();
			return true;
		}	
		else 
			return false;
	}
	public boolean barrightintersect()   
	{
		if(signx==-1 && signy==1 && ball.y+ball.getHeight()>=bar.y && ball.x<=bar.x+bar.getwidth())    // aikhane vul ase
		{
		System.out.println("bar right intersected");
		Sound.bar_left_intersect_sound();
			return true;
		}
		else 
			return false;
	}
	
	
	
	public void ballmove()
	{
		
		if(this.ball_speed_increase())
		{
			if(this.barupperintersect_with_ball_on_hury())
			{
				ball_speed_timer--;
				Sound.ball_speed_increase_sound();
				System.out.println("one life plus bonus touched");
				this.ball_on_hury.y=this.HEIGHT+100;
			}
			if(ball_on_hury.y==HEIGHT)
			{
				ball_on_hury.x=-30;
			}
			ball_on_hury.y++;
			repaint();
					
		}		
		
			
        try {
					Thread.sleep(ball_speed_timer);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
				}
	
		if(barleftintersect())
		{
			System.out.println("left true"+signy);
			signy*=(-1);
			System.out.println("after change"+signy);
				
			signx*=(-1);
		}
	/*
	
		 if(barrightintersect())
		{
			System.out.println("right true"+signy);
			signy*=(-1);
			System.out.println("after change"+signy);
				
			signx*=-1;
		}
		*/
					
        else if(ball.x<5 || ball.x>950)
        {
        	Sound.wall_touch_sound();
		   signx=signx*(-1);
        }
		 else if(ball.y<5 || barupperintersect())
		 {	
			 Sound.wall_touch_sound();	 
			 signy=signy*(-1);
		 }
	// condition for gaming over
		 if(ball.y>=HEIGHT && this.Life_count>=0)
	{ 
			 this.Life_count--;
			 			 
			   Sound.gameover_sound();
			   if(this.Life_count==0)
			   {
			  msg="Game over";
			  repaint();
		      gameover=true;
			   }
			   signy=-1;
	}
		 
		
		int x1=ball.x;
		int y1=ball.y;
		 
		//Rectangle r1=new Rectangle(x1,y1,x1+ball.getwidth(),y1+ball.getHeight());
	//	Rectangle r2=new Rectangle(ball.x,ball.y,ball.x+ball.getwidth(),ball.y+ball.getHeight());
		   
	   
		
		 ball.x=ball.x+signx;
	   ball.y=ball.y+signy;
	   
	//   Rectangle r=new Rectangle();
	 //  repaint(x1,y1,x1+ball.getwidth(),y1+ball.getHeight(),ball.x,ball.y,ball.x+ball.getwidth(),ball.y+ball.getHeight());
	//  repaint(ball.x,ball.y,x1+ball.getwidth(),y1+ball.getHeight());
	   //this.rep
	   //repaint();
	
	   repaint(x1,y1,x1+ball.getwidth(),y1+ball.getHeight()); //repaint the previous position

	   repaint(ball.x,ball.y,ball.x+ball.getwidth(),ball.y+ball.getHeight());//repaint the new position
	}
	
	 void go()
	{	 
		//long gameSpeed=0;
		// repaint();
		long t1,t2;
		t1=System.currentTimeMillis();
		 
		 while(true)
		 {
			 System.out.println("while");
			 if(isgamestarted)
				 
			 {
				 System.out.println("if");
				t2=System.currentTimeMillis();
				
			//	 if(gameSpeed%3000000==0){
				
				ballmove();
				if(t2-t1>=80){
				repaint();
				// gameSpeed=0;
				 //}
				  //gameSpeed++;
				 t1=System.currentTimeMillis();
				}
	            }
		 }//while
	}//go	
	 int level=1;
	 
	@Override
	public void paint(Graphics g)
	{


		//g.clearRect(0, 0, WIDTH,HEIGHT);
		background.draw(g);
		this.game_over_image.draw(g);
		
		
		
		if(this.Life_count==4)          // life count condition
		{
			this.small_bar1.draw(g);
			this.small_bar2.draw(g);
			this.small_bar3.draw(g);			
		}
		if(this.Life_count==3)
		{
		this.small_bar2.draw(g);
		this.small_bar3.draw(g);
		}
		if(this.Life_count==2)
		{
			this.small_bar3.draw(g);
		}
		
//		this.rocket_left.draw(g);
	//  this.rocket_right.draw(g);
		//bullet_at_rocket_left.draw(g);
	//	bullet_at_rocket_right.draw(g);


		
		//bar_size_increase.draw(g);
		
		//this.bar_size_decrease.draw(g);
		
		
		
		if(this.bar_size_decrease())
		{
			if(this.barupperintersect_with_bar_size_decrease())
			{
				Sound.bar_size_decrease();
				bar_width=120;
				System.out.println("one life plus bonus touched");
				this.bar_size_decrease.y=this.HEIGHT+100;
			}
			if(bar_size_decrease.y==HEIGHT)
			{
				bar_size_decrease.x=-30;
			}
			bar_size_decrease.y++;
			bar_size_decrease.draw(g);		
		}		
		
		if(this.bar_size_increase())
		{
			if(this.barupperintersect_with_bar_size_increase())
			{
				Sound.bar_size_increase_sound();
				bar_width=190;
				this.rocket_right.x=bar_width+160;
				System.out.println("one life plus bonus touched");
			bar_size_increase.y=-30;	
			}
			
				if(bar_size_increase.y==HEIGHT)
				{
					bar_size_increase.x=-30;
				}
			bar_size_increase.y++;
			bar_size_increase.draw(g);
			
		}		
		if(this.bar_size_increase_secondtime())
		{
			if(this.barupperintersect_with_bar_size_increase())
			{
				Sound.bar_size_increase_sound();
				bar_width=190;
				System.out.println("one life plus bonus touched");
				this.bar_size_increase2.y=this.HEIGHT+100;
			}
			if(bar_size_increase2.y==HEIGHT)
			{
				bar_size_increase2.x=-30;
			}
			bar_size_increase2.y++;
			bar_size_increase2.draw(g);		
		}	
		
		if(this.game_over_image_run())
		{
			if(this.barupperintersect_with_game_over_image()  )
			{		
				Sound.gameover_sound();		
				
								
				
				System.out.println("one life plus bonus touched");
				this.game_over_image.x=-100;
			}
			if(this.game_over_image.y==HEIGHT)
			{
				this.game_over_image.x=-100;
			}
		this.game_over_image.y++;
		this.game_over_image.draw(g);		
		}		
		
		
		if(this.one_life_plus())
		{
			if(this.barupperintersect_with_one_life_plus() && this.Life_count<5)
			{
				this.Life_count++;
				Sound.one_life_plus_sound();
				System.out.println("one life plus bonus touched");
				one_life_plus.x=-100;
			}
			if(one_life_plus.y==HEIGHT)
			{
				one_life_plus.x=-100;
			}
		one_life_plus.y++;
		one_life_plus.draw(g);		
		}		
		
		//brick.draw(g);
		
		
							
		bar.draw_bar(g,bar_width);
		calcbricks_drawbricks(g);
		
		g.drawString("x "+bar.x+" y "+ bar.y, bar.x, bar.y);
		
		Rectangle r=g.getClipBounds();
		g.setClip(ball.x,ball.y,ball.x+ball.getwidth(),ball.y+ball.getHeight());
		ball.draw(g);
		g.setClip(r);
		
		g.drawString("x "+ball.x+" y "+ ball.y, ball.x, ball.y);
		
		
		
		g.setColor(Color.GREEN);
		Font font=new Font("Arial",Font.ITALIC,40);      //  printing the scores
		g.setFont(font);
		if(score==null)
		score="0";
		g.drawString("Score: "+score, 15, 35);
		
		//String s=String.valueOf(this.Life_count);
	//	g.drawString("Life "+s, 500, 350);
		
		if(gameover==true)   //for game over message
		{	
			
		background.draw(g);
		isgamestarted=false;
		g.setColor(Color.WHITE);	
		g.drawString(msg, 400, 360);
		g.setColor(Color.CYAN);
		g.drawString("Your score is: " +score, 360, 400);
		
		
		}
		
		if(level_1_complete())
		{
	//		this.setRootPaneCheckingEnabled(false);
			
			//new Dxball_level2().ballmove();
			
			background.draw(g);
			isgamestarted=false;
			g.setColor(Color.WHITE);
			g.drawString("Score: "+score, 405, 355);	
			
		}
		
		// game over message
		//System.out.print("not called");
		//g.drawLine(10, 11, 122, 53);


	
	// game over message
	//System.out.print("not called");
	//g.drawLine(10, 11, 122, 53);

	}
	public boolean check()
	{
		if(this.score_count==20)
		{
			level=2;
			return true;
		}
		else
			return false;
	}
	
	public boolean ball_speed_increase()
	{
		if((score_count==120 || score_count==130) && this.ball_speed_timer>2 && this.ball_speed_timer<7)
		{
		
			return true;	
		}
		else
			return false;
	}
	public boolean bar_size_increase()
	{
		if((score_count==80 || score_count==90 ) && this.bar_width==120)		
		{		
			return true;		
		}
			else return false;
	}
	public boolean bar_size_increase_secondtime()
	{
		if((score_count==210 || score_count==220) && this.bar_width==120)		
		{		
			return true;		
		}
			else return false;
	}
	
	public boolean bar_size_decrease()
	{
		if((score_count==160 || score_count==170 || score_count==180) && this.bar_width==190)		
		{		
			return true;		
		}
			else return false;
	}
	public boolean level_1_complete()
	{
		if(score_count/10==this.row_number_of_bricks*this.column_number_of_bricks)
		{
		Sound.Level_up();
			return true;
		}
				else 
			return false;
	}
	public boolean one_life_plus()
	{
		
		if((score_count==100 || score_count==110 || score_count==120 ) && one_life_plus.y<HEIGHT)
		return true;
		else 
			return false;
	}
	public boolean game_over_image_run()
	{
		if(this.score_count==240 || this.score_count==250 || this.score_count==260 || this.score_count==270)
		{
			return true;
		}
		else
			return false;
	}
	public boolean barupperintersect_with_one_life_plus()
	{
//		System.out.println("bar x "+bar.x+" bar y "+bar.y+" ball x "+ball.x+" ball y "+ball.y);
		
		if( bar.y<=one_life_plus.y+one_life_plus.getHeight() && ( (one_life_plus.x>=bar.x && one_life_plus.x<=bar.x+bar.getwidth()) ||(one_life_plus.x+one_life_plus.getwidth()>=bar.x && one_life_plus.x+one_life_plus.getwidth()<=bar.x+bar.getwidth()) )   ){
	     
			
			
			//Sound.bartouch_sound();
			//System.out.println(" bonus touched");
			return true;	
			
		}
		else	
	   return false;	
	}
	public boolean barupperintersect_with_bar_size_increase()
	{
//		System.out.println("bar x "+bar.x+" bar y "+bar.y+" ball x "+ball.x+" ball y "+ball.y);
		
		if( bar.y<=bar_size_increase.y+bar_size_increase.getHeight() && ( (bar_size_increase.x>=bar.x && bar_size_increase.x<=bar.x+bar.getwidth()) ||(bar_size_increase.x+bar_size_increase.getwidth()>=bar.x && bar_size_increase.x+bar_size_increase.getwidth()<=bar.x+bar.getwidth()) )   ){
	     
			
			
			//Sound.bartouch_sound();
			//System.out.println(" bonus touched");
			return true;	
			
		}
		else	
	   return false;	
	}
	public boolean barupperintersect_with_bar_size_decrease()
	{
//		System.out.println("bar x "+bar.x+" bar y "+bar.y+" ball x "+ball.x+" ball y "+ball.y);
		
		if( bar.y<=bar_size_decrease.y+bar_size_decrease.getHeight() && ( (bar_size_decrease.x>=bar.x && bar_size_decrease.x<=bar.x+bar.getwidth()) ||(bar_size_decrease.x+bar_size_decrease.getwidth()>=bar.x && bar_size_decrease.x+bar_size_decrease.getwidth()<=bar.x+bar.getwidth()) )   ){
	     
			
			
			//Sound.bartouch_sound();
			//System.out.println(" bonus touched");
			return true;	
			
		}
		else	
	   return false;	
	}
	public boolean barupperintersect_with_ball_on_hury()
	{
//		System.out.println("bar x "+bar.x+" bar y "+bar.y+" ball x "+ball.x+" ball y "+ball.y);
		
		if( bar.y<=ball_on_hury.y+ball_on_hury.getHeight() && ( (ball_on_hury.x>=bar.x && ball_on_hury.x<=bar.x+bar.getwidth()) ||(ball_on_hury.x+ball_on_hury.getwidth()>=bar.x && ball_on_hury.x+ball_on_hury.getwidth()<=bar.x+bar.getwidth()) )   ){
	     
			
			
			//Sound.bartouch_sound();
			//System.out.println(" bonus touched");
			return true;	
			
		}
		else	
	   return false;	
	}	
	public boolean barupperintersect_with_game_over_image()
	{
//		System.out.println("bar x "+bar.x+" bar y "+bar.y+" ball x "+ball.x+" ball y "+ball.y);
		
		if( bar.y<=game_over_image.y+game_over_image.getHeight() && ( (game_over_image.x>=bar.x && game_over_image.x<=bar.x+bar.getwidth()) ||(game_over_image.x+game_over_image.getwidth()>=bar.x && game_over_image.x+game_over_image.getwidth()<=bar.x+bar.getwidth()) )   ){
	     
			
			
			//Sound.bartouch_sound();
			//System.out.println(" bonus touched");
			return true;	
			
		}
		else	
	   return false;	
	}	
			
	private void calcbricks_drawbricks(Graphics g) //if brick intersects then return false, by this brick will be vanished otherwise draw it
	{
		for(int r=0;r<brick.length;r++)
			for(int c=0;c<brick[r].length;c++){
							
			if(isbrick_bottom_intersected(brick[r][c]))
			{
					//brick[r][c]=null;
				brick[r][c].isalive=false;             // object of the brick is becoming false
				
				signy=1;	// after intersecting ball returns
				
				
					System.out.println("bottom intersected");
					score_count+=10;
					score=String.valueOf(score_count);
					repaint();
					 
					
					System.out.println(score_count);
					
			}
			
			
		else if(isbrick_leftside_intersected(brick[r][c]))
			{
					//brick[r][c]=null;
				brick[r][c].isalive=false;             // object of the brick is becoming false
				
				signx=-1;			              // after intersecting ball returns
				score_count+=10;
				score=String.valueOf(score_count);
				repaint();
				
				System.out.println(score_count);
					//System.out.println("left side intersected");	
			}
			
		else if(isbrick_upper_intersected(brick[r][c]))
		{
				//brick[r][c]=null;
			brick[r][c].isalive=false;             // object of the brick is becoming false
			
			signy=-1;			              // after intersecting ball returns
			score_count+=10;
			score=String.valueOf(score_count);
			repaint();
		
			System.out.println(score_count);
				//System.out.println("left side intersected");	
		}
		
			
		/*
		 if(isbrick_rightside_intersected(brick[r][c]))
		{
				//brick[r][c]=null;
			brick[r][c].isalive=false;             // object of the brick is becoming false
			
			signx=1;			              // after intersecting ball returns
				//System.out.println("left side intersected");	
		}
		*/
		
		
			else
			
				brick[r][c].draw(g);
			//System.out.println("not intersected");
			}
	}
	
	private boolean isbrick_bottom_intersected(Elements brick)
	{
          if(brick!=null && signy==-1 && brick.isalive &&( (ball.x>=brick.x && ball.x<=brick.x+brick.getwidth()) 
        		  || ball.x+ball.getwidth()>=brick.x && ball.x+ball.getwidth()<=brick.x+brick.getwidth() )
        		  && (ball.y<=brick.y+brick.getHeight() && ball.y>=brick.y) )	
          {
        	  Sound.brick_break_sound();
			return true;
          }
		else 
			return false;
	}
	private boolean isbrick_upper_intersected(Elements brick)
	{
        if(brick!=null && signy==1 && brick.isalive && ( (ball.x>=brick.x && ball.x<=brick.x+brick.getwidth()) 
      		  || ball.x+ball.getwidth()>=brick.x && ball.x+ball.getwidth()<=brick.x+brick.getwidth() ) && 
      		  (ball.y + ball.getHeight() >=brick.y && ball.y+ball.getHeight()<= brick.y+ brick.getHeight()))
        {
        	Sound.brick_break_sound();
        	System.out.println(" upper brick intersected");
		return true;
        }
        else 
        	return false;
        }
	private boolean isbrick_leftside_intersected(Elements brick)
	{
         if(brick!=null && signx==1 && brick.isalive && (ball.x+ball.getwidth()>=brick.x && ball.x+ball.getwidth()<=brick.x+brick.getwidth()) && 
        ((ball.y>=brick.y && ball.y<=brick.y+brick.getHeight()) || (ball.y+ball.getHeight()>=brick.y && ball.y+ball.getHeight()<=brick.y+brick.getHeight()) ))
         {
        	 Sound.brick_break_sound();
        	 System.out.println("left side intersected");
        	 return true;
         }
         else 
        	 return false;
	}
	/*
	private boolean isbrick_rightside_intersected(Elements brick)
	{
        
		if(brick!=null && signx==-1 && brick.isalive && (ball.x<=brick.x+brick.getwidth() && ball.x>=brick.x) &&
        	((ball.y>=brick.y && ball.y<=brick.y+brick.getHeight()) || (ball.y+ball.getHeight()>=brick.y && ball.y+ball.getHeight()<=brick.y+brick.getHeight())) )
		{	
			System.out.println(" right side intersected");
		return true;    
		}
		else 
			return false;
	}
	*/

	
	
	
	
	/**
	 * 
	 * @param args
	 */
	
	/*public static void main(String args[])
	{		
		new Dxball().go();
		
		//Dxball_level2 ob=new Dxball_level2();
	}
	*/
	
}
 