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
        if (G instanceof BadGirl && B instanceof BadBoy) room(); //BB e BG vanno subito nella stanza
        if (G instanceof GoodGirl && B instanceof GoodBoy) resturant(); //GG e GB passano per il ristorante e poi si sposano
        if (G instanceof BadGirl && B instanceof GoodBoy) wedding(); //GB vuole sposare BG ma BG potrebbe dire di no
    }

    private void resturant() {
        G.assignCosts(-c);
        B.assignCosts(-c);
        wedding();

    }



    private void room() {

        try {
            B.hasChild(G);
            G.hasChild(B);
            G.assignCosts(a);
            B.assignCosts(a);
            if(B instanceof GoodBoy){
                //nonostante BG non voglia sposare GB quest'ultimo sceglie di affrontare il costo di avere un figlio in ogni caso
                G.assignCosts(-b/2);
                B.assignCosts(-b/2);
            }
            else{
                G.assignCosts(-b);
            }
        } catch (CannotHaveChildrenException e) {
        }
    }
    private void wedding() {

        if(G instanceof BadGirl){
            if(!(((BadGirl) G).childWithBad)){
                room(); // BG non è ancora rimasta fregata da BB quindi non sa il richio che potrebbe correre e quindi rifiuta la poroposta di matrimonio ma non perde l'occasione per procreare
            }
            else{
                // una volta sposati si hanno figli finchè si è fertili
                while (G.fertility() && B.fertility()) {
                    try {
                        B.hasChild(G);
                        G.hasChild(B);
                        G.assignCosts(a - b/2);
                        B.assignCosts(a - b/2);
                    } catch (CannotHaveChildrenException e) {
                    }
                }
            }
        }
        else{
            // una volta sposati si hanno figli finchè si è fertili
            while (G.fertility() && B.fertility()) {
                try {
                    B.hasChild(G);
                    G.hasChild(B);
                    G.assignCosts(a - b/2);
                    B.assignCosts(a - b/2);
                } catch (CannotHaveChildrenException e) {
                }
            }
        }

    }
}
