package GerenciadorPlayList;

import GerenciadorMusica.Musica; 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorPlayList {

    private static Scanner scanner = new Scanner(System.in);
    private static List<PlayList> listaDePlaylists = new ArrayList<>();

    public static void criarPlaylist() {
        System.out.println("┌───────────────────────┐");
        System.out.println("│ Criação de Playlist   │");
        System.out.println("└───────────────────────┘");
    
        System.out.print("Digite o nome da PlayList: ");
        String nomePlayList = scanner.nextLine();
    
        PlayList novaPlaylist = new PlayList(nomePlayList);
        listaDePlaylists.add(novaPlaylist);
    
        System.out.println("┌───────────────────────┐");
        System.out.println("│ Playlist Criada !     │");
        System.out.println("└───────────────────────┘");
    
        System.out.println("\nGostaria de ver a lista de PlayList? S/N\n");
        System.out.print("-> ");
        String choice = scanner.nextLine();
    
        switch (choice) {
            case "S":
            case "s":
                listaPlaylist();
                break;
    
            case "N":
            case "n":
                break;
        }
    
        if (novaPlaylist.getMusicas().isEmpty()) {
            System.out.println("\nA playlist está vazia. Deseja adicionar uma música? S/N");
            System.out.print("-> ");
            String addMusicChoice = scanner.nextLine();
    
            switch (addMusicChoice) {
                case "S":
                case "s":
                    adicionarMusicaPlaylist(novaPlaylist);
                    break;
    
                case "N":
                case "n":
                    break;
            }
        }
    }

    public static void adicionarMusicaPlaylist(PlayList playlist) {
        System.out.println("\nAdicionar Música à Playlist: " + playlist.getNome());
    
        System.out.print("Digite o título da música: ");
        String titulo = scanner.nextLine();
    
        System.out.print("Digite o artista: ");
        String artista = scanner.nextLine();
    
        System.out.print("Digite a duração em segundos: ");
        int duracaoSegundos;
        try {
            duracaoSegundos = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Duração inválida. A música não será adicionada à playlist.");
            return;
        }
    
        Musica musica = new Musica(titulo, artista, duracaoSegundos);
        playlist.adicionarMusica(musica);
    
        System.out.println("Música adicionada à playlist com sucesso!");
    }
    

    public static void listaPlaylist() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│ Lista de Playlists                  │");
        System.out.println("└─────────────────────────────────────┘\n");

        if (listaDePlaylists.isEmpty()) {
            System.out.println("Não há playlists disponíveis.\n");
        } else {
            for (PlayList playlist : listaDePlaylists) {
                System.out.println("Nome da Playlist: " + playlist.getNome());
                System.out.println("─────────────────────────────────────");
            }
        }
    }
}
