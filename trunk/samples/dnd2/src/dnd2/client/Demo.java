package dnd2.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class Demo implements EntryPoint {

  @Override
  public void onModuleLoad() {
    RootPanel.get().add(new SampleView(Window.getClientWidth(), Window.getClientHeight()));
  }

}

