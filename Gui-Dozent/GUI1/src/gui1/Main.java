package gui1;
/**
 * 	GRAFISCHE OBERFLÄCHEN:
 * 
 * 	-> In Java:
 * 
 * 	-> AWT(die ältesten Fensterklassen)
 * 
 * 		-> Low-Level-Komponenten bzw. Heavyweight-Komponenten
 * 			-> Setzen zum Teil auf den bereits bestehenden Komponenten
 * 			   des jeweiligen OS auf, auf dem die JVM läuft
 * 
 * 			-> Vorteile: - Performance
 * 				    - Komponenten sehen weitestgehend so aus wie in dem OS
 * 
 * 			-> Nachteil: - Wenig Funktionen
 * 				     - Wenige Komponenten
 * 
 * 	-> Swing(Wurde entwickelt um möglichst unabhängig von spezifischen GUI-Komponenten
 * 		des jeweiligen OS zu sein)
 * 
 * 		-> Basiert, was die elementaren Fensterklassen angeht, immer noch auf AWT
 * 		-> Bietet viel mehr Komponenten mit mehr Funktionen an
 * 		-> Galt viele Jahre als hässlich und umständlich und langsam
 * 		-> Für Desktopanwendungen ist Swing bis heute der De-Fakto-Standard
 * 
 * 	-> SWT(von IBM entwickelt, mit Heavyweight-Komponenten)
 * 
 * 		-> komplett unabhängig von Swing und AWT
 * 		-> ist in vielen Bereichen in der Nutzung sehr umständlich
 * 		-> Ziel: Schnelle und stabile Komponenten
 * 		-> Bietet sehr mächtige Komponenten an
 * 
 * 	-> JavaFX(Von Oracle neu entwickelt und immer noch in der Entwicklungsphase)
 * 
 * 		-> Ziel: Schnelle und stabile Rich Internet Application
 * 		-> Oracle strebt hiermit die komplette Abschaffung von AWT/Swing an
 * 		-> Nutzt XML-artige Strukturen (FXML) und auch CSS
 * 		-> Basiert auf Szenen unf Graphen
 * 		-> Bietet viele Widgets an
 * 
 * 	-> Apache Pivot(Framework für Web-Applikation)
 * 
 * 	-> Qt Jambi(Basiert auf dem Framework Qt, sehr mächtig, leistungsstark)
 * 
 * 	-> Java Foundation Classes(JFC) -> API-Sammlung besteht aus AWT/Swing, Java 2D...
 * 
 * 
 * Listener in Java:
 * 
 * 	-> Damit eine Komponente als Listener agieren kann, muss sie 2 Dinge tun:
 * 
 * 		1. Eine/mehrer Call-Back-Methoden implementieren
 * 			-> Eine Calll-Back-Methode ist dafür da, eine bestimmte Art von
 * 			   Event-Objekt zu empfangen, um adäquat auf das Ereignis reagieren
 * 			   zu können
 * 
 * 			-> Um an diese Call-Back-Methode dran zu kommen, muss eine Klasse
 * 		 	   entweder von einer entsprechenden Adapterklasse erben, oder das
 * 			   entpsrechende Interface implementieren
 * 
 * 		2. Die Komponente muss sich per "add"-Methode bei der Ereignisquelle anmelden
 * 
 * 
 * Fensterklassen in AWT:
 * 
 * 	-> Oberste Klasse ist "Component"
 * 	-> Aus Component wurde "Container" abgeleitet
 * 	-> Die Klasse Container ist die Superklasse von "Window" und "Panel"
 * 	-> Die Klassen "Frame" und "Dialog"(als konkrete Fensterklassen) erweitern die 
 * 	   Klasse Window
 * 	-> "Applet" ist aus "Panel" abgeleitet
 * 	-> "FileDialog" ist als spezielle Variante von "Dialog" auch davon abgeleitet
 * 
 * Component:
 * 
 * 	-> Abstrakte Klasse
 * 	-> Aufgaben: - Steht für ein grafisches Grundelement, welches eine Größe und Position
 * 		       hat
 * 		     - Kann Ereignisse senden und empfangen
 * 
 * Container:
 * 
 * 	-> Abstrakte Klasse
 * 	-> Besitzt die grundlegenden Funktionen, die es ermöglichen, dass Komponenten in 
 * 	   andere Komponenten gepackt werden können
 * 	-> Zur Positionierung der Unterkomponenten, kann Container Layout-Manager
 * 	   auf die Unterkomponenten anwenden
 * 
 * 
 * Panel:
 * 
 * 	-> Einfachste konkrete Klasse, welche Eigenschaften aus Component und Container
 * 	   miteinander vereint
 * 
 * Window:
 * 
 * 	-> Abstrakte Form eines Top-Level-Fensters(kein Rahmen, kein Titel und kein Menü)
 * 	
 * Frame:
 * 
 * 	-> Ein Top-Level-Fenster mit Rahmen, optionalem Menü und Titel
 * 	-> Ein Icon kann zugeordnet werden
 * 	-> Kann die Größenänderung durch den User unterbinden
 * 	-> Kann den Mauszeiger beeinflussen
 * 
 * Dialog:
 * 
 * 	-> Dient der Repräsentation von modalen/non-modalen Dialogen
 * 
 * FileDialog:
 * 
 * 	-> Bietet den common dialog an
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
 * 
 * 
 * 
 *
 */

import java.awt.*;
import java.awt.event.*;

public class Main extends Frame
{
    //anonyme ereignisbehandlung:
    WindowAdapter schliessen=new WindowAdapter()
    {
	@Override
	public void windowClosing(WindowEvent e)
	{
	    setVisible(false); //macht das fenster unsichtbar
	    dispose();//setzt die vom fenster reservierten ressourcen wieder frei
	    System.exit(0);
	}
    };
    
    
    
    
    public Main(String titel)
    {
	super(titel);
	//listener registrieren
	addWindowListener(new MyWindowCloser(true));
	//größe des fensters angeben
	setSize(400, 400); //in pixel -> vom jeweiligen gerät(einstellung) abhängig
	//position des fensters setzen
	setLocation(250, 250); //ursprungspunkt des fensters ist die linke obere ecke
	//sichtbar machen
	setVisible(true);
    }
    
    
    public static void main(String[] args) 
    {
	Main m=new Main("Hauptprogramm");
	

    }

    
    
    @Override
    public void paint(Graphics g)
    {
	/*
	 * 	Die Methode update:
	 * 
	 * 		-> Wird ausgeführt als Antwort auf den Aufruf der Methode repaint
	 * 		-> Wenn nicht überschrieben, löscht update den Hintergrund und ruft danach
	 * 		   die paint auf
	 * 
	 * 	Die Methode paint:
	 * 
	 * 		-> Wird von der update aufgerufen
	 * 		-> sollte nie vom Entwickler so direkt aufgerufen werden(ausser explizit
	 * 		  aus der update)
	 * 		-> Die Default-Implementierung in der Superklasse Frame tut nichts
	 * 
	 * 	Die Methode repaint:
	 * 
	 * 		-> Sendet eine Anfrage zum Neu-Zeichnen der Komponente bzw. eines Bereiches
	 * 		   der Komponente
	 * 
	 * 
	 * Die Klasse Graphics:
	 * 
	 * 	-> Abstrakte Klasse
	 * 	-> Wird von der "bemalbaren" Komponente angeboten und auch an die Methoden paint und
	 * 	   update übergeben
	 * 
	 * 
	 * Linien:
	 * 
	 * 	public void drawLine(int x1, int y1, int x2, int y2)
	 * 		-> Zieht eine Linie vom Punkt1(x1, y1) bis Punkt2(x2, y2)
	 * 
	 * Rechtecke:
	 * 
	 * 	public void drawRect(int x, int y, int breite, int hoehe)
	 * 		-> Zeichnet ein Rechteck mit der angegebenen Breite und Höhe ausgehend
	 * 		  vom durch x/y angegebenen Ursprungspunkt(linke obere Ecke des Rechtecks)
	 * 
	 * Polygone:
	 * 
	 * 	-> Zeichnen von Vielecken
	 * 
	 * 	public void drawPolygon(int[] arx, int[] ary, int anz)
	 * 		-> Die ersten beiden Argumente: Listen von x-/y-Koordinaten
	 * 		-> anz legt die Anzahl der Koordinatenpaare fest
	 * 		-> falls der allererste und der letzte Punkt nicht übereinstimmen, werden
	 * 		   sie automatisch mit einer weiteren Linie verbunden
	 * 
	 * 			-> wenn man das nicht möchte: public void drawPolyline
	 * 
	 * Kreise:
	 * 
	 * 	public void drawOval(int x, int y, int breite, int hoehe)
	 * 		-> Zeichnet die größtmögliche Ellipse in das angegebene Rechteck
	 * 
	 * Füllmodus:
	 * 
	 * 	fillRect, fillOval, fillPolygon
	 * 
	 * Farben:
	 * 
	 * 	-> Basiert hier auf RGB
	 * 
	 * 	-> Mischung aus Rot-Grün-Blau-Werten
	 * 
	 * 	-> Dafür gibt es die Klasse Color:
	 * 		public Color(int r, int g, int b)
	 * 
	 * 	-> Es gibt für die gängigsten Farben bereits fertige Farbkontanten
	 * 
	 * 	-> Werte abfragen:
	 * 
	 * 		-> getRed(), getGreen(), getBlue()
	 * 
	 * Die Methode setColor des Graphics-Objektes kann fertige Farben setzen
	 * 
	 * 
	 * Systemfarben:
	 * 
	 * 	Die Klasse SystemColor bietet Methoden, mit welchen man in der jeweiligen
	 * 	Plattform vordefinierte Systemfarben holen kann
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	Dimension fensterdim=new Dimension(300, 400);
	//Bildschirmgröße ermitteln
	Dimension bildschirm=Toolkit.getDefaultToolkit().getScreenSize();
	int top=(bildschirm.height - fensterdim.height)/2;
	int left=(bildschirm.width - fensterdim.width)/2;
	setSize(fensterdim);
	
	
	
	
	
	
	
    }
    
    
    
    
    
    
    
    
    
}














