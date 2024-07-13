package fpoly.datn.polypet_app.screen;

import android.app.Activity;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fpoly.datn.polypet_app.R;
import fpoly.datn.polypet_app.adapter.OderAdapter;
import fpoly.datn.polypet_app.databinding.ActivityOderBinding;


public class OderActivity extends AppCompatActivity {
    private ActivityOderBinding binding;
    private OderAdapter adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}