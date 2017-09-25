package lehilima.zapmoveis_teste.data.model;

/**
 * Created by Lehiteixeira on 11/09/17.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Imoveis"
})
public class Imoveis {

    @JsonProperty("Imoveis")
    private List<Imovel> imoveis = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Imoveis")
    public List<Imovel> getImoveis() {
        return imoveis;
    }

    @JsonProperty("Imoveis")
    public void setImoveis(List<Imovel> imoveis) {
        this.imoveis = imoveis;
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