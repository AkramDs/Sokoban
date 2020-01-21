package sokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Image;

import javax.swing.JFrame;

class Viewer {
    Controller controller;
    Canvas canvas;
    Image image;

    protected JFrame frame;

    Viewer() {
        controller = new Controller(this);
        canvas = new Canvas(controller.model);

        frame = new JFrame(Integer.toString(controller.model.countWin));
        frame.setSize(500, 500);
        frame.setIconImage(image);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.addKeyListener(controller);
        frame.setVisible(true);
    }

    public void loadImage() {
        try {
            image = ImageIO.read(new File("images/duke.jpeg"));

        } catch(IOException ioe) {
            System.out.println(ioe);
            
        }
    }

    public void updateCanvas() {
        canvas.repaint();
    }
}