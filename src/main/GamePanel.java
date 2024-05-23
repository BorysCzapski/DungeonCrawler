import java.awt.*;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = 48;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = 768;
    final int screenHeight = 576;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    public void run() {
        while (true) {

            long currentTime = System.nanoTime();

            update();
            try {
                Thread.sleep(1000 / 60); // 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public void update() {
        if(keyH.upPressed == true){
            playerY -= playerSpeed;
        }else if(keyH.downPressed == true){
            playerY += playerSpeed;
        }else if(keyH.leftPressed == true){
            playerX -= playerSpeed;
        }else if(keyH.rightPressed == true){
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);

        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose();
    }
}
