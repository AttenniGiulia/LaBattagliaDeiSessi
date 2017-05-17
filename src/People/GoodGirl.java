package People;

import java.util.Random;

import static People.People.*;

/**
 * Created by Giulia on 04/05/2017.
 */
public class GoodGirl extends Thread implements Person{
    private int MaxNumChildren;
    private int lifeTime;
    private int lifePoints;
    private boolean loveStory;

    public GoodGirl(){
        MaxNumChildren = 3;
        lifePoints = 0;
        lifeTime = 15000;
        loveStory = false;
    }
    public void run(){
        long bornTime = System.currentTimeMillis();
        childHasBorn(this);
        System.out.println("Sono GG e cerco amore");
        findLove(this);
        while (System.currentTimeMillis() - bornTime < lifeTime && fertility()) {
        }
        funeral(this);
    }

    public boolean fertility(){
        if(MaxNumChildren != 0) return true;
        else return false;
    }

    public void hasChild(Person father) throws CannotHaveChildrenException{
        if(!(father instanceof GoodBoy) || MaxNumChildren == 0){
            System.out.println(father.getClass() + "is not appropriate");
            throw new CannotHaveChildrenException();
        }


        Random random = new Random();
        boolean ChildSex = random.nextBoolean();
        Person child;
        if (ChildSex){
            //true = male
            child = new GoodBoy();

        }
        else{
            //false = female
            child = new GoodGirl();
        }
        child.start();

        System.out.println(this.getClass() + " e " + father.getClass() + " got a " + child.getClass());
        // Decremento numero massimo figli
        this.MaxNumChildren--;



    }
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
