package lehilima.zapmoveis_teste.presenter;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import lehilima.zapmoveis_teste.contract.MainActivityContract;
import lehilima.zapmoveis_teste.data.model.Imoveis;
import lehilima.zapmoveis_teste.data.model.Imovel;
import lehilima.zapmoveis_teste.data.network.DataManager;
import lehilima.zapmoveis_teste.data.network.RemoteCallback;

/**
 * Created by Lehiteixeira on 11/09/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    @NonNull
    private final DataManager mDataManager;

    @NonNull
    private MainActivityContract.View mView;

    public MainActivityPresenter(DataManager mDataManager,@NonNull MainActivityContract.View view) {
        this.mDataManager = mDataManager;
        this.mView = view;
    }

    @Override
    public void getImoveis() {
        mDataManager.getImoveis(new RemoteCallback<Imoveis>() {
            @Override
            public void onSuccess(Imoveis response) {
                mView.ShowImoveis(response);
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
}
