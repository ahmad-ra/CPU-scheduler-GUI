
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



class processDraw extends JPanel {


    public int width ;
    char name ;
    public processDraw (int w , char s){ 
        width = 20 ; //because drawing 1 second slices so width is constant
        name=s ;
        this.add(new JLabel(String.valueOf(name)) ) ;

    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        g2.setColor(Color.getHSBColor(560, 100, 500));
        g2.fillRoundRect(0, 0, width, 100,0,0);
       // g2.drawString("wheere", 75  ,75);
     //  g2.fill3DRect(10, 10, 100, 100, false);

    }

        @Override
    public Dimension getPreferredSize() {
        return new Dimension(width,100); //because drawing 1 second slices so width is constant
    }




}
