package GerenciadorPlayList;

import GerenciadorMusica.GerenciadorMusica;
import GerenciadorMusica.Musica;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorPlayList {

    GerenciadorMusica gerenciadorm = new GerenciadorMusica();
    
    private List<Musica> listaDeMusicas;
    private Scanner scanner;
    private List<PlayList> listaDePlaylists;

    public GerenciadorPlayList() {
        listaDeMusicas = new ArrayList<>();
        scanner = new Scanner(System.in);
        listaDePlaylists = new ArrayList<>();
    }

    public void criarPlaylist() {
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
        gerenciadorm.exibirPlaylists(listaDePlaylists);

    }

    public void listaPlaylist() {

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

    /*public void exibirMusicasCadastradas() {
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
            scanner.nextLine();

            if (escolha >= 0 && escolha < listaDeMusicas.size()) {
                Musica musicaSelecionada = listaDeMusicas.get(escolha);

                System.out.println("\nSelecione a playlist na qual deseja adicionar a música:");
                listaPlaylist();
                System.out.print("Digite o número da playlist: ");
                int playlistEscolhida = scanner.nextInt();
                scanner.nextLine();

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
    }*/

 public void AdicionaMusica(){

 }
    

}
