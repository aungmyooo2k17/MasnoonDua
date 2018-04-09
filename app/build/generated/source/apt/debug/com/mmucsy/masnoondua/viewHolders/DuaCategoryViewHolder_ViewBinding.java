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

public class DuaCategoryViewHolder_ViewBinding implements Unbinder {
  private DuaCategoryViewHolder target;

  @UiThread
  public DuaCategoryViewHolder_ViewBinding(DuaCategoryViewHolder target, View source) {
    this.target = target;

    target.tvCategory = Utils.findRequiredViewAsType(source, R.id.tv_category, "field 'tvCategory'", MMTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DuaCategoryViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvCategory = null;
  }
}
