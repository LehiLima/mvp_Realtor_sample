package lehilima.zapmoveis_teste.data.model;

/**
 * Created by Lehiteixeira on 11/09/17.
 */

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Numero",
        "CEP",
        "Bairro",
        "Cidade",
        "Estado",
        "Zona",
        "Logradouro",
        "Complemento"
})
public class Endereco {

    @JsonProperty("Numero")
    private String numero;
    @JsonProperty("CEP")
    private String cEP;
    @JsonProperty("Bairro")
    private String bairro;
    @JsonProperty("Cidade")
    private String cidade;
    @JsonProperty("Estado")
    private String estado;
    @JsonProperty("Zona")
    private String zona;
    @JsonProperty("Logradouro")
    private String logradouro;
    @JsonProperty("Complemento")
    private String complemento;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Numero")
    public String getNumero() {
        return numero;
    }

    @JsonProperty("Numero")
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @JsonProperty("CEP")
    public String getCEP() {
        return cEP;
    }

    @JsonProperty("CEP")
    public void setCEP(String cEP) {
        this.cEP = cEP;
    }

    @JsonProperty("Bairro")
    public String getBairro() {
        return bairro;
    }

    @JsonProperty("Bairro")
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @JsonProperty("Cidade")
    public String getCidade() {
        return cidade;
    }

    @JsonProperty("Cidade")
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @JsonProperty("Estado")
    public String getEstado() {
        return estado;
    }

    @JsonProperty("Estado")
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonProperty("Zona")
    public String getZona() {
        return zona;
    }

    @JsonProperty("Zona")
    public void setZona(String zona) {
        this.zona = zona;
    }

    @JsonProperty("Logradouro")
    public String getLogradouro() {
        String actualValue = logradouro == null ? "Não Informado" : logradouro;
        return actualValue;
    }

    @JsonProperty("Logradouro")
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @JsonProperty("Complemento")
    public String getComplemento() {
        return complemento;
    }

    @JsonProperty("Complemento")
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}