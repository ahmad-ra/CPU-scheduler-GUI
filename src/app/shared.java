

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



public class shared  {

    public  int[] lengths ={4,3,2,6,1,7,4,4,4,7} ; 
    public char[] names={'A' ,'B','C','C','C','C','c','c','c','v'};
    private static shared instance = null;
    shared() {


    }

    public static shared getInstance(){
        if(instance==null){
           instance = new shared();
          }
          return instance;
      }

}