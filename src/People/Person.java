package People;

/**
 * Created by Giulia on 04/05/2017.
 */
public interface Person{
    void run();
    boolean fertility();
    void hasChild(Person person) throws CannotHaveChildrenException;

    void start();
    void assignCosts(int cost);
    int happiness();
}
