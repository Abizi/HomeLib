// Generated code from Butter Knife. Do not modify!
package com.turkeytech.homelib.Activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.barteksc.pdfviewer.PDFView;
import com.turkeytech.homelib.R;
import com.turkeytech.homelib.Activities.PdfReaderActivity.PdfReaderActivity;

import java.lang.IllegalStateException;
import java.lang.Override;

public class PdfReaderActivity_ViewBinding implements Unbinder {
  private PdfReaderActivity target;

  @UiThread
  public PdfReaderActivity_ViewBinding(PdfReaderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PdfReaderActivity_ViewBinding(PdfReaderActivity target, View source) {
    this.target = target;

    target.mPdfView = Utils.findRequiredViewAsType(source, R.id.main_pdf, "field 'mPdfView'", PDFView.class);
    target.mProgressBar = Utils.findRequiredViewAsType(source, R.id.pdfReader_progressBar, "field 'mProgressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PdfReaderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPdfView = null;
    target.mProgressBar = null;
  }
}
