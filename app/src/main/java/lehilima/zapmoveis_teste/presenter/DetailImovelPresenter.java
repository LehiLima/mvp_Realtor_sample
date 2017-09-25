package lehilima.zapmoveis_teste.presenter;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;

import lehilima.zapmoveis_teste.contract.DetailImovelActivityContract;
import lehilima.zapmoveis_teste.contract.MainActivityContract;
import lehilima.zapmoveis_teste.data.model.Imovel;
import lehilima.zapmoveis_teste.data.model.Message;
import lehilima.zapmoveis_teste.data.network.DataManager;
import lehilima.zapmoveis_teste.data.network.RemoteCallback;

/**
 * Created by Lehiteixeira on 12/09/17.
 */

public class DetailImovelPresenter implements DetailImovelActivityContract.Presenter {

    @NonNull
    private final DataManager mDataManager;

    @NonNull
    private DetailImovelActivityContract.View mView;

    public DetailImovelPresenter(@NonNull DataManager mDataManager, @NonNull DetailImovelActivityContract.View mView) {
        this.mDataManager = mDataManager;
        this.mView = mView;
    }

    @Override
    public void getImovel(long imovelId) {
        mDataManager.getDetalhesImoveis(imovelId, new RemoteCallback<Imovel>() {
            @Override
            public void onSuccess(Imovel response) {
                mView.ShowImovel(response.getImovel());
            }

            @Override
            public void onUnauthorized() {
                mView.ShowEmpty();
            }

            @Override
            public void onFailed(Throwable throwable) {
                mView.ShowEmpty();
            }
        });
    }

    @Override
    public void sendMessage(String Nome, String email, String tel, String CodImovel, String msg) {
        mDataManager.postEnviaMensagem(Nome, email, tel, CodImovel, msg, new RemoteCallback<Message>() {
            @Override
            public void onSuccess(Message response) {
                mView.showSuccess();
            }

            @Override
            public void onUnauthorized() {
                mView.showFail();
            }

            @Override
            public void onFailed(Throwable throwable) {
                mView.showFail();
            }
        });
    }
}
