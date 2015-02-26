package gui2;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * Key-Ereignisse:
 * 
 * Eigenschaft:					Klasse, Interface, Methode:
 * ------------------------------------------------------------------------
 * 
 * Ereignisklasse				KeyEvent
 * Listener-Interface				KeyListener
 * Registrerungsmethode				addKeyListener
 * Mögliche Ereignisquelle			Component
 * 
 * Ereignismethoden:
 * 
 * keyTyped					Taste gedrückt und wieder losgelassen
 * keyPressed
 * keyReleased
 * 
 * -----------------------
 * 
 * Mouse-Events:
 * 
 * Eigenschaft:					Klasse, Interface, Methode:
 * ------------------------------------------------------------------------
 * 
 * Ereignisklasse				MouseEvent
 * Listener-Interface				MouseListener
 * Registrierungsmethode			addMouseListener
 * Mögliche Ereignisquelle			Component
 * 
 * Ereignismethoden:
 * 
 * mouseClicked					Maustaste gedrückt und losgelassen
 * mouseEntered					Mauszeiger betritt die Komponente
 * mouseExited					...........verlässt Komponente
 * mousePressed					Maustaste drücken und festgehalten
 * mouseReleased				......
 * 
 * 
 * 
 * Window-Ereignisse:
 * 
 * Eigenschaft					Klasse, Interface, Methode
 * ---------------------------------------------------------------------------
 * 
 * Ereignisklasse				WindowEvent
 * Listener-Interface				WindowListener
 * Registrierungsmethode			addWindowListener
 * Mögliche Ereignisquellen			Frame, Dialog
 * 
 * Ereignismethoden:
 * 
 * 
 * windowClosed
 * windowOpened
 * ...........
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class Malen extends Frame
{
    //hier werden die gemalten rechtecke gehalten:
    ArrayList<Rectangle> rechtecke;
    Rectangle aktuellesRechteck;
    
    public Malen()
    {
	super("Malprogramm");
	rechtecke=new ArrayList<Rectangle>();
	aktuellesRechteck=new Rectangle(0,0,0,0);
	//listener registrieren(innere klassen)
	addMouseListener(new MyMausListener());
	addMouseMotionListener(new MyMausMotionListener());
	addWindowListener(new MyWindowListener());
	
	
	
	//grösse und position
	setSize(400, 400);
	setLocation(200,300);
	setVisible(true);
	
	
    }
    
    @Override
    public void paint(Graphics g)
    {
	Rectangle rect;
	//zuerst alle bisherigen rechtecke malen:
	Iterator<Rectangle> it=rechtecke.iterator();
	while(it.hasNext())
	{
	    rect=it.next();
	    g.drawRect(rect.x, rect.y, rect.width, rect.height);
	}
		
	//das aktuell gemalte rechteck ausgeben:
	if(aktuellesRechteck.x>0 || aktuellesRechteck.y>0)
	{
	    g.drawRect(aktuellesRechteck.x, aktuellesRechteck.y, aktuellesRechteck.width, aktuellesRechteck.height);
	}
	
	
	
	
    }
    
    
    
    class MyMausListener extends MouseAdapter
    {
	@Override
	public void mousePressed(MouseEvent e)
	{
	    //sobald maustaste gedrückt wurde, wird das momentan gezeichnete rechteck
	    //auf der variablen "aktuellesRechteck" abgelegt und gehalten
	    aktuellesRechteck=new Rectangle(e.getX(), e.getY(), 0 , 0);
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
	  
	    //prüfen, ob auch wirklich ein rechteck gezogen wurde
	    if(aktuellesRechteck.width>0 && aktuellesRechteck.height>0)
	    {
		//fertiges rechteck in der list ablegen
		rechtecke.add(aktuellesRechteck);
	    }
	    
	}
    }
    
    class MyMausMotionListener extends MouseMotionAdapter
    {
	@Override
	public void mouseDragged(MouseEvent e)
	{
	    //zwischenpseichern von aktuellem x und y
	    int x=e.getX();
	    int y=e.getY();
	    
	    if(x>aktuellesRechteck.x && y>aktuellesRechteck.y)
	    {
		aktuellesRechteck.width=(int)(x-aktuellesRechteck.getX());
		aktuellesRechteck.height=(int)(y-aktuellesRechteck.getY());
		//neuzeichnen anfordern
		repaint();
	    }
	
	}
	
	
    }
    
    class MyWindowListener extends WindowAdapter
	{
	    
	    
	    @Override
	    public void windowClosing(WindowEvent e)
	    {
		setVisible(false);
		dispose();
		System.exit(0);
	    }
	}
	
    public static void main(String[] args)
    {
	Malen m=new Malen();
    }
    
    
    
}

/*	Aufgabe:
 * 
 * 		-> Wird die Strg+Maustaste gedrückt wurde, soll ein Rechteck gemalt werden
 * 		-> Wird die Alt+Maustaste betätigt -> Kreis
 * 		-> Shift+Maustaste -> Linie
 * 		-> Del -> Letztes gemaltes Element löschen
 * 
 * 
 * 
 * 
 */








