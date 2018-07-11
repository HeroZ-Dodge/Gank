package dodge.hero.z.gank.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

import com.blankj.utilcode.util.LogUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by linzheng on 2018/6/27.
 */

public class ImageDragFrameLayout extends FrameLayout {

    public static final String TAG = "ImageDragFrameLayout";

    private float actionDownX;
    private float actionDownY;
    private boolean disallowDrag;

    @Status
    private int status = Status.FREE;

    public ImageDragFrameLayout(@NonNull Context context) {
        super(context);
    }

    public ImageDragFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageDragFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (status == Status.DRAG || disallowDrag) {
            return super.onInterceptTouchEvent(ev);
        }
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                actionDownX = ev.getRawX();
                actionDownY = ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                float distance = ev.getRawY() - actionDownY;
                int touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
                if (distance > touchSlop) {
                    status = Status.DRAG;
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                status = Status.FREE;
                actionDownY = 0f;
                actionDownX = 0f;
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtils.d(TAG, "onTouchEvent event action = " + event.getAction());
        float distanceX = event.getRawX() - actionDownX;
        float distanceY = event.getRawY() - actionDownY;
        if (distanceY <= 0) {
            setScaleX(1.0f);
            setScaleY(1.0f);
        } else {
            int height = getHeight();
            float scale = (height - distanceY) / height;
            setScaleX(scale);
            setScaleY(scale);
        }
        setTranslationX(distanceX);
        setTranslationY(distanceY);
        int action = event.getAction();
        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
            status = Status.FREE;
            reset();
        }
        return super.onTouchEvent(event);
    }


    private void reset() {
        animate().translationX(0)
                .translationY(0)
                .scaleX(1.0f)
                .scaleY(1.0f)
                .setDuration(400)
                .start();
    }

    private void finish() {



    }



    public void setDisallowDrag(boolean disallowDrag) {
        this.disallowDrag = disallowDrag;
    }


    @IntDef({Status.FREE, Status.DRAG})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
        int FREE = 0;
        int DRAG = 1;
    }








}
