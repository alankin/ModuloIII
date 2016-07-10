package moduloiii.alankin.com.moduloiii.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import moduloiii.alankin.com.moduloiii.PostFragment;
import moduloiii.alankin.com.moduloiii.UserFragment;

/**
 * Created by ALANKIN on 3/7/16.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

                return new PostFragment();
            case 1:
                return new UserFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
