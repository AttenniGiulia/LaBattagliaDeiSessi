package People;

/**
 * Created by Giulia on 04/05/2017.
 */
public interface Person{

    void run();
    void clone(Person p) throws CannotHaveChildrenException;
}
