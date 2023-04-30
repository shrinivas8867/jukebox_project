package Model;

import java.util.Timer;
import java.util.TimerTask;

public class Timers {
    Timer timer=new Timer();
    int x = 0;
    int count=0;

    TimerTask task=new TimerTask() {
        public void run() {
            x++;
            System.out.print(x+",");


        }
    };
    public void runTime(int songtime){
        timer.schedule(task,0,1000/songtime);
    }
    public void cancle(){
        timer.cancel();
    }
    public void pouse(){
        timer.purge();

    }
}
