/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex04;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Site {

    // Atributos
    private String nome;
    private String enderecoDeIp;
    private boolean statusSite;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome.trim().isEmpty() || nome == null) {
            throw new IllegalArgumentException();
        }
        this.nome = nome;
    }

    public String getEnderecoDeIp() {
        return enderecoDeIp;
    }

    public void setEnderecoDeIp(String enderecoDeIp) {
        if (enderecoDeIp.trim().isEmpty() || enderecoDeIp == null) {
            throw new IllegalArgumentException();
        }
        this.enderecoDeIp = enderecoDeIp;
    }

    public boolean isStatusSite() {
        return statusSite;
    }

    public void setStatusSite(boolean statusSite) {
        this.statusSite = statusSite;
    }

    // Construtor
    public Site(String nome, String enderecoDeIp, boolean statusSite) {
        setNome(nome);
        setEnderecoDeIp(enderecoDeIp);
        setStatusSite(statusSite);
    }

    // Métodos
    @Override
    public String toString() {
        String status;
        if (this.isStatusSite()) {
            status = "Livre";
        } else {
            status = "Bloqueado";
        }
        return "Site: " + this.getNome() + "\nIP: " + this.getEnderecoDeIp() + "\nAcesso: " + status;
    }
}
