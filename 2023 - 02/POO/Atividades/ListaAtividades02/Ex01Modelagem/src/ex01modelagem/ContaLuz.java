/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex01modelagem;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ContaLuz {
    private String dtLeitura;
    private int numLeitura;
    private int kwGasto;
    private double vlrPagar;
    private String dtPagto;
    private double mediaConsumo;

    public ContaLuz(String dtLeitura, int numLeitura, int kwGasto, double vlrPagar, String dtPagto, double mediaConsumo) {
        setDtLeitura(dtLeitura);
        setNumLeitura(numLeitura);
        setKwGasto(kwGasto);
        setVlrPagar(vlrPagar);
        setDtPagto(dtPagto);
        setMediaConsumo(mediaConsumo);
    }

    public String getDtLeitura() {
        return dtLeitura;
    }
    public void setDtLeitura(String dtLeitura) {
        this.dtLeitura = dtLeitura;
    }

    public int getNumLeitura() {
        return numLeitura;
    }
    public void setNumLeitura(int numLeitura) throws IllegalArgumentException {
        if (numLeitura < 0)
            throw new IllegalArgumentException("Valor de leitura inválido");
        this.numLeitura = numLeitura;
    }

    public int getKwGasto() {
        return kwGasto;
    }
    public void setKwGasto(int kwGasto) throws IllegalArgumentException {
        if (kwGasto < 0)
            throw new IllegalArgumentException("Valor gasto inválido");
        this.kwGasto = kwGasto;
    }

    public double getVlrPagar() {
        return vlrPagar;
    }
    public void setVlrPagar(double vlrPagar) throws IllegalArgumentException {
        if (vlrPagar < 0)
            throw new IllegalArgumentException("Valor a pagar inválido");
        this.vlrPagar = vlrPagar;
    }

    public String getDtPagto() {
        return dtPagto;
    }
    public void setDtPagto(String dtPagto) {
        this.dtPagto = dtPagto;
    }

    public double getMediaConsumo() {
        return mediaConsumo;
    }
    public void setMediaConsumo(double mediaConsumo) throws IllegalArgumentException {
        if (mediaConsumo < 0)
            throw new IllegalArgumentException("Media de consumo inválida");
        this.mediaConsumo = mediaConsumo;
    }
    
    @Override
    public String toString() {
        return "Menor Consumo: " + this.getKwGasto() + "Kw; " + this.getDtLeitura();
    }
}
