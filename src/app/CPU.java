package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

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

class CPU extends Thread {
	shared.cpuType type;
	int quantum;
	int currentTime = 0;
	Object lock;
	shared a = shared.getInstance();

	CPU(int quantum, shared.cpuType type) {

		this.quantum = quantum;
		this.type = type;
	}

	@Override
	public void run() {

		super.run();
		// this.priority_pre(a.all) ;
	}

	public void priority_pre(ArrayList<process> procs) {

		// deep copy all to changing
		a.changing.clear();

		for (int it = 0; it < a.all.size(); it++) {
			process p = new process(a.all.get(it).priority, a.all.get(it).arrival, a.all.get(it).name,
					a.all.get(it).burst);

			a.changing.add(p);
		}
		//////////////////////////

		ArrayList<process> gant = new ArrayList<process>(30);
		process now;
		int j, nowIndex = -1;
		int[] turnarround = new int[30];
		int nullSeconds = 0;
		int current_time_null = 0;
		for (int i = 0; i < shared.getInstance().totalTime; i++) {
			currentTime = i;
			if (i != 0 && nowIndex != -1) {
				a.changing.get(nowIndex).remaining -= 1;
				if ((a.changing.get(nowIndex).remaining) == 0) {
					a.changing.remove(nowIndex);
				}
			}

			j = a.changing.lastIndexOf(new process(-1, i, 'N', 7));
			if (j == -1) {
				now = new process(0, i, 'N', 1);
				nowIndex = -1;
				a.totalTime++;
				nullSeconds++;
				current_time_null++;
			} else {
				now = a.changing.get(0);
				nowIndex = 0;
			}
			for (int k = 1; k <= j; k++) {

				if (a.changing.get(k).priority < now.priority) {
					now = a.changing.get(k);
					nowIndex = k;
				}

			}

			gant.add(now);
			turnarround[i] = current_time_null;
		}

		a.totalTime -= nullSeconds;
		a.gant.clear();
		a.gant = gant;
		double wait = 0;
		for (int i = 0; i < a.all.size(); i++) {
			wait += turnarround[i] - a.all.get(i).arrival - a.all.get(i).burst;
		}
		a.waitingtime = wait / a.all.size();
	}

	public void sjf_pre(ArrayList<process> procs) {

		// deep copy all to changing
		a.changing.clear();

		for (int it = 0; it < a.all.size(); it++) {
			process p = new process(a.all.get(it).priority, a.all.get(it).arrival, a.all.get(it).name,
					a.all.get(it).burst);

			a.changing.add(p);
		}
		//////////////////////////

		ArrayList<process> gant = new ArrayList<process>(30);
		process now;
		int[] turnarround = new int[30];
		int j, nowIndex = -1;
		int nullSeconds = 0;
		int current_time_null = 0;
		for (int i = 0; i < shared.getInstance().totalTime; i++) {
			currentTime = i;
			if (i != 0 && nowIndex != -1) {
				a.changing.get(nowIndex).remaining -= 1;
				if ((a.changing.get(nowIndex).remaining) == 0) {
					a.changing.remove(nowIndex);
				}
			}

			j = a.changing.lastIndexOf(new process(-1, i, 'N', 7));
			if (j == -1) {
				now = new process(0, i, 'N', 1);
				nowIndex = -1;
				a.totalTime++;
				nullSeconds++;
				current_time_null++;
			} else {
				now = a.changing.get(0);
				nowIndex = 0;
			}
			for (int k = 1; k <= j; k++) {

				if (a.changing.get(k).burst < now.burst) {
					now = a.changing.get(k);
					nowIndex = k;
					current_time_null++;
				}

			}

			gant.add(now);
			turnarround[i] = current_time_null;
		}

		a.totalTime -= nullSeconds;
		a.gant.clear();
		a.gant = gant;
		double wait = 0;
		for (int i = 0; i < a.all.size(); i++) {
			wait += turnarround[i] - a.all.get(i).arrival - a.all.get(i).burst;
		}
		a.waitingtime = wait / a.all.size();

	}

	public void fcfs(ArrayList<process> procs) {

		// deep copy all to changing
		a.changing.clear();

		int nullSeconds = 0;
		for (int it = 0; it < a.all.size(); it++) {
			process p = new process(a.all.get(it).priority, a.all.get(it).arrival, a.all.get(it).name,
					a.all.get(it).burst);

			a.changing.add(p);
			a.totalTime += a.all.get(it).burst;
		}
		int[] turnarround = new int[30];
		int current_time = 0;
		int current_time_null = 0;
		ArrayList<process> gant = new ArrayList<process>(30);
		process now = new process(0, 0, 'N', 1);
		for (int i = 0; i < a.all.size(); i++) {
			while (a.changing.get(i).arrival > current_time) {
				now = new process(0, current_time, 'N', 1);
				gant.add(now);
				current_time++;
			}
			for (int j = 0; j < a.changing.get(i).burst; j++) {
				now = a.changing.get(i);
				gant.add(now);
				current_time++;
				current_time_null++;
			}
			turnarround[i] = current_time_null;

		}

		a.totalTime -= nullSeconds;
		a.gant.clear();
		a.gant = gant;
		double wait = 0;
		for (int i = 0; i < a.all.size(); i++) {
			wait += turnarround[i] - a.all.get(i).arrival - a.all.get(i).burst;
		}
		a.waitingtime = wait / a.all.size();

	}

	public void sjf(ArrayList<process> procs) {

		// deep copy all to changing
		a.changing.clear();
		int[] turnarround = new int[30];
		int totaltime = 0;
		int time = 0;
		int bursttime = 0;
		int nullSeconds = 0;
		for (int it = 0; it < a.all.size(); it++) {
			process p = new process(a.all.get(it).priority, a.all.get(it).arrival, a.all.get(it).name,
					a.all.get(it).burst);

			a.changing.add(p);
			a.totalTime += a.all.get(it).burst;
			bursttime += a.all.get(it).burst;
		}

		int current_time = 0;
		int current_time_null = 0;
		ArrayList<process> gant = new ArrayList<process>(30);
		process now = new process(0, 0, 'N', 1);
		for (int i = 0; i < a.all.size(); i++) {
			while (a.changing.get(i).arrival > current_time) {
				now = new process(0, current_time, 'N', 1);
				gant.add(now);
				current_time++;
			}
			for (int j = 0; j < a.changing.get(i).burst; j++) {
				now = a.changing.get(i);
				gant.add(now);
				current_time++;
				current_time_null++;
				totaltime++;
				time++;
			}
			turnarround[i] = current_time_null;
		}

		a.totalTime -= nullSeconds;
		a.gant.clear();
		a.gant = gant;
		double wait = 0;
		for (int i = 0; i < a.all.size(); i++) {
			wait += turnarround[i] - a.all.get(i).arrival - a.all.get(i).burst;
		}
		a.waitingtime = wait / a.all.size();
	}

	public void rr(ArrayList<process> procs, int slice) {

		// deep copy all to changing
		a.changing.clear();
		int[] turnarround = new int[30];
		int[] burst = new int[30];
		int nullSeconds = 0;
		int totaltime = 0;
		int bursttotal = 0;
		int time = 0;
		for (int it = 0; it < a.all.size(); it++) {
			process p = new process(a.all.get(it).priority, a.all.get(it).arrival, a.all.get(it).name,
					a.all.get(it).burst);

			a.changing.add(p);
			a.totalTime += a.all.get(it).burst;
			totaltime += a.all.get(it).burst;
			bursttotal += a.all.get(it).burst;
			burst[it] = a.all.get(it).burst;

		}

		int current_time = 0;
		ArrayList<process> gant = new ArrayList<process>(30);

		process now = new process(0, 0, 'N', 1);
		// for(int i=0 ; i<a.all.size(); i++)
		int i = 0;
		int current_time_null = 0;
		while (totaltime > 0) {
			while (a.changing.get(i).arrival > current_time) {
				now = new process(0, current_time, 'N', 1);
				gant.add(now);
				current_time++;
				// time++;
				// if(a.changing.get(i+1).arrival>=current_time)
				// break;
			}
			for (int j = 0; j < slice; j++) {
				if (burst[i] > 0) {
					now = a.changing.get(i);
					gant.add(now);
					current_time++;
					current_time_null++;
					time++;
				}
			}
			if (burst[i] > 0) {
				burst[i] -= slice;
				totaltime -= slice;
			}
			i++;
			if (i == a.all.size())
				i = 0;
			turnarround[i] = current_time_null;
		}
		a.waitingtime = time - bursttotal;
		a.totalTime -= nullSeconds;
		a.gant.clear();
		a.gant = gant;
		double wait = 0;
		for (int k = 0; k < a.all.size(); k++) {
			wait += turnarround[k] - a.all.get(k).arrival - a.all.get(k).burst;
		}
		a.waitingtime = wait / a.all.size();

	}

	public void piority(ArrayList<process> procs) {
		int[] turnarround = new int[30];
		// deep copy all to changing
		a.changing.clear();

		int nullSeconds = 0;
		for (int it = 0; it < a.all.size(); it++) {
			process p = new process(a.all.get(it).priority, a.all.get(it).arrival, a.all.get(it).name,
					a.all.get(it).burst);

			a.changing.add(p);
			a.totalTime += a.all.get(it).burst;
		}

		int current_time = 0;
		int current_time_null = 0;
		ArrayList<process> gant = new ArrayList<process>(30);
		process now = new process(0, 0, 'N', 1);
		for (int i = 0; i < a.all.size(); i++) {
			while (a.changing.get(i).arrival > current_time) {
				now = new process(0, current_time, 'N', 1);
				gant.add(now);
				current_time++;
			}
			for (int j = 0; j < a.changing.get(i).burst; j++) {
				now = a.changing.get(i);
				gant.add(now);
				current_time++;
			}
			turnarround[i] = current_time_null;
		}

		a.totalTime -= nullSeconds;
		a.gant.clear();
		a.gant = gant;
		double wait = 0;
		for (int i = 0; i < a.all.size(); i++) {
			wait += turnarround[i] - a.all.get(i).arrival - a.all.get(i).burst;
		}
		a.waitingtime = wait / a.all.size();
	}

	public synchronized void priority_preOneCycle(int currentT) {



	    this.currentTime = currentT ;
	// deep copy all to changing ////////////// 
	//  a.changing.clear();


	//  for(int it=0 ; it<a.all.size(); it++)
	//  {
//	      process p = new process(a.all.get(it).priority, a.all.get(it).arrival, a.all.get(it).name, a.all.get(it).burst);


//	      a.changing.add(p) ;
	//  }
	////////////////////////////////////////////////

	//////////////////get last process currently on cpu //////////////
	if(a.gant.size()!= 0) {
	process lastOnCpu = a.gant.get(a.gant.size()-1) ;
	 int lastOnCpuIndex ;
	 if (lastOnCpu.name !='N' ){

	    lastOnCpuIndex =a.changing.indexOf(new process(1, 1, lastOnCpu.name, 0)) ; //equals method of process acts on name property if priority property is not -1
	 a.changing.get(lastOnCpuIndex).remaining -=1 ;
	/* if it finished then remove it*/
	if(  a.changing.get(lastOnCpuIndex).remaining ==0) a.changing.remove(lastOnCpuIndex) ;
	}
	}
	//////////////////////////////////////////////////////

	//////////////////find next process to put on cpu////////////////////
	 int j; process nextProc ;
	 int nextIndex ;


	     j = a.changing.lastIndexOf(new process(-1, currentT, '1', 7));
	     if (j == -1) {
	         nextProc = new process(0, currentT, 'N', 1);
	         nextIndex = -1;
	     
	        
	     } else {
	         nextProc = a.changing.get(0);
	         nextIndex = 0;
	     }
	     for (int k = 1; k <= j; k++) {

	         if (a.changing.get(k).priority < nextProc.priority) {
	             nextProc = a.changing.get(k);
	             nextIndex = k;
	         }

	     }
	    
	     a.gant.add(nextProc);
	     
	 
	 
	 //a.gant.clear();
	//a.gant = gant;

	}





	public void priority_nonPreOneCycle( int currentT ) {
	this.currentTime = currentT ;


	//////////////////get last process currently on cpu //////////////
	if(a.gant.size()!= 0) {
	process lastOnCpu = a.gant.get(a.gant.size()-1) ;
	int lastOnCpuIndex ;
	if (lastOnCpu.name !='N' ){

	lastOnCpuIndex =a.changing.indexOf(new process(1, 1, lastOnCpu.name, 0)) ; //equals method of process acts on name property if priority property is not -1
	a.changing.get(lastOnCpuIndex).remaining -=1 ;
	/* if it finished then remove it*/
	if(  a.changing.get(lastOnCpuIndex).remaining ==0) a.changing.remove(lastOnCpuIndex) ;

	else { a.gant.add(lastOnCpu ) ; return ;}

	}
	}
	//////////////////////////////////////////////////////

	//////////////////find next process to put on cpu////////////////////
	int j; process nextProc ;
	int nextIndex ;


	 j = a.changing.lastIndexOf(new process(-1, currentT, '1', 7));
	 if (j == -1) {
	     nextProc = new process(0, currentT, 'N', 1);
	     nextIndex = -1;
	 
	    
	 } else {
	     nextProc = a.changing.get(0);
	     nextIndex = 0;
	 }
	 for (int k = 1; k <= j; k++) {

	     if (a.changing.get(k).priority < nextProc.priority) {
	         nextProc = a.changing.get(k);
	         nextIndex = k;
	     }

	 }

	 a.gant.add(nextProc);
	 


	//a.gant.clear();
	//a.gant = gant;

	}




	public void FCFS_OneCycle( int currentT ) {
	this.currentTime = currentT ;


	//////////////////get last process currently on cpu //////////////
	if(a.gant.size()!= 0) {
	process lastOnCpu = a.gant.get(a.gant.size()-1) ;
	int lastOnCpuIndex ;
	if (lastOnCpu.name !='N' ){

	lastOnCpuIndex =a.changing.indexOf(new process(1, 1, lastOnCpu.name, 0)) ; //equals method of process acts on name property if priority property is not -1
	a.changing.get(lastOnCpuIndex).remaining -=1 ;
	/* if it finished then remove it*/
	if(  a.changing.get(lastOnCpuIndex).remaining ==0) a.changing.remove(lastOnCpuIndex) ;

	//else {a.gant.add(new process(0, currentT, 'N', 1) ); return ;}

	}
	}
	//////////////////////////////////////////////////////

	//////////////////find next process to put on cpu////////////////////
	int j; process nextProc ;
	int nextIndex ;


	 j = a.changing.lastIndexOf(new process(-1, currentT, '1', 7));
	 if (j == -1) {
	     nextProc = new process(0, currentT, 'N', 1);
	     nextIndex = -1;
	 
	    
	 } else {
	     nextProc = a.changing.get(0);
	     nextIndex = 0;
	 }
	 for (int k = 1; k <= j; k++) {

	     if (a.changing.get(k).arrival < nextProc.arrival) { //edit here from priority non pre
	         nextProc = a.changing.get(k);
	         nextIndex = k;
	     }

	 }

	 a.gant.add(nextProc);
	 


	//a.gant.clear();
	//a.gant = gant;

	}




	public void SJF_preOneCycle( int currentT ) {
	this.currentTime = currentT ;
	// deep copy all to changing ////////////// 
	//  a.changing.clear();


	//  for(int it=0 ; it<a.all.size(); it++)
	//  {
//	      process p = new process(a.all.get(it).priority, a.all.get(it).arrival, a.all.get(it).name, a.all.get(it).burst);


//	      a.changing.add(p) ;
	//  }
	////////////////////////////////////////////////

	//////////////////get last process currently on cpu //////////////
	if(a.gant.size()!= 0) {
	process lastOnCpu = a.gant.get(a.gant.size()-1) ;
	int lastOnCpuIndex ;
	if (lastOnCpu.name !='N' ){

	lastOnCpuIndex =a.changing.indexOf(new process(1, 1, lastOnCpu.name, 0)) ; //equals method of process acts on name property if priority property is not -1
	a.changing.get(lastOnCpuIndex).remaining -=1 ;
	/* if it finished then remove it*/
	if(  a.changing.get(lastOnCpuIndex).remaining ==0) a.changing.remove(lastOnCpuIndex) ;
	}
	}
	//////////////////////////////////////////////////////

	//////////////////find next process to put on cpu////////////////////
	int j; process nextProc ;
	int nextIndex ;


	 j = a.changing.lastIndexOf(new process(-1, currentT, '1', 7));
	 if (j == -1) {
	     nextProc = new process(0, currentT, 'N', 1);
	     nextIndex = -1;
	 
	    
	 } else {
	     nextProc = a.changing.get(0);
	     nextIndex = 0;
	 }
	 for (int k = 1; k <= j; k++) {

	     if (a.changing.get(k).remaining < nextProc.remaining) {
	         nextProc = a.changing.get(k);
	         nextIndex = k;
	     }

	 }

	 a.gant.add(nextProc);
	 


	//a.gant.clear();
	//a.gant = gant;

	}




	public void SJF_nonPreOneCycle( int currentT ) {
	this.currentTime = currentT ;


	//////////////////get last process currently on cpu //////////////
	if(a.gant.size()!= 0) {
	process lastOnCpu = a.gant.get(a.gant.size()-1) ;
	int lastOnCpuIndex ;
	if (lastOnCpu.name !='N' ){

	lastOnCpuIndex =a.changing.indexOf(new process(1, 1, lastOnCpu.name, 0)) ; //equals method of process acts on name property if priority property is not -1
	a.changing.get(lastOnCpuIndex).remaining -=1 ;
	/* if it finished then remove it*/
	if(  a.changing.get(lastOnCpuIndex).remaining ==0) a.changing.remove(lastOnCpuIndex) ;

	else {return ;}

	}
	}
	//////////////////////////////////////////////////////

	//////////////////find next process to put on cpu////////////////////
	int j; process nextProc ;
	int nextIndex ;


	 j = a.changing.lastIndexOf(new process(-1, currentT, '1', 7));
	 if (j == -1) {
	     nextProc = new process(0, currentT, 'N', 1);
	     nextIndex = -1;
	 
	    
	 } else {
	     nextProc = a.changing.get(0);
	     nextIndex = 0;
	 }
	 for (int k = 1; k <= j; k++) {

	     if (a.changing.get(k).remaining < nextProc.remaining) {
	         nextProc = a.changing.get(k);
	         nextIndex = k;
	     }

	 }

	 a.gant.add(nextProc);
	 


	//a.gant.clear();
	//a.gant = gant;

	}



	public void RR_live (int currentT , int quantum ,Queue <process> procs ){

	process nowOnCpu = procs.peek() ;
	process nextOnCPu ;

	if(currentT % quantum ==0  && currentT != 0 )
	{
	if(nowOnCpu.remaining != 0) {
	    procs.add(    procs.poll()) ;
	}

	else { procs.poll() ;}

	}




	nextOnCPu = procs.peek() ;


	a.gant.add(nextOnCPu) ;


	}







}