

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
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.Shape;



public class myFrame extends JFrame {
 
myFrame(){
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension dim = tk.getScreenSize();
    this.setSize(dim.width ,dim.height);
    this.setLocationRelativeTo(null);
    this.setTitle("CPU_SCHEDULER");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    
JPanel mainPanel = new JPanel();
mainPanel.setLayout(new GridLayout(1,2));
mainPanel.add( new formPanel()) ;


mainPanel.add( new drawPanel()) ;
this.add(mainPanel) ;
this.setVisible(true);

}
    
}