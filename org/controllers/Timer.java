package org.controllers;
import org.models.*;
import org.views.*;


/**
 * Handles the call of Controller's update() method every (x)
 * miliseconds.
 *
 * @author  Malo Blanchard
 * @version 0.9
 */
public class Timer extends Thread {

  private int speed;
  private Controller c;
  private Grid g;

  /**
   * Build a new instance of the Timer
   *
   * @param  speed  Duration between two refresh
   * @param  c      Instance of the Controller
   * @param  g      instance of Grid view
   */
  public Timer() {}
  public Timer(int speed, Controller c, Grid g) {
    this.speed = speed;
    this.c     = c;
    this.g     = g;
  }

  /**
   * Call the run method with parameters
   *
   * @param  w  Instance of World model
   */
  public void start(World w) {
    this.run(w);
  }

  /**
   * Call indefinitly the Controller's update() method, an then freeze
   * while statement for a specific duration. The run method is provided
   * by Thread abstract class.
   *
   * @param  w  Instance of World model
   */
  public void run(World w) {
    while(true) {
      try {
        this.c.update(w, g);
        Thread.sleep(this.speed);
      } catch(InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

}

