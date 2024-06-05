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
            u1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            u2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            d1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            d2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            l1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            l2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            r1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            r2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
    	if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
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
        
        spriteCounter++;
        if(spriteCounter > 10) {
        	if(spriteNum == 1) {
        		spriteNum = 2;
        	}
        	else if(spriteNum == 2) {
        		spriteNum = 1;
        	}
        	spriteCounter = 0;
        }
    	}
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;

        switch (direction){
            case "up":
            	if(spriteNum == 1) {
            		image = u1;
            	}
            	if(spriteNum == 2) {
            		image = u2;
            	}
                break;
            case "down":
            	if(spriteNum == 1) {
            		image = d1;
            	}
            	if(spriteNum == 2) {
            		image = d2;
            	}
                break;
            case "left":
            	if(spriteNum == 1) {
            		image = l1;
            	}
            	if(spriteNum == 2) {
            		image = l2;
            	}
                break;
            case "right":
            	if(spriteNum == 1) {
            		image = r1;
            	}
            	if(spriteNum == 2) {
            		image = r2;
            	}
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize,null);
    }
}
