package org.models;

import org.controllers.*;

public abstract class Thief extends Robot {

  // Constructor
  public Thief() {}

  public Thief(String ref, String name) {
    super(ref, name);
    this.image = "thief";
  }

  public void stealJewels(int x, int y, World w) {}

  @Override public void move(Controller c, World w) {
    int x = (int) Math.abs(Math.random() * w.getWidth());
    int y = (int) Math.abs(Math.random() * w.getHeight());
    c.moveIfPossible(x, y, this, w);
  }

  @Override public void use(int x, int y, Jewel j, World w) {
    this.stealJewels(x, y, w); // todo passer les jewels en param de cette fonction ?
  }

}
