/*
 * Copyright 2010 Hydro4GE, Incorporated. http://www.hydro4ge.com/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hydro4ge.mycircle.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasMouseWheelHandlers;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.shared.HandlerRegistration;

import com.hydro4ge.raphaelgwt.client.*;

import java.util.ArrayList;

/**
 * simple drawing demonstration
 */
public class MyDrawing extends Raphael {

  /* center point of the drawing */
  private int cx;
  private int cy;

  /**
   * a clickable, mousewheel-able circle
   */
  public class Circle extends Raphael.Circle
      implements HasClickHandlers, HasMouseWheelHandlers
  {
    public Circle(double x, double y, double node_size) {
      super(x, y, node_size);
    }

    public HandlerRegistration addClickHandler(ClickHandler handler) {
      return this.addDomHandler(handler, ClickEvent.getType());
    }

    public HandlerRegistration addMouseWheelHandler(MouseWheelHandler handler) {
      return this.addDomHandler(handler, MouseWheelEvent.getType());
    }
  }

  /**
   * MyDrawing constructor
   */
  public MyDrawing(final int width, final int height) {
    super(width, height);
    this.cx = width/2;
    this.cy = height/2;
  }

  /**
   * Raphael Text and the Firefox 3.6 SVG implementation do not
   * work together when the text is appended to the drawing
   * before the drawing is appended to the document.  Therefore,
   * we defer the layout to onLoad() here instead of doing it in
   * the constructor.
   */
  @Override
  public void onLoad() {
    super.onLoad();

    // clickable, mousewheel-able circle with 200px radius
    final Circle c = new Circle(cx, cy, 200);

    // path shaped like an arrow (not clickable)
    PathBuilder pb = new PathBuilder();
    pb.M(cx, cy)
        .m(-60, -20)
        .l(80, 0, 0, -40, 70, 60, -70, 60, 0, -40, -80, 0)
        .z();

    final Path p = new Path(pb);
    setFill(false, c, p);

    final Text t = new Text(cx, cy, "Hello, world!");
    t.attr("font-size", "10px");

    c.addClickHandler(new ClickHandler() {
      private boolean toggle = true;
      public void onClick(ClickEvent e) {
        setFill(toggle, c, p);
        toggle = !toggle;
      }
    });

    c.addMouseWheelHandler(new MouseWheelHandler() {
      private final static int DEGREES = 20;
      public void onMouseWheel(MouseWheelEvent e) {
        p.rotate((e.isNorth()?-1:1)*DEGREES, cx, cy, false);
        t.rotate((e.isNorth()?-1:1)*DEGREES, cx, cy, false);
      }
    });
  }

  private void setFill(boolean swap, Circle c, Path p) {
    if (swap) {
      c.attr("fill", "#d1b48c");
      p.attr("fill", "#974b00");
    } else {
      c.attr("fill", "#974b00");
      p.attr("fill", "#d1b48c");
    }
  }

}

