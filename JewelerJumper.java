import java.util.Random;

public class JewelerJumper extends Jeweler {

  // Constructor
  public JewelerJumper(String ref, String name, int x, int y) {
    super(ref, name, x, y);
    //System.out.println("Création du robot bijoutier " + name + " (" + ref + ")");
  }

  @Override public void move(Controller c, World w) {
    Random random1 = new Random();
    Random random2 = new Random();
    int x          = random1.nextInt(w.getWidth());
    int y          = random2.nextInt(w.getHeight());
    c.moveRobot(x, y, this, w);
  }

}
