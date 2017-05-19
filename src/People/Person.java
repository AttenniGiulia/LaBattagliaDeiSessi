package People;

import static People.People.childHasBorn;
import static People.People.findLove;
import static People.People.funeral;

/**
 * Created by Giulia on 04/05/2017.
 */
public interface Person{

    default void run(){
        childHasBorn(this);
        findLove(this);
        findLove(this);
        funeral(this);
    }
    void clone(Person p) throws CannotHaveChildrenException;
    int calculateGain(Person p);
}
