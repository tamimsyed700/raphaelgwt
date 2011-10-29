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

import com.hydro4ge.raphaelgwt.client.*;

class SampleView extends Raphael {

  public SampleView(int width, int height) {
    super(width, height);
  }

  @Override
  public void onLoad() {
	super.onLoad();

    //Text
    final Text t = this.new Text(500,250,"Drag and drop!");
    t.attr("font-size","100px");
    t.attr("fill","blue");

    //Circle
    final Circle c = this.new Circle(260, 100, 50);
    c.attr(new Attr()
        .strokeWidth(3).strokeDash(Attr.StrokeDashArray.LONG_DASH_DOT)
        .fill("#00BFFF"));
    c.drag(new SampleDragCallback(c));

    //Ellipse
    final Ellipse e = this.new Ellipse(100,100,100,100);
    e.attr(new Attr()
        .strokeWidth(3).strokeDash(Attr.StrokeDashArray.LONG_DASH_DOT_DOT)
        .fill("#FA5858"));
    e.drag(new SampleDragCallback(e));

    //Rectangle
    final Rect r = this.new Rect(350,350,100,100);
    r.attr(new Attr()
        .strokeWidth(3).strokeDash(Attr.StrokeDashArray.LONG_DASH)
        .fill("#2EFE2E"));
    r.drag(new SampleDragCallback(r));
  }

}

