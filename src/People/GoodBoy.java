package People;

import static People.People.*;

/**
 * Created by Giulia on 04/05/2017.
 */
public class GoodBoy extends Thread implements Person{
    @Override
    public void clone(Person father) throws CannotHaveChildrenException {
        int gain = calculateGain(father);

        for (int i = 0; i<gain; i++){
            GoodBoy clone = new GoodBoy();
            clone.start();
        }

    }

    @Override
    public int calculateGain(Person father) {
        if (father instanceof GoodGirl) return a-b/2;
        if (father instanceof BadGirl) return a-b;
        return 0;
    }
}
