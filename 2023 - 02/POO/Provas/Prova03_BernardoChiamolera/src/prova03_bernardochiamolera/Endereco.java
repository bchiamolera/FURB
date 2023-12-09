package prova03_bernardochiamolera;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Endereco {
    private String rua;
    private String numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;

    public Endereco(String rua, String numero, String complemento, String cep, String cidade, String estado) {
        setRua(rua);
        setNumero(numero);
        setComplemento(complemento);
        setCep(cep);
        setCidade(cidade);
        setEstado(estado);
    }
    

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
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
        if (complemento != null) {
            this.complemento = complemento;
        } else {
            this.complemento = "";
        }
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Rua: " + this.getRua() + "\nNúmero: " + this.getNumero() + "\nComplemento: " + this.getComplemento()
                + "\nCEP:" + this.getCep() + "\nCidade: " + this.getCidade() + "\nEstado: " + this.getEstado();
    }
}
