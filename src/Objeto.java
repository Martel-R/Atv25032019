import java.awt.Color;
import java.awt.Graphics;

public class Objeto {
    public int x;
    public int y;
    public int largura;
    public int altura;
    public int velocidade;

    public Objeto(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }
    
    public void drawObjetoColorido(Graphics g){
        Color [] color = {
                Color.MAGENTA,
                Color.BLUE,
                Color.CYAN,
                Color.GREEN,
                Color.YELLOW,
                Color.decode("#ff7f00"),
                Color.RED
        };
        for (int i=6; i>=0;i--){
            g.setColor(color[i]);
            g.fillOval(x-(((i+1)*10)/2), y-(((i+1)*10)/2),(i+1)*10 , (i+1)*10);
        }
    }
    
}
