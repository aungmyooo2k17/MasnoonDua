// Generated code from Butter Knife. Do not modify!
package com.mmucsy.masnoondua.viewHolders;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mmucsy.masnoondua.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import net.aungpyaephyo.mmtextview.components.MMTextView;

public class FavoriteDuaViewHolder_ViewBinding implements Unbinder {
  private FavoriteDuaViewHolder target;

  @UiThread
  public FavoriteDuaViewHolder_ViewBinding(FavoriteDuaViewHolder target, View source) {
    this.target = target;

    target.favDuaTitle = Utils.findRequiredViewAsType(source, R.id.fav_dua_title, "field 'favDuaTitle'", MMTextView.class);
    target.btnRemove = Utils.findRequiredViewAsType(source, R.id.btn_remove, "field 'btnRemove'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FavoriteDuaViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.favDuaTitle = null;
    target.btnRemove = null;
  }
}
