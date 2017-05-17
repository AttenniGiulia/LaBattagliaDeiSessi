package People;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Giulia on 17/05/2017.
 */
public class MeetingPoint {
    private Person G;
    private Person B;
    private Queue<Person> queueGirls = new LinkedList<Person>();
    private Queue<Person> queueBoys = new LinkedList<Person>();

    MeetingPoint(){
        G = null;
        B = null;
    }

    public boolean isBusy(){
        if(G != null && B != null) return true;
        else return false;
    }
    public void theLine(Person person){
        String typ = person.getClass().getSimpleName();
        if (typ.charAt(typ.length()-1) == 'l'){
            queueGirls.add(person);
        }
        else{
            queueBoys.add(person);
        }

        try {
            entry();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void entry() throws InterruptedException{
        while(!queueGirls.isEmpty() || !queueBoys.isEmpty()){
            while (isBusy()){
                wait();
            }
            if (G == null) G = queueGirls.remove();
            if (B == null) B = queueBoys.remove();
            LoveStory loveStory = new LoveStory(G, B);
            loveStory.start();
            G = null;
            B = null;
        }
    }
}
