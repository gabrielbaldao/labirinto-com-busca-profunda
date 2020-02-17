package arvore;

import Main.Singleton;
import java.util.ArrayList;

import gui.Canal;
import gui.Mapa;
import java.util.Collections;

import javax.swing.JOptionPane;

import java.lang.management.GarbageCollectorMXBean;
import java.sql.Time;
public class Arvore implements Canal {
	Node raiz;

	@Override
	public void iniciaArvore(int[][] mapa) {
//		piorCaso();
		raiz = new Node(mapa, Singleton.getInstance().getInicio());
		System.out.println("Raiz filhos " + raiz.getFilhos().size());
		long startTime = System.nanoTime();
		Node r = buscaLargura(raiz);
		System.err.println("Tempo de busca = "+(System.nanoTime()-startTime)+"\t");
		if (r != null) {
			
			for (int i = 0; i < r.getEstado().length; i++) {
				for (int j = 0; j < r.getEstado().length; j++) {
					System.out.print(r.getEstado()[i][j] + "\t");
				}
				System.out.println();
			}
			achaCaminho(r);
			JOptionPane.showMessageDialog(null, "Tempo de busca: "+(System.nanoTime()-startTime)+" nanosegundos");
			System.out.println(r.getPosicao().getX() + " e " + r.getPosicao().getY());
		} else {
			JOptionPane.showMessageDialog(null, "Solução inexistente \n Erro 404");
			
		}
	}

	public Node buscaProfundidade(Node x) {
		x.getEstado()[x.getPosicao().getX()][x.getPosicao().getY()] = 1;

		if (x.testaTerminal())
			
			{
			System.err.println("Terminal");
			return x;
			}
		else {
			System.err.println(x.getFilhos().size());
			System.out.println();
			
			for (Node i : x.getFilhos()) {
		

					System.err.println("ENtrou");
				
				return buscaProfundidade(i);
			
					}
		}
		return x;
	}

	public Node buscaLargura(Node x) {
		ArrayList<Node> fila = new ArrayList<>();
		x.getEstado()[x.getPosicao().getX()][x.getPosicao().getY()] = -1;
		addNaFila(x, fila);
		
			while (!fila.isEmpty()) {
				System.out.println(fila.size());
				Node aux = fila.remove(0);

				if (aux.testaTerminal())
					return aux;
				addNaFila(aux, fila);

			}
			return null;

		

	}

	private boolean naoEstaHistorico(Node x, ArrayList<Node> historico) {
		for (int i = 0; i < historico.size(); i++) {
			if (historico.get(i) == x)
				return false;
		}
		return true;
	}

	private void addNaFila(Node x, ArrayList<Node> fila) {
		for (Node i : x.getFilhos())
			fila.add(i);
	}

	public void achaCaminho(Node solucao) {
		ArrayList<Posicao> s = new ArrayList<>();

		while (solucao != null) {
			s.add(solucao.getPosicao());
			System.out.println(solucao.getPosicao().getX() + " " + solucao.getPosicao().getY());

			// solucao.getEstado();
			solucao = solucao.getPai();

		}
		Collections.reverse(s);
		Singleton.getInstance().setS(s);

		new Mapa();

	}
	public void piorCaso()
	{
		System.out.println("Piores casos");
		for(int i =6;i<7;i++)
		{
			Singleton.getInstance().setFim(new Posicao(i-1, i-1));
			int[][] m = new int[i][i];
			for(int j =0;j<i;j++)
				for(int k=0;k<i;k++)
					m[j][k] =1;
			Node raiz = new Node(m, Singleton.getInstance().getInicio());
			
			long startTime = System.nanoTime();
			Node r = buscaLargura(raiz);
			System.err.println("Caso "+i+"Tempo de busca = "+(System.nanoTime()-startTime)+"\t");
			System.gc();

		}
	}
}
