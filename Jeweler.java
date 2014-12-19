import java.util.Random;
import java.lang.reflect.Method;

public class Jeweler extends Robot {

  // Constructor
  public Jeweler(String ref, String name, int x, int y) {
    super(ref, name, x, y);
    //System.out.println("Création du robot bijoutier " + name + " (" + ref + ")");
  }

  @Override public void move(Supervisor s, World w) {
    Random random1 = new Random();
    Random random2 = new Random();
    int x          = random1.nextInt(w.getWidth());
    int y          = random2.nextInt(w.getHeight());
    s.moveRobot(x, y, "dropJewels", this, w);
  }

  @Override public void dropJewels(int x, int y, World w) {
    if (w.map[y][x].getState() == 0) {
      w.map[y][x].setState(1);
      //System.out.print(" -> perd des bijoux");
    }
  }

}
