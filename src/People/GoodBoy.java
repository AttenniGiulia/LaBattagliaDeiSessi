package People;

import static People.People.*;

/**
 * Created by Giulia on 04/05/2017.
 */
public class GoodBoy extends Thread implements Person{
    private int MaxNumChildren;
    private int lifeTime;
    private int lifePoints;
    private boolean inLove;

    GoodBoy(){
        MaxNumChildren = 3;
        lifeTime = 15000;
        lifePoints = 0;
        inLove = false;
    }
    public void run(){
        long bornTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - bornTime < lifeTime) {

        }
        funeral(this);
    }
    public boolean isInLove(){
        return inLove;
    }

    public boolean fertility(){
        if(MaxNumChildren != 0) return true;
        else return false;
    }

    @Override
    public void hasChild(Person person) throws CannotHaveChildrenException {
        if(MaxNumChildren==0) throw new CannotHaveChildrenException();
        MaxNumChildren--;
        //assegnare costi
        if (person instanceof GoodGirl) lifePoints += a - b/2 - c;
        else lifePoints += a - b/2;
    }

    public int happiness() {
        return lifePoints;
    }

}