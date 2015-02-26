package gui3;
import java.awt.*;
import java.awt.event.*;

/*
 * 	-> Das Konzept der Layoutmanager
 * 
 * 		-> In Form einer Instanz eines konkreten Layoutmanagers, kann man 
 * 		   ein bestimmtes Regelwerk, mit Parametern, auf einen Container
 * 		   und seine Unterkomponenten die Anordnung beeinflussen
 * 
 * 			
 * -> FlowLayout
 * 
 * 	-> Ordnet Elemente von links nach rechts in dem Container an(in Einfügereihenfolge)
 * 
 * 	-> Wenn das nächste Element nicht mehr in die Zeile passt, wird in der nächsten
 * 	   weitergemacht
 * 
 * 	-> public FlowLayout(int ausrichtung), Defaultausrichtung ist CENTER, weitere
 * 	   LEFT, RIGHT
 * 
 * 
 * -> GridLayout
 * 
 * 	-> Ordent Elemente in einem Gitter von links nach rechts zeilenweise an
 * 
 * 	-> Beim Erzeugen des Layouts wird die Anzahl der Zellen festgesetzt
 * 
 * 		-> public GridLayout(int zeilen, int spalten)
 * 		-> public GridLayout(int zeilen, int spalten, int hor_abst, int vert_abst)
 * 
 * 
 * -> BorderLayout
 * 
 * 	-> Container wird in einen nörlichen, südlichen, westlichen, östlichen und
 * 	   einen zentralen Mittelbereich aufgeteilt
 * 
 * 	-> Norden und Süden nehmen den gesamten Raum von links nach rechts ein
 * 	-> Osten und Westen dehnen sich vertikal zwischen nord und süd aus
 * 	-> Center nimmt den restlichen Raum in der Mitte ein
 * 
 * 		-> public BorderLayout(int hor_abst, int vert_abst)
 * 			
 * 
 * 
 * GridBagLayout
 * 
 * 	-> Im Gegensatz zum "normalen" Gridlayout:
 * 		-> Gitterzellen müssen nicht alle dieselbe Größe haben
 * 		-> Elemente können sich über mahr als eine Zelle hinweg ausdehnen
 * 
 * 	-> Vorgehensweise:
 * 
 * 		1. Inszanziieren des GridBagLayout-Objekts
 * 		2. Dieses Layout wird einem Container/Fenster zugewiesen
 * 		3. Für jedes Element, welches nun hinzugefügt werden soll
 * 			muss ein Eigenschaftenobjekt konfiguriert werden
 * 		
 * 			-> Diese Objekte sind vom Typ "GridBagConstraints"
 * 		4. Die Attribute dieser Eigenschaftenobjekte bestimmten das Layout-
 * 		   verhalten eines jedem einezelnen Elementes innerhalb des 
 * 		   GridBagLayouts
 * 
 * 		5. Mit "setConstraints" wird das Element und sein Eigenschaftenobjekt
 * 		  an den Manager übergeben
 * 		6. Element mit "add" in Container/Fenster laden
 * 
 * 	-> Eigenschaften/Methoden der Constraints:
 * 
 * 		int gridx -> In welcher Spalte befindet sich der linke Rand des Elements?
 * 
 * 		int gridy -> In welcher Zeile befindet sich der obere Rand des Elements?
 * 
 * 		int gridwidth -> Über wieviele Zellen soll sich das Element horizontal ausdehnen?
 * 
 * 		int gridheight -> Über wieviele Zellen vertikal?
 * 
 * 		-------------
 * 
 * 		Verhalten im Bereich der Skalierung:
 * 
 * 			int anchor -> An welcher Kante der Zelle soll das Element verankert werden?
 * 
 * 			int fill -> Wie soll das Element bezogen auf seine Größe skaliert werden?
 * 
 * 				GridbagConstraints.NONE, HORIZONTAL, VERTICAL, BOTH
 * 
 * 			double weightx, weighty -> Wie soll überschüssiger Platz über die Zelle
 * 						   verteilt werden?
 * 
 * 				-> 0 steht für keinen Platz
 * 
 * 			int ipadx, ipady -> Wie soll eine konstante Höhe/Breite meines Elementes sein?
 * 
 * ---------------------------------------
 * 
 * Menüs in AWT/Swing:
 * 
 * 	-> Menüs bestehen aus einer MenuBar
 * 	
 * 		-> public MenuBar()
 * 	
 * 			-> Erzeugt eine leere Menüleiste
 * 
 * 			-> Die einzelnen Menüs(zB. "Datei", "Bearbeiten" ...) werden mit der
 * 			   add-Methode einzeln hinzugefügt
 * 
 * 				-> Dafür erzeugen Sie Objekte vom Typ "Menu"
 * 			
 * 			-> Die einzelnen Menüpunkte an sich sind Objekte vom Typ "MenuItem"
 * 			
 * 
 * ------------------------------------------
 * 
 * Dialoge:
 * 
 * 	-> public Dialog(Frame owner)
 * 
 * 	-> public Dialog(Frame owner, boolean modal)
 * 
 * 	-> public Dialog(Frame owner, String titel, boolean modal)
 * 
 * 
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
public class Main extends Frame
{

    public Main()
    {
	super("Hauptfenster");
	setSize(200, 200);
	setLocation(100, 100);
	addWindowListener(new WindowAdapter(){
	    @Override
	    public void windowClosing(WindowEvent e)
	    {
		setVisible(false);
		dispose();
		System.exit(0);
	    }
	});
	//Layout des Fensters
	setLayout(new BorderLayout());
	
	//panel 1
	Panel pnl_label_button=new Panel();
	pnl_label_button.setLayout(new FlowLayout());
	Label lbl_druecken=new Label("Bitte Knopf drücken...");
	//Label dem panel hinzufügen
	pnl_label_button.add(lbl_druecken);
	Button btn_ok=new Button("OK");
	//Knopf dem Panel hinzufügen
	pnl_label_button.add(btn_ok);
	
	//panel 2
	Panel pnl_temp=new Panel();
	pnl_temp.setLayout(new GridLayout(2, 2));
	pnl_temp.add(new Button("Abbrechen"));
	pnl_temp.add(new Button("Beenden"));
	pnl_temp.add(new Button("Speichern"));
	pnl_temp.add(new Button("Laden"));
	
	//an den button "beenden" vom panel pnl_temp drankommen
	Button btn_temp=(Button)pnl_temp.getComponent(1);
	btn_temp.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		//auf button-druck reagieren
	    }
	});
	
	//die beiden panel dem fenster hinzufügen
	add(pnl_label_button, BorderLayout.NORTH);
	add(pnl_temp, BorderLayout.SOUTH);
	
	setVisible(true);
	
	pack();
    }
    
    
    
    public static void main(String[] args) 
    {
	Main m=new Main();

    }

}
