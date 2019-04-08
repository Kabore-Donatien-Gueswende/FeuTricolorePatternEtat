package tp.feu.tricolor;

/**
 * @author Kabore Donatien
 *
 */

/**
Class context ayant une variable du type de l'interface, et affectant chaque etat à sa valeur initiale
*/
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
}
