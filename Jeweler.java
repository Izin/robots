// @todo robot pollueur (laisse tomber des pièces, diamants et billets sur la case)
// @todo passer en paramètre le Supervisor, faire un getWorld() pour utiliser
// la propriété Supervisor.world
import java.util.Random;

public class Jeweler extends Robot {

  // Constructor
  public Jeweler(String ref, String name) {
    super(ref, name);
  }

  public void move(Supervisor s, World w) {
    Random random1 = new Random();
    Random random2 = new Random();
    int x          = random1.nextInt(w.getWidth());
    int y          = random2.nextInt(w.getWidth());
    s.moveRobot(x, y, this);
  }

}
