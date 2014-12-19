import java.util.Random;
import java.lang.reflect.Method;

public class Thief extends Robot {

  // Attributes

  // Constructor
  public Thief(String ref, String name, int x, int y) {
    super(ref, name, x, y);
    //System.out.println("Création du robot voleur " + name + " (" + ref + ")");
  }

  @Override public void move(Supervisor s, World w) {
    Random random1 = new Random();
    Random random2 = new Random();
    int x          = random1.nextInt(w.getWidth());
    int y          = random2.nextInt(w.getHeight());
    s.moveRobot(x, y, "stealJewels", this, w);
  }

  @Override public void stealJewels(int x, int y, World w) {
    if (w.map[y][x].getState() == 1) {
      w.map[y][x].setState(0);
      //System.out.print(" -> vole les bijoux");
    } else {
      //System.out.print(" -> rien à voler");
    }
  }

}
