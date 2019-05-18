package app;
import java.util.Timer ;
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
import java.util.TimerTask;

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

public class formPanel extends JPanel {

  shared a = shared.getInstance();
  JPanel my = this;
 CPU pri   = new CPU(0, shared.cpuType.PRIORITY_PRE);
  formPanel() {

    JButton tt = new JButton("baher");
    tt.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        a.sortByArrivalTime(a.all);
  
        

      // pri.priority_pre(a.all) ;
        
        shared.getInstance().deepCopyProcess(a.all, a.changing);
        a.gant.clear();
      Timer timer = new Timer();
     
      int begin = 0;
      int timeInterval = 1000;
      
      timer.schedule(new TimerTask() {
        int counter =0 ;
        int currentTime =0;
         @Override
         public void run() {
             //call the method
           //  pri.priority_pre(a.all) ;
           pri.priority_preOneCycle(currentTime);
             counter++;
              currentTime ++ ;
             if(a.gant.get(a.gant.size()-1).name == 'N') counter --  ; //if CPU is IDlE this loop doesn't count
             if (counter >= a.totalTime){
              
               timer.cancel();
             }
         }
      }, begin, timeInterval);

    









        for (int i =0 ; i<a.all.size() ; i++)
        System.out.println(a.all.get(i).name);
   
        my.revalidate();
    my.getParent().repaint();

      }
  });
    this.add(tt) ;

////////////////////////////////////////////


    JButton addproc =  new JButton("add proc") ;
    addproc.addActionListener(new ActionListener(){
    
        @Override
        public void actionPerformed(ActionEvent e) {
  
        // a.all.remove(0) ;
         a.all.add(new process(0, pri.currentTime ,'O', 2)) ;
         a.changing.add(new process(0, pri.currentTime, 'O', 2)) ;

         a.totalTime +=2 ;
         a.sortByArrivalTime(a.all);
         a.sortByArrivalTime(a.changing);
  
        }
    });
      this.add(addproc) ;

}

}