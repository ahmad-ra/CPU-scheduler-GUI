package app;

import javax.swing.border.*;

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




public class drawPanel extends JPanel {


drawPanel() {
this.setBorder(BorderFactory.createTitledBorder(""));
Box myBox = Box.createVerticalBox() ;
this.add(myBox) ;


JLabel title =new JLabel("                                              SCHEDULE GANT CHART ") ;

myBox.add(title);




JScrollPane chartScroll = new JScrollPane(new canvas(),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED) ;
chartScroll.getViewport().setPreferredSize(new Dimension(400, 100));
myBox.add(chartScroll);





}

}