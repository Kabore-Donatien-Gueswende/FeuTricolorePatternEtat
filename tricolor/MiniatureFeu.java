package tp.feu.tricolor;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class MiniatureFeu extends JComponent {
    TrafficContext trafficcontext = new TrafficContext();
    Color go = Color.gray;
    Color slow = Color.gray;
    Color stop = Color.red;
    
    public void paintComponent(Graphics g) {
        //fond
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 150, 250);
        //border
        g.setColor(Color.black);
        g.drawRect(0, 0, 150, 250); 
        
        //oval feu
        g.setColor(stop);
        g.fillOval(50, 30, 50, 50);
        
        g.setColor(slow);
        g.fillOval(50, 100, 50, 50);
        
        g.setColor(go);
        g.fillOval(50, 170, 50, 50);     
    }
    
    String activeLight = "red";
    public void changeColor() {
        
         go = Color.gray;
         slow = Color.gray;
         stop = Color.gray;
         
         TrafficEtat etat=trafficcontext.getTrafficetat();
         String G;
         G=etat.toString().substring(16, 23);
         
       switch(G) {
         case  "FeuRoug":
             trafficcontext.EtatVert();            
             activeLight = "green";             
             go = Color.green;
           break;
         case "FeuOran":
             trafficcontext.EtatRouge();
             activeLight = "red";
             stop = Color.red;         
           break;
         case "FeuVert":
             trafficcontext.EtatOrange();
             activeLight = "yellow";
             slow = Color.orange;
             break;
       }
        repaint(); 
              
    }
}
