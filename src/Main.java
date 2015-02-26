
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by sschiefer on 26.02.2015.
 */
public class Main extends Frame
{
    public Main()
    {
        super("Hauptfenster");
        setSize(400,400);
        setLocation(200,200);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });

        //Textflied dummies
        TextField dummie1 = new TextField();
        TextField dummie2 = new TextField();
        TextField dummie3 = new TextField();
        TextField dummie4 = new TextField();
        TextField dummie5 = new TextField();
        TextField dummie6 = new TextField();
        TextField dummie7 = new TextField();
        TextField dummie8 = new TextField();
        TextField dummie9 = new TextField();
        TextField dummie10 = new TextField();
        dummie1.setVisible(false);
        dummie2.setVisible(false);
        dummie3.setVisible(false);
        dummie4.setVisible(false);
        dummie5.setVisible(false);
        dummie6.setVisible(false);
        dummie7.setVisible(false);
        dummie8.setVisible(false);
        dummie9.setVisible(false);
        dummie10.setVisible(false);



        //Panel Dummies
        Panel pnl_dummie1 = new Panel();
        Panel pnl_dummie2 = new Panel();
        Panel pnl_dummie3 = new Panel();
        Panel pnl_dummie4 = new Panel();

        // Layout waehlen
        setLayout(new BorderLayout());
        GridLayout gridL = new GridLayout(7,2);


        //Panel 1
        Panel pnl_textfield=new Panel();
        pnl_textfield.setLayout(gridL);
        //setContentPane(pnl_textfield);


        TextField txt_dm=new TextField();
        TextField txt_euro=new TextField();
        txt_dm.setPreferredSize(new Dimension(20,20));

        Button btn_dmInEuro=new Button("DM in Euro");
        Button btn_ende=new Button("Ende");


        pnl_textfield.add(dummie1);
        pnl_textfield.add(dummie2);
        pnl_textfield.add(txt_dm);
        pnl_textfield.add(txt_euro);
        pnl_textfield.add(dummie3);
        pnl_textfield.add(dummie4);
        pnl_textfield.add(dummie5);
        pnl_textfield.add(btn_dmInEuro);
        pnl_textfield.add(dummie6);
        pnl_textfield.add(dummie7);
        pnl_textfield.add(dummie8);
        pnl_textfield.add(dummie9);
        pnl_textfield.add(dummie10);
        pnl_textfield.add(btn_ende);



        txt_euro.setVisible(true);
        txt_dm.setVisible(true);

        add(pnl_dummie1,BorderLayout.NORTH);
        add(pnl_dummie2,BorderLayout.SOUTH);
        add(pnl_dummie3,BorderLayout.WEST);
        add(pnl_dummie4,BorderLayout.EAST);

        add(pnl_textfield,BorderLayout.CENTER);
        setVisible(true);



    }



    public static void main(String[] args)
    {
        Main m=new Main();

    }

}
