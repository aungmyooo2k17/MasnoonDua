// Generated code from Butter Knife. Do not modify!
package com.mmucsy.masnoondua.viewHolders;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mmucsy.masnoondua.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import net.aungpyaephyo.mmtextview.components.MMTextView;

public class DuaViewHolder_ViewBinding implements Unbinder {
  private DuaViewHolder target;

  @UiThread
  public DuaViewHolder_ViewBinding(DuaViewHolder target, View source) {
    this.target = target;

    target.tvDuaTitle = Utils.findRequiredViewAsType(source, R.id.tv_dua_title, "field 'tvDuaTitle'", MMTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DuaViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvDuaTitle = null;
  }
}
