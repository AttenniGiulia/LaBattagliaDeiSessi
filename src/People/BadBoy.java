package People;
import static People.People.a;
import static People.People.funeral;
/**
 * Created by Giulia on 05/05/2017.
 */
public class BadBoy extends Thread implements Person {


    private int MaxNumChildren;
    private int lifeTime;
    private int lifePoints;

    BadBoy(){
        MaxNumChildren = 10;
        lifeTime = 15000;
        lifePoints = 0;
    }

    public void run() {
        long bornTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - bornTime < lifeTime) {

        }
        funeral(this);
    }

    public boolean fertility() {
        if(MaxNumChildren != 0) return true;
        else return false;
    }

    public void hasChild(Person person) throws CannotHaveChildrenException {
        if(MaxNumChildren==0) throw new CannotHaveChildrenException();
        MaxNumChildren--;
        // Assegnamento costi
        lifePoints += a;
    }



}
