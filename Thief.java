import java.util.Random;

public abstract class Thief extends Robot {

  // Constructor
  public Thief(String ref, String name, int x, int y) {
    super(ref, name, x, y);
    //System.out.println("Création du robot voleur " + name + " (" + ref + ")");
  }

  public void stealJewels(int x, int y, World w) {
    if (w.map[y][x].getState() == 1) {
      w.map[y][x].setState(0);
      //System.out.print(" -> vole les bijoux");
    } else {
      //System.out.print(" -> rien à voler");
    }
  }

  @Override public void move(Controller c, World w) {
    Random random1 = new Random();
    Random random2 = new Random();
    int x          = random1.nextInt(w.getWidth());
    int y          = random2.nextInt(w.getHeight());
    c.moveRobot(x, y, this, w);
  }

  @Override public void use(int x, int y, World w) {
    this.stealJewels(x, y, w);
  }

}
