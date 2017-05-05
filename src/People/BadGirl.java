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
        while (System.currentTimeMillis() - bornTime < lifeTime) {

        }
        funeral(this);
    }
    public boolean fertility() {
        if(MaxNumChildren != 0) return true;
        else return false;
    }

    public void hasChild(Person father) throws CannotHaveChildrenException{

        System.out.println(this.getClass() + " is trying to have a child");
        if((father instanceof GoodGirl) ||(father instanceof BadGirl)|| MaxNumChildren == 0) {
            System.out.println(father.getClass() + " is not appropriate");
            throw new CannotHaveChildrenException();
        }


        Random random = new Random();
        boolean ChildSex = random.nextBoolean();
        Person child;
        if (ChildSex){
            //true = male
            if (father instanceof GoodBoy){
                child = new GoodBoy();
            }
            else{
                // La BadGirl se ha già fatto un figlio con un BadBoy non ci ricasca un'altra volta ... forse questa cosa potrebbe sbilanciare la situazione
                if(childWithBad) throw new CannotHaveChildrenException();
                child = new BadBoy();
            }
            // Assegnamento costi
            lifePoints += a - b/2;
        }
        else{
            //false = female
            if (father instanceof GoodBoy){
                child = new BadGirl();
            }
            else{
                // La BadGirl se ha già fatto un figlio con un BadBoy non ci ricasca un'altra volta ... forse questa cosa potrebbe sbilanciare la situazione
                if(childWithBad){
                    System.out.println(this.getClass() + " does not want " + father.getClass() + "  anymore");
                    throw new CannotHaveChildrenException();
                }
                child = new BadGirl();
                childWithBad = true;
            }
            // Assegnamento costi
            lifePoints -= b;
        }
        childHasBorn(child);
        child.start();
        System.out.println(this.getClass() + " e " + father.getClass() + " got a " + child.getClass());
        // Decremento numero massimo figli
        father.hasChild(this);
        this.MaxNumChildren--;

    }
}
