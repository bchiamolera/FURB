/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex01;
import java.util.ArrayList;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Ex01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String time01 = "Gremio";
        String time02 = "Internacional";
        String time03 = "Corinthians";
        String time04 = "Flamengo";
        String time05 = "Palmeiras";
        String time06 = "Cruzeiro";
        String time07 = "Vasco";
        String time08 = "Santos";
        String time09 = "Fluminense";
        String time10 = "Chapecoense";
        
        ArrayList<String> times = new ArrayList<String>();
        times.add(time01);
        times.add(time02);
        times.add(time03);
        times.add(time04);
        times.add(time05);
        times.add(time06);
        times.add(time07);
        times.add(time08);
        times.add(time09);
        times.add(time10);
        
        times.remove(5);
        for (int i = 0; i < times.size(); i++) {
            System.out.println(times.get(i));
        }
    }
    
}
