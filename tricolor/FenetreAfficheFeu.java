package tp.feu.tricolor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


import Traffic.ligth.tp.StopLightDrawing;


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
