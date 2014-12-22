package controllers;

import models.*;

public class Timer extends Thread {

  // Attributes
  private int step = 500;
  private Controller controller;

  // Constructor
  public Timer(int step, Controller c) {
    this.step       = step;
    this.controller = c;
  }

  // Methods
  public void start(World w) {
    this.run(w);
  }

  public void run(World w) {
    while(true) {
      try {
        this.controller.update(w);
        Thread.sleep(this.step);
      } catch(InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}

