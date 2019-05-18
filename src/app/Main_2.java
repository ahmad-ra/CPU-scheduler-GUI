package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

//import com.sun.javafx.geom.RoundRectangle2D;

import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

//import com.sun.javafx.geom.RoundRectangle2D;

import javax.swing.table.*;
//JButton() Constructors:
//JButton()
//JButton(string s)
//JButton(Icon i)

//JButton() Methods:
//public void setText(String s)
//public void setEnabled(boolean b)
//public void setIcon(Icon i)
//public void getIcon()
//public String getText()
//public void addActionListener(ActionListener a)

//JRadioButton() Constructors:
//JButton()
//JRadioButton(string s)
//JRadioButton(string s,boolean b)

//JButton() Methods:
//public void setText(String s)
//public void setEnabled(boolean b)
//public void setIcon(Icon i)
//public void getIcon()
//public String getText()
//public void addActionListener(ActionListener a)

public class Main_2 extends JPanel {
	JButton addLive;
	JButton stopLive;
	char index = 'A';
	int integer_index = 0;
	int sliceI;
	static boolean resetFlag = true;
	JPanel frame = this;
	JButton start = new JButton("Start");

	JButton select1 = new JButton("Confirm");
	JButton select2 = new JButton("Confirm");
	JButton add = new JButton("ADD");
	JRadioButton static_1 = new JRadioButton("Static");
	JRadioButton dynamic = new JRadioButton("Dynamic");
	JRadioButton FCFS = new JRadioButton("FCFS");
	JRadioButton SJF = new JRadioButton("SJF");
	JRadioButton Piority = new JRadioButton("Piority");
	JRadioButton Round_Robin = new JRadioButton("Round Robin");
	JRadioButton preemptive = new JRadioButton("Preemptive");
	JRadioButton nonpreemptive = new JRadioButton("Non-Preemptive");

	JLabel label2 = new JLabel("     Please choose Preemptive or Non-Preemptive: ");
	SpinnerNumberModel model1 = new SpinnerNumberModel(0, 0.0, 100.0, 1.0);
	JSpinner arrival_time = new JSpinner(model1);
	SpinnerNumberModel model2 = new SpinnerNumberModel(1.0, 1.0, 100.0, 1.0);
	JSpinner burst_time = new JSpinner(model2);
	JLabel arrival = new JLabel("Arrival Time");
	JLabel burst = new JLabel("Burst Time");
	JLabel wait = new JLabel("Average Waiting Time:");
	JLabel wait_label = new JLabel("");
	SpinnerNumberModel model3 = new SpinnerNumberModel(1.0, 1.0, 100.0, 1.0);
	JSpinner slice_time = new JSpinner(model3);
	JLabel slice = new JLabel("Slice Time");
	JSpinner priority = new JSpinner(model3);
	JLabel priority_label = new JLabel("Priority");
	Vector<String> onerow = new Vector<String>();
	Vector<Vector<String>> rows = new Vector<Vector<String>>();
	Vector<String> headers = new Vector<String>();
	JPanel Prem = new JPanel();

	Main_2() {
		index = 'A';
		integer_index = 0;
		// jtextarea
		// textArea.setFont(new Font("Monaco", Font.PLAIN, 20));

		// jlabel

		// label1.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		// jlist
		// list.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));

		// *this.add(this) ;
		headers.addElement("ID");
		headers.addElement("Arrival Time");
		headers.addElement("Burst Time");

		/*
		 * onerow.addElement("ID"); onerow.addElement("Arrival Time");
		 * onerow.addElement("Burst Time"); rows.add(onerow);
		 */
		preemptive.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		nonpreemptive.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		JTable table = new JTable(rows, headers);
		table.setBounds(40, 340, 200, 200);
		table.setVisible(true);
		JScrollPane scroll = new JScrollPane();
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(20);
		columnModel.getColumn(1).setPreferredWidth(80);
		columnModel.getColumn(2).setPreferredWidth(80);
		scroll.getViewport().add(table);
		scroll.setBounds(40, 340, 260, 200);
		this.add(scroll);
		// this.add(table);

		arrival_time.setBounds(40, 240, 80, 60);
		burst_time.setBounds(140, 240, 80, 60);
		slice_time.setBounds(240, 240, 80, 60);
		priority.setBounds(240, 240, 80, 60);
		arrival_time.setVisible(false);
		burst_time.setVisible(false);
		slice_time.setVisible(false);
		priority.setVisible(false);
		arrival.setBounds(40, 200, 80, 60);
		burst.setBounds(140, 200, 80, 60);
		arrival.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
		burst.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
		slice.setBounds(240, 200, 80, 60);
		priority_label.setBounds(240, 200, 80, 60);
		arrival.setVisible(false);
		burst.setVisible(false);
		slice.setVisible(false);
		priority_label.setVisible(false);
		arrival.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		burst.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		slice.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		priority_label.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		FCFS.setBounds(40, 40, 80, 40);
		SJF.setBounds(140, 40, 80, 40);
		static_1.setBounds(440, 50, 100, 20);
		dynamic.setBounds(440, 80, 100, 20);
		add.setBounds(340, 240, 80, 60);
		add.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		add.setVisible(false);
		Piority.setBounds(240, 40, 80, 40);
		Round_Robin.setBounds(340, 40, 180, 40);
		preemptive.setBounds(0, 140, 120, 40);
		nonpreemptive.setBounds(200, 140, 180, 40);
		ButtonGroup buttonGroup = new ButtonGroup();
		ButtonGroup staticGroup = new ButtonGroup();
		ButtonGroup buttonGrouppreemptive = new ButtonGroup();
		JLabel label1 = new JLabel("     Please choose the Scheduling Algorithm: ");
		label1.setBounds(20, 0, 800, 40);
		label1.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		FCFS.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		SJF.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		static_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		dynamic.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		Piority.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		Round_Robin.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		select1.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		select2.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		start.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		// reset.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		label1.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		label2.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		label2.setBounds(20, 100, 760, 40);
		label2.setVisible(false);

		this.add(label1);
		this.add(label2);
		this.add(arrival_time);
		this.add(burst_time);
		this.add(arrival);
		this.add(burst);
		this.add(add);
		this.add(slice_time);
		this.add(slice);
		this.add(priority);
		this.add(priority_label);
		buttonGroup.add(FCFS);
		buttonGroup.add(SJF);
		buttonGroup.add(Piority);
		buttonGroup.add(Round_Robin);
		staticGroup.add(static_1);
		staticGroup.add(dynamic);
		buttonGrouppreemptive.add(preemptive);
		buttonGrouppreemptive.add(nonpreemptive);
		Border operBorder = BorderFactory.createTitledBorder("Alg.");
		Border premBorder = BorderFactory.createTitledBorder("Pre.");
		JPanel Alg = new JPanel();
		Alg.add(FCFS);
		Alg.add(SJF);
		Alg.add(Piority);
		Alg.add(Round_Robin);
		Alg.setBorder(operBorder);
		Alg.setBounds(50, 40, 350, 60);
		Prem.add(preemptive);
		Prem.add(nonpreemptive);
		Prem.setBorder(premBorder);
		Prem.setBounds(50, 140, 350, 60);
		Prem.setVisible(false);
		this.add(Prem);
		this.add(Alg);
		this.add(static_1);
		this.add(dynamic);
		// preemptive.setVisible(false);
		// nonpreemptive.setVisible(false);
		preemptive.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		;
		nonpreemptive.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		;
		// this.add(preemptive);
		// this.add(nonpreemptive);
		start.setBounds(40, 600, 100, 60);
		// reset.setBounds(240, 600, 100, 60);
		start.addActionListener(new startListener());

		select1.setBounds(550, 40, 100, 40);
		select2.setBounds(550, 140, 100, 40);
		add.addActionListener(new AddListener());
		select1.addActionListener(new select1Listener());
		select2.addActionListener(new select2Listener());
		select2.setVisible(false);
		this.add(select1);
		this.add(select2);
		this.add(start);
		// this.add(reset);
		// this.setSize(800,700);
		this.setBounds(0, 0, 800, 700);
		this.setLayout(null);
		this.setVisible(true);
		wait.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		wait_label.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		wait.setBounds(20, 540, 200, 60);
		wait_label.setBounds(180, 540, 100, 60);
		this.add(wait);
		this.add(wait_label);
		stopLive = new JButton("stop!");
		stopLive.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timer.cancel();
			}
		});

		stopLive.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		stopLive.setBounds(300, 550, 90, 30);
		stopLive.setVisible(false);
		this.add(stopLive);

		JButton res = new JButton("Restart");
		res.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				shared.getInstance().gant.clear();
				shared.getInstance().changing.clear();
				shared.getInstance().all.clear();
				index = 'A';
				integer_index = 0;

				FCFS.setEnabled(true);
				SJF.setEnabled(true);
				Piority.setEnabled(true);
				Round_Robin.setEnabled(true);
				Prem.setVisible(false);
				preemptive.setVisible(false);
				nonpreemptive.setVisible(false);
				label2.setVisible(false);
				select2.setVisible(false);
				static_1.setEnabled(true);
				dynamic.setEnabled(true);

				arrival_time.setVisible(false);
				burst_time.setVisible(false);
				add.setVisible(false);
				arrival.setVisible(false);
				burst.setVisible(false);
				if (Piority.isSelected()) {
					priority.setVisible(false);
					priority_label.setVisible(false);
				}

				slice_time.setVisible(false);
				slice.setVisible(false);

				JTable table = new JTable(rows, headers);
				table.setBounds(40, 340, 200, 200);
				table.setVisible(true);
				JScrollPane scroll = new JScrollPane();
				TableColumnModel columnModel = table.getColumnModel();
				columnModel.getColumn(0).setPreferredWidth(20);
				columnModel.getColumn(1).setPreferredWidth(80);
				columnModel.getColumn(2).setPreferredWidth(80);
				scroll.getViewport().add(table);
				scroll.setBounds(40, 340, 260, 200);
				my.add(scroll);
				rows = new Vector<Vector<String>>();

				preemptive.setEnabled(true);
				nonpreemptive.setEnabled(true);

				add.setText("ADD");
				stopLive.setVisible(false);

				a.totalTime = 0;
				pri.currentTime = 0;

				try {
					timer.cancel();
				} catch (NullPointerException de) {

				}

				liveOn = 0;
			}
		});

		res.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		res.setBounds(390, 550, 90, 30);

		this.add(res);

	}

	// public static void main(String[] args) {
	//
	// Main_2 Main = new Main_2();
	//
	// aa.add(Main) ;
	// }

	private class select1Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (FCFS.isSelected()) {

				FCFS.setEnabled(false);
				SJF.setEnabled(false);
				static_1.setEnabled(false);
				dynamic.setEnabled(false);
				Piority.setEnabled(false);
				Round_Robin.setEnabled(false);
				arrival_time.setVisible(true);
				burst_time.setVisible(true);
				add.setVisible(true);
				arrival.setVisible(true);
				burst.setVisible(true);
			}
			if (SJF.isSelected()) {

				FCFS.setEnabled(false);
				SJF.setEnabled(false);
				Piority.setEnabled(false);
				Round_Robin.setEnabled(false);
				Prem.setVisible(true);
				preemptive.setVisible(true);
				nonpreemptive.setVisible(true);
				label2.setVisible(true);
				select2.setVisible(true);
				static_1.setEnabled(false);
				dynamic.setEnabled(false);

			}
			if (Piority.isSelected()) {

				FCFS.setEnabled(false);
				SJF.setEnabled(false);
				Piority.setEnabled(false);
				Round_Robin.setEnabled(false);
				Prem.setVisible(true);
				preemptive.setVisible(true);
				nonpreemptive.setVisible(true);
				label2.setVisible(true);
				select2.setVisible(true);
				static_1.setEnabled(false);
				dynamic.setEnabled(false);

			}
			if (Round_Robin.isSelected()) {

				FCFS.setEnabled(false);
				SJF.setEnabled(false);
				Piority.setEnabled(false);
				Round_Robin.setEnabled(false);
				arrival_time.setVisible(true);
				burst_time.setVisible(true);
				add.setVisible(true);
				arrival.setVisible(true);
				burst.setVisible(true);
				slice_time.setVisible(true);
				slice.setVisible(true);
				static_1.setEnabled(false);
				dynamic.setEnabled(false);
			}
		}
	}

	private class select2Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (preemptive.isSelected()) {
				preemptive.setEnabled(false);
				nonpreemptive.setEnabled(false);
				arrival_time.setVisible(true);
				burst_time.setVisible(true);
				add.setVisible(true);
				arrival.setVisible(true);
				burst.setVisible(true);
				if (Piority.isSelected()) {
					priority.setVisible(true);
					priority_label.setVisible(true);
				}
			}
			if (nonpreemptive.isSelected()) {
				preemptive.setEnabled(false);
				nonpreemptive.setEnabled(false);
				arrival_time.setVisible(true);
				burst_time.setVisible(true);
				add.setVisible(true);
				arrival.setVisible(true);
				burst.setVisible(true);
				if (Piority.isSelected()) {
					priority.setVisible(true);
					priority_label.setVisible(true);
				}
			}
		}
	}

	JPanel my = this;
	CPU pri = new CPU(0, shared.cpuType.PRIORITY_PRE);
	shared a = shared.getInstance();
	int fake = 0;
	Timer timer;
	Object lock = new Object();

	private class startListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			shared a = shared.getInstance();
			String wait1 = String.valueOf(shared.getInstance().waitingtime);
			wait_label.setText(wait1);

			if (static_1.isSelected()) {
				if (FCFS.isSelected()) {
					a.sortByArrivalTime_fcfs(a.all);
					pri.fcfs(a.all);
					my.revalidate();
					my.getParent().repaint();
					wait_label.setText(String.valueOf(shared.getInstance().waitingtime));
				} else if (Round_Robin.isSelected()) {
					a.sortByArrivalTime_rr(a.all);
					pri.rr(a.all, sliceI);
					my.revalidate();
					my.getParent().repaint();
					wait_label.setText(String.valueOf(shared.getInstance().waitingtime));
				} else if (SJF.isSelected()) {
					if (preemptive.isSelected()) {
						a.sortByArrivalTime(a.all);
						pri.sjf_pre(a.all);
						my.revalidate();
						my.getParent().repaint();
						wait_label.setText(String.valueOf(shared.getInstance().waitingtime));
					} else if (nonpreemptive.isSelected()) {
						a.sortByArrivalTime_sjf(a.all);
						a.sortBySjf(a.all);
						pri.sjf(a.all);
						my.revalidate();
						my.getParent().repaint();
						wait_label.setText(String.valueOf(shared.getInstance().waitingtime));
					}
				} else if (Piority.isSelected()) {
					if (preemptive.isSelected()) {
						a.sortByArrivalTime(a.all);
						pri.priority_pre(a.all);
						my.revalidate();
						my.getParent().repaint();
						wait_label.setText(String.valueOf(shared.getInstance().waitingtime));
					} else if (nonpreemptive.isSelected()) {
						a.sortByArrivalTime_piority(a.all);
						a.sortByPiority(a.all);
						pri.piority(a.all);
						my.revalidate();
						my.getParent().repaint();
						wait_label.setText(String.valueOf(shared.getInstance().waitingtime));
					}
				}

			} else if (dynamic.isSelected()) {
				liveOn = 1;
				timer = new Timer();
				// addLive.setVisible(true );
				add.setText("Add On The Go");
				add.setSize(150, 30);
				stopLive.setVisible(true);

				a.sortByArrivalTime(a.all);
				shared.getInstance().deepCopyProcess(a.all, a.changing);
				a.gant.clear();
				// Timer timer = new Timer();
				int begin = 0;
				int timeInterval = 1000;

				if (FCFS.isSelected()) {
					timer.schedule(new TimerTask() {
						int counter = 0;
						int currentTime = 0;

						@Override
						public void run() {

							// call the method
							// pri.priority_preOneCycle(a.all);
							Main_2.this.pri.FCFS_OneCycle(currentTime);
							// pri.priority_preOneCycle(currentTime);
							// pri.priority_nonPreOneCycle(currentTime);
							// pri.SJF_preOneCycle(currentTime);
							// pri.RR_live (currentTime , 1 ,procs ) ;
							// counter++;
							currentTime++;
							// if(a.gant.get(a.gant.size()-1).name == 'N') counter -- ; //if CPU is IDlE
							// this loop doesn't count

							my.revalidate();
							my.getParent().repaint();

						}
					}, begin, timeInterval);

				} else if (Round_Robin.isSelected()) {

				} else if (SJF.isSelected()) {
					if (preemptive.isSelected()) {
						timer.schedule(new TimerTask() {
							int counter = 0;
							int currentTime = 0;

							@Override
							public void run() {
								// call the method
								// pri.priority_preOneCycle(a.all);
								// pri.priority_preOneCycle(currentTime);
								// pri.priority_nonPreOneCycle(currentTime);
								pri.SJF_preOneCycle(currentTime);
								// pri.RR_live (currentTime , 1 ,procs ) ;
								counter++;
								currentTime++;
								if (a.gant.get(a.gant.size() - 1).name == 'N')
									counter--; // if CPU is IDlE this loop doesn't count

								my.revalidate();
								my.getParent().repaint();

							}
						}, begin, timeInterval);

					} else if (nonpreemptive.isSelected()) {
						timer.schedule(new TimerTask() {
							int counter = 0;
							int currentTime = 0;

							@Override
							public void run() {
								// call the method
								// pri.priority_preOneCycle(a.all);
								// pri.priority_preOneCycle(currentTime);
								// pri.priority_nonPreOneCycle(currentTime);
								pri.SJF_nonPreOneCycle(currentTime);
								// pri.RR_live (currentTime , 1 ,procs ) ;
								counter++;
								currentTime++;
								if (a.gant.get(a.gant.size() - 1).name == 'N')
									counter--; // if CPU is IDlE this loop doesn't count

								my.revalidate();
								my.getParent().repaint();

							}
						}, begin, timeInterval);

					}
				} else if (Piority.isSelected()) {
					if (preemptive.isSelected()) {
						timer.schedule(new TimerTask() {
							int counter = 0;
							int currentTime = 0;

							@Override
							public void run() {
								// call the method
								// pri.priority_preOneCycle(a.all);
					
								pri.priority_preOneCycle(currentTime);

								// pri.priority_nonPreOneCycle(currentTime);
								// pri.SJF_preOneCycle(currentTime);
								  // pri.RR_live (currentTime , 1 ,procs ) ;
							 counter++;
							  currentTime ++ ;
						//	 if(a.gant.get(a.gant.size()-1).name == 'N') counter --  ; //if CPU is IDlE this loop doesn't count
				
							 my.revalidate();
							 my.getParent().repaint();
							 

						 }
					  }, begin, timeInterval);
		
		
					}
					else if(nonpreemptive.isSelected())
					{
						timer.schedule(new TimerTask() {
							int counter = 0;
							int currentTime = 0;
		
							@Override
							public void run() {
								// call the method
								// pri.priority_preOneCycle(a.all);
								//pri.priority_preOneCycle(currentTime);
								 pri.priority_nonPreOneCycle(currentTime);
								// pri.SJF_preOneCycle(currentTime);
								  // pri.RR_live (currentTime , 1 ,procs ) ;
							 counter++;
							  currentTime ++ ;
							 if(a.gant.get(a.gant.size()-1).name == 'N') counter --  ; //if CPU is IDlE this loop doesn't count
				
							 my.revalidate();
							 my.getParent().repaint();
						 }
					  }, begin, timeInterval);
		
						
		
					}			
			}
			
			
		}

	}
	}
	int liveOn = 0;
	private class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// data[integer_index][0]=Character.toString(index);
			// data[integer_index][1]=arrival_time.getValue().toString();
			// data[integer_index][2]=burst_time.getValue().toString();
			//process(int arriv , int priori ,int burs ,int rem, char inde)
		    //int p ,int a  , char n , int burst
			String pri=priority.getValue().toString();
			String arv=arrival_time.getValue().toString();
			String brst=burst_time.getValue().toString();
			String slice=slice_time.getValue().toString();
			int priI=Double.valueOf(pri).intValue();
			int arvI=Double.valueOf(arv).intValue();
			int brstI=Double.valueOf(brst).intValue();
			sliceI=Double.valueOf(slice).intValue();
			process temp = new process( priI,arvI,index,brstI);
			shared processes = shared.getInstance();
			if(dynamic.isSelected() && liveOn ==1 ) {
				 temp.arrival = Main_2.this.pri.currentTime ;
				 
			processes.changing.add(temp);
			processes.all.add(temp);

			}

			else if(dynamic.isSelected() && liveOn ==0 ){

				processes.all.add(temp);

			}

			else {
				processes.all.add(temp);
			}
			//   process[] processes = new process[4];
		    //	processes.processes[0]=temp;
			//processes.size++;
			processes.totalTime +=brstI ;
			Vector<String> tworow = new Vector<String>();
			tworow.addElement(Character.toString(index));
			tworow.addElement(arrival_time.getValue().toString());
			tworow.addElement(burst_time.getValue().toString());
			index++;
			integer_index++;
			rows.add(tworow);
			JTable table = new JTable(rows, headers);
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(20);
			columnModel.getColumn(1).setPreferredWidth(80);
			columnModel.getColumn(2).setPreferredWidth(80);
			JScrollPane scroll = new JScrollPane();
			scroll.getViewport().add(table);
			scroll.setBounds(40, 340, 260, 200);
			scroll.setVisible(true);
			frame.add(scroll);
			/*
			 * JTable table = new JTable(rows, headers); table.setBounds(540,440,300,400);
			 * table.setVisible(true); this.add(table);
			 */

		}
	}

	

}
