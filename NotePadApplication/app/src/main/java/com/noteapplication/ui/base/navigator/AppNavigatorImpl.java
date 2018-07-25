
package com.noteapplication.ui.base.navigator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.noteapplication.application.constants.BundleConstants;
import com.noteapplication.injection.scope.ActivityScope;
import com.noteapplication.injection.scope.ContainerId;
import com.noteapplication.ui.base.BaseActivity;
import com.noteapplication.ui.module.detail.NotePadFragment;
import com.noteapplication.ui.module.landing.NoteBookLandingFragment;
import com.noteapplication.util.IKeyBoardUtil;

import javax.inject.Inject;

@ActivityScope
public class AppNavigatorImpl implements AppNavigator {

    private final IKeyBoardUtil mKeyBoardUtil;
    private FragmentActivity mActivity;
    private int mContainerId;

    @Inject
    public AppNavigatorImpl(BaseActivity context, @ContainerId int containerId, IKeyBoardUtil keyBoardUtil) {
        mActivity = context;
        mContainerId = containerId;
        mKeyBoardUtil = keyBoardUtil;
    }

    @Override
    public void launchNotePadScreen() {
        addFragmentAndAddToBackStack(mContainerId, NotePadFragment.newInstance());
    }

    @Override
    public void launchNotePadLandingScreen() {
        replaceFragment(mContainerId, NoteBookLandingFragment.newInstance());
    }

    @Override
    public void hideKeyBoard() {
        mKeyBoardUtil.hideSoftKeyboard(mActivity);
    }

    // Internal Implementation
    // below code can be moved to separate class for optimization

    private void startActivity(@NonNull Class<? extends Activity> activityClass, Bundle args, Integer requestCode) {
        Intent intent = new Intent();
        intent.putExtra(BundleConstants.EXTRA_ARG, args);
        startActivityInternal(activityClass, intent, requestCode);
    }

    private void addFragmentAndAddToBackStack(@IdRes int containerId, @NonNull Fragment fragment, String backStackTag) {
        addFragmentInternal(mActivity.getSupportFragmentManager(), containerId, fragment, null, null, true, backStackTag);
    }

    private void addFragmentAndAddToBackStack(@IdRes int containerId, @NonNull Fragment fragment) {
        addFragmentInternal(mActivity.getSupportFragmentManager(), containerId, fragment, null, null, true, null);
    }

    private final void replaceFragment(@IdRes int containerId, Fragment fragment) {
        replaceFragmentInternal(mActivity.getSupportFragmentManager(), containerId, fragment, null, null, false, null);
    }

    public final void replaceFragment(@IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag) {
        replaceFragmentInternal(mActivity.getSupportFragmentManager(), containerId, fragment, fragmentTag, null, false, null);
    }

    private final void replaceFragmentAndAddToBackStack(@IdRes int containerId, Fragment fragment, String backStackTag) {
        replaceFragmentInternal(mActivity.getSupportFragmentManager(), containerId, fragment, null, null, true, backStackTag);
    }


    //

    private void startActivityInternal(Class<? extends Activity> activityClass, Intent setArgsAction, Integer requestCode) {
        Intent intent = new Intent(mActivity, activityClass);
        intent.putExtras(setArgsAction.getExtras());
        if (requestCode != null) {
            mActivity.startActivityForResult(intent, requestCode);
        } else {
            mActivity.startActivity(intent);
        }
    }

    private final void replaceFragmentInternal(FragmentManager fm, @IdRes int containerId, Fragment fragment, String fragmentTag, Bundle args, boolean addToBackstack, String backstackTag) {
        if (mActivity.isFinishing()) return;

        if (args != null) {
            fragment.setArguments(args);
        }
        FragmentTransaction ft = fm.beginTransaction().replace(containerId, fragment, fragmentTag);
        if (addToBackstack) {
            ft.addToBackStack(backstackTag).commitAllowingStateLoss();
            fm.executePendingTransactions();
        } else {
            ft.commitAllowingStateLoss();
        }
    }

    private final void addFragmentInternal(FragmentManager fm, @IdRes int containerId, Fragment fragment, String fragmentTag, Bundle args, boolean addToBackstack, String backstackTag) {
        if (mActivity.isFinishing()) return;
        if (args != null) {
            fragment.setArguments(args);
        }
        FragmentTransaction ft = fm.beginTransaction().add(containerId, fragment, fragmentTag);
        if (addToBackstack) {
            ft.addToBackStack(backstackTag).commitAllowingStateLoss();
            fm.executePendingTransactions();
        } else {
            ft.commitAllowingStateLoss();
        }
    }
}
