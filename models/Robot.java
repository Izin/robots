package models;

import controllers.*;

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
  }

  // Accessors
  public void setPosition(int x, int y, World w) {
    this.x = w.isCoord(x, w.getWidth())  ? x : this.x;
    this.y = w.isCoord(x, w.getHeight()) ? y : this.y;
  }

  public void move(Controller c, World w) {}
  public void use(int x, int y, World w) {}
  public void setDirection() {}

  public int getX()         { return this.x;    }
  public int getY()         { return this.y;    }
  public String getRef()    { return this.ref;  }
  public String getName()   { return this.name; }

}
