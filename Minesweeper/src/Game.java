public class Game {
    private Model mnd = new Model();

    public void RegulateMassiv() {
        int c = 1;
        while (c != 0) {
            c = 0;
            for (int i = 0; i < mnd.getHeights(); i++) {
                for (int j = 0; j < mnd.getLenghts(); j++) {
                    if (mnd.place[1][i][j] == 1 && mnd.place[0][i][j] == 0) {
                        if (i < mnd.getHeights() - 1 && mnd.place[0][i + 1][j] >= 0 && mnd.place[0][i + 1][j] < 9 && mnd.place[1][i + 1][j] != 1) {
                            mnd.place[1][i + 1][j] = 1;
                            c++;
                        }
                        if (j < mnd.getLenghts() - 1 && mnd.place[0][i][j + 1] >= 0 && mnd.place[0][i][j + 1] < 9 && mnd.place[1][i][j + 1] != 1) {
                            mnd.place[1][i][j + 1] = 1;
                            c++;
                        }
                        if (j > 0 && mnd.place[0][i][j - 1] >= 0 && mnd.place[0][i][j - 1] < 9 && mnd.place[1][i][j - 1] != 1) {
                            mnd.place[1][i][j - 1] = 1;
                            c++;
                        }
                        if (i > 0 && mnd.place[0][i - 1][j] >= 0 && mnd.place[0][i - 1][j] < 9 && mnd.place[1][i - 1][j] != 1) {
                            mnd.place[1][i - 1][j] = 1;
                            c++;
                        }
                        if (i < mnd.getHeights() - 1 && j < mnd.getLenghts() - 1 && mnd.place[0][i + 1][j + 1] >= 0 && mnd.place[0][i + 1][j + 1] < 9 && mnd.place[1][i + 1][j + 1] != 1) {
                            mnd.place[1][i + 1][j + 1] = 1;
                            c++;
                        }
                        if (j > 0 && i > 0 && mnd.place[0][i - 1][j - 1] >= 0 && mnd.place[0][i - 1][j - 1] < 9 && mnd.place[1][i - 1][j - 1] != 1) {
                            mnd.place[1][i - 1][j - 1] = 1;
                            c++;
                        }
                        if (j > 0 && i < mnd.getHeights() - 1 && mnd.place[0][i + 1][j - 1] >= 0 && mnd.place[0][i + 1][j - 1] < 9 && mnd.place[1][i + 1][j - 1] != 1) {
                            mnd.place[1][i + 1][j - 1] = 1;
                            c++;
                        }
                        if (i > 0 && j < mnd.getLenghts() - 1 && mnd.place[0][i - 1][j + 1] >= 0 && mnd.place[0][i - 1][j + 1] < 9 && mnd.place[1][i - 1][j + 1] != 1) {
                            mnd.place[1][i - 1][j + 1] = 1;
                            c++;
                        }
                    }
                }
            }
        }
    }
    public void restart(){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < mnd.getHeights(); j++) {
                for (int f = 0; f < mnd.getLenghts(); f++) {
                    mnd.place[i][j][f] = 0;
                }
            }
        }
        mnd.setFlag(mnd.getMins());
    }
    public void start(int MouseX, int MouseY) {
        int rnd1 = 0;
        for (int i = 0; i < mnd.getHeights(); i++) {
            for (int j = 0; j < mnd.getLenghts(); j++) {
                mnd.place[0][i][j] = 0;
            }
        }
        for (int i = 0; i < mnd.getMins(); i++) {
            int i1;
            rnd1 = (int) (Math.random() * mnd.getHeights());
            i1 = (int) (Math.random() * mnd.getLenghts());
            if (rnd1 == MouseY && i1 == MouseX) i--;
            else {
                if (mnd.place[0][rnd1][i1] != -1) {
                    mnd.place[0][rnd1][i1] = -1;
                } else i--;
            }
        }
        for (int i = 0; i < mnd.getHeights(); i++) {
            for (int j = 0; j < mnd.getLenghts(); j++) {
                if (mnd.place[0][i][j] != -1) {
                    rnd1 = 0;
                    if (j > 0 && i < mnd.getHeights() - 1) if (mnd.place[0][i + 1][j - 1] == -1) rnd1++;
                    if (i < mnd.getHeights() - 1) if (mnd.place[0][i + 1][j] == -1) rnd1++;
                    if (j < mnd.getLenghts() - 1 && i < mnd.getHeights() - 1) if (mnd.place[0][i + 1][j + 1] == -1) rnd1++;
                    if (j > 0) if (mnd.place[0][i][j - 1] == -1) rnd1++;
                    if (j < mnd.getLenghts() - 1) if (mnd.place[0][i][j + 1] == -1) rnd1++;
                    if (j > 0 && i > 0) if (mnd.place[0][i - 1][j - 1] == -1) rnd1++;
                    if (i > 0) if (mnd.place[0][i - 1][j] == -1) rnd1++;
                    if (j < mnd.getLenghts() - 1 && i > 0) if (mnd.place[0][i - 1][j + 1] == -1) rnd1++;
                    mnd.place[0][i][j] = rnd1;
                }
            }
        }
    }

    public static void main(String[] args) {
        OnFrame First = new OnFrame();
    }
}


