// Generated code from Butter Knife. Do not modify!
package com.mmucsy.masnoondua.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mmucsy.masnoondua.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FavouriteFragment_ViewBinding implements Unbinder {
  private FavouriteFragment target;

  @UiThread
  public FavouriteFragment_ViewBinding(FavouriteFragment target, View source) {
    this.target = target;

    target.recyclerViewFavourite = Utils.findRequiredViewAsType(source, R.id.rv_favourite, "field 'recyclerViewFavourite'", RecyclerView.class);
    target.rlNotHaveFav = Utils.findRequiredViewAsType(source, R.id.rl_not_have_fav, "field 'rlNotHaveFav'", RelativeLayout.class);
    target.tvNoFav = Utils.findRequiredViewAsType(source, R.id.tv_no_fav, "field 'tvNoFav'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FavouriteFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerViewFavourite = null;
    target.rlNotHaveFav = null;
    target.tvNoFav = null;
  }
}
