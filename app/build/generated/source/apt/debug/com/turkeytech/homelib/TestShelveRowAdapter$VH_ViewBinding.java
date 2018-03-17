// Generated code from Butter Knife. Do not modify!
package com.turkeytech.homelib;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TestShelveRowAdapter$VH_ViewBinding implements Unbinder {
  private TestShelveRowAdapter.VH target;

  @UiThread
  public TestShelveRowAdapter$VH_ViewBinding(TestShelveRowAdapter.VH target, View source) {
    this.target = target;

    target.imageView = Utils.findRequiredViewAsType(source, R.id.shelf_row_image, "field 'imageView'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TestShelveRowAdapter.VH target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageView = null;
  }
}
