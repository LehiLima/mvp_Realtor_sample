package lehilima.zapmoveis_teste.Custom;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lehilima.zapmoveis_teste.R;
import lehilima.zapmoveis_teste.contract.DetailImovelActivityContract;
import lehilima.zapmoveis_teste.data.network.DataManager;
import lehilima.zapmoveis_teste.presenter.DetailImovelPresenter;


/**
 * Created by Lehiteixeira on 06/09/17.
 */

public class CustomDialogSendMessage extends Dialog {

    private Activity mActivity;
    private Context mContext;
    private DetailImovelPresenter detailImovelPresenter;

    @Bind(R.id.txtName)
    TextView txtName;

    @Bind(R.id.txtEmail)
    TextView txtEmail;

    @Bind(R.id.txtDDD)
    TextView txtDDD;

    @Bind(R.id.txtTelefone)
    TextView txtTelefone;

    @Bind(R.id.txtMessage)
    TextView txtMessage;

    @OnClick(R.id.btn_close)
    public void close() {
        dismiss();
    }

    @OnClick(R.id.btn_send)
    public void sendMassage() {
        detailImovelPresenter = new DetailImovelPresenter(DataManager.getInstance(mContext),(DetailImovelActivityContract.View) mActivity);
        if (validadeFiled()) {
            detailImovelPresenter.sendMessage(txtName.getText().toString(),
                    txtEmail.getText().toString(),
                    txtTelefone.getText().toString(),
                    txtDDD.getText().toString(),
                    txtMessage.getText().toString());
            dismiss();
        }

    }

    private Boolean validadeFiled() {
        Boolean isOk = true;
        final String name = txtName.getText().toString();
        final String email = txtEmail.getText().toString();
        final String ddd = txtDDD.getText().toString();
        final String tel = txtTelefone.getText().toString();
        final String message = txtMessage.getText().toString();

        if (name.trim().isEmpty() || name.toString() == null) {
            txtName.setError("Nome deve ser preenchido");
            isOk = false;
        }
        if ((!isValidEmail(email)) || email.isEmpty()) {
            txtEmail.setError("E-mail invalido");
            isOk = false;
        }
        if (ddd.trim().isEmpty() || ddd.toString() == null) {
            txtDDD.setError("DDD deve ser preenchido");
            isOk = false;
        }
        if (tel.trim().isEmpty() || tel.toString() == null) {
            txtTelefone.setError("Telefone deve ser preenchido");
        }
        if (message.trim().isEmpty() || tel.toString() == null) {
            txtMessage.setError("Message deve ser preenchido");
            isOk = false;
        }

        return isOk;
    }


    public CustomDialogSendMessage(@NonNull Context context, Activity activity) {
        super(activity);
        mActivity = activity;
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_send_massage);

        ButterKnife.bind(this);
        setCancelable(false);

    }



    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


}
