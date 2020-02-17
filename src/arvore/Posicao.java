package arvore;

public class Posicao {
	private int x,y;
        
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Posicao(int x, int y) {
		this.x = x;
		this.y = y;
		// TODO Auto-generated constructor stub
	}
        public String toString()
        {
            return ("Posicao "+this.x+"\t"+this.y);
        }
}
