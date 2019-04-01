import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interface extends JFrame{

    JPanel      screen;
    Objeto      obj;
    int         FPS = 1000/50;
    boolean[]   isControler = new boolean[2];
    boolean     isStarting = true;
    boolean     cima=true,
                baixo=false,
                esquerda=true,
                direita=false;

    public Interface(){


        obj = new Objeto(0,0,80,80);
        obj.velocidade = 10;
        screen = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.fillRect(0,0,screen.getWidth(),10);                      // Superior
                g.fillRect(0,screen.getHeight()-10,screen.getWidth(),10);  // Inferior
                g.fillRect(0,0,10,screen.getHeight());                      // Esquerdo
                g.fillRect(screen.getWidth()-10,0,10,screen.getHeight());   // Direito
                obj.drawObjetoColorido(g);                                               // Gera o Objeto colorido
                g.setColor(Color.BLACK);                                                 // Seta a cor para a exibição dos eixos
                g.drawString("Eixos: X "+obj.x+" x Y"+obj.y, 10,100);         // Exibe os eixos
            }
        };
        super.getContentPane().add(screen);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(600,600);
        super.setVisible(true);
        obj.x = screen.getWidth()/2-obj.largura/2;
        obj.y = screen.getHeight()/2-obj.altura/2;
    }
    public void controler(){
        if(!isControler[0]){
            if(obj.y<=screen.getHeight()){
                if(obj.y>=screen.getHeight()-45){
                    baixo = true;           // setando true eu ativo o if(baixo==true)
                    cima=false;             // logo terei que desativar o if(cima==true)
                }
                if(cima==true){
                    obj.y+=obj.velocidade;  // aumenta o eixo Y
                }
            }
            if(obj.y>=10){
                if(obj.y<=45){
                    cima=true;              // setando true eu ativo o if(cima==true)
                    baixo=false;            // logo terei que desativar o if(baixo==true)
                }
                if(baixo==true){
                    obj.y-=obj.velocidade;  //diminui o eixo Y
                }
            }
            if(obj.x<=screen.getWidth()-40){
                if(obj.x >= screen.getWidth()-45){
                    direita=true;           // setando true eu ativo o if(direita==true)
                    esquerda=false;         // logo terei que desativar o if(esquerda==true)
                }
                if(esquerda==true){
                    obj.x+=obj.velocidade;  //aumenta o eixo X
                }
            }

            if(obj.x>40){
                if(obj.x<45){
                    esquerda=true;          // setando true eu ativo o if(esquerda==true)
                    direita=false;          // logo terei que desativar o if(direita==true)
                }
                if(direita==true){
                    obj.x-=obj.velocidade;  //diminui o eixo X
                }
            }
        }
    }
    public void start(){
        long prx=0;
        while (isStarting){
            if (System.currentTimeMillis()>=prx){
                screen.repaint();
                update();
                prx = System.currentTimeMillis()+FPS;
            }
        }
    }
    public void update(){
        controler();
    }
}
