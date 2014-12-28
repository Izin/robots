package org.controllers;
import org.models.*;
import org.views.*;
import java.util.ArrayList;


/**
 * Intelligence of the application. Actions like robot:move() are checked here
 *
 * @author  Malo Blanchard
 * @version 0.9
 */
public class Controller {

  private ArrayList<Robot> robots = new ArrayList<Robot>();

  /**
   * Build a new instance of the Controller
   */
  public Controller() {}

  /**
   * Automates the movements of robots and then refresh the graphic view
   *
   * @param  w  Instance of World model
   * @param  g  Instance of Grid view
   */
  public void update(World w, Grid g) {
    for (Robot r : this.robots) {
      r.move(this, w);
    }
    g.repaint();
  }

  /**
   * Initiates the movement of a specified robot in a new Cell of the World.
   * If it's not possible, reload the method to try with new coordinates.
   *
   * @param  x  First part of the targeted cell's coordinates
   * @param  y  Second part of the targeted cell's coordinates
   * @param  r  Instance of Robot model
   * @param  w  Instance of World model
   */
  public void moveIfPossible(int x, int y, Robot r, World w) {
    if (w.isCell(x, y)) {
      if (w.grid[y][x].isFree()) {
        w.grid[r.getY()][r.getX()].release();
        w.grid[y][x].setRobot(r);
        r.setPosition(x, y, w);
        r.use(x, y, w);
      }
    } else {
      if (r instanceof JewelerMadman) {
        r.setDirection();
      }
      r.move(this, w);
    }
  }

  /**
   * Add a list of new robots to the class property this.robots
   *
   * @param  robots  List of Robot instances
   * @param  w       Instance of World model
   */
  public void setRobots(ArrayList<Robot> robots, World w) {
    for (Robot r : robots) {
      this.addRobot(r, w);
    }
  }

  /**
   * Add a specified robot to the class property this.robots and edit
   * the World model to add this robot to the right cell
   *
   * @param  r  Instance of Robot model
   * @param  w  Instance of World model
   */
  public void addRobot(Robot r, World w) {
    this.robots.add(r);
    w.grid[r.getY()][r.getX()].setRobot(r);
  }

}

