package maingame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input  implements KeyListener {

	public int x_axis_increment=40;
	
	//static int x=Dxball.getbarx();
	Elements bar;
	Elements rocket_left;
	Elements rocket_right;
	Elements bullet_at_rocket_left;
	Elements bullet_at_rocket_right;
	
	public Input(Elements b,Elements r_l,Elements r_r,Elements b_at_r_l,Elements b_at_r_r)
	{
		rocket_left=r_l;
		rocket_right=r_r;
		
		bar=b;
		
		bullet_at_rocket_left=b_at_r_l;
		bullet_at_rocket_right=b_at_r_r;
	}
	
	
	@Override	
	public void keyPressed(KeyEvent e) {
		int k=e.getKeyCode();// TODO Auto-generated method stub

		if(k==KeyEvent.VK_ESCAPE)
			System.exit(0);	
		else if(k==KeyEvent.VK_LEFT && bar.x>5)		
		{
		    
			bar.x=bar.x-x_axis_increment;
			rocket_left.x=rocket_left.x-x_axis_increment;
			rocket_right.x=rocket_right.x-x_axis_increment;
			bullet_at_rocket_left.x=bullet_at_rocket_left.x-x_axis_increment;
			bullet_at_rocket_right.x=bullet_at_rocket_right.x-x_axis_increment;			
		}
		else if(k==KeyEvent.VK_RIGHT && bar.x<871)
		{
			bar.x=bar.x+x_axis_increment;
			rocket_left.x=rocket_left.x+x_axis_increment;
			rocket_right.x=rocket_right.x+x_axis_increment;
			
			bullet_at_rocket_left.x=bullet_at_rocket_left.x+x_axis_increment;
			bullet_at_rocket_right.x=bullet_at_rocket_right.x+x_axis_increment;

		}
		else if(k==KeyEvent.VK_D && this.bullet_at_rocket_left.y>=-2 &&this.bullet_at_rocket_right.y>=-2)
		{
			
			if(this.bullet_at_rocket_left.y==-1 && this.bullet_at_rocket_right.y==-1)
			{
				this.bullet_at_rocket_left.y=599;
				this.bullet_at_rocket_right.y=599;
			}
			
            //this.bullet_at_rocket_left.y=this.bullet_at_rocket_left.y-100;
			
			//this.bullet_at_rocket_right.y=this.bullet_at_rocket_right.y-100;

			
			while(this.bullet_at_rocket_left.y!=-1 && this.bullet_at_rocket_right.y!=-1)
			{		
			this.bullet_at_rocket_left.y--;//=this.bullet_at_rocket_left.y--;
			
			this.bullet_at_rocket_right.y--;//=this.bullet_at_rocket_right.y--;
			}
					
		}
			else if(k==KeyEvent.VK_ENTER)
			Dxball.isgamestarted=true;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
