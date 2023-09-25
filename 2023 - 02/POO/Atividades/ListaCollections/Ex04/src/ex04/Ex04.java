/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex04;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.util.HashMap;

public class Ex04 {

    /**
     * @param args the command line arguments
     */
    public static void inserirSite(Site s, HashMap<String, Site> h) {
        h.put(s.getNome(), s);
    }
    
    public static String acessarSite(String s, HashMap<String, Site> h) {
        if (h.containsKey(s)) {
            if (h.get(s).isStatusSite()) return "Site: " + h.get(s).getNome() + "\nIP: " + h.get(s).getEnderecoDeIp();
            else return "Site bloqueado";
        }
        return "Site não existe";
    }
    
    public static String imprimirSite(HashMap<String, Site> h) {
        String retorno = "";
        for (Site s : h.values()) {
            retorno += s.toString();
        }
        return retorno;
    }
    
    public static void main(String[] args) {
        Site s = new Site("www.inf.furb.br", "201.54.201.5", true);
        Site s1 = new Site("www.orkut.com", "64.233.163.86", false);
        
        HashMap<String, Site> mapaSite = new HashMap<String, Site>();
        
        inserirSite(s, mapaSite);
        inserirSite(s1, mapaSite);
        
        System.out.println(acessarSite("www.inf.furb.br", mapaSite));
        System.out.println("");
        System.out.println(acessarSite("www.orkut.com", mapaSite));
        System.out.println("");
        
        System.out.println(imprimirSite(mapaSite));
    }
    
}
