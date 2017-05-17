package People;

import java.util.Random;

import static People.People.*;

/**
 * Created by Giulia on 05/05/2017.
 */
public class BadGirl extends Thread implements Person {

    private int MaxNumChildren;
    private int lifeTime;
    private int lifePoints;
    private boolean childWithBad;

    BadGirl(){
        MaxNumChildren = 5;
        lifePoints = 0;
        lifeTime = 15000;
        childWithBad = false;
    }

    public void run(){
        long bornTime = System.currentTimeMillis();
        childHasBorn(this);
        while (System.currentTimeMillis() - bornTime < lifeTime) {

        }
        funeral(this);
    }
    public boolean fertility() {
        if(MaxNumChildren != 0) return true;
        else return false;
    }

    public void hasChild(Person father) throws CannotHaveChildrenException{
        if((father instanceof GoodGirl) ||(father instanceof BadGirl)|| MaxNumChildren == 0) {
            System.out.println(father.getClass() + " is not appropriate");
            throw new CannotHaveChildrenException();
        }


        Random random = new Random();
        boolean childSex = random.nextBoolean();
        Person child;
        if (father instanceof GoodBoy){
            //true = male
            if (childSex){
                child = new GoodBoy();
            }
            else{
                child = new GoodGirl();
            }

        }
        else{
            //false = female
            // La BadGirl se ha già fatto un figlio con un BadBoy non ci ricasca un'altra volta
            if(childWithBad) throw new CannotHaveChildrenException();
            if (childSex){
                child = new BadBoy();
            }
            else{
                child = new BadGirl();
            }
            childWithBad = true;

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

}
