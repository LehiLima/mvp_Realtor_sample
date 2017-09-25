package lehilima.zapmoveis_teste.contract;

import java.util.ArrayList;
import java.util.List;

import lehilima.zapmoveis_teste.data.model.Imoveis;
import lehilima.zapmoveis_teste.data.model.Imovel;

/**
 * Created by Lehiteixeira on 11/09/17.
 */

public interface MainActivityContract {

    interface View  {

        void ShowImoveis(Imoveis imoveis);

        void ShowEmpty();

    }

    interface Presenter  {

        void getImoveis();

    }


}
