public class Model {
    private static int Heights = 8;
    private static int Lenghts = 6;
    private static int mins = 0;
    private static int flag = 0;

    private static int vin = 0;
    private static int btn;

    private static boolean in = false;

    public static int[][][] place;

    public void start() {
        place = new int[2][Heights][Lenghts];
        if(mins == 0)mins = (Heights * Lenghts) / 7;
        flag = mins;
    }

    public static boolean isIn() {
        return in;
    }

    public static void setIn(boolean in) {
        Model.in = in;
    }

    public static int getVin() {
        return vin;
    }

    public static void setVin(int vin) {
        Model.vin = vin;
    }

    public static int getHeights() {
        return Heights;
    }

    public static void setHeights(int Heights) {
        Model.Heights = Heights;
    }

    public static int getLenghts() {
        return Lenghts;
    }

    public static void setLenghts(int getLenghts) {
        Model.Lenghts = getLenghts;
    }

    public static int getMins() {
        return mins;
    }

    public static void setMins(int mins) {
        Model.mins = mins;
    }

    public static int getBtn() {
        return btn;
    }

    public static void setBtn(int btn) {
        Model.btn = btn;
    }

    public static int getFlag() {
        return flag;
    }

    public static void setFlag(int flag) {
        Model.flag = flag;
    }
}
