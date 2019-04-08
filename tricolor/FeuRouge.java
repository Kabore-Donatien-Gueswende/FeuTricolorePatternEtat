package tp.feu.tricolor;

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
