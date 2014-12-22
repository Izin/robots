package models;

import controllers.*;

public abstract class Thief extends Robot {

  // Constructor
  public Thief(String ref, String name) {
    super(ref, name);
  }

  public void stealJewels(int x, int y, World w) {}

  @Override public void move(Controller c, World w) {
    int x = (int) Math.abs(Math.random() * w.getWidth());
    int y = (int) Math.abs(Math.random() * w.getHeight());
    c.moveRobot(x, y, this, w);
  }

  @Override public void use(int x, int y, World w) {
    this.stealJewels(x, y, w);
  }

}
