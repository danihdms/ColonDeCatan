public class EdgeLocation extends Location{
    private int orientation;
    
    public EdgeLocation(int x,int y,int or){
        super(x, y);
        orientation=or;
    }
    public int getOr(){return orientation;}
}
