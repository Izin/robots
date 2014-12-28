package org.models;


/**
 * A ThiefExpert is a drunked robot that steal jewels like a pro
 *
 * @author  Malo Blanchard
 * @version 0.9
 * @see     Thief
 */
public class ThiefExpert extends Thief {

  /**
   * Build a new instance of ThiefExpert
   *
   * @param  ref   Robot #reference, like an id (eg: R2)
   * @param  name  name of the robot
   */
  public ThiefExpert() {}
  public ThiefExpert(String ref, String name) {
    super(ref, name);
    this.image = "expert";
  }

  /**
   * Try stealing a jewel in a specific cell (using x and y) and always succeed
   *
   * @param  x  First part of the targeted cell's coordinates
   * @param  y  Second part of the targeted cell's coordinates
   * @param  w  Instance of World model
   */
  @Override public void stealJewel(int x, int y, World w) {
    if (w.grid[y][x].hasJewel()) {
      w.grid[y][x].steal();
    }
  }

}
