package People;

import World.Room;
import static People.People.a;
import static People.People.b;
import static People.People.c;

/**
 * Created by Giulia on 04/05/2017.
 */
public class Main {
    public static void main(String[] args){
        a = 15;
        b = 20;
        c = 3;
        GoodBoy goodBoy = new GoodBoy();
        GoodGirl goodGirl = new GoodGirl();
        BadBoy badBoy = new BadBoy();
        BadGirl badGirl = new BadGirl();
        goodBoy.start();
        goodGirl.start();
        badBoy.start();
        badGirl.start();
        Room r = new Room();


        // test per goodGirl
        r.meeting(goodGirl, goodGirl);
        System.out.println("---------------------");
        r.meeting(goodGirl, badGirl);
        System.out.println("---------------------");
        r.meeting(goodGirl, goodBoy);
        System.out.println("---------------------");
        r.meeting(goodGirl, badBoy);
        System.out.println("---------------------");

        // test per goodBoy
        r.meeting(goodBoy, goodGirl);
        System.out.println("---------------------");
        r.meeting(goodBoy, badGirl);
        System.out.println("---------------------");
        r.meeting(goodBoy, goodBoy);
        System.out.println("---------------------");
        r.meeting(goodBoy, badBoy);
        System.out.println("---------------------");

        // test per badBoy
        r.meeting(badBoy, goodGirl);
        System.out.println("---------------------");
        r.meeting(badBoy, badGirl);
        System.out.println("---------------------");
        r.meeting(badBoy, goodBoy);
        System.out.println("---------------------");
        r.meeting(badBoy, badBoy);
        System.out.println("---------------------");


        // test per badGirl
        r.meeting(badGirl, goodGirl);
        System.out.println("---------------------");
        r.meeting(badGirl, badGirl);
        System.out.println("---------------------");
        r.meeting(badGirl, goodBoy);
        System.out.println("---------------------");
        r.meeting(badGirl, badBoy);
        System.out.println("---------------------");

    }
}
