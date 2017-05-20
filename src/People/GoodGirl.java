package People;

import java.util.Random;

import static People.People.*;

/**
 * Created by Giulia on 04/05/2017.
 */
public class GoodGirl extends Thread implements Person{

    public void run(){
        childHasBorn(this);
        findLove(this);
        findLove(this);
        funeral(this);
    }

    @Override
    public void clone(Person father) throws CannotHaveChildrenException {

        if(!(father instanceof GoodBoy)) throw new CannotHaveChildrenException();



        for(int i=0; i<GGGB; i++){
            GoodGirl clone = new GoodGirl();
            clone.start();
        }


    }

}
