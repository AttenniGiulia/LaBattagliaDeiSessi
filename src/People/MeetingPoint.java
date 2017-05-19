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
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            B = queueBoys.remove();
            G = queueGirls.remove();
            System.out.println(G.getClass().getSimpleName()  + B.getClass().getSimpleName()+ " popped ");

            try {
                G.clone(B);
                B.clone(G);
                System.out.println(G.getClass().getSimpleName() + " and " + B.getClass().getSimpleName());
            } catch (CannotHaveChildrenException e) {
                System.out.println(G.getClass().getSimpleName() + B.getClass().getSimpleName()+ " something got wrong");
            }

            G = null;
            B = null;

        }

    }
}
