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

public class TestShelveAdapter$VH_ViewBinding implements Unbinder {
  private TestShelveAdapter.VH target;

  @UiThread
  public TestShelveAdapter$VH_ViewBinding(TestShelveAdapter.VH target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.shelf_row, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TestShelveAdapter.VH target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
  }
}
