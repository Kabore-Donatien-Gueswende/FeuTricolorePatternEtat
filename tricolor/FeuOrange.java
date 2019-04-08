package tp.feu.tricolor;


/**
 * @author Kabore Donatien
 *
 */
/**
Class FeuOrange implementant l'interface et changeant ainsi d'etat à chaque fois qu'il est excecuté

ainsi l'etat jaune passe au rouge uniquement trafficcontext.setTrafficetat(trafficcontext.feuRouge);
*/
public class FeuOrange implements TrafficEtat {
    TrafficContext trafficcontext;
    
    public FeuOrange(TrafficContext trafficcontext) {
        super();
        this.trafficcontext = trafficcontext;
    }
    @Override
    public void EtatRouge() {
        // TODO Auto-generated method stub
        System.out.println("Orange vers Rouge");
        trafficcontext.setTrafficetat(trafficcontext.feuRouge);

    }

    @Override
    public void EtatOrange() {
        // TODO Auto-generated method stub
        System.out.println("etat orange deja");

    }

    @Override
    public void EtatVert() {
        // TODO Auto-generated method stub
        System.out.println("orange vers vert impossible");

    }

}
