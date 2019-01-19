package me.seandillon.gnarlydialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

//import android.support.annotation.NonNull;

/**
 * Created by Sean on 3/19/2018.
 */

public class GnarlyDialog extends Dialog {

        // ========== Start of TODO ==========

            // 1) Add Gnarly interface with GnarlyClick instead of View.OnClickListener

        // =========== End of TODO ===========



    private Context context;

    private int gnarlyDialogType;
    public static final int GNARLY_DIALOG_TYPE_SUCCESS = 1;
    public static final int GNARLY_DIALOG_TYPE_ERROR = 2;
    public static final int GNARLY_DIALOG_TYPE_INFO = 3;
    public static final int GNARLY_DIALOG_TYPE_WARNING = 4;
    public static final int GNARLY_DIALOG_TYPE_DEFAULT = GNARLY_DIALOG_TYPE_INFO;


    // ============= Start UI Elements =============

    private TextView textViewTitle;
    private TextView gnarlyTextviewContent;
    private Button gnarlyButtonPrimarySuccess;
    private Button gnarlyButtonPrimaryError;
    private Button gnarlyButtonPrimaryInfo;
    private Button gnarlyButtonPrimaryWarning;
    private Button gnarlyButtonSecondaryCancel;
    private LinearLayout gnarlyLinearLayoutTitle;
    private LinearLayout gnarlyLinearLayoutContent;
    private LinearLayout gnarlyLinearLayoutContentWrapper;
    private LinearLayout gnarlyLinearLayoutWrapper;

    // ============= End UI Elements =============


    // ============= Start Gnarly class Vars =============

    // title + content
    private String gnarlyTitle = "";
    private String gnarlyContent= "";

    // primary button
    private boolean shouldShowPrimaryButton = false;
    private String primaryButtonText = "";
    private View.OnClickListener primaryButtonOnClickListener = null;

    // secondary button
    private boolean shouldShowSecondaryButton = false;
    private String secondaryButtonText = "";
    private View.OnClickListener secondaryButtonOnClickListener = null;

    private boolean shouldDismissOnOutsideTouch = true;

    // ============= End Gnarly class Vars =============



    // ============= Start Gnarly animation Vars =============

    private Animation animationDialogShow;
    private Animation animationDialogDismiss;

    // ============= End Gnarly animation Vars =============


    // ============= Start Constructors =============

//    public GnarlyDialog(@NonNull Context context) {
    public GnarlyDialog(Context context) {
        this(context, GNARLY_DIALOG_TYPE_DEFAULT);
    }

//    public GnarlyDialog(@NonNull Context context, int gnarlyDialogType) {
    public GnarlyDialog(Context context, int gnarlyDialogType) {
        super(context, R.style.gnarly_dialog_style);

        this.context = context;
        this.gnarlyDialogType = gnarlyDialogType;

        initAnimations();

    }

    // ============= End Constructors =============



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.gnarly_dialog_layout);

        findByIds();

        setCanceledOnTouchOutside(false);

        // TODO: decide if we want the color to wrap around the content like in the Info and Warning types below
        if (gnarlyDialogType == GNARLY_DIALOG_TYPE_SUCCESS) {

            gnarlyLinearLayoutTitle.setBackgroundResource(R.drawable.gnarly_background_success);

        } else if (gnarlyDialogType == GNARLY_DIALOG_TYPE_ERROR) {

            gnarlyLinearLayoutTitle.setBackgroundResource(R.drawable.gnarly_background_error);

        } else if (gnarlyDialogType == GNARLY_DIALOG_TYPE_INFO) {

            gnarlyLinearLayoutWrapper.setBackgroundResource(R.drawable.gnarly_background_wrapper_info);
            gnarlyLinearLayoutContentWrapper.setBackgroundResource(R.drawable.gnarly_background_inner);

        } else if (gnarlyDialogType == GNARLY_DIALOG_TYPE_WARNING) {

            gnarlyLinearLayoutWrapper.setBackgroundResource(R.drawable.gnarly_background_wrapper_warning);
            gnarlyLinearLayoutContentWrapper.setBackgroundResource(R.drawable.gnarly_background_inner);

        }

        assignPropertiesAfterCreated();

    }

    private void findByIds() {

        textViewTitle = (TextView)findViewById(R.id.mTextView1);
        gnarlyButtonPrimarySuccess = (Button)findViewById(R.id.gnarlyButtonPrimarySuccess);
        gnarlyButtonPrimaryError = (Button)findViewById(R.id.gnarlyButtonPrimaryError);
        gnarlyButtonPrimaryInfo = (Button)findViewById(R.id.gnarlyButtonPrimaryInfo);
        gnarlyButtonPrimaryWarning= (Button)findViewById(R.id.gnarlyButtonPrimaryWarning);
        gnarlyButtonSecondaryCancel = (Button)findViewById(R.id.gnarlyButtonSecondaryCancel);
        gnarlyLinearLayoutTitle = (LinearLayout)findViewById(R.id.gnarlyLinearLayoutTitle);
        gnarlyTextviewContent = (TextView)findViewById(R.id.gnarlyTextviewContent);
        gnarlyLinearLayoutContent = (LinearLayout)findViewById(R.id.gnarlyLinearLayoutContent);
        gnarlyLinearLayoutWrapper = (LinearLayout)findViewById(R.id.gnarlyLinearLayoutWrapper);
        gnarlyLinearLayoutContentWrapper = (LinearLayout)findViewById(R.id.gnarlyLinearLayoutContentWrapper);

    }

    private void assignPropertiesAfterCreated() {

        textViewTitle.setText(gnarlyTitle);
        gnarlyTextviewContent.setText(gnarlyContent);

        if (shouldShowPrimaryButton) {

            if (gnarlyDialogType == GNARLY_DIALOG_TYPE_SUCCESS) {

                gnarlyButtonPrimarySuccess.setText(primaryButtonText);
                gnarlyButtonPrimarySuccess.setOnClickListener(primaryButtonOnClickListener);
                gnarlyButtonPrimarySuccess.setVisibility(View.VISIBLE);

            } else if (gnarlyDialogType == GNARLY_DIALOG_TYPE_ERROR) {

                gnarlyButtonPrimaryError.setText(primaryButtonText);
                gnarlyButtonPrimaryError.setOnClickListener(primaryButtonOnClickListener);
                gnarlyButtonPrimaryError.setVisibility(View.VISIBLE);

            } else if (gnarlyDialogType == GNARLY_DIALOG_TYPE_WARNING) {

                gnarlyButtonPrimaryWarning.setText(primaryButtonText);
                gnarlyButtonPrimaryWarning.setOnClickListener(primaryButtonOnClickListener);
                gnarlyButtonPrimaryWarning.setVisibility(View.VISIBLE);

            } else if (gnarlyDialogType == GNARLY_DIALOG_TYPE_INFO) {

                gnarlyButtonPrimaryInfo.setText(primaryButtonText);
                gnarlyButtonPrimaryInfo.setOnClickListener(primaryButtonOnClickListener);
                gnarlyButtonPrimaryInfo.setVisibility(View.VISIBLE);

            }

        }

        if (shouldShowSecondaryButton) {

            gnarlyButtonSecondaryCancel.setText(secondaryButtonText);
            gnarlyButtonSecondaryCancel.setOnClickListener(secondaryButtonOnClickListener);
            gnarlyButtonSecondaryCancel.setVisibility(View.VISIBLE);

        }

        setCanceledOnTouchOutside(shouldDismissOnOutsideTouch);

    }

    public void gnarlyDialogShow() {

        this.show();
        gnarlyLinearLayoutWrapper.startAnimation(animationDialogShow);

    }

    public void gnarlyDialogDismiss() {

        gnarlyLinearLayoutWrapper.startAnimation(animationDialogDismiss);

    }


    // ============= Start Helper Functions =============

    private void initAnimations() {

        animationDialogShow = AnimationUtils.loadAnimation(context, R.anim.gnarly_dialog_show);

        animationDialogDismiss = AnimationUtils.loadAnimation(context, R.anim.gnarly_dialog_dismiss);
        animationDialogDismiss.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                dismiss();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    public void setGnarlyTitleText(String title) {

        gnarlyTitle = title;

    }

    public void setGnarlyContentText(String content) {

        gnarlyContent = content;

    }

    public void setGnarlyPrimaryButtonText(String text) {

        shouldShowPrimaryButton = true;
        primaryButtonText = text;

    }

    public void setGnarlyPrimaryButtonListener(View.OnClickListener primaryButtonListener) {

        this.primaryButtonOnClickListener = primaryButtonListener;

    }

    public void setGnarlySecondaryButtonText(String text) {

        shouldShowSecondaryButton = true;
        secondaryButtonText = text;

    }

    public void setGnarlySecondaryButtonListener(View.OnClickListener secondaryButtonListener) {

        this.secondaryButtonOnClickListener = secondaryButtonListener;

    }

    public void setGnarlyShouldDismisOnOutsideTouch(boolean shouldDismissOnOutsideTouch) {
        this.shouldDismissOnOutsideTouch = shouldDismissOnOutsideTouch;
    }

    // ============= End Helper Functions =============


}
