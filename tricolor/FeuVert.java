package tp.feu.tricolor;

/**
 * @author Kabore Donatien
 *
 */

/**
Class FeuVert implementant l'interface et changeant ainsi d'etat à chaque fois qu'il est excecuté

ainsi l'etat vert passe au jaune uniquement trafficcontext.setTrafficetat(trafficcontext.feuOrange);
*/
public class FeuVert implements TrafficEtat {
    TrafficContext trafficcontext;
    
    public FeuVert(TrafficContext trafficcontext) {
        super();
        this.trafficcontext = trafficcontext;
    }

    @Override
    public void EtatRouge() {
        // TODO Auto-generated method stub
        System.out.println("vert vers rouge impossible");
    }

    @Override
    public void EtatOrange() {
        // TODO Auto-generated method stub
        System.out.println("vert vers orange");
        
        trafficcontext.setTrafficetat(trafficcontext.feuOrange);

    }

    @Override
    public void EtatVert() {
        // TODO Auto-generated method stub
        System.out.println("etat vert deja");

    }

}
