/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Stopwatch {
    int interval;
                Timer timer;
    public Stopwatch(){
        timer =new Timer();
      
}
public  void stopwatche(int time , final int id) {
    
   
    
    int delay = 1000;
    int period = 1000;
    interval= time*60;

    timer.scheduleAtFixedRate(new TimerTask() {

        public void run() {
            
            System.out.println(setInterval(id));

        }
    }, delay, period);
}

private  final String setInterval(int id) {
    if (interval == 1){
        timer.cancel();
       
       
//        System.out.println("i is : " + i);
        for (int i =0;i < main_fram.wait.length ; i++) {
           
          if( main_fram.wait[i].id == id ){
             main_fram.waits[i] = main_fram.waits[i].replaceAll("Waiting","OK" );
              
          main_fram.jList3.setModel(new javax.swing.AbstractListModel() {

    public int getSize() { return  main_fram.waits.length; }
    public Object getElementAt(int i) { return  main_fram.waits[i]; }
    
});
          }
        }
    }
    String s = "" +interval/60+":"+interval%60;
    
            --interval;
            return s;
}
}