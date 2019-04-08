package tp.feu.tricolor;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;


/**
 * @author Kabore Donatien Gueswendé
 *
 */

/**
Dans cette classe on creait la couleur de signalisation ainsi que les "ronds" contenant chaque couleur

*/

public class MiniatureFeu extends JComponent {
    /**
    @param trafficcontext permet de recuperer l'etat actuel du feu et de le passer à l'etat suivante qu'il faut
     */
    TrafficContext trafficcontext = new TrafficContext();
    
    /**
    @param vert
    @param jaune
    @param rouge    
    toutes initialisées avec la couleur grise
*/
    Color vert = Color.gray;
    Color jaune = Color.gray;
    Color rouge = Color.red;
       
    public void paintComponent(Graphics g) {
        
        //Couleur de fond du panneau des trois couleurs
        
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 150, 250);

        //rondeur des couleurs (taille et position)
        
        g.setColor(rouge);
        g.fillOval(50, 30, 50, 50);
        
        g.setColor(jaune);
        g.fillOval(50, 100, 50, 50);
        
        g.setColor(vert);
        g.fillOval(50, 170, 50, 50);     
    }    
    /*
     * @param changecolor() permet de changer d'etat à chaque fois qu'il est appelé
     * 
     * */

    public void changeColor() {
        
         vert = Color.gray;
         jaune = Color.gray;
         rouge = Color.gray;
         
         TrafficEtat etat=trafficcontext.getTrafficetat();
         String G;
         G=etat.toString().substring(16, 23);
         
       switch(G) {
         case  "FeuRoug":
             trafficcontext.EtatVert();                         
             vert = Color.green;
           break;
         case "FeuOran":
             trafficcontext.EtatRouge();
             rouge = Color.red;         
           break;
         case "FeuVert":
             trafficcontext.EtatOrange();
             jaune = Color.orange;
             break;
       }
        repaint(); 
              
    }
}
