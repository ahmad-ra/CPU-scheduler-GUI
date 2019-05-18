


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
 JFrame t = this ;
 JPanel tp;
myFrame(){
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension dim = tk.getScreenSize();
    this.setSize(dim.width ,dim.height);
    this.setLocationRelativeTo(null);
    this.setTitle("CPU_SCHEDULER");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    
JPanel mainPanel = new JPanel();
tp=mainPanel;
mainPanel.setLayout(null);


mainPanel.add( new Main_2()) ;
drawPanel ahmad = new drawPanel();
ahmad.setBounds(500,0,1000,1000);
mainPanel.add( ahmad) ;
this.add(mainPanel) ;
this.setVisible(true);


JButton reset = new JButton("Restart");
reset.addActionListener(new resetListener());
reset.setBounds(40, 700, 100, 60);
reset.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
reset.setVisible(true);



}
    



private class resetListener implements ActionListener {
	public resetListener() {
		

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		t.dispose();
		new myFrame();
		shared.getInstance().gant.clear();
		shared.getInstance().changing.clear();
		   tp.revalidate();
		   tp.getParent().repaint();
		   t.revalidate();
		   t.getParent().repaint();
		
	}


	
}
}

// package app;

// import java.awt.Button;
// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.Toolkit;
// import java.awt.Window;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.event.FocusEvent;
// import java.awt.event.FocusListener;
// import java.awt.image.ImageObserver;
// import java.text.AttributedCharacterIterator;

// import javax.swing.*;
// import javax.swing.border.*;
// import java.awt.BorderLayout;
// import java.awt.Dimension;
// import java.awt.FlowLayout;
// import java.awt.Font;
// import java.awt.FontMetrics;
// import java.awt.Frame;
// import java.awt.Graphics;
// import java.awt.Graphics2D;
// import java.awt.GridLayout;
// import java.awt.Image;
// import java.awt.Rectangle;
// import java.awt.ScrollPane;
// import java.awt.Shape;



// public class myFrame extends JFrame {
 
// myFrame(){
//     Toolkit tk = Toolkit.getDefaultToolkit();
//     Dimension dim = tk.getScreenSize();
//     this.setSize(dim.width ,dim.height);
//     this.setLocationRelativeTo(null);
//     this.setTitle("CPU_SCHEDULER");
//     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    
// JPanel mainPanel = new JPanel();
// mainPanel.setLayout(new GridLayout(1,2));
// mainPanel.add( new formPanel()) ;


// mainPanel.add( new drawPanel()) ;
// this.add(mainPanel) ;
// this.setVisible(true);

// }
    
// }