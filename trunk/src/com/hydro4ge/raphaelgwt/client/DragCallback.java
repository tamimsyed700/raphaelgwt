package com.hydro4ge.raphaelgwt.client;

/**
 * Drag and drop callback
 * @authors cristian.n.miranda, geoffspeicher
 */
public interface DragCallback {
  public void onStart(double x, double y);
  public void onMove(double dx, double dy, double x, double y);
  public void onEnd();
}

