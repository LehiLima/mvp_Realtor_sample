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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Imovel {
    @JsonProperty("Imovel")
    private Imovel imovel;

    @JsonProperty("CodImovel")
    private Integer codImovel;
    @JsonProperty("TipoImovel")
    private String tipoImovel;
    @JsonProperty("Endereco")
    private Endereco endereco;
    @JsonProperty("PrecoVenda")
    private Integer precoVenda;
    @JsonProperty("Dormitorios")
    private Integer dormitorios;
    @JsonProperty("Suites")
    private Integer suites;
    @JsonProperty("Vagas")
    private Integer vagas;
    @JsonProperty("AreaUtil")
    private Integer areaUtil;
    @JsonProperty("AreaTotal")
    private Integer areaTotal;
    @JsonProperty("DataAtualizacao")
    private String dataAtualizacao;
    @JsonProperty("Cliente")
    private Cliente cliente;
    @JsonProperty("Fotos")
    private List<String> fotos = null;
    @JsonProperty("UrlImagem")
    private String urlImagem;
    @JsonProperty("SubTipoOferta")
    private String subTipoOferta;
    @JsonProperty("Observacao")
    private String observacao;
    @JsonProperty("Caracteristicas")
    private List<String> caracteristicas = null;
    @JsonProperty("PrecoCondominio")
    private Integer precoCondominio;
    @JsonProperty("SubtipoImovel")
    private String subtipoImovel;
    @JsonProperty("CaracteristicasComum")
    private List<String> caracteristicasComum = null;
    @JsonProperty("InformacoesComplementares")
    private String informacoesComplementares;
    @JsonProperty("StatusQualidadeTotal")
    private Boolean statusQualidadeTotal;
    @JsonProperty("EstagioObra")
    private String estagioObra;
    @JsonProperty("DistanciaKilometros")
    private Double distanciaKilometros;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonProperty("Imovel")
    public Imovel getImovel() {
        return imovel;
    }

    @JsonProperty("Imovel")
    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    @JsonProperty("CodImovel")
    public Integer getCodImovel() {
        return codImovel;
    }

    @JsonProperty("CodImovel")
    public void setCodImovel(Integer codImovel) {
        this.codImovel = codImovel;
    }

    @JsonProperty("TipoImovel")
    public String getTipoImovel() {
        return tipoImovel;
    }

    @JsonProperty("TipoImovel")
    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    @JsonProperty("Endereco")
    public Endereco getEndereco() {
        return endereco;
    }

    @JsonProperty("Endereco")
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @JsonProperty("PrecoVenda")
    public Integer getPrecoVenda() {
        return precoVenda;
    }

    @JsonProperty("PrecoVenda")
    public void setPrecoVenda(Integer precoVenda) {
        this.precoVenda = precoVenda;
    }

    @JsonProperty("Dormitorios")
    public Integer getDormitorios() {
        return dormitorios;
    }

    @JsonProperty("Dormitorios")
    public void setDormitorios(Integer dormitorios) {
        this.dormitorios = dormitorios;
    }

    @JsonProperty("Suites")
    public Integer getSuites() {
        return suites;
    }

    @JsonProperty("Suites")
    public void setSuites(Integer suites) {
        this.suites = suites;
    }

    @JsonProperty("Vagas")
    public Integer getVagas() {
        return vagas;
    }

    @JsonProperty("Vagas")
    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    @JsonProperty("AreaUtil")
    public Integer getAreaUtil() {
        return areaUtil;
    }

    @JsonProperty("AreaUtil")
    public void setAreaUtil(Integer areaUtil) {
        this.areaUtil = areaUtil;
    }

    @JsonProperty("AreaTotal")
    public Integer getAreaTotal() {
        return areaTotal;
    }

    @JsonProperty("AreaTotal")
    public void setAreaTotal(Integer areaTotal) {
        this.areaTotal = areaTotal;
    }

    @JsonProperty("DataAtualizacao")
    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    @JsonProperty("DataAtualizacao")
    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @JsonProperty("Cliente")
    public Cliente getCliente() {
        return cliente;
    }

    @JsonProperty("Cliente")
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @JsonProperty("UrlImagem")
    public String getUrlImagem() {
        return urlImagem.replace("http","https");
    }

    @JsonProperty("UrlImagem")
    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    @JsonProperty("SubTipoOferta")
    public String getSubTipoOferta() {
        return subTipoOferta;
    }

    @JsonProperty("SubTipoOferta")
    public void setSubTipoOferta(String subTipoOferta) {
        this.subTipoOferta = subTipoOferta;
    }

    @JsonProperty("SubtipoImovel")
    public String getSubtipoImovel() {
        return subtipoImovel;
    }

    @JsonProperty("SubtipoImovel")
    public void setSubtipoImovel(String subtipoImovel) {
        this.subtipoImovel = subtipoImovel;
    }

    @JsonProperty("StatusQualidadeTotal")
    public Boolean getStatusQualidadeTotal() {
        return statusQualidadeTotal;
    }

    @JsonProperty("StatusQualidadeTotal")
    public void setStatusQualidadeTotal(Boolean statusQualidadeTotal) {
        this.statusQualidadeTotal = statusQualidadeTotal;
    }

    @JsonProperty("EstagioObra")
    public String getEstagioObra() {
        return estagioObra;
    }

    @JsonProperty("EstagioObra")
    public void setEstagioObra(String estagioObra) {
        this.estagioObra = estagioObra;
    }

    @JsonProperty("DistanciaKilometros")
    public Double getDistanciaKilometros() {
        return distanciaKilometros;
    }

    @JsonProperty("DistanciaKilometros")
    public void setDistanciaKilometros(Double distanciaKilometros) {
        this.distanciaKilometros = distanciaKilometros;
    }

    @JsonProperty("Fotos")
    public List<String> getFotos() {
        return fotos;
    }
    @JsonProperty("Fotos")
    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }
    @JsonProperty("Observacao")
    public String getObservacao() {
        return observacao;
    }
    @JsonProperty("Observacao")
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    @JsonProperty("Caracteristicas")
    public List<String> getCaracteristicas() {
        return caracteristicas;
    }
    @JsonProperty("Caracteristicas")
    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    @JsonProperty("PrecoCondominio")
    public Integer getPrecoCondominio() {
        return precoCondominio;
    }
    @JsonProperty("PrecoCondominio")
    public void setPrecoCondominio(Integer precoCondominio) {
        this.precoCondominio = precoCondominio;
    }
    @JsonProperty("CaracteristicasComum")
    public List<String> getCaracteristicasComum() {
        return caracteristicasComum;
    }
    @JsonProperty("CaracteristicasComum")
    public void setCaracteristicasComum(List<String> caracteristicasComum) {
        this.caracteristicasComum = caracteristicasComum;
    }
    @JsonProperty("InformacoesComplementares")
    public String getInformacoesComplementares() {
        return informacoesComplementares;
    }
    @JsonProperty("InformacoesComplementares")
    public void setInformacoesComplementares(String informacoesComplementares) {
        this.informacoesComplementares = informacoesComplementares;
    }


    public String getInfo() {
        return dormitorios + " dorms, "  + suites + " suite, " + vagas + " vagas, " + areaTotal + " m²";
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


