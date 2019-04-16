# Feu Tricolore avec le patron Etat

Dans cet projet nous allons mettre en pratique nos connaissances du pattern Etat dans la realisation de feu de signalisation

# Interface

nous representons ainsi dans l'interface l'ensemble des Etats possibles que peu prendre un feu de signalisation (3 ici)

    public interface TrafficEtat {

      public void EtatRouge();
      public void EtatOrange();
      public void EtatVert();
    
    }
    
# Contexte

Dans cette classe trafficContext, nous recuperons une variable du type de l'interface, creons un contructeur au tour de cette variable
puis creons des methodes qui contiendrons l'etat initial que chaque etat devras representer


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
    
# Etat

ici nous implemenatons trois Etats (Rouge, Orange, Vert)

# Rouge

Dans cet etat nous aurions la possibilité d'implementer chaque methode et ainsi donc definir les regles pour chaque etat en fonction
de l'etat Rouge

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

# Vert
On fera exactement le meme chose que l'etat precedent mais le changement d'etat se fera à l'etat Orange

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
        
  # Orange
  Meme combinaison gagnant :D)
  
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
      
# Console

A cette etape nous pouvions constater que les etats changent d'eux meme de valeurs dans le console
Illustration en image : 
![ConsolImg](https://github.com/Kabore-Donatien-Gueswende/FeuTricolorePatternEtat/blob/master/img/Consol.PNG)



# Interface Graphique

La console fonctionnant à merveille nous allons l'implementer dans une interface visuel, nous allons utiliser Swing et Awt pour la
gestion de nos 3 couleurs ainsi que d'une methode ChangeColor() pour le changement d'etat chaque fois qu'il est excuté, la methode
paintComponent() dessine 3 ronds affecter avec une couleur grise par defaut


    import java.awt.Color;
    import java.awt.Graphics;
    import javax.swing.JComponent;

    public class MiniatureFeu extends JComponent {
        TrafficContext trafficcontext = new TrafficContext();
        Color vert = Color.gray;
        Color jaune = Color.gray;
        Color rouge = Color.red;
       
        public void paintComponent(Graphics g) {
            g.setColor(Color.yellow);
            g.fillRect(0, 0, 150, 250);
            g.setColor(rouge);
            g.fillOval(50, 30, 50, 50);  
            g.setColor(jaune);
            g.fillOval(50, 100, 50, 50);
            g.setColor(vert);
            g.fillOval(50, 170, 50, 50);     
        }    

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
      
 # Fenetre d'Affichage
 Ayant nos trois couleurs à chaud, nous allons creer une fenetre dans laquelle les mettre.
 La blibliotheque Swing et Awt seront sollicté (rappelons Swing dependant un petit peu de Awt) à nouveau
 la classe FenetreAfficheFeu contient un constructeur dont le but est de creer un panneau dimensionné qui contiendra les 3 couleurs
 defini precedemment, ainsi que d'un boutton "Swicth" permettant de changer d'etat à chaque clique. Suivi d'une autre methode 
 buttonListener() qui ecoutera l'evenement clique.
 
 
 
 
      import java.awt.Dimension;
      import java.awt.event.ActionEvent;
      import java.awt.event.ActionListener;
      import javax.swing.JButton;
      import javax.swing.JPanel;

      public class FenetreAfficheFeu extends JPanel {  
          MiniatureFeu light = new MiniatureFeu();
          public FenetreAfficheFeu() {
              JButton ChangeButton = new JButton("Switch");
              light.setPreferredSize(new Dimension(160, 260));        
              buttonListener l = new buttonListener();
              ChangeButton.addActionListener(l);
              add(light);
              add(ChangeButton);    
          }
    
           class buttonListener implements ActionListener{
              @Override
              public void actionPerformed(ActionEvent e) {
                  // TODO Auto-generated method stub
                  light.changeColor();
              }
          }
    

}

# Demo

Nous pouvons passer à la demo, avec uniquement la bibliotheque Swing
Nous allons allons ajouter un objet FenetreAfficheFeu() dans un frame visible pour pouvoir faire nos test : une capture de notre test
en visuel cette fois-ci :D)
![GraphiqueImg](https://github.com/Kabore-Donatien-Gueswende/FeuTricolorePatternEtat/blob/master/img/feu.PNG)



          import javax.swing.JFrame;
          import javax.swing.JPanel;

          public class Demo {
              public static void main(String[] args) {
                  JFrame frame = new JFrame();
                  JPanel panel = new FenetreAfficheFeu();
                  frame.add(panel);
                  frame.setSize(250, 350);
                  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  frame.setVisible(true);
              }
          }
          
          
# Conclusion

Le Patron Etat est de model adapté dans un context ou le comportement des objets sont liés entre eux.
