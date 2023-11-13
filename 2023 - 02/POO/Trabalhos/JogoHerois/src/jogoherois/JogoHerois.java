package jogoherois;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bernardo Chiamolera
 */
public class JogoHerois {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<SuperHeroi> herois = new ArrayList();
        ArrayList<Vilao> viloes = new ArrayList();
        
        // Criando heróis
        SuperHeroi chapolim = new SuperHeroi("Chapolim Colorado", "");
        SuperHeroi homemAranha = new SuperHeroi("Homem-Aranha", "Peter Parker");
        SuperHeroi superHomem = new SuperHeroi("Super-Homem", "Clark Kent");
        SuperHeroi capitaoAmerica = new SuperHeroi("Capitão América", "Steve Rogers");
        SuperHeroi flash = new SuperHeroi("Flash", "Barry Allen");
        SuperHeroi lanternaVerde = new SuperHeroi("Lanterna-Verde", "Hal Jordan");
        SuperHeroi homemDeFerro = new SuperHeroi("Homem de Ferro", "Tony Stark");
        
        // Criando vilões
        Vilao duendeVerde = new Vilao("Duende Verde", "Norman Osbourne", 2);
        Vilao lexLuthor = new Vilao("Lex Luthor", "Lex Luthor", 4);
        Vilao bizarro = new Vilao("Bizarro", "", 100);
        Vilao octopus = new Vilao("Octopus", "Otto Octavius", 5);
        
        // Adicionando poderes;
        chapolim.adicionaSuperpoder(new Superpoder("Anteninhas de Vinil", 4));
        chapolim.adicionaSuperpoder(new Superpoder("Marreta Bionica", 5));
        chapolim.adicionaSuperpoder(new Superpoder("Corneta Paralisadora", 5));
        chapolim.adicionaSuperpoder(new Superpoder("Pastilhas Encolhedoras", 4));
        
        homemAranha.adicionaSuperpoder(new Superpoder("Soltar Teia", 3));
        homemAranha.adicionaSuperpoder(new Superpoder("ndar nas Paredes", 2));
        
        superHomem.adicionaSuperpoder(new Superpoder("Voar", 3));
        superHomem.adicionaSuperpoder(new Superpoder("Força", 5));
        superHomem.adicionaSuperpoder(new Superpoder("Visão de Raio-X", 4));
        superHomem.adicionaSuperpoder(new Superpoder("Sopro Congelante", 4));
        
        capitaoAmerica.adicionaSuperpoder(new Superpoder("Super Soldado", 3));
        capitaoAmerica.adicionaSuperpoder(new Superpoder("Escudo", 3));
        
        flash.adicionaSuperpoder(new Superpoder("Velocidade", 5));
        
        lanternaVerde.adicionaSuperpoder(new Superpoder("Anel Mágico", 5));
        
        homemDeFerro.adicionaSuperpoder(new Superpoder("Armadura", 4));
        homemDeFerro.adicionaSuperpoder(new Superpoder("Dispositivos Eletrônicos", 2));
        
        duendeVerde.adicionaSuperpoder(new Superpoder("Força", 5));
        
        lexLuthor.adicionaSuperpoder(new Superpoder("Mente Aguçada", 5));
        
        bizarro.adicionaSuperpoder(new Superpoder("Voar", 3));
        bizarro.adicionaSuperpoder(new Superpoder("Força", 5));
        bizarro.adicionaSuperpoder(new Superpoder("Visão de Raio-X", 4));
        bizarro.adicionaSuperpoder(new Superpoder("Sopro Congelante", 4));
        
        octopus.adicionaSuperpoder(new Superpoder("Tentáculos Indestrutíveis", 5));
        octopus.adicionaSuperpoder(new Superpoder("Velocidade", 1));
        
        // Adicionando heróis
        herois.add(chapolim);
        herois.add(homemAranha);
        herois.add(superHomem);
        herois.add(capitaoAmerica);
        herois.add(flash);
        herois.add(lanternaVerde);
        herois.add(homemDeFerro);
        
        // Adicionando vilões
        viloes.add(duendeVerde);
        viloes.add(lexLuthor);
        viloes.add(bizarro);
        viloes.add(octopus);
        
        // Inicio
        System.out.println("Bem-Vindo ao Confronto de Heróis!");
        System.out.println("---------------------------------");
        
        // MOSTRA HEROIS
        System.out.println("Escolha um Herói: ");
        for (int i = 0; i < herois.size(); i++) {
            System.out.println((i + 1) + ". "+ herois.get(i).getNome());
        }
        int opHeroi = s.nextInt() - 1;
        
        // MOSTRA VILÕES
        System.out.println("Escolha um Vilão: ");
        for (int i = 0; i < viloes.size(); i++) {
            System.out.println((i + 1) + ". "+ viloes.get(i).getNome());
        }
        int opVilao = s.nextInt() - 1;
        
        // MOSTRA RESULTADO
        System.out.println("O vencedor da batalha é: ");
        int vencedor = new Confronto().executar(herois.get(opHeroi), viloes.get(opVilao));
        if (vencedor == 1) System.out.println(herois.get(opHeroi).getNome());
        else System.out.println(viloes.get(opVilao).getNome());
        s.close();
    }
}
