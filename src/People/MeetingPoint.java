package People;

import static People.People.queueBoys;
import static People.People.queueGirls;

/**
 * Created by Giulia on 17/05/2017.
 */
public class MeetingPoint extends Thread{

    public static final int time = 100;

    private Person G;
    private Person B;
    Object bouncer;

    public MeetingPoint(){
        G = null;
        B = null;
    }

    public boolean isBusy(){
        if(G != null && B != null) return true;
        else return false;
    }


    public void run(){
        while(true){
            while((queueBoys.isEmpty() || queueGirls.isEmpty()) || isBusy()){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            B = queueBoys.remove();
            G = queueGirls.remove();

            LoveStory loveStory = new LoveStory(G,B);
            loveStory.start();




            try {
                sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
