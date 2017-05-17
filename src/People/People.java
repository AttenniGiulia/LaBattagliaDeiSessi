package People;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Giulia on 05/05/2017.
 */
public class People {
    public static Set<GoodBoy> GoodBoysInTheWorld = new HashSet<GoodBoy>();
    public static Set<GoodGirl> GoodGirlsInTheWorld = new HashSet<GoodGirl>();
    public static Set<BadBoy> BadBoysInTheWorld = new HashSet<BadBoy>();
    public static Set<BadGirl> BadGirlsInTheWorld = new HashSet<BadGirl>();
    public static MeetingPoint meetingPoint = new MeetingPoint();
    static int a, b, c;

    public  static void setParameters(int A, int B, int C){
        a = A;
        b = B;
        c = C;
    }
    public static void childHasBorn(Person person){

        switch(person.getClass().getSimpleName()){
            case "GoodBoy":
                GoodBoysInTheWorld.add((GoodBoy) person);
                break;
            case "GoodGirl":
                GoodGirlsInTheWorld.add((GoodGirl) person);
                break;
            case "BadBoy":
                BadBoysInTheWorld.add((BadBoy) person);
                break;
            case "BadGirl":
                BadGirlsInTheWorld.add((BadGirl) person);
                break;
            default:
                break;
        }
        System.out.println(person.getClass().getSimpleName() + " has born");
    }
    public static void funeral(Person person){
        System.out.println(person.getClass().getSimpleName() +  " got " + person.happiness());

        switch(person.getClass().getSimpleName()){
            case "GoodBoy":
                GoodBoysInTheWorld.remove((GoodBoy) person);
                break;
            case "GoodGirl":
                GoodGirlsInTheWorld.remove((GoodGirl) person);
                break;
            case "BadBoy":
                BadBoysInTheWorld.remove((BadBoy) person);
                break;
            case "BadGirl":
                BadGirlsInTheWorld.remove((BadGirl) person);
                break;
            default:
                break;
        }
        System.out.println(person.getClass().getSimpleName() + " has died");
    }

    public static void findLove(Person person){
        meetingPoint.theLine(person);
    }
}
