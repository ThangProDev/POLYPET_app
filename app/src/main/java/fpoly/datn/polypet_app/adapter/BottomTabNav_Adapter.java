package fpoly.datn.polypet_app.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fpoly.datn.polypet_app.fragment.FavouriteFragment;
import fpoly.datn.polypet_app.fragment.HomeFragment;
import fpoly.datn.polypet_app.fragment.MangeFragment;
import fpoly.datn.polypet_app.fragment.ProfileFragment;

public class BottomTabNav_Adapter  extends FragmentStateAdapter {
    public BottomTabNav_Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new FavouriteFragment();
            case 2:
                return new MangeFragment();
            default:
                return new ProfileFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
