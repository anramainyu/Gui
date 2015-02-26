package gui3;
/*
 * 	Swing-Fenster sind in mehrere virtuelle Ebenen/Schichten aufgeteilt
 * 
 * 		-> Die wichtigste Schicht ist die ContentPane
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingFenster extends JFrame 
{
    public SwingFenster()
    {
	super("Fensterle");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel pnl=new JPanel();
	pnl.setBorder(BorderFactory.createEtchedBorder());
	
	
	
    }
    
    
    
    
    
}
