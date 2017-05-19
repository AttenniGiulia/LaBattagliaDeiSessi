package People;
import static People.People.*;

/**
 * Created by Giulia on 05/05/2017.
 */
public class BadGirl extends Thread implements Person {
    public void run(){
        childHasBorn(this);
        findLove(this);
        findLove(this);
        funeral(this);
    }

    @Override
    public void clone(Person father) throws CannotHaveChildrenException {
        int gain = calculateGain(father);

        for (int i = 0; i<gain; i++){
            BadGirl clone = new BadGirl();
            clone.start();
        }

    }

    @Override
    public int calculateGain(Person father) {
        if (father instanceof GoodBoy) return a-b/2;
        if (father instanceof BadBoy) return a-b;
        return 0;
    }
}
