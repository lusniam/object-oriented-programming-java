import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel {
    private ArrayList<Kula> listaKul;
    private int size = 20;
    private Timer timer;
    private final int DELAY = 16;  //dla 30fps -> 1s/30 = 0,033s
    
    public Panel() {
        listaKul = new ArrayList<>();
        setBackground(Color.BLACK);
        addMouseListener(new Event());
        addMouseWheelListener(new Event());
        timer = new Timer(DELAY, new Event());
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Kula k : listaKul) {
            g.setColor(k.color);
            g.drawOval(k.x, k.y, k.size, k.size);
        }
        g.setColor(Color.YELLOW);
        g.drawString(Integer.toString(listaKul.size()),40,40);
    }
    
    private class Event implements MouseWheelListener, MouseListener, ActionListener {
        @Override
        public void mouseClicked(MouseEvent e) { }
        
        @Override
        public void mousePressed(MouseEvent e) {
            listaKul.add(new Kula(e.getX(), e.getY(), size));
            repaint();
            size = 20;
        }
        
        @Override
        public void mouseReleased(MouseEvent e) { }
        
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            size -= e.getWheelRotation();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            timer.stop();
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            timer.start();
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Kula k : listaKul) {
                k.update();
            }
            repaint();
        }
    }
    
    private class Kula {
        public int x, y, size;
        double xspeed, yspeed;
        public Color color;
        private final int MAX_SPEED = 5;
        
        private double genSpeed() {
            double speed = (2*Math.random()-1) * MAX_SPEED;
            return (speed!=0 ? speed : genSpeed());
        }

        public Kula(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
            color = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
            xspeed = genSpeed();
            yspeed = genSpeed();
        }
        
        private void checkColision(Kula other){
            double dx = x + size/2 - other.x - other.size/2;
            double dy = y + size/2 - other.y - other.size/2;
            double distance = Math.sqrt(dx*dx + dy*dy);
            if (distance < size/2 + other.size/2){
                double angle = Math.atan2(dy, dx);
                double otherspeed = Math.sqrt(other.xspeed*other.xspeed + other.yspeed*other.yspeed);
                double thisspeed = Math.sqrt(xspeed*xspeed + yspeed*yspeed);

                double newotherspeed = (()*this.size*thisspeed)/(other.size*(()*(other.yspeed/otherspeed)-(other.xspeed/otherspeed)));
                double newspeed = (this.size*thisspeed-other.size*newotherspeed*(other.yspeed/otherspeed))/(this.size*(this.yspeed/thisspeed)-other.size*(other.yspeed/otherspeed));
            }
        }

        public void update() {
            x += xspeed;
            y += yspeed;
            if ((x < 0 && xspeed < 0) || (x > getWidth() - size && xspeed > 0)) {
                xspeed = -xspeed;
            }
            if ((y < 0 && yspeed < 0) || (y > getHeight() - size && yspeed > 0)) {
                yspeed = -yspeed;
            }

            for(Kula other : listaKul){
                if (other != this){
                    checkColision(other);
                }
            }
        }
    }
}