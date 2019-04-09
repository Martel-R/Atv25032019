package EarthDefender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame {
    JPanel screen;
    private int FPS = 60;
    private boolean [] isControler = new boolean[4];

    Player player;
    Inimigo inimigo;

    public Main (){
        super.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                tecla(e.getKeyCode(),true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                tecla(e.getKeyCode(),false);
            }
        });
        screen = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };
        super.getContentPane().add(screen);
        super.setSize(600,600);
        super.setVisible(true);
        super.setTitle("Earth Defender");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void tecla(int tecla, boolean isPressed) {
        switch (tecla){
            case KeyEvent.VK_LEFT:
                isControler[0] = isPressed;
            break;
            case KeyEvent.VK_RIGHT:
                isControler[1] = isPressed;
                break;
            case KeyEvent.VK_UP:
                isControler[2] = isPressed;
                break;
            case KeyEvent.VK_DOWN:
                isControler[3] = isPressed;
                break;

        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
    public void start(){
        long prx=0;
        while (true){
            if (System.currentTimeMillis()>=prx){
                screen.repaint();
                update();
                prx = System.currentTimeMillis()+FPS;
            }
        }
    }
    public void update(){
        setControler();
    }

    private void setControler() {
        if (isControler[0]){
            player.setPx(player.getPx()-player.getVelocidade());//esquerda
        }
        if (isControler[1]){
            player.setPx(player.getPx()+player.getVelocidade());// direita
        }
        if (isControler[2]){

        }
        if (isControler[3]){

        }

    }
}
