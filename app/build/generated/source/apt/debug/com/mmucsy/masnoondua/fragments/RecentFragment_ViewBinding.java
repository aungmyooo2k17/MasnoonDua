// Generated code from Butter Knife. Do not modify!
package com.mmucsy.masnoondua.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
    target.floatingActionButtonDelete = Utils.findRequiredViewAsType(source, R.id.fl_delete, "field 'floatingActionButtonDelete'", FloatingActionButton.class);
    target.rlHaveRecent = Utils.findRequiredViewAsType(source, R.id.rl_have_recent, "field 'rlHaveRecent'", RelativeLayout.class);
    target.rlNotHaveRecent = Utils.findRequiredViewAsType(source, R.id.rl_not_have_recent, "field 'rlNotHaveRecent'", RelativeLayout.class);
    target.tvNoRecent = Utils.findRequiredViewAsType(source, R.id.tv_no_recent, "field 'tvNoRecent'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RecentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerViewRecent = null;
    target.floatingActionButtonDelete = null;
    target.rlHaveRecent = null;
    target.rlNotHaveRecent = null;
    target.tvNoRecent = null;
  }
}
