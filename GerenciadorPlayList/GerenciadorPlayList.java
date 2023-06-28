package GerenciadorPlayList;

import GerenciadorMusica.GerenciadorMusica;
import GerenciadorMusica.Musica;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorPlayList {

    private static List<Musica> listaDeMusicas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static List<PlayList> listaDePlaylists = new ArrayList<>();

public static void criarPlaylist() {
    System.out.println("┌───────────────────────┐");
    System.out.println("│ Criação de Playlist   │");
    System.out.println("└───────────────────────┘");

    System.out.print("Digite o nome da Playlist: ");
    String nomePlayList = scanner.nextLine();

    PlayList novaPlaylist = new PlayList(nomePlayList);
    listaDePlaylists.add(novaPlaylist);

    System.out.println("┌───────────────────────┐");
    System.out.println("│ Playlist Criada !     │");
    System.out.println("└───────────────────────┘");

    if (!novaPlaylist.getMusicas().isEmpty()) {
        System.out.println("\nMúsicas cadastradas:");
        for (Musica musica : novaPlaylist.getMusicas()) {
            System.out.println("Título: " + musica.getTitulo() + ", Artista: " + musica.getArtista());
        }
    } else {
        System.out.println("\nA playlist está vazia. Deseja adicionar uma música? S/N");
        System.out.print("-> ");
        String addMusicChoice = scanner.nextLine();

        switch (addMusicChoice) {
            case "S":
            case "s":
                GerenciadorMusica.cadastrarMusica();
                break;

            case "N":
            case "n":
                break;
        }
    }
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

    public static void exibirMusicasCadastradas() {
    System.out.println("\n┌─────────────────────────────────────┐");
    System.out.println("│ Músicas Cadastradas                 │");
    System.out.println("└─────────────────────────────────────┘\n");

    if (listaDeMusicas.isEmpty()) {
        System.out.println("Não há músicas cadastradas.\n");
    } else {
        for (int i = 0; i < listaDeMusicas.size(); i++) {
            Musica musica = listaDeMusicas.get(i);
            System.out.println("[" + i + "] Título: " + musica.getTitulo() + ", Artista: " + musica.getArtista());
        }
        System.out.println("[" + listaDeMusicas.size() + "] Cancelar");
        System.out.print("\nSelecione o número da música que deseja adicionar a uma playlist: ");

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente após a leitura do número

        if (escolha >= 0 && escolha < listaDeMusicas.size()) {
            Musica musicaSelecionada = listaDeMusicas.get(escolha);

            System.out.println("\nSelecione a playlist na qual deseja adicionar a música:");
            listaPlaylist();
            System.out.print("Digite o número da playlist: ");
            int playlistEscolhida = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente após a leitura do número

            if (playlistEscolhida >= 0 && playlistEscolhida < listaDePlaylists.size()) {
                PlayList playlist = listaDePlaylists.get(playlistEscolhida);
                playlist.adicionarMusica(musicaSelecionada);
                System.out.println("\nMúsica adicionada à playlist: " + playlist.getNome());
            } else {
                System.out.println("\nPlaylist inválida. A música não foi adicionada a nenhuma playlist.");
            }
        } else if (escolha == listaDeMusicas.size()) {
            System.out.println("\nOperação cancelada. Nenhuma música foi adicionada a uma playlist.");
        } else {
            System.out.println("\nEscolha inválida. Nenhuma música foi adicionada a uma playlist.");
        }
    }
}

}
