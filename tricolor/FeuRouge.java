package tp.feu.tricolor;

/**
 * @author Kabore Donatien
 *
 */
/**
Class FeuRouge implementant l'interface et changeant ainsi d'etat à chaque fois qu'il est excecuté

ainsi l'etat rouge passe au vert uniquement trafficcontext.setTrafficetat(trafficcontext.feuvert);
*/
public class FeuRouge implements TrafficEtat {
    TrafficContext trafficcontext;
    

    public FeuRouge(TrafficContext trafficcontext) {
        super();
        this.trafficcontext = trafficcontext;
    }

    @Override
    public void EtatRouge() {
        // TODO Auto-generated method stub
        System.out.println("Etat Rouge Deja");
        

    }

    @Override
    public void EtatOrange() {
        // TODO Auto-generated method stub
        System.out.println("Rouge vers Orange impossible");

    }

    @Override
    public void EtatVert() {
        // TODO Auto-generated method stub
        System.out.println("passe du rouge au vert");
        trafficcontext.setTrafficetat(trafficcontext.feuVert);
        
    }
    
    

}
