/*
 * Copyright 2011 Hydro4GE, Incorporated. http://www.hydro4ge.com/
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

package dnd2.client;

import com.google.gwt.dom.client.Style.Cursor;
import com.hydro4ge.raphaelgwt.client.*;

class SampleDragCallback implements DragCallback {

  String origFill;
  double origX;
  double origY;
  double rotation;
  Raphael.Shape shape;
  String xAttr;
  String yAttr;

  public SampleDragCallback(Raphael.Shape s) {
    this(s, 60, "cx", "cy");
  }

  public SampleDragCallback(Raphael.Rect r) {
    this(r, 360, "x", "y");
  }

  private SampleDragCallback(Raphael.Shape s, double rotation, String xAttr, String yAttr) {
    shape = s;
    this.rotation = rotation;
    this.origFill = shape.attrAsString("fill");
    this.xAttr = xAttr;
    this.yAttr = yAttr;
    shape.attr(new Attr().cursor(Cursor.POINTER));
  }

  @Override
  public void onStart(double x, double y) {
    origX = shape.attrAsDouble(xAttr);
    origY = shape.attrAsDouble(yAttr);
    shape.attr(new Attr().cursor(Cursor.MOVE));
    shape.toFront();
    shape.animate(new Attr().rotation(rotation).fill("#415899").opacity(0.85), 400, "bounce");
  }

  @Override
  public void onMove(double dx, double dy, double x, double y) {
    shape.attr(xAttr, origX+dx);
    shape.attr(yAttr, origY+dy);
  }

  @Override
  public void onEnd() {
    shape.animate(new Attr().rotation(-rotation).fill(origFill).opacity(1), 400, "bounce");
    shape.attr(new Attr().cursor(Cursor.POINTER));
  }

}

