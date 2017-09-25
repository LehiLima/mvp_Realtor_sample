package lehilima.zapmoveis_teste.contract;

import lehilima.zapmoveis_teste.data.model.Imoveis;
import lehilima.zapmoveis_teste.data.model.Imovel;

/**
 * Created by Lehiteixeira on 11/09/17.
 */

public interface DetailImovelActivityContract {

    interface View  {

        void ShowImovel(Imovel imovel);

        void ShowEmpty();

        void showSuccess();

        void showFail();

    }

    interface Presenter  {

        void getImovel(long imovelId);

        void sendMessage(String Nome, String email, String tel, String CodImovel, String msg);
    }


}
