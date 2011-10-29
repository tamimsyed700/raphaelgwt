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

