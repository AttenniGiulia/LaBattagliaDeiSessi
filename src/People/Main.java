package People;

import java.util.Random;

import static People.People.*;

/**
 * Created by Giulia on 04/05/2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        a = 15;
        b = 20;
        c = 3;

        GoodBoy goodBoy = new GoodBoy();
        GoodGirl goodGirl  = new GoodGirl();


        goodBoy.start();
        goodGirl.start();


        MeetingPoint meetingPoint = new MeetingPoint();
        meetingPoint.start();




    }
}
