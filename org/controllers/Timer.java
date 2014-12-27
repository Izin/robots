package org.controllers;

import org.models.*;
import org.views.*;

public class Timer extends Thread {

  // Attributes
  private int speed;
  private Controller ctrl;
  private Grid g;

  public Timer() {}

  public Timer(int speed, Controller c, Grid g) {
    this.speed = speed;
    this.ctrl  = c;
    this.g     = g;
    System.out.println("Création du timer (" + this.speed + "ms)");
  }

  // Methods
  public void start(World w) {
    this.run(w);
  }

  public void run(World w) {
    while(true) {
      try {
        this.ctrl.update(w, g);
        Thread.sleep(this.speed);
      } catch(InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}

