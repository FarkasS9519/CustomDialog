package hu.alewo.customdialog;

import android.view.View;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * Created by Sandor Farkas on 2020. 03. 23.
 */
@Builder
@Getter
@ToString
public class DialogBuilder {

    @NonNull
    private int backgroundColor;

    @NonNull
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
}
