package fpoly.datn.polypet_app.screen;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fpoly.datn.polypet_app.R;

public class SignUpActivity extends AppCompatActivity {
    TextView txt_signin;
    Button btn_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn_signup = findViewById(R.id.btn_signup);
        txt_signin = findViewById(R.id.txt_signin);
        txt_signin.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
            // Kết thúc  để không thể quay lại
            finish();
        });
        btn_signup.setOnClickListener(v -> {
            showOtpDialog();
        });
    }
    private void showOtpDialog(){
        // Tạo view từ layout tùy chỉnh
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_input_otp, null);

        // Tạo dialog sử dụng AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.BottomDialog);
        builder.setView(dialogView);

        // Hiển thị dialog
        AlertDialog dialog = builder.create();

        // Thiết lập các thành phần của dialog
        EditText otp1 = dialogView.findViewById(R.id.otp1);
        EditText otp2 = dialogView.findViewById(R.id.otp2);
        EditText otp3 = dialogView.findViewById(R.id.otp3);
        EditText otp4 = dialogView.findViewById(R.id.otp4);
        EditText otp5 = dialogView.findViewById(R.id.otp5);
        EditText otp6 = dialogView.findViewById(R.id.otp6);
        Button verifyButton = dialogView.findViewById(R.id.btn_verify);

        // Thiết lập TextWatcher cho từng EditText để tự động chuyển sang ô tiếp theo
        setOtpTextWatcher(otp1, otp2);
        setOtpTextWatcher(otp2, otp3);
        setOtpTextWatcher(otp3, otp4);
        setOtpTextWatcher(otp4, otp5);
        setOtpTextWatcher(otp5, otp6);

        // Thiết lập hành động cho nút Verify
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý khi nhấn nút Verify
                String otp = otp1.getText().toString() + otp2.getText().toString() + otp3.getText().toString() +
                        otp4.getText().toString() + otp5.getText().toString() + otp6.getText().toString();
                // Có thể làm gì đó với OTP
                dialog.dismiss(); // Đóng dialog
            }
        });

        // Thiết lập các thuộc tính của cửa sổ dialog
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
            layoutParams.height = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_SP, 450, getResources().getDisplayMetrics());
            layoutParams.gravity = Gravity.BOTTOM;
            window.setAttributes(layoutParams);
        }

        dialog.show();
    }
    private void setOtpTextWatcher(final EditText currentEditText, final EditText nextEditText) {
        currentEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    nextEditText.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}