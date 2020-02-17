package Main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Alerta {
    
    final JFrame minhaJanela = new JFrame();
    JButton aceitandoDesculpas = new JButton("Ok!");
    //construtor
    public Alerta() {
        
        String name = "";

           
                name = JOptionPane.showInputDialog(minhaJanela,
                        "Digite apenas valores numéricos", null);
          
            
        minhaJanela.add(aceitandoDesculpas);
        minhaJanela.pack();
        minhaJanela.setVisible(true);
        minhaJanela.setLocationRelativeTo(null);
        
        aceitandoDesculpas.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               minhaJanela.setVisible(false);
            }
        });
    }
}
