package fpoly.datn.polypet_app;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import fpoly.datn.polypet_app.adapter.BottomTabNav_Adapter;
import fpoly.datn.polypet_app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomTabNav_Adapter adapter = new BottomTabNav_Adapter(this);
        binding.viewPager.setAdapter(adapter);

        binding.navigation.setOnItemSelectedListener(item -> {
            int viewPagerPosition = 0; // Default position

            if (item.getItemId() == R.id.btnHome) {
                viewPagerPosition = 0;
            } else if (item.getItemId() == R.id.btnFavourite) {
                viewPagerPosition = 1;
            } else if (item.getItemId() == R.id.btnNotification) {
                viewPagerPosition = 2;
            } else if (item.getItemId() == R.id.btnProfile) {
                viewPagerPosition = 3;
            }

            binding.viewPager.setCurrentItem(viewPagerPosition, true);
            return true;
        });

        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // Update BottomNavigationView when ViewPager2 page changes
                if (position == 0) {
                    binding.navigation.setSelectedItemId(R.id.btnHome);
                } else if (position == 1) {
                    binding.navigation.setSelectedItemId(R.id.btnFavourite);
                } else if (position == 2) {
                    binding.navigation.setSelectedItemId(R.id.btnNotification);
                } else if (position == 3) {
                    binding.navigation.setSelectedItemId(R.id.btnProfile);
                }
            }
        });
    }
}