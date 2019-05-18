
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

import javax.swing.*;
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



class canvas extends JPanel{

    shared a = shared.getInstance();

    public canvas(){
    start();
    }


    public void start(){

     
        for (int i =0 ; i<a.gant.size() ;i++ ){

            this.add(new processDraw(a.gant.get(i).burst, a.gant.get(i).name) ) ;
           
        }

    }

   

    
    // @Override
    // public Dimension getPreferredSize() {
    //     return new Dimension(50,50);
    // }

    
    //  @Override public Dimension   getMaximumSize(){
    //     return new Dimension(50,50);
    //  }


    public void paintComponent(Graphics g) {
      
        this.removeAll();
        super.paintComponent(g);
       start();
       this.validate();
    }
  
    


       

    }







      




