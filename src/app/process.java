package app;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class process {

public int priority,arrival,remaining,burst ;
public char name ;




process(int p ,int a  , char n , int burst){

this.burst = burst ;
    priority = p ;
    remaining =burst ;
    arrival = a ;
    name = n ;
}


@Override
public boolean equals (Object p) {

    if(this.priority ==-1) {
  if(this.arrival >=  (( process ) p).arrival  ) return true ;
  else return false ;
    }

else {
    if(this.name ==  (( process ) p).name  ) return true ;
    else return false ;

}

 
}


}