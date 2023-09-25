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

    public static boolean inserirSite(Site s, HashMap<String, Site> h) {
        if (h.containsKey(s.getNome())) {
            return false;
        }
        h.put(s.getNome(), s);
        return true;
    }

    public static String acessarSite(String s, HashMap<String, Site> h) {
        if (h.containsKey(s)) {
            if (h.get(s).isStatusSite()) {
                return "Site: " + h.get(s).getNome() + "\nIP: " + h.get(s).getEnderecoDeIp();
            } else {
                return "Site bloqueado";
            }
        }
        return "Site não existe";
    }

    public static String imprimirSite(HashMap<String, Site> h) {
        String ret = "";
        for (Site s : h.values()) {
            ret += s.toString();
        }
        return ret;
    }

    public static void main(String[] args) {
        HashMap<String, Site> mapaSite = new HashMap<>();

        try {
            Site s = new Site("www.inf.furb.br", "201.54.201.5", true);
            Site s1 = new Site("www.orkut.com", "64.233.163.86", false);

            inserirSite(s, mapaSite);
            inserirSite(s1, mapaSite);

            System.out.println(acessarSite("www.inf.furb.br", mapaSite));
            System.out.println("");
            System.out.println(acessarSite("www.orkut.com", mapaSite));
            System.out.println("");

            System.out.println(imprimirSite(mapaSite));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
