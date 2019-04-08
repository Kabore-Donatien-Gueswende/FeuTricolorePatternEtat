package tp.feu.tricolor;

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
