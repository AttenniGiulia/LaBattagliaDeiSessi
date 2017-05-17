package People;

import java.util.LinkedList;
import java.util.Queue;

import static People.People.queueBoys;
import static People.People.queueGirls;

/**
 * Created by Giulia on 17/05/2017.
 */
public abstract class MeetingPoint {
    private Person G;
    private Person B;


    MeetingPoint(){
        G = null;
        B = null;
    }

    public boolean isBusy(){
        if(G != null && B != null) return true;
        else return false;
    }

    public void entry() throws InterruptedException{
        Thread.currentThread().sleep(2000);
        while(!queueGirls.isEmpty() || !queueBoys.isEmpty()){
            while (isBusy()){
                wait();
            }
            if(!queueBoys.isEmpty() && !queueGirls.isEmpty()){
                if (G == null) G = queueGirls.remove();
                if (B == null) B = queueBoys.remove();
                LoveStory loveStory = new LoveStory(G, B);
                loveStory.start();
                G = null;
                B = null;

            }

        }
    }
}
