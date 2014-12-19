public abstract class Robot {

  // Attributes
  protected String ref;
  protected String name;
  protected int x;
  protected int y;

  // Constructor
  public Robot(String ref, String name, int x, int y) {
    this.ref  = ref;
    this.name = name;
    this.setPosition(x, y);
  }

  // Accessors
  public void move(Controller c, World w) {
  }

  public void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void use(int x, int y, World w) {}

  public int getX()         { return this.x;    }
  public int getY()         { return this.y;    }
  public String getRef()    { return this.ref;  }
  public String getName()   { return this.name; }

}
