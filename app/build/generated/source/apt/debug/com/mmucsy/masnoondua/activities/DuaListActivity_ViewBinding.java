// Generated code from Butter Knife. Do not modify!
package com.mmucsy.masnoondua.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mmucsy.masnoondua.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DuaListActivity_ViewBinding implements Unbinder {
  private DuaListActivity target;

  @UiThread
  public DuaListActivity_ViewBinding(DuaListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DuaListActivity_ViewBinding(DuaListActivity target, View source) {
    this.target = target;

    target.recyclerViewDuaList = Utils.findRequiredViewAsType(source, R.id.rv_dua_list, "field 'recyclerViewDuaList'", RecyclerView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar_dua_list, "field 'toolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DuaListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerViewDuaList = null;
    target.toolbar = null;
  }
}
