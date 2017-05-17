package People;
import static People.People.*;

/**
 * Created by Giulia on 15/05/2017.
 */
public class LoveStory extends Thread {
    Person G;
    Person B;

    LoveStory(Person A, Person B){
        String typA = A.getClass().getSimpleName();

        if( typA.charAt(typA.length()-1) == 'l'){
            this.G = A;
            this.B = B;
        }
        else{
            this.G = B;
            this.B = A;
        }


    }

    public void run(){
        bar();
    }

    private void bar() {
        if (G instanceof BadGirl && B instanceof BadBoy) room();
        if (G instanceof GoodGirl && B instanceof GoodBoy) resturant();
        if (G instanceof BadGirl && B instanceof GoodBoy) resturant();
    }

    private void resturant() {
        if(G instanceof GoodGirl){
            G.assignCosts(-c);
            B.assignCosts(-c);
            wedding();
        }
        else room();
    }



    private void room() {

        try {
            B.hasChild(G);
            G.hasChild(B);
            G.assignCosts(a);
            B.assignCosts(a);
            if(B instanceof GoodBoy){
                G.assignCosts(-b/2);
                B.assignCosts(-b/2);
            }
            else{
                G.assignCosts(-b);
            }
        } catch (CannotHaveChildrenException e) {
            e.printStackTrace();
        }
    }
    private void wedding() {
        // fanno tutti i figli
        while (G.fertility() && B.fertility()) {
            try {
                B.hasChild(G);
                G.hasChild(B);
                G.assignCosts(a - b/2);
                B.assignCosts(a - b/2);
            } catch (CannotHaveChildrenException e) {
                e.printStackTrace();
            }
        }
    }
}
