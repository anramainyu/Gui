package gui1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
public class MyWindowCloser extends WindowAdapter
{
    private boolean exit;
    
    public MyWindowCloser(boolean beenden)
    {
	exit=beenden;
    }
    
    @Override
    public void windowClosing(WindowEvent e)
    {
	((Frame)e.getSource()).setVisible(false);
	((Frame)e.getSource()).dispose();
	if(exit)
	{
	    System.exit(0);
	}
    }
    
    
    
}
