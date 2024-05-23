package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "right";
    }
    public void getPlayerImage() {
        try{
            u1 = ImageIO.read(getClass().getResourceAsStream("/player/u1.png"));

            d1 = ImageIO.read(getClass().getResourceAsStream("/player/d1.png"));

            l1 = ImageIO.read(getClass().getResourceAsStream("/player/l1.png"));

            r1 = ImageIO.read(getClass().getResourceAsStream("/player/r1.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyH.upPressed == true){
            direction = "up";
            y -= speed;
        }else if(keyH.downPressed == true){
            direction = "down";
            y += speed;
        }else if(keyH.leftPressed == true){
            direction = "left";
            x -= speed;
        }else if(keyH.rightPressed == true){
            direction = "right";
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;

        switch (direction){
            case "up":
                image = u1;
                break;
            case "down":
                image = d1;
                break;
            case "left":
                image = l1;
                break;
            case "right":
                image = r1;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize,null);
    }
}
