package People;

/**
 * Created by Giulia on 05/05/2017.
 */
public class Room {
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
