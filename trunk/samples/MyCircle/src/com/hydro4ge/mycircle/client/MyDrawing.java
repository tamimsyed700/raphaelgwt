package com.hydro4ge.mycircle.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

import com.hydro4ge.raphaelgwt.client.*;

import java.util.ArrayList;

public class MyDrawing extends Raphael {

  private boolean toggle;

  public MyDrawing(int width, int height) {
    super(width, height);

    //create a circle with a 200px radius
    //NOTE: this circle is an instance of the Circle class below and accepts click events
    Circle c = new Circle(width/2, height/2, 200);
    //set color as blue
    c.attr("fill", "#00f");

    //create a path
    PathBuilder pb = new PathBuilder();
    pb.M(width/2, height/2).m(-60, -20).l(80, 0, 0, -40, 70, 60, -70, 60, 0, -40, -80, 0).z();
    Path p = new Path(pb);
    p.attr("fill", "#0f0");

    //toggle variable used in onClick
    toggle = true;
  }

  public class Circle extends Raphael.Circle implements HasClickHandlers, ClickHandler {

    private ArrayList<HandlerRegistration> handlers;

    public Circle(double x, double y, double node_size) {
      super(x, y, node_size);
    }

    @Override
    protected void onLoad() {
      super.onLoad();
      if (handlers == null)
      handlers = new ArrayList<HandlerRegistration>();
      handlers.add(addClickHandler(this));
    }

    @Override
    protected void onUnload() {
      for (HandlerRegistration h : handlers)
      h.removeHandler();
      handlers.clear();
      super.onUnload();
    }

    public HandlerRegistration addClickHandler(ClickHandler handler) {
      return this.addDomHandler(handler, ClickEvent.getType());
    }

    public void onClick(ClickEvent e) {
      if (toggle) {
        attr("fill", "#f00");
      }
      else {
        attr("fill", "#00f");
      }

      toggle = !toggle;
    }

  }

}

