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
    private int title;
    private String stringTitle;
    private int content;
    private String stringContent;
    private int icon;
    private int textColor;

    private Button btnOk;
    private Button btnCancel;
    private int positiveBtnTitle;
    private String positiveBtnStringTitle;
    private View.OnClickListener positiveBtnClickListener;

    private int negativeBtnTitle;
    private String negativeBtnStringTitle;
    private View.OnClickListener negativeBtnClickListener;
    private int negativeBtnColor;

    public CustomDialog(Context context, @NonNull DialogBuilder dialogBuilder) {
        super(context);
        backgroundColor = dialogBuilder.getBackgroundColor();
        buttonLineColor = dialogBuilder.getButtonLineColor();
        title = dialogBuilder.getTitle();
        stringTitle = dialogBuilder.getStringTitle();
        content = dialogBuilder.getContent();
        stringContent = dialogBuilder.getStringContent();
        icon = dialogBuilder.getIcon();
        textColor = dialogBuilder.getTextColor();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_alert_dialog);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        ImageView imgIcon = findViewById(R.id.imgIcon);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);
        TextView txtTitle = findViewById(R.id.txtTitle);
        TextView txtContent = findViewById(R.id.txtContent);
        ConstraintLayout clBackground = findViewById(R.id.clBackground);
        RelativeLayout rlButtonLine = findViewById(R.id.rlButtonLine);

        clBackground.setBackgroundColor(backgroundColor);
        rlButtonLine.setBackgroundColor(buttonLineColor);

        setupIcon(imgIcon);
        setupTitle(txtTitle);
        setupContent(txtContent);
        setupButtons();
    }

    private void setupIcon(ImageView imgIcon) {
        if (icon != 0) {
            imgIcon.setVisibility(View.VISIBLE);
            imgIcon.setBackgroundResource(icon);
        }
    }

    private void setupTitle(TextView txtTitle) {
        txtTitle.setTextColor(textColor);
        if (stringTitle != null) {
            txtTitle.setText(stringTitle);
        } else if (title != 0) {
            txtTitle.setText(title);
        }
    }

    private void setupContent(TextView txtContent) {
        txtContent.setTextColor(textColor);
        if (content != 0) {
            txtContent.setText(content);
        } else if (stringContent != null) {
            txtContent.setText(stringContent);
        }
    }

    private void setupButtons() {
        if (positiveBtnTitle != 0) {
            btnOk.setText(positiveBtnTitle);
        } else if (positiveBtnStringTitle != null) {
            btnOk.setText(positiveBtnStringTitle);
        }
        btnOk.setTextColor(textColor);
        btnOk.setBackgroundColor(backgroundColor);
        btnOk.setOnClickListener(positiveBtnClickListener);

        if ((negativeBtnTitle != 0 || negativeBtnStringTitle != null) && negativeBtnClickListener != null) {
            btnCancel.setVisibility(View.VISIBLE);
            if (negativeBtnTitle != 0) {
                btnCancel.setText(negativeBtnTitle);
            } else {
                btnCancel.setText(negativeBtnStringTitle);
            }
            btnCancel.setTextColor(textColor);
            btnCancel.setBackgroundColor(backgroundColor);
            btnCancel.setOnClickListener(negativeBtnClickListener);
        }
    }

    public void setupPositiveButton(int btnTitle, @NonNull View.OnClickListener clickListener) {
        positiveBtnTitle = btnTitle;
        positiveBtnClickListener = clickListener;
    }

    public void setupPositiveButton(@NonNull String btnTitle, @NonNull View.OnClickListener clickListener) {
        positiveBtnStringTitle = btnTitle;
        positiveBtnClickListener = clickListener;
    }

    public void setupNegativeButton(int btnTitle, @NonNull View.OnClickListener clickListener) {
        negativeBtnTitle = btnTitle;
        negativeBtnClickListener = clickListener;
    }

    public void setupNegativeButton(String btnTitle, @NonNull View.OnClickListener clickListener) {
        negativeBtnStringTitle = btnTitle;
        negativeBtnClickListener = clickListener;
    }
}
