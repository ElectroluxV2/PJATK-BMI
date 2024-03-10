package pl.edu.pjwstk.s24048.bmi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText massInput;
    private EditText heightInput;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        massInput = findViewById(R.id.massInput);
        heightInput = findViewById(R.id.heightInput);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultText);

        calculateButton.setOnClickListener(view -> calculateBmi());
    }

    @SuppressLint("SetTextI18n")
    private void calculateBmi() {
        final var mString = massInput.getText().toString();
        final var hString = heightInput.getText().toString();

        if (mString.isEmpty() || hString.isEmpty()) {
            return;
        }

        final var m = Double.parseDouble(mString);
        final var h = Double.parseDouble(hString) / 100;

        final var bmi = m / Math.pow(h, 2);

        System.out.println(bmi);

        resultText.setText("Your BMI is : %.2f".formatted(bmi));
    }
}