package razerdp.demo.fragment.basedemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import razerdp.basepopup.BasePopupWindow;
import razerdp.basepopup.R;
import razerdp.demo.fragment.other.SimpleBaseFrag;
import razerdp.demo.popup.GravityPopup;
import razerdp.demo.utils.MultiSpanUtil;

/**
 * Created by 大灯泡 on 2018/11/28.
 */
public class GravityPopupFrag extends SimpleBaseFrag implements View.OnClickListener {

    private GravityPopup mPopupWindow;
    private AppCompatCheckBox checkGravityLeft;
    private AppCompatCheckBox checkGravityTop;
    private AppCompatCheckBox checkGravityRight;
    private AppCompatCheckBox checkGravityBottom;
    private AppCompatCheckBox checkGravityCenterVertical;
    private AppCompatCheckBox checkGravityCenterHorizontal;
    private AppCompatCheckBox checkGravityCenter;
    private AppCompatCheckBox checkGravityMode;
    private Button popupShow;
    private AppCompatCheckBox checkCombineAnchor;
    private static final String DESC = " · 不跟anchorView关联的情况下，gravity意味着在整个decorView中的方位，默认Gravity为NO_GRAVITY，即屏幕左上角\n" +
            " · 如果跟anchorView关联\n" +
            "\t\t· GravityMode = ALIGN_TO_ANCHOR_SIDE，此时gravity意味着以anchorView的边为参考点，BasePopup将尝试对齐anchorView的边。\n"+
            "\t\t· GravityMode = RELATIVE_TO_ANCHOR，此时gravity意味着以anchorView整体为参考点，BasePopup将尝试定位到anchorView的某个方位。";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onInitView(View rootView) {
        initView();
        mPopupWindow = new GravityPopup(mContext);

        popupShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gravity = Gravity.NO_GRAVITY;
                if (checkGravityLeft.isChecked()) {
                    gravity |= Gravity.LEFT;
                }
                if (checkGravityTop.isChecked()) {
                    gravity |= Gravity.TOP;
                }
                if (checkGravityRight.isChecked()) {
                    gravity |= Gravity.RIGHT;
                }
                if (checkGravityBottom.isChecked()) {
                    gravity |= Gravity.BOTTOM;
                }
                if (checkGravityCenterVertical.isChecked()) {
                    gravity |= Gravity.CENTER_VERTICAL;
                }
                if (checkGravityCenterHorizontal.isChecked()) {
                    gravity |= Gravity.CENTER_HORIZONTAL;
                }
                if (checkGravityCenter.isChecked()) {
                    gravity |= Gravity.CENTER;
                }
                mPopupWindow.setPopupGravity(checkGravityMode.isChecked() ? BasePopupWindow.GravityMode.ALIGN_TO_ANCHOR_SIDE : BasePopupWindow.GravityMode.RELATIVE_TO_ANCHOR,
                        gravity);
                if (checkCombineAnchor.isChecked()) {
                    mPopupWindow.showPopupWindow(v);
                } else {
                    mPopupWindow.showPopupWindow();
                }
            }
        });


    }

    private void initView() {
        this.checkGravityLeft = (AppCompatCheckBox) findViewById(R.id.check_gravity_left);
        this.checkGravityTop = (AppCompatCheckBox) findViewById(R.id.check_gravity_top);
        this.checkGravityRight = (AppCompatCheckBox) findViewById(R.id.check_gravity_right);
        this.checkGravityBottom = (AppCompatCheckBox) findViewById(R.id.check_gravity_bottom);
        this.checkGravityCenterVertical = (AppCompatCheckBox) findViewById(R.id.check_gravity_center_vertical);
        this.checkGravityCenterHorizontal = (AppCompatCheckBox) findViewById(R.id.check_gravity_center_horizontal);
        this.checkGravityCenter = (AppCompatCheckBox) findViewById(R.id.check_gravity_center);
        this.checkCombineAnchor = (AppCompatCheckBox) findViewById(R.id.check_combine_anchor);
        this.checkGravityMode = (AppCompatCheckBox) findViewById(R.id.check_gravity_mode);
        this.popupShow = (Button) findViewById(R.id.popup_show);
        initDesc();
    }


    private void initDesc() {
        TextView desc = (TextView) findViewById(R.id.tv_desc);
        MultiSpanUtil.create(DESC)
                .append("默认Gravity为NO_GRAVITY，即屏幕左上角").setTextColor(Color.RED)
                .append("ALIGN_TO_ANCHOR_SIDE").setTextColor(Color.RED)
                .append("以anchorView的边为参考点").setTextColor(Color.RED)
                .append("RELATIVE_TO_ANCHOR").setTextColor(Color.RED)
                .append("以anchorView整体为参考点").setTextColor(Color.RED)
                .into(desc);
    }

    @Override
    public BasePopupWindow getPopup() {
        return null;
    }

    @Override
    public Button getButton() {
        return null;
    }

    @Override
    public View getFragment() {
        return mInflater.inflate(R.layout.frag_demo_gravity, container, false);
    }

}
