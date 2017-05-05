package People;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Giulia on 05/05/2017.
 */
public class People {
    static Set<Person> peopleInTheWorld = new HashSet<Person>();
    static int a, b, c;

    public static void childHasBorn(Person person){
        peopleInTheWorld.add(person);
    }
    public static void funeral(Person person){
        peopleInTheWorld.remove(person);
        System.out.println(person.getClass() + " has died");
    }
}
