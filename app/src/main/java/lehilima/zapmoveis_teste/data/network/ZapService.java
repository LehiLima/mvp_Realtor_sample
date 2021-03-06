/*
 * Copyright (c) Joaquim Ley 2016. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package lehilima.zapmoveis_teste.data.network;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lehilima.zapmoveis_teste.data.model.Imoveis;
import lehilima.zapmoveis_teste.data.model.Imovel;
import lehilima.zapmoveis_teste.data.model.Message;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ZapService {

    /**
     * Recupera lista de imoveis
     */
    @GET("/imoveis")
    Call<Imoveis> getImoveis();

    /**
     * Detalues dos Imovel
     */

    @GET("/imoveis/{ImovelId}")
    Call<Imovel> getDetalheImovel(@Path("ImovelId") long ImovelId);

    /**
     * Envia mensagem
     */
    @POST("/imoveis/contato")
    Call<Message> postEnviaMensagem(@Body HashMap<String, Object> body);
}


