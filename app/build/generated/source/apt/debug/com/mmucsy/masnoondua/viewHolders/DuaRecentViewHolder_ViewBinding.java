// Generated code from Butter Knife. Do not modify!
package com.mmucsy.masnoondua.viewHolders;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mmucsy.masnoondua.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import net.aungpyaephyo.mmtextview.components.MMTextView;

public class DuaRecentViewHolder_ViewBinding implements Unbinder {
  private DuaRecentViewHolder target;

  @UiThread
  public DuaRecentViewHolder_ViewBinding(DuaRecentViewHolder target, View source) {
    this.target = target;

    target.tvDuaTitle = Utils.findRequiredViewAsType(source, R.id.tv_dua_title, "field 'tvDuaTitle'", MMTextView.class);
    target.tvDuaArbic = Utils.findRequiredViewAsType(source, R.id.tv_dua, "field 'tvDuaArbic'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DuaRecentViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvDuaTitle = null;
    target.tvDuaArbic = null;
  }
}
