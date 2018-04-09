// Generated code from Butter Knife. Do not modify!
package com.mmucsy.masnoondua.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mmucsy.masnoondua.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RecentFragment_ViewBinding implements Unbinder {
  private RecentFragment target;

  @UiThread
  public RecentFragment_ViewBinding(RecentFragment target, View source) {
    this.target = target;

    target.recyclerViewRecent = Utils.findRequiredViewAsType(source, R.id.rv_recent, "field 'recyclerViewRecent'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RecentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerViewRecent = null;
  }
}
