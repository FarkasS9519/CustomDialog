package hu.alewo.customdialog;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DialogBuilder dialogBuilder = DialogBuilder.builder()
//                .backgroundColor(Color.rgb(120, 120, 120))
//                .buttonLineColor(Color.rgb(255, 255, 255))
//                .stringTitle("Teszt")
//                .stringContent("Teszt content")
//                .positiveBtnTitle(R.string.app_name)
//                .positiveBtnListener(view -> {})
//                .icon(R.drawable.ic_launcher_background)
//                .negativeBtnTitle(R.string.app_name)
//                .negativeBtnListener(view -> {})
//                .build();
//
//        CustomDialog customDialog = new CustomDialog(this, dialogBuilder);
//        customDialog.show();
    }
}
