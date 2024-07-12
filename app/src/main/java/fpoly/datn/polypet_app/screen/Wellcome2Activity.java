package fpoly.datn.polypet_app.screen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fpoly.datn.polypet_app.R;

public class Wellcome2Activity extends AppCompatActivity {
    Button btn_getstarted;
    TextView tv_Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wellcome2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tv_Login = findViewById(R.id.tv_Login);
        btn_getstarted = findViewById(R.id.btn_getStarted);

        tv_Login.setOnClickListener(v -> {
            Intent intent = new Intent(Wellcome2Activity.this, LoginActivity.class);
            startActivity(intent);
            // Kết thúc  để không thể quay lại
            finish();
        });
        btn_getstarted.setOnClickListener(v -> {
            Intent intent = new Intent(Wellcome2Activity.this, SignUpActivity.class);
            startActivity(intent);
            // Kết thúc  để không thể quay lại
            finish();
        });
    }
}