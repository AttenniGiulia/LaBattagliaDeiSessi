package People;

import static People.People.*;

/**
 * Created by Giulia on 05/05/2017.
 */
public class BadBoy extends Thread implements Person {


    private int MaxNumChildren;
    private int lifeTime;
    private int lifePoints;

    public BadBoy(){
        MaxNumChildren = 10;
        lifeTime = 15000;
        lifePoints = 0;
    }

    public void run() {
        long bornTime = System.currentTimeMillis();
        childHasBorn(this);
        while (System.currentTimeMillis() - bornTime < lifeTime) {
            findLove(this);
        }
        funeral(this);
    }

    public boolean fertility() {
        if(MaxNumChildren != 0) return true;
        else return false;
    }

    public void hasChild(Person mother) throws CannotHaveChildrenException {
        if (MaxNumChildren == 0) throw new CannotHaveChildrenException();
        MaxNumChildren--;
    }
    public void assignCosts(int cost) {
        lifePoints += cost;

    }
    public int happiness() {
        return lifePoints;
    }


}
