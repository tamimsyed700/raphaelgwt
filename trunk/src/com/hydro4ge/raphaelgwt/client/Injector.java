/*
 * Copyright 2010-2014 Hydro4GE, Incorporated. http://www.hydro4ge.com/
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

package com.hydro4ge.raphaelgwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

class Injector {
  private static boolean loaded = false;

  static class JsPicker {
	public TextResource pick(JsResources bundle) {
	  return bundle.raphaelMinJs();
	}
  }

  static class DebugJsPicker extends JsPicker {
	public TextResource pick(JsResources bundle) {
	  return bundle.raphaelDebugJs();
	}
  }

  public interface JsResources extends ClientBundle {
	@Source("raphael-min.js")
	TextResource raphaelMinJs();

	@Source("raphael.js")
	TextResource raphaelDebugJs();
  }

  static public void ensureInjected() {
	if (!loaded) {
	  loaded = true;
	  JsResources bundle = GWT.create(JsResources.class);
	  JsPicker picker = GWT.create(JsPicker.class);
	  ScriptInjector.fromString(picker.pick(bundle).getText())
		  .setWindow(ScriptInjector.TOP_WINDOW)
		  .inject();
	}
  }
}

