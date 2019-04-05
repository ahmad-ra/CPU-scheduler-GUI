package app;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.border.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.Shape;

//import java.awt.events.* ;
import javax.swing.*;

public class App extends JFrame {
    public static void main(String[] args) throws Exception {
        new App();
    }









    JTextField j1;
    int i ;
    public App() {

        //JOptionPane.showMessageDialog(this, "dddddddddddddd","this is title", JOptionPane.ERROR_MESSAGE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        JPanel my = new JPanel();

        JLabel L1 = new JLabel("ddd");
        JLabel L2 = new JLabel("eee");
        my.setLayout(new FlowLayout(FlowLayout.LEFT));
       // my.setLayout(new FlowLayout())
        my.add(L1);
        my.add(L2);
       // this.add(my);

        Box b = Box.createHorizontalBox() ;
        this.add(b) ;
        b.add(my) ;
        

        Button b1 = new Button("but");
        b1.setName("button1");
       // my.add(b1);

        lis l1 = new lis();

        b1.addActionListener(l1);

        my.add(b1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        lis2 l2 = new lis2() ;

         j1 = new JTextField("ff") ;


        j1.addFocusListener(l2);

        //my.add(j1) ;
       
        JTextArea aa = new JTextArea(15 ,15);

       // my.add(aa) ;

      JScrollPane fff = new JScrollPane(aa);
       // my.add(fff) ;

       b.add(new myComp());
       
      
       JPanel pan3 = new JPanel();
       JScrollPane g = new JScrollPane(pan3 , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      pan3.add(new MyCanvas());
      pan3.setVisible(true);

      //3shan panel gwa panel gwa box fa lazem tzabbat el size bta3 pan3 
pan3.setSize(new Dimension(300,300));

      //b.add(new MyCanvas2());
     // b.add(new MyCanvas());
       b.add(g);

       this.setVisible(true);
        this.setTitle("frame1");

       // this.getContentPane().removeAll();
        
      //  this.repaint();
       // this.setLocation(0, 100);

    }




    class MyCanvas extends JPanel {

        public MyCanvas(){ 
           // JPanel inner = new JPanel() ;
            this.setSize(new Dimension(600,600));
          //  JScrollPane g = new JScrollPane(this , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//JScrollBar gg= new JScrollBar(JScrollBar.HORIZONTAL,0,1,0,500);
this.add(new JLabel("                                                                                                                                                                                                                                                                                                                             "));
this.add(new JLabel("                            "));
this.add(new JLabel("                            "));
this.add(new JLabel("                            "));
this.add(new JLabel("                            "));
this.add(new JLabel("                            "));
           // Box b =Box.createHorizontalBox();
           
           //this.getContentPane().add(g, BorderLayout.CENTER );

        }
        // public void paint(Graphics g) {
        //     super.paint(g);
        //   g.drawRect (10, 10, 200, 200);  
        // }

        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            super.paintComponent(g);
            g2.setColor(Color.getHSBColor(560, 100, 50));
            g2.fillRect(10, 10, 100, 100);

            //super.paintComponent(g);
            Graphics2D g3 = (Graphics2D) g;

            g3.setColor(Color.getHSBColor(560, 100, i));
            g3.fillRect(30, 10, 10, 100);

            for   (int x=0 ;x< i ; x++ ){
                g3.fillRect(30*x, 10, 10, 100);
  

            }
        }
      }




      private class MyCanvas2 extends JPanel {

     MyCanvas2(){ 
        JPanel a = new JPanel();
        JScrollPane g = new JScrollPane(a , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.add(g) ;
      }

      }







    private class lis implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getSource().toString());
            //i++;
            //.getContentPane().removeAll();
            
           
            Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();

           // activeWindow.removeAll();
           i+=20 ;
           activeWindow.repaint();
           

            ;

        }

    }

    private class lis2 implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {

       
           j1.setText ("whyy") ;
           System.out.println( e.getSource().toString());//.setText("dddd") ;

         
        }

        @Override
        public void focusLost(FocusEvent e) {

        }

       

    }


 class myComp extends JPanel {

    public myComp(){

        JButton h1 =new JButton("button1" );
        JButton h2 =new JButton("button2" );

        this.add(h1);
        this.add(h2);
       // this.add(new JTextArea("l3",20,20));
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        Border operBorder = BorderFactory.createTitledBorder("Operation");
        this.setBorder(operBorder);
        this.setSize(new Dimension(60,60));

    }
}

}

