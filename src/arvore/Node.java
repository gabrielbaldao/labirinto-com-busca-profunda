package arvore;

import Main.Singleton;
import java.util.ArrayList;

public class Node {
	private Node pai;
	private int[][] estado;
	private Posicao posicao;


	public Node getPai() {
		return pai;
	}

	public void setPai(Node pai) {
		this.pai = pai;
	}

	public int[][] getEstado() {
		return estado;
	}

	public void setEstado(int[][] estado) {
		this.estado = estado;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public ArrayList<Node> getFilhos() {
		return filhos;
	}

	public void setFilhos(ArrayList<Node> filhos) {
		this.filhos = filhos;
	}

	private ArrayList<Node> filhos;

	public Node(int[][] estado, Posicao posicao) {
		this.filhos = new ArrayList<>();
		this.pai = null;
		this.estado = estado;
		this.posicao = posicao;
//                this.estado[this.posicao.getX()][this.posicao.getY()] = -1;
		geraFilhos();
	}

	public void addFilho(Node filho) {
		filho.setPai(this);
		this.filhos.add(filho);
	}

	public boolean testaTerminal() {
//		int matriz = (int) (this.estado.length)-1;
//                                    System.out.println("Fim "+((Singleton.getInstance().getFim().getX()==this.posicao.getX()) && (Singleton.getInstance().getFim().getY())==this.posicao.getY()));
//                                    System.out.println("Fim "+Singleton.getInstance().getFim().getX()+"\t"+this.posicao.getX() +"\t"+ Singleton.getInstance().getFim().getY()+"\t"+this.posicao.getY());

		if (this.estado[Singleton.getInstance().getFim().getX()][Singleton.getInstance().getFim().getY()] == -1)
                {

			return true;
                }
		return false;
	}

	public void geraFilhos() {
		Posicao xesquerda = new Posicao(this.posicao.getX() - 1, this.posicao.getY());
		Posicao xdireita = new Posicao(this.posicao.getX() + 1, this.posicao.getY());
		Posicao ycima = new Posicao(this.posicao.getX(), this.posicao.getY() - 1);
		Posicao ybaixo = new Posicao(this.posicao.getX(), this.posicao.getY() + 1);

		/* Verificando os X */
		if (dentroDaMatriz(xesquerda)) {
			verificaPosicao(xesquerda);
		}
		if (dentroDaMatriz(xdireita)) {
			verificaPosicao(xdireita);

		}
		if (dentroDaMatriz(ycima)) {
			verificaPosicao(ycima);

		}
		if (dentroDaMatriz(ybaixo)) {
			verificaPosicao(ybaixo);

		}

	

	}

	private void verificaPosicao(Posicao posicao) {
		if (this.estado[posicao.getX()][posicao.getY()] == 1) {
			int[][] matriz = copiaEstado();
			matriz[posicao.getX()][posicao.getY()] = -1;
			
			Node f = new Node(matriz, posicao);
			this.addFilho(f);
			
		}
	}

	private boolean dentroDaMatriz(Posicao posicao) {
		return posicao.getX() >= 0 && posicao.getX() < this.estado.length && posicao.getY() >= 0
				&& posicao.getY() < this.estado.length;

	}

	private int[][] copiaEstado() // geralmente com a funcao clone, obtive problemas
	{
		int[][] copia = new int[this.estado.length][this.estado.length];
		for (int i = 0; i < this.estado.length; i++) {
			for (int j = 0; j < this.estado.length; j++) {
				copia[i][j] = this.estado[i][j];
			}
		}
		return copia;
	}

}
