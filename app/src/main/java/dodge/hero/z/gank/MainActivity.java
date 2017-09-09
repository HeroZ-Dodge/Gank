package dodge.hero.z.gank;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.init(getApplication());
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_camara).setOnClickListener(view -> {
            MainActivityPermissionsDispatcher.openCameraWithCheck(this);
        });

    }


    @NeedsPermission(Manifest.permission.CAMERA)
    void openCamera() {
        ToastUtils.showShort("授权成功");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnShowRationale(Manifest.permission.CAMERA)
    void cameraRationale(final PermissionRequest request) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("需要照相机权限")
                .setMessage("要搞事情！！！！")
                .setPositiveButton("OK", (dialogInterface, i) -> request.proceed())
                .setNegativeButton("CANCEL", (dialogInterface, i) -> request.cancel());
        builder.create().show();
    }

    @OnPermissionDenied(Manifest.permission.CAMERA)
    void cameraDenied() {
        ToastUtils.showShort("授权失败");
    }

    @OnNeverAskAgain(Manifest.permission.CAMERA)
    void cameraNeverAsk() {
        ToastUtils.showShort("不再访问");
    }

}
