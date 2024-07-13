package fpoly.datn.polypet_app.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import fpoly.datn.polypet_app.fragment.notificationFragment.MyFragment;
import fpoly.datn.polypet_app.fragment.notificationFragment.PolypetFragment;

public class NotificationPaperAdapter extends FragmentPagerAdapter {
    public NotificationPaperAdapter(@NonNull FragmentManager fm,int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MyFragment();
            case 1:
                return new PolypetFragment();
            default:
                return new MyFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Thông báo của tôi";
            case 1:
                return "Thông báo POLYPET";
            default:
                return null;
        }
    }
}
