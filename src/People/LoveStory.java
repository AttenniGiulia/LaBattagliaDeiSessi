package People;

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
        if(G instanceof GoodGirl) wedding();
        else room();
    }



    private void room() {

        try {
            G.hasChild(B);
        } catch (CannotHaveChildrenException e) {
            e.printStackTrace();
        }
    }
    private void wedding() {
        // fanno tutti i figli
        while (G.fertility()) {
            try {
                G.hasChild(B);
            } catch (CannotHaveChildrenException e) {
                e.printStackTrace();
            }
        }
    }
}
