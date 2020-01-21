package sokoban;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Controller implements KeyListener {

    Model model;
    Controller(Viewer viewer) {
        model = new Model(viewer);

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        char direction = 'N';

        switch(keyCode) {
            case 37:
                direction = 'L';

            break;

            case 38:
                direction = 'U';

            break;

            case 39:
                direction = 'R';

            break;

            case 40:
                direction = 'D';

            break;

        } // switch
        
        model.move(direction);
    }// keyPressed

    public void keyReleased(KeyEvent e) {

    }
}