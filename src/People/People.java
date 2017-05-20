package People;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * Created by Giulia on 05/05/2017.
 */
public class People {
    public static Set<GoodBoy> GoodBoysInTheWorld = new HashSet<GoodBoy>();
    public static Set<GoodGirl> GoodGirlsInTheWorld = new HashSet<GoodGirl>();
    public static Set<BadBoy> BadBoysInTheWorld = new HashSet<BadBoy>();
    public static Set<BadGirl> BadGirlsInTheWorld = new HashSet<BadGirl>();
    public static Queue<Person> queueGirls = new LinkedList<Person>();
    public static Queue<Person> queueBoys = new LinkedList<Person>();
    public static int a, b, c;
    public static int GGGB, BGGB, BGBB, BBBG;

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
        String typ = person.getClass().getSimpleName();
        System.out.println(person.getClass().getSimpleName() + " is in the queue");

        if(typ.charAt(typ.length()-1)=='l'){
            if(!queueGirls.contains(person))
                queueGirls.add(person);
        }
        else {
            if(!queueGirls.contains(person))
                queueBoys.add(person);
        }


    }

    public static void calculateMaxChildren(){
        GGGB = 0;
        BGGB = 0;
        BGBB = 0;
        BBBG = 0;

    }


}
