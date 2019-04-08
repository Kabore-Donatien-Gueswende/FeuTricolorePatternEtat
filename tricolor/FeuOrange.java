package tp.feu.tricolor;

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
