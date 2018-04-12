// Generated code from Butter Knife. Do not modify!
package com.mmucsy.masnoondua.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mmucsy.masnoondua.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DuaViewPagerAdapter_ViewBinding implements Unbinder {
  private DuaViewPagerAdapter target;

  @UiThread
  public DuaViewPagerAdapter_ViewBinding(DuaViewPagerAdapter target, View source) {
    this.target = target;

    target.tvDuaTitle = Utils.findRequiredViewAsType(source, R.id.tv_dua_tilte_s, "field 'tvDuaTitle'", TextView.class);
    target.tvDua = Utils.findRequiredViewAsType(source, R.id.tv_dua_s, "field 'tvDua'", TextView.class);
    target.tvDuaTranslation = Utils.findRequiredViewAsType(source, R.id.tv_dua_translation_s, "field 'tvDuaTranslation'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DuaViewPagerAdapter target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvDuaTitle = null;
    target.tvDua = null;
    target.tvDuaTranslation = null;
  }
}
