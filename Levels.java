package sokoban;

class Levels {
    private int currentLevels = 1;

    public int[][] nextLevel() {
        int[][] newDesktop = null;

        switch(currentLevels) {
            case 1:
                newDesktop = level1();
            break;

            default:
                newDesktop = level1();
                currentLevels = 1;
            break;
        }

        currentLevels++;
        return newDesktop;
    }

    private int[][] level1() {
        int[][] level = 
        {
            {2,2,2,2,2,2,2,2,2},
            {2,0,0,0,0,0,0,0,2},
            {2,0,1,0,0,0,0,0,2},
            {2,0,3,4,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,2},
            {2,2,2,2,2,2,2,2,2}
        };

        return level;
    }
}