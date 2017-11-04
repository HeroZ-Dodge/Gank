package dodge.hero.z.gank.view.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.di.DI;
import dodge.hero.z.gank.view.abstrac.BaseAbsDialog;

/**
 * Created by Linzheng on 2017/10/11.
 * <br>Email:linzheng@aipai.com</br>
 */

public class CreateCollectionDialog extends BaseAbsDialog {

    private Button mBtnCancel;
    private Button mBtnOk;
    private EditText mEtFolderName;

    @Override
    public void onStart() {
        super.onStart();
        setStyle(STYLE_NO_TITLE, R.style.GankDialog);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public int layout() {
        return R.layout.gank_dialog_create_collection;
    }

    @Override
    public void initView() {
        mBtnCancel = findViewById(R.id.btn_cancel);
        mBtnCancel.setOnClickListener(v -> dismiss());
        mBtnOk = findViewById(R.id.btn_ok);
        mEtFolderName = findViewById(R.id.et_folder_name);
        mBtnOk.setOnClickListener(v -> {
            String folderName = mEtFolderName.getText().toString();
            if (TextUtils.isEmpty(folderName)) {
                ToastUtils.showShort("请输入收藏夹名称");
            } else {
                DI.dbRepository().createCollection(folderName);
            }
        });

    }
}
