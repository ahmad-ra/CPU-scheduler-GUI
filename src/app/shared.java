
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

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



public class shared  {

    public enum cpuType { PRIORITY_PRE , PRIORITY_NON_PRE , FCFS , RR , SJF_PRE , SJF_NONPRE  } 


    public  int[] lengths = new int[20]  ; 

    public int size=0;
    public char[] names={'A' ,'B','C','C','C','C','c','c','c','v'};
    public int totalTime =0 ;
    public double waitingtime=0;


    
    private static shared instance = null;
    ArrayList<process> all = new ArrayList<process>() ; 
    ArrayList<process> gant = new ArrayList<process>() ; 
    ArrayList<process> changing= new ArrayList<process>() ; 



    
    shared() {

        // all.add( new process(2, 0, 'a', 2) );
        // all.add( new process(0, 3, 'b', 2) );
        // all.add( new process(0, 3, 'c', 2) );

        // changing.add( new process(2, 0, 'a', 2) );
        // changing.add( new process(0, 3, 'b', 2) );
        // changing.add( new process(0, 3, 'c', 2) );


    }

    public static shared getInstance(){
        if(instance==null){
           instance = new shared();
          }
          return instance;
      }


      public  void sortByArrivalTime(ArrayList<process> a) {

        Collections.sort(a , new Comparator<process>() {
            @Override
            public int compare(process p1 ,process p2)
            {
        
                return (p1.arrival > p2.arrival)? 1 : -1;
            }
        });
        
    }
      
      
      public  void sortByArrivalTime_fcfs(ArrayList<process> a) {

          Collections.sort(a , new Comparator<process>() {
              @Override
              public int compare(process p1 ,process p2)
              {
          
                  return (p1.arrival >= p2.arrival)? 1 : -1;
              }
          });
          
      }
      
      
      public  void sortByArrivalTime_sjf(ArrayList<process> a) {

          Collections.sort(a , new Comparator<process>() {
              @Override
              public int compare(process p1 ,process p2)
              {
          
                  return (p1.arrival >= p2.arrival)? 1 : -1;
              }
          });
          
      }
      
      public  void sortByArrivalTime_piority(ArrayList<process> a) {

          Collections.sort(a , new Comparator<process>() {
              @Override
              public int compare(process p1 ,process p2)
              {
          
                  return (p1.arrival >= p2.arrival)? 1 : -1;
              }
          });
          
      }
      
      public  void sortByArrivalTime_rr(ArrayList<process> a) {

          Collections.sort(a , new Comparator<process>() {
              @Override
              public int compare(process p1 ,process p2)
              {
          
                  return (p1.arrival >= p2.arrival)? 1 : -1;
              }
          });
          
      }
      
      
      public  void sortBySjf(ArrayList<process> a) {

          Collections.sort(a , new Comparator<process>() {
              @Override
              public int compare(process p1 ,process p2)
              {
                   if(p1.arrival==p2.arrival)
                  return (p1.burst >= p2.burst)? 1 : -1;
                   else
                	   return 1;
              }
          });
          
      }
      
      public  void sortByPiority(ArrayList<process> a) {

          Collections.sort(a , new Comparator<process>() {
              @Override
              public int compare(process p1 ,process p2)
              {
                   if(p1.arrival==p2.arrival)
                  return (p1.priority >= p2.priority)? 1 : -1;
                   else
                	   return 1;
              }
          });
          
      }


    public void deepCopyProcess ( ArrayList<process> from , ArrayList<process> to){

        to.clear();
        
     for(int it=0 ; it<from.size(); it++)
     {
         process p = new process(from.get(it).priority, from.get(it).arrival, from.get(it).name, from.get(it).burst);

    
         to.add(p) ;
     }
    }

}










// /////////////////////////////////////////////////////////

//     PriorityQueue<process> procs = new PriorityQueue<process>(25,new processComparator()) ;

//     class processComparator implements Comparator<process>{ 
              

//         @Override
//         public int compare(process p1, process p2) {
//             if (p1.priority > p2.priority) 
//                 return 1; 
//             else if (p1.priority < p2.priority) 
//                 return -1; 
//                             return 0; 
//         }
//     } 

// ///////////////////////////
