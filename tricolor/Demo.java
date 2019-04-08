package tp.feu.tricolor;


import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * @author Kabore Donatien
 *
 */

/**
Class methode permet de mettre en pratique le feu tricolore
creait une fenetre de taille frame.setSize(250, 350), visible frame.setVisible(true), contenant un objet de la class FenetreAfficheFeu  frame.add(panel)
*/
public class Demo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new FenetreAfficheFeu();
        frame.add(panel);
        frame.setSize(250, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
