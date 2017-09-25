package lehilima.zapmoveis_teste.data.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
        "CodCliente",
        "NomeFantasia"
})
public class Cliente {

    @JsonProperty("CodCliente")
    private Integer codCliente;
    @JsonProperty("NomeFantasia")
    private String nomeFantasia;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CodCliente")
    public Integer getCodCliente() {
        return codCliente;
    }

    @JsonProperty("CodCliente")
    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    @JsonProperty("NomeFantasia")
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    @JsonProperty("NomeFantasia")
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
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