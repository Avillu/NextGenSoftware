package es.uclm.repartodomicilio.business.entity;


import jakarta.persistence.Embeddable;

@Embeddable
public class Direccion {
    CodigoPostal codigoPostal;
    private String calle;
    private String numero;
    private String complemento;
    private String municipio;

    // Constructor vacio de JPA
    public Direccion(){}

    // Constructor con parametros
    public Direccion(String calle, String numero, String municipio, String complemento, CodigoPostal codigoPostal){
        this.calle = calle;
        this.numero = numero;
        this.municipio = municipio;
        this.codigoPostal = codigoPostal;
    }

    // Getters y setters
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public CodigoPostal getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(CodigoPostal codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

}
