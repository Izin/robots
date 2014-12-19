public class Timer extends Thread {

  // Attributes
  private int step = 500;
  private Supervisor controller;

  // Constructor
  public Timer(int step, Supervisor s) {
    this.step       = step;
    this.controller = s;
  }

  // Methods
  public void start(World w) {
    run(w);
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
