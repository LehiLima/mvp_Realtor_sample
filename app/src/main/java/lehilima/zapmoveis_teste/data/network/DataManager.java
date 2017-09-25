package lehilima.zapmoveis_teste.data.network;

/**
 * Created by Lehiteixeira on 05/09/17.
 */

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import lehilima.zapmoveis_teste.data.model.Imoveis;
import lehilima.zapmoveis_teste.data.model.Imovel;
import lehilima.zapmoveis_teste.data.model.Message;

/**
 * Api abstraction
 */
public class DataManager {

    private static DataManager sInstance;
    private final ZapService mZapService;
    private Context mContext;
    private String  mToken;

    private static final String SHARED_PREFERENCE_NAME = "NEON_SHARED_PREFERENCES";

    public static DataManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DataManager(context);
        }
        return sInstance;
    }

    private DataManager(Context context) {
        mZapService = ZapServiceFactory.makeNeonService();
        this.mContext = context;
    }

    public void getImoveis(RemoteCallback<Imoveis> listener) {
        mZapService.getImoveis().enqueue(listener);
    }

    public void getDetalhesImoveis(long imovelId, RemoteCallback<Imovel> listener) {
        mZapService.getDetalheImovel(imovelId).enqueue(listener);
    }

    public void postEnviaMensagem(String Nome, String email, String tel, String CodImovel, String msg,RemoteCallback<Message> listener) {
        HashMap<String, Object> jsonParams = new HashMap<String, Object>();
        jsonParams.put("Nome",Nome);
        jsonParams.put("email",email);
        jsonParams.put("tel",tel);
        jsonParams.put("CodImovel",CodImovel);
        jsonParams.put("msg",msg);
        mZapService.postEnviaMensagem(jsonParams).enqueue(listener);
    }

}
