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
        int maxChildren = 0;
        if (father instanceof GoodBoy) maxChildren = BGGB;
        if (father instanceof BadBoy) maxChildren = BGBB;

        for (int i = 0; i<maxChildren; i++){
            BadGirl clone = new BadGirl();
            clone.start();
        }

    }

}
