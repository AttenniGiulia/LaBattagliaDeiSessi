package People;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Giulia on 17/05/2017.
 */
public class MeetingPoint {
    private Person G;
    private Person B;
    private Queue queueGirls = new LinkedList();
    private Queue queueBoys = new LinkedList();

    MeetingPoint(){
        G = null;
        B = null;
    }

    public boolean isBusy(){
        if(G != null && B != null) return true;
        else return false;
    }
    public synchronized void entry() throws InterruptedException{
        while (isBusy()){
            wait();
        }

    }
}
