package People;

import static People.People.queueBoys;
import static People.People.queueGirls;

/**
 * Created by Giulia on 17/05/2017.
 */
public class MeetingPoint extends Thread{
    private Person G;
    private Person B;

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
            }
            B = queueBoys.remove();
            G = queueGirls.remove();
            try {
                G.clone(B);
                B.clone(G);

            } catch (CannotHaveChildrenException e) {
            }

            G = null;
            B = null;

        }

    }
}
