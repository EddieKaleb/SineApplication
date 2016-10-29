package ifpb.edu.br.sineapplication.objects;

/**
 * Created by root on 28/10/16.
 */

public class Sine {


    String codPosto;
    String nome;
    String entidadeConveniada;
    String endereco;
    String bairro;
    String cep;
    String telefone;
    String municipio;
    String uf;
    long lat;
    long longitude;

    public Sine(){

    }

    public Sine(String codPosto, String nome, String entidadeConveniada, String endereco, String bairro, String cep, String telefone, String municipio, String uf, long lat, long longitude) {
        this.codPosto = codPosto;
        this.nome = nome;
        this.entidadeConveniada = entidadeConveniada;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.telefone = telefone;
        this.municipio = municipio;
        this.uf = uf;
        this.lat = lat;
        this.longitude = longitude;
    }

    public String getCodPosto() {
        return codPosto;
    }

    public void setCodPosto(String codPosto) {
        this.codPosto = codPosto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEntidadeConveniada() {
        return entidadeConveniada;
    }

    public void setEntidadeConveniada(String entidadeConveniada) {
        this.entidadeConveniada = entidadeConveniada;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "\n Sine\n" +
                "\n codPosto: " + codPosto + '\'' +
                "\n nome: " + nome + '\'' +
                "\n entidadeConveniada: " + entidadeConveniada + '\'' +
                "\n endereco: " + endereco + '\'' +
                "\n bairro: " + bairro + '\'' +
                "\n cep: " + cep + '\'' +
                "\n telefone: " + telefone + '\'' +
                "\n municipio: " + municipio + '\'' +
                "\n uf: " + uf + '\'' +
                "\n lat: " + lat +
                "\n longitude: " + longitude;
    }
}
