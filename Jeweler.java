import java.util.Random;
import java.lang.reflect.Method;

public class Jeweler extends Robot {

  // Constructor
  public Jeweler(String ref, String name, int x, int y) {
    super(ref, name);
    this.x = x;
    this.y = y;
  }

  @Override public void move(Supervisor s, World w) {
    Random random1 = new Random();
    Random random2 = new Random();
    int x          = random1.nextInt(w.getWidth());
    int y          = random2.nextInt(w.getWidth());
    s.moveRobot(x, y, "dropJewels", this, w);
  }

}
