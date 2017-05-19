package People;

import static People.People.*;

/**
 * Created by Giulia on 05/05/2017.
 */
public class BadBoy extends Thread implements Person {
    public void run(){
        childHasBorn(this);
        findLove(this);
        findLove(this);
        funeral(this);
    }
    @Override
    public void clone(Person mother) throws CannotHaveChildrenException {
        if(!(mother instanceof BadGirl)) throw new CannotHaveChildrenException();
        int gain = calculateGain(mother);
        for(int i=0; i<gain; i++){
            BadBoy clone = new BadBoy();
            clone.start();
        }

    }

    @Override
    public int calculateGain(Person mother) {
        return a;
    }
}
