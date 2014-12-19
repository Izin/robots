public class Jeweler extends Robot {

  // Constructor
  public Jeweler(String ref, String name) {
    super(ref, name);
  }

  public void dropJewels(int x, int y, World w) {
    if (w.map[y][x].getState() == 0) {
      w.map[y][x].setState(1);
      //System.out.print(" -> perd des bijoux");
    }
  }

  @Override public void use(int x, int y, World w) {
    this.dropJewels(x, y, w);
  }

  public void changeDirection() {}

}
