package People;

import java.util.Random;

import static People.People.funeral;
import static People.People.childHasBorn;

/**
 * Created by Giulia on 04/05/2017.
 */
public class GoodGirl extends Thread implements Person{
    private int MaxNumChildren;
    private int lifeTime;
    private int lifePoints;
    private boolean inLove;
    private Person inLoveWith;

    GoodGirl(){
        MaxNumChildren = 3;
        lifePoints = 0;
        lifeTime = 15000;
        inLove = false;
        inLoveWith = null;
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

    public void hasChild(Person father) throws CannotHaveChildrenException{
        System.out.println(this.getClass() + " is trying to have a child");
        if(!(father instanceof GoodBoy) || MaxNumChildren == 0){
            System.out.println(father.getClass() + "is not appropriate");
            throw new CannotHaveChildrenException();
        }

        // sleep

        if(inLove){
            System.out.println(this.getClass() + " is in love with" + inLoveWith);

            if(father != inLoveWith) throw new CannotHaveChildrenException();
        }
        else{
            inLove = true;
            inLoveWith = father;
            System.out.println(this.getClass() + " now is in love with" + inLoveWith);
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
        childHasBorn(child);
        child.start();

        System.out.println(this.getClass() + " e " + father.getClass() + " got a " + child.getClass());
        // Decremento numero massimo figli
        father.hasChild(this);
        this.MaxNumChildren--;

        // Assegnamento dei costi
        lifePoints += 2;


    }

}
