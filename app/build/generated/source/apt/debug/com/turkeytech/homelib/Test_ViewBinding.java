// Generated code from Butter Knife. Do not modify!
package com.turkeytech.homelib;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Test_ViewBinding implements Unbinder {
  private Test target;

  @UiThread
  public Test_ViewBinding(Test target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Test_ViewBinding(Test target, View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.shelf_main, "field 'mRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Test target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
  }
}
