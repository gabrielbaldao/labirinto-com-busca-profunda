package gui;

import Main.Main;
import Main.Singleton;
import arvore.Posicao;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Mapa extends JPanel {
	// constantes
	private int tempo = 80;
	// variaveis
	public static final String PREENCHIDO = "1";
	public static final String VAZIO = "";

	private ArrayList<JButton> casas;

	private String jogador;
	private ArrayList<JButton> lista;
	private Canal c;
	private int[][] estados;

	// construtor
	public Mapa(int tamanho, Canal c) {
		this.c = c;
		jogador = VAZIO;
		lista = new ArrayList<>();
		inicializaTabuleiro(tamanho);
		Singleton.getInstance().setB(lista);

	}

	public Mapa() {
		coloreCaminho();
	}

	// metodos
	private void inicializaTabuleiro(int tamanho) {

		GridLayout layout = new GridLayout(tamanho + 1, tamanho);

		setLayout(layout);

		for (int i = 0; i < tamanho * tamanho; i++) {

			getLista().add(new JButton(""));
			getLista().get(getLista().size() - 1).setBackground(Color.white);
			add(getLista().get(getLista().size() - 1));

		}
		/*
		 * int auxInicio =
		 * Singleton.getInstance().getInicio().getX()+((Singleton.getInstance().
		 * getInicio().getY())*tamanho); System.out.println("auxInicio: "+ auxInicio);
		 * 
		 * int auxFim =
		 * Singleton.getInstance().getFim().getX()+((Singleton.getInstance().getFim().
		 * getY())*tamanho); System.out.println("auxFim: "+ auxFim);
		 * 
		 * getLista().get(auxInicio).setForeground(Color.green);
		 * //getLista().get(auxInicio).setText("Entrada");
		 * getLista().get(auxFim).setForeground(Color.cyan);
		 * //getLista().get(auxFim).setText("Saida");
		 */
		setBounds(0, 0, 494, 500);

		setEventos();
	}

	public void marcaCaminho(String jogador) {

	}

	public void setEventos() {
		for (JButton casa : getLista()) {
			casa.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (casa.getText().equals(PREENCHIDO)) {
						casa.setText(VAZIO);
						casa.setBackground(Color.white);
					} else {
						casa.setText(PREENCHIDO);
						casa.setBackground(Color.black);
					}
					/*
					 * else{ if (casa.getBackground() == Color.white){
					 * casa.setBackground(Color.black); } else{ casa.setBackground(Color.white); } }
					 */

				}
			});
		}
	}

	public int[][] getEstado() {
		int t = (int) Math.sqrt(getLista().size());

		int novoEstado[][] = new int[t][t];
		int indice = 0;
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < t; j++) {

				if (getLista().get(indice).getText().equals(PREENCHIDO)) {
					novoEstado[i][j] = 1;
					getLista().get(indice).setBackground(Color.black);
				}
				if (getLista().get(indice).getText().equals(VAZIO)) {
					novoEstado[i][j] = 0;
				}

				++indice;
			}

		}

		return novoEstado;
	}

	/**
	 * @return the lista
	 */
	public ArrayList<JButton> getLista() {
		return lista;
	}

	/**
	 * @param lista
	 *            the lista to set
	 */
	public void setLista(ArrayList<JButton> lista) {
		this.lista = lista;
	}

	/**
	 * @return the c
	 */
	public Canal getC() {
		return c;
	}

	/**
	 * @param c
	 *            the c to set
	 */
	public void setC(Canal c) {
		this.c = c;
	}

	public void coloreCaminho() {
		new Thread(t1).start();

	}

	private Runnable t1 = new Runnable() {
		public void run() {
			try {

				int tam = Singleton.getInstance().getTamanhoMatriz();

				System.out.println("tam :" + tam);
				for (int i = 0; i < Singleton.getInstance().getS().size(); i++) {

					System.out.println(Singleton.getInstance().getS().get(i).getY() + " "
							+ Singleton.getInstance().getS().get(i).getX());

					int casa = Singleton.getInstance().getS().get(i).getY()
							+ (Singleton.getInstance().getS().get(i).getX() * tam);

					System.out.println("casa: " + casa);
					Singleton.getInstance().getB().get(casa).setBackground(Color.pink);
					Singleton.getInstance().getB().get(casa).setText("");
					pause();
				}

				/*
				 * for(int i=0;i<lista.size();i++){ pause();
				 * getLista().get(i).setBackground(Color.pink); }
				 */

			} catch (Exception e) {
			}

		}
	};

	public void pause() {
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
		}
	}
}
