package fpoly.datn.polypet_app.screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fpoly.datn.polypet_app.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Sử dụng Handler để chuyển màn hình sau 2 giây
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Chuyển đến WellcomeActivity
                Intent intent = new Intent(StartActivity.this, WellcomeActivity.class);
                startActivity(intent);
                // Kết thúc StartActivity để không thể quay lại
                finish();
            }
        }, 2000); // 2000 milliseconds = 2 seconds

    }
}