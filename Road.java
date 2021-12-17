public class Road {
    private Player player;
    private int x;
    private int y;

    public Road(int x, int y, Player player) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Player getPlayer(){
        return this.player;
    }
}