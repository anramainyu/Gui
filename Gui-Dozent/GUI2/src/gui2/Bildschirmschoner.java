package gui2;
import java.awt.*;
import java.awt.event.*;


public class Bildschirmschoner extends Frame
{
    public Bildschirmschoner()
    {
	setSize(getToolkit().getScreenSize());
	setBackground(Color.BLACK);
	setUndecorated(true);
	setLocation(0,0);
	addKeyListener(new KeyAdapter(){
	    
	    @Override
	    public void keyPressed(KeyEvent e)
	    {
		setVisible(false);
		dispose();
		System.exit(0);
	    }
	});
	requestFocus();
	setVisible(true);
    }
    
    public void render()
    {
	Graphics g=getGraphics();
	draw(g);
    }
    
    public void draw(Graphics g)
    {
	//animation
	
	
    }
    
    @Override
    public void paint(Graphics g)
    {
	
    }
    
    
    
    
    
    
   /* 
    public static void main(String[] args)
    {
	Render r=new Render();
	Thread t=new Thread(r);
	t.start();
    }
    
    */
    
    
    
    
    
}
