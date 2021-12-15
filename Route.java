public class Route{
    private Player owner =null;
    private EdgeLocation location;


    public Route(int x,int y,int or){
        location=new EdgeLocation(x, y, or);
    }
    public void setOwner(Player p){
        if(null==owner){
            owner=p;
        }
        //p.add(this);
    }
    public Player getOwner(){return owner;}
    public EdgeLocation getEdgeLocation(){return location;}

}