public abstract class Robot {

  // Attributes
  protected int id;
  protected int x;
  protected int y;

  // Constructor
  public Robot(int id, int x, int y) {
    this.id = id;
    this.x  = x;
    this.y  = y;
  }

  // Accessors
  public void move(int x, int y, World map) {
    map.moveRobot(x, y);
  }

}
