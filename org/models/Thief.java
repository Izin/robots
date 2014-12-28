package org.models;
import org.controllers.*;


/**
 * A Thief is a robot that steal jewels
 *
 * @author  Malo Blanchard
 * @version 0.9
 * @see     Robot
 */
public abstract class Thief extends Robot {

  /**
   * Build a new instance of Thief
   *
   * @param  ref   Robot #reference, like an id (eg: R2)
   * @param  name  name of the robot
   */
  public Thief() {}
  public Thief(String ref, String name) {
    super(ref, name);
  }

  /**
   * Find random coordinates adjacents to the current cell.
   *
   * @param  c  Instance of the Controller
   * @param  w  Instance of World model
   */
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

  /**
   * Call the stealJewel() method
   *
   * @param  x  First part of the targeted cell's coordinates
   * @param  y  Second part of the targeted cell's coordinates
   * @param  w  Instance of World model
   */
  @Override public void use(int x, int y, World w) {
    this.stealJewel(x, y, w);
  }

  /**
   * Try stealing a jewel in a specific cell (using x and y)
   *
   * @param  x  First part of the targeted cell's coordinates
   * @param  y  Second part of the targeted cell's coordinates
   * @param  w  Instance of World model
   */
  public void stealJewel(int x, int y, World w) {}
}
