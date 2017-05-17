package People;

import static People.People.*;

/**
 * Created by Giulia on 04/05/2017.
 */
public class GoodBoy extends Thread implements Person{
    private int MaxNumChildren;
    private int lifeTime;
    private int lifePoints;
    public boolean loveStory;

    public GoodBoy(){
        MaxNumChildren = 3;
        lifeTime = 15000;
        lifePoints = 0;
        loveStory = false;
    }
    public void run(){
        long bornTime = System.currentTimeMillis();
        childHasBorn(this);
        System.out.println("Sono GB e cerco amore");
        findLove(this);
        while (System.currentTimeMillis() - bornTime < lifeTime && fertility()) {


        }
        funeral(this);
    }

    public boolean fertility(){
        if(MaxNumChildren != 0) return true;
        else return false;
    }

    @Override
    public void hasChild(Person mother) throws CannotHaveChildrenException {

        if(MaxNumChildren==0) throw new CannotHaveChildrenException();
        MaxNumChildren--;

    }

    @Override
    public void assignCosts(int cost) {
        lifePoints += cost;

    }

    public int happiness() {
        return lifePoints;
    }
    @Override
    public void setLoveStory(boolean flag) {
        loveStory = flag;
    }

}
