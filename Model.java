package sokoban;

class Model {

    Viewer viewer;

    boolean flag;
    char gamerDirection;

    int indexI;
    int indexJ;
    int countWin = 0;

    int[][] arrayGoals;

    int currentLevels = 0;

    Levels levels = new Levels();

    public int[][] desktop = levels.nextLevel();

    Model(Viewer viewer) {
        this.viewer = viewer;

        if(flag == true) {
            viewer.canvas.paint(viewer.canvas.getGraphics());
        }

        viewer.loadImage();
        initialization();
    }

    public void initialization() {
        int countGamer = 0;
        int countGoal = 0;
        int countBox = 0;

        for(int i = 0; i < desktop.length; i++) {
            for(int j = 0; j < desktop[i].length; j++) {
                if(desktop[i][j] == 1) {
                    indexI = i;
                    indexJ = j;
                    countGamer++;
                }

                if(desktop[i][j] == 3) {
                    countBox++;
                }

                if(desktop[i][j] == 4) {
                    countGoal++;
                }
            }
        }

        arrayGoals = new int[2][countGoal];
        int indexGoal = 0;
		for(int i = 0; i < desktop.length; i++) {
            for(int j = 0; j < desktop[i].length; j++) {
                if(desktop[i][j] == 4) {

                    arrayGoals[0][indexGoal] = i;
                    arrayGoals[1][indexGoal] = j;
                    indexGoal++;
                }
            }
		}

        if(countGamer != 1 || countBox == 0 || countGoal == 0 || (countBox != countGoal)) {
            flag = true;
        }

    }

    public void move(char direction) {
        gamerDirection = direction;

        if(direction == 'L') {
            moveLeft();

        } else if(direction == 'R') {
            moveRight();

        } else if(direction == 'U') {
            moveUp();
            
        } else if(direction == 'D') {
            moveDown();
            
        }

        check();
        viewer.updateCanvas();
        check_win();

    }

    public void check() {
        for(int j = 0; j < arrayGoals[0].length; j++) {
            int x = arrayGoals[0][j];
            int y = arrayGoals[1][j];
    
            if(desktop[x][y] == 0) {
                desktop[x][y] = 4;
            }
        }
    }

    public void check_win() {
        boolean isFinished = true;

        for(int j = 0; j < arrayGoals[0].length; j++) {
            int x = arrayGoals[0][j];
            int y = arrayGoals[1][j];
    
            if(desktop[x][y] != 3) {
                isFinished = false;
            }
        }
        
        if(isFinished) {
            countWin++;
            viewer.frame.setTitle(Integer.toString(countWin));
            javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(), "You Win: " + countWin);
            desktop = levels.nextLevel();
            initialization();
            viewer.updateCanvas();
        }
    }

    private void moveLeft() {
        if(desktop[indexI][indexJ - 1] == 3) {
            if(desktop[indexI][indexJ - 2] == 0 || desktop[indexI][indexJ - 2] == 4) {
                desktop[indexI][indexJ - 1] = 0;
                desktop[indexI][indexJ - 2] = 3;
            }
        }

        if(desktop[indexI][indexJ - 1] == 0 || desktop[indexI][indexJ - 1] == 4) {
            desktop[indexI][indexJ] = 0;
            indexJ = indexJ - 1;
            desktop[indexI][indexJ] = 1;
        }
    }

    private void moveRight() {
        if(desktop[indexI][indexJ + 1] == 3) {
            if(desktop[indexI][indexJ + 2] == 0 || desktop[indexI][indexJ + 2] == 4) {
                desktop[indexI][indexJ + 1] = 0;
                desktop[indexI][indexJ + 2] = 3;
            }
        }

        if(desktop[indexI][indexJ + 1] == 0 || desktop[indexI][indexJ + 1] == 4) {
            desktop[indexI][indexJ] = 0;
            indexJ = indexJ + 1;
            desktop[indexI][indexJ] = 1;
        }
    }

    private void moveUp() {
        if(desktop[indexI - 1][indexJ] == 3) {
            if(desktop[indexI - 2][indexJ] == 0 || desktop[indexI - 2][indexJ] == 4) {
                desktop[indexI - 1][indexJ] = 0;
                desktop[indexI - 2][indexJ] = 3;
            }
        }

        if(desktop[indexI - 1][indexJ] == 0 || desktop[indexI - 1][indexJ] == 4) {
            desktop[indexI][indexJ] = 0;
            indexI = indexI - 1;
            desktop[indexI][indexJ] = 1;
        }
    }

    private void moveDown() {
        if(desktop[indexI + 1][indexJ] == 3) {
            if(desktop[indexI + 2][indexJ] == 0 || desktop[indexI + 2][indexJ] == 4) {
                desktop[indexI + 1][indexJ] = 0;
                desktop[indexI][indexJ] = 3;
            }
        }

        if(desktop[indexI + 1][indexJ] == 0 || desktop[indexI + 1][indexJ] == 4) {
            desktop[indexI][indexJ] = 0;
            indexI = indexI + 1;
            desktop[indexI][indexJ] = 1;
        }
    }
}