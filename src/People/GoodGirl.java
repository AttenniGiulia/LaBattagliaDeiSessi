package People;

import java.util.Random;

import static People.People.*;

/**
 * Created by Giulia on 04/05/2017.
 */
public class GoodGirl extends Thread implements Person{


    @Override
    public void clone(Person father) throws CannotHaveChildrenException {

        if(!(father instanceof GoodBoy)) throw new CannotHaveChildrenException();

        int gain = calculateGain(father);

        for(int i=0; i<gain; i++){
            GoodGirl clone = new GoodGirl();
            clone.start();
        }


    }

    @Override
    public int calculateGain(Person father) {
        return a-(b/2)-c;
    }

}
