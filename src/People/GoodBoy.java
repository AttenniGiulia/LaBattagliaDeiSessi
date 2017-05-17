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
    private Person inLoveWith;

    GoodBoy(){
        MaxNumChildren = 3;
        lifeTime = 15000;
        lifePoints = 0;
        inLove = false;
        inLoveWith = null;
    }
    public void run(){
        long bornTime = System.currentTimeMillis();
        childHasBorn(this);
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
        if(inLove){
            System.out.println(this.getClass() + " is in love with" + inLoveWith);

            if(person != inLoveWith) throw new CannotHaveChildrenException();
        }
        else{
            inLove = true;
            inLoveWith = person;
            System.out.println(this.getClass() + " now is in love with" + inLoveWith);
        }
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
