package hu.alewo.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * Created by Sandor Farkas on 2020. 03. 23.
 */
public class CustomDialog extends Dialog {

    private int backgroundColor;
    private int buttonLineColor;
    private int positiveBtnTitle;
    private String positiveBtnStringTitle;
    private int negativeBtnTitle;
    private String negativeBtnStringTitle;
    private View.OnClickListener positiveBtnListener;
    private View.OnClickListener negativeBtnListener;
    private int title;
    private String stringTitle;
    private int content;
    private String stringContent;
    private int icon;

    public CustomDialog(Context context, @NonNull DialogBuilder dialogBuilder) {
        super(context);
        backgroundColor = dialogBuilder.getBackgroundColor();
        buttonLineColor = dialogBuilder.getButtonLineColor();
        positiveBtnTitle = dialogBuilder.getPositiveBtnTitle();
        positiveBtnStringTitle = dialogBuilder.getPositiveBtnStringTitle();
        negativeBtnTitle = dialogBuilder.getNegativeBtnTitle();
        negativeBtnStringTitle = dialogBuilder.getNegativeBtnStringTitle();
        positiveBtnListener = dialogBuilder.getPositiveBtnListener();
        negativeBtnListener = dialogBuilder.getNegativeBtnListener();
        title = dialogBuilder.getTitle();
        stringTitle = dialogBuilder.getStringTitle();
        content = dialogBuilder.getContent();
        stringContent = dialogBuilder.getStringContent();
        icon = dialogBuilder.getIcon();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_alert_dialog);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        ImageView imgIcon = findViewById(R.id.imgIcon);
        Button btnOk = findViewById(R.id.btnOk);
        Button btnCancel = findViewById(R.id.btnCancel);
        TextView txtTitle = findViewById(R.id.txtTitle);
        TextView txtContent = findViewById(R.id.txtContent);
        ConstraintLayout clBackground = findViewById(R.id.clBackground);
        RelativeLayout rlButtonLine = findViewById(R.id.rlButtonLine);

        clBackground.setBackgroundColor(backgroundColor);
        rlButtonLine.setBackgroundColor(buttonLineColor);

        setupIcon(imgIcon);
        setupTitle(txtTitle);
        setupContent(txtContent);
        setupPositiveButton(btnOk);
        setupNegativeButton(btnCancel);
    }

    private void setupIcon(ImageView imgIcon) {
        if (icon != 0) {
            imgIcon.setVisibility(View.VISIBLE);
            imgIcon.setBackgroundResource(icon);
        }
    }

    private void setupTitle(TextView txtTitle) {
        if (stringTitle != null) {
            txtTitle.setText(stringTitle);
        } else if (title != 0) {
            txtTitle.setText(title);
        }
    }

    private void setupContent(TextView txtContent) {
        if (content != 0) {
            txtContent.setText(content);
        } else if (stringContent != null) {
            txtContent.setText(stringContent);
        }
    }

    private void setupPositiveButton(Button btnOk) {
        if (positiveBtnTitle != 0) {
            btnOk.setText(positiveBtnTitle);
        } else if (positiveBtnStringTitle != null) {
            btnOk.setText(positiveBtnStringTitle);
        }
        btnOk.setBackgroundColor(backgroundColor);
        btnOk.setOnClickListener(positiveBtnListener);
    }

    private void setupNegativeButton(Button btnCancel) {
        if ((negativeBtnTitle != 0 || negativeBtnStringTitle != null) && negativeBtnListener != null) {
            btnCancel.setVisibility(View.VISIBLE);

            if (negativeBtnTitle != 0) {
                btnCancel.setText(negativeBtnTitle);
            } else {
                btnCancel.setText(negativeBtnStringTitle);
            }
            btnCancel.setBackgroundColor(backgroundColor);
            btnCancel.setOnClickListener(negativeBtnListener);
        }
    }
}
