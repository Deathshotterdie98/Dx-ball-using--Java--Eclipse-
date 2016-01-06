package maingame;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Elements 
{
	int x;
	int y;
	
	Image img;
	
	public boolean isalive;
/**
 * initialize the members	
 * @param filepath filepath of this object image
 * @param x drawing image's  x
 * @param y drawing image's y
  */
public Elements(String filepath,int x,int y,boolean isalive)
{
 img =new ImageIcon(filepath).getImage();
 this.x=x;
 this.y=y;
 
 this.isalive=isalive;
}
public Elements(Image img,int x,int y,boolean isalive)
{
 this.img =img;
 this.x=x;
 this.y=y;
 
 this.isalive=isalive;
}
public int getwidth()
{
	if(img==null)
	return 0;
	else 
	return img.getWidth(null);
}
public int getHeight()
{
	if(img==null)
		return 0;
		else 
		return img.getHeight(null);
}
public  void draw(Graphics g)
{
	if(img!=null && isalive)
		g.drawImage(img, x, y, null);	
}
public void draw_bar(Graphics g,int width)
{
	if(img!=null && isalive)
	g.drawImage(img,x, y, width, 27, null);
}


}
