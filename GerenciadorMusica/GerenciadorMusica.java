package GerenciadorMusica;
import java.util.Scanner;

public class GerenciadorMusica {

    private static Scanner scanner = new Scanner(System.in);


    public static void cadastrarMusica() {
        System.out.println("┌───────────────────────┐");
        System.out.println("│ Cadastro de Música    │");
        System.out.println("└───────────────────────┘");
    
        System.out.print("Digite o título da música: ");
        String titulo = scanner.nextLine();
    
        System.out.print("Digite o artista: ");
        String artista = scanner.nextLine();
    
        int duracaoMinutos = 0;
        int duracaoSegundos = 0;
    
        while (true) {
            System.out.print("Digite a duração da música (minutos:segundos): ");
            String duracao = scanner.nextLine();
    
            String[] partesDuracao = duracao.split(":");
            if (partesDuracao.length == 2) {
                try {
                    duracaoMinutos = Integer.parseInt(partesDuracao[0]);
                    duracaoSegundos = Integer.parseInt(partesDuracao[1]);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida! Digite a duração no formato correto (minutos:segundos).");
                }
            }
        }
    
        int duracaoTotalSegundos = duracaoMinutos * 60 + duracaoSegundos;
        Musica musica = new Musica(titulo, artista, duracaoTotalSegundos);
    
        System.out.println("\n┌───────────────────────┐");
        System.out.println("│ Música Cadastrada !    │");
        System.out.println("└───────────────────────┘\n");
    }
    
}