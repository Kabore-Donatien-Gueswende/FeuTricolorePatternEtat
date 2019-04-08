package tp.feu.tricolor;

public class TrafficContext {
    
    TrafficEtat trafficetat;
    TrafficEtat feuRouge;
    TrafficEtat feuVert;
    TrafficEtat feuOrange;
    
    public TrafficContext() {
        feuRouge = new FeuRouge(this);   
        feuVert = new FeuVert(this);
        feuOrange = new FeuOrange(this);
        trafficetat = feuRouge;
        
    }

    public void setTrafficetat(TrafficEtat trafficetat) {
        this.trafficetat = trafficetat;
    }
    
    public TrafficEtat getTrafficetat() {
        //TrafficEtat n = trafficetat;
        //System.out.println(n);
        
        return trafficetat;
    }
    
    public void EtatRouge() {
        trafficetat.EtatRouge();
    }
    
    public void EtatVert() {
        trafficetat.EtatVert();
    }
    
    public void EtatOrange() {
        trafficetat.EtatOrange();
    }


  /*  public TrafficEtat getFeuRouge() {
      
        return feuRouge;
    }

    public TrafficEtat getFeuVert() {
        
        return feuVert;
    }

    public TrafficEtat getFeuOrange() {
       
        return feuOrange;
    }   */
}
