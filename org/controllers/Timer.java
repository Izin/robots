package org.controllers;

import org.models.*;

public class Timer extends Thread {

  // Attributes
  private int speed;
  private Controller controller;

  // Constructor
  public Timer(int speed, Controller c) {
    this.speed      = speed;
    this.controller = c;
    System.out.println("Création du timer (" + this.speed + "ms)");
  }

  // Methods
  public void start(World w) {
    this.run(w);
  }

  public void run(World w) {
    while(true) {
      try {
        this.controller.update(w);
        Thread.sleep(this.speed);
      } catch(InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}

