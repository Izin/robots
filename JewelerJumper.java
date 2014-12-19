public class JewelerJumper extends Jeweler {

  // Constructor
  public JewelerJumper(String ref, String name) {
    super(ref, name);
    System.out.println("Création du robot bijoutier sauteur " + name + " (" + ref + ")");
  }

  @Override public void move(Controller c, World w) {
    int x = (int) Math.abs(Math.random() * w.getWidth());
    int y = (int) Math.abs(Math.random() * w.getHeight());
    c.moveRobot(x, y, this, w);
  }

}
