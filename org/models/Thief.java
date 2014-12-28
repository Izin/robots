package org.models;

import org.controllers.*;

public abstract class Thief extends Robot {

  // Constructor
  public Thief() {}

  public Thief(String ref, String name) {
    super(ref, name);
  }

  public void stealJewels(int x, int y, World w) {}

  @Override public void move(Controller c, World w) {
    int x = this.x;
    int y = this.y;
    int r = (int) Math.abs(Math.random() * 8);

    switch(r) {
      case 0 : x--; y--; break; // top-left
      case 1 : x--;      break; // top
      case 2 : x--; y++; break; // top-right
      case 3 : x++;      break; // right
      case 4 : x--;      break; // left
      case 5 : x++; y++; break; // bottom-right
      case 6 : x++;      break; // bottom
      default: x++; y--; break; // bottom-left
    }

    c.moveIfPossible(x, y, this, w);
  }

  @Override public void use(int x, int y, World w) {
    this.stealJewels(x, y, w); // todo passer les jewels en param de cette fonction ?
  }

}
