package org.models;

import org.controllers.*;

public class JewelerMadman extends Jeweler {

  // Attributes
  private int direction = 0;

  // Constructor
  public JewelerMadman() {}

  public JewelerMadman(String ref, String name) {
    super(ref, name);
    System.out.println("Création du robot bijoutier fou " + name + " (" + ref + ")");
    this.setDirection();
  }

  @Override public void move(Controller c, World w) {
    //System.out.println("Direction : " + direction);
    int x = this.x;
    int y = this.y;
    switch(this.direction) {
      case 0 : y--; break; // top
      case 1 : x++; break; // right
      case 2 : y++; break; // bottom
      default: x--; break; // left
    }
    c.moveIfPossible(x, y, this, w);
  }

  @Override public void setDirection() {
    this.direction = (int) Math.abs(Math.random() * 4);
    //System.out.println("Direction de J1 : " + this.direction);
  }

}
