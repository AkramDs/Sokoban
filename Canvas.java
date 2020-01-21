package sokoban;

import javax.imageio.ImageIO;

import javax.swing.JPanel;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

import java.io.File;
import java.io.IOException;

class Canvas extends JPanel {

    private static final long serialVersionUID = 536871008l;

    Model model;

    Image imageGamer;
    Image imageWall;
    Image imageGoal;
    Image imageBox;

    Font font;

    Canvas(Model model) {
        this.model = model;
        setBackground(Color.black);

        font = new Font("Impact", Font.BOLD, 35);

        File fileGamer = new File("images/gamer.png");
        File fileWall = new File("images/wall.png");
        File fileGoal = new File("images/goal.png");
        File fileBox = new File("images/box.png");

        try {
            imageGamer = ImageIO.read(fileGamer);
            imageWall = ImageIO.read(fileWall);
            imageGoal = ImageIO.read(fileGoal);
            imageBox = ImageIO.read(fileBox);

        } catch(IOException ioe) {
            model.flag = true;
            System.out.println(ioe);

        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        if(model.flag) {
			g.setFont(font);
			g.setColor(Color.red);
			g.drawString("Initialization Error!!!", 50, 50);

		} else {
			drawDesktop(g);
		}
    }

    public void drawDesktop(Graphics g) {
        int startX = 50;
        int startY = 50;
        
        int x = startX;
        int y = startY;
        int width = 30;
        int height = 30;
        int offset = 0;

        for(int i = 0; i < model.desktop.length; i++) {
            for(int j = 0; j < model.desktop[i].length; j++) {
                if(model.desktop[i][j] == 1) {
                    g.drawImage(imageGamer, x, y, null);

                } else if(model.desktop[i][j] == 2) {
                    g.drawImage(imageWall, x, y, null);

                } else if(model.desktop[i][j] == 3) {
                    g.drawImage(imageBox, x, y, null);
        
                } else if(model.desktop[i][j] == 4) {
                    g.drawImage(imageGoal, x, y, null);

                }

                x = x + width + offset;
            } // for J
            x = startX;
            y = y + height + offset;
        } // for I
    } // public void drawDesktop()
} // class Canvas