import java.util.Random;

public abstract class Robot {

  // Attributes
  protected String ref;
  protected String name;
  protected int x = 0;
  protected int y = 0;

  // Constructor
  public Robot(String ref, String name) {
    this.ref  = ref;
    this.name = name;
    System.out.println("Création du robot " + name + " (#" + ref + ")");
  }

  // Accessors
  public String show() {
    return this.getRef() + " | " + this.getName();
  }

  public void move(Supervisor s, World w) {
    Random random1 = new Random();
    Random random2 = new Random();
    int x          = random1.nextInt(w.getWidth());
    int y          = random2.nextInt(w.getWidth());
    s.moveRobot(x, y, "", this, w);
  }

  public void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX()         { return this.x;    }
  public int getY()         { return this.y;    }
  public String getRef()    { return this.ref;  }
  public String getName()   { return this.name; }

}
