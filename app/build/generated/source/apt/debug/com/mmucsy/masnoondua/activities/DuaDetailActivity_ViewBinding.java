// Generated code from Butter Knife. Do not modify!
package com.mmucsy.masnoondua.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mmucsy.masnoondua.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DuaDetailActivity_ViewBinding implements Unbinder {
  private DuaDetailActivity target;

  @UiThread
  public DuaDetailActivity_ViewBinding(DuaDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DuaDetailActivity_ViewBinding(DuaDetailActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.viewPagerDua = Utils.findRequiredViewAsType(source, R.id.view_pager_dua, "field 'viewPagerDua'", ViewPager.class);
    target.bottomNavigationView = Utils.findRequiredViewAsType(source, R.id.bottom_navigation_dua_item, "field 'bottomNavigationView'", BottomNavigationView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DuaDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.viewPagerDua = null;
    target.bottomNavigationView = null;
  }
}
