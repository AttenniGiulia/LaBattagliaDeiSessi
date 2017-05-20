package People;

import static People.People.*;

/**
 * Created by Giulia on 04/05/2017.
 */
public class GoodBoy extends Thread implements Person{
    public void run(){
        childHasBorn(this);
        findLove(this);
        findLove(this);
        funeral(this);
    }
    @Override
    public void clone(Person father) throws CannotHaveChildrenException {
        int maxChildren = 0;
        if (father instanceof GoodGirl) maxChildren = GGGB;
        if (father instanceof BadGirl) maxChildren = BGBB;

        for (int i = 0; i<maxChildren; i++){
            GoodBoy clone = new GoodBoy();
            clone.start();
        }

    }


}
