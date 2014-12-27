package org.controllers;

import org.models.*;
import org.views.*;

import java.util.ArrayList;

public class Controller {

  // Attributes
  private ArrayList<Robot> robots = new ArrayList<Robot>();

  // Contructor
  public Controller() {
    System.out.println("Création du controlleur");
  }

  // Accessors
  public void update(World w, Grid g) {
    for (Robot r : this.robots) {
      // todo appeler moveIfPossible, plus logique !
      r.move(this, w);
    }
    g.repaint();
  }

  public void initGame(ArrayList<Robot> robots, World w) {
    setRobots(robots, w);
  }

  public void moveIfPossible(int x, int y, Robot r, World w) {
    //System.out.print("Tentative de déplacement de " + r.getName() + " en case [" + x + ", " + y + "] ->");
    if (w.isCell(x, y)) {
      if (w.map[y][x].isFree()) {
        w.map[r.getY()][r.getX()].release();
        w.map[y][x].setRobot(r);
        r.setPosition(x, y, w);
        //System.out.print(" case disponible");
        r.use(x, y, w);
        //System.out.println("");
      } else {
        //System.out.print(" case indisponible");
        //System.out.println("");
      }
    } else {
      //System.out.print(" case innexistante");
      //System.out.println("");
      if (r instanceof JewelerMadman) {
        r.setDirection();
      }
      r.move(this, w);
      //System.out.println("");
    }
    //System.out.println("");
  }

  public void setRobots(ArrayList<Robot> robots, World w) {
    for (Robot r : robots) {
      this.addRobot(r, w);
    }
  }

  public void addRobot(Robot r, World w) {
    this.robots.add(r);
    w.map[r.getY()][r.getX()].setRobot(r);
  }

}

