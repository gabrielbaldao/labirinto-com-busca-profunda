package Main;

import javax.swing.JFrame;

public class Main {

	
	public static void main(String[] args) {
            System.out.println("Inicio");
            
            //tela inicial
            JFrame minhaTela = new TelaInicial();    
            minhaTela.setTitle("Menu Principal");
            minhaTela.setSize(500, 600);
            minhaTela.setLocationRelativeTo(null);
            minhaTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            minhaTela.setVisible(true);
            minhaTela.setResizable(false);
	    
	}
}
