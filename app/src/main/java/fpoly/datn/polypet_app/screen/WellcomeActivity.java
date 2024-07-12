package fpoly.datn.polypet_app.screen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fpoly.datn.polypet_app.R;

public class WellcomeActivity extends AppCompatActivity {
    Button btn_next,btn_skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wellcome);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn_skip = findViewById(R.id.btn_Skip);
        btn_next = findViewById(R.id.btn_Next);

        btn_next.setOnClickListener(v -> {
            Intent intent = new Intent(WellcomeActivity.this, Wellcome2Activity.class);
            startActivity(intent);
            // Kết thúc  để không thể quay lại
            finish();
        });
        btn_skip.setOnClickListener(v -> {
            Intent intent = new Intent(WellcomeActivity.this, LoginActivity.class);
            startActivity(intent);
            // Kết thúc  để không thể quay lại
            finish();
        });
    }
}