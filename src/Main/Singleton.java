package Main;

import arvore.Posicao;
import java.util.ArrayList;
import javax.swing.JButton;


public final class Singleton {

    private static final Singleton instance = new Singleton();
    

    private int tamanhoMatriz;
    private Posicao inicio;
    private Posicao fim;
    
    private ArrayList <Posicao> s =  new ArrayList <Posicao>();
    private ArrayList <JButton> b =  new ArrayList <JButton>();
    private Singleton() {
        
    }
    
    public int getTamanhoMatriz() {
        return tamanhoMatriz;
    }

    public void setTamanhoMatriz(int tamanhoMatriz) {
        this.tamanhoMatriz = tamanhoMatriz;
    }

    public Posicao getInicio() {
        return inicio;
    }

    public void setInicio(Posicao inicio) {
        this.inicio = inicio;
    }

    public Posicao getFim() {
        return fim;
    }

    public void setFim(Posicao fim) {
        this.fim = fim;
    }

    
    public static Singleton getInstance() {
      
        return instance;
    }

    /**
     * @return the s
     */
    public ArrayList <Posicao> getS() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(ArrayList <Posicao> s) {
        this.s = s;
    }

    /**
     * @return the b
     */
    public ArrayList <JButton> getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(ArrayList <JButton> b) {
        this.b = b;
    }
    

}
