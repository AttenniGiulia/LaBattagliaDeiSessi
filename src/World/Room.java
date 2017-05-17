package World;

import People.BadGirl;
import People.CannotHaveChildrenException;
import People.GoodGirl;
import People.Person;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Giulia on 05/05/2017.
 */
public class Room extends Thread{
    public Queue<Person> Girls = new LinkedList<>();
    public Queue<Person> Boys = new LinkedList<>();

    public void run(){
        while ((!Girls.isEmpty())|| (!Boys.isEmpty())){
            meeting(Girls.remove(), Boys.remove());
        }
    }
    public void theDoor(Person person){
        if((person instanceof GoodGirl) || (person instanceof BadGirl)){
            Girls.add(person);
        }
        else{
            Boys.add(person);
        }

    }


    public void meeting(Person p1, Person p2){

        String p1Class = p1.getClass().toString();
        String p2Class = p2.getClass().toString();
        System.out.println("The room is busy: " + p1Class + " " + p2.getClass() + " are inside");


        try {
            // Per chiamare il giusto hasChild ho bisogno di sapere chi è la Girl
            if (p1Class.charAt(p1Class.length()-1) == 'l') {
                p1.hasChild(p2);
            }
            else
            {
                if (p2Class.charAt(p2Class.length()-1) == 'l')
                    p2.hasChild(p1);
            }

        } catch (CannotHaveChildrenException e) {
        }
    }
}
