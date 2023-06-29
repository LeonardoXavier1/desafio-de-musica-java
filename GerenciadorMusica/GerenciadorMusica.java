package GerenciadorMusica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import GerenciadorPlayList.GerenciadorPlayList;
import GerenciadorPlayList.PlayList;

public class GerenciadorMusica {

    private Scanner scanner = new Scanner(System.in);
    private  List<Musica> listaDeMusicas = new ArrayList<>();
    private  List<PlayList> listaDePlaylists = new ArrayList<>();

    public GerenciadorMusica() {
        listaDeMusicas = new ArrayList<>();
        scanner = new Scanner(System.in);
        listaDePlaylists = new ArrayList<>();
    }
    
public void cadastrarMusica(GerenciadorPlayList gerenciador) {
    this.listaDePlaylists = gerenciador.getListaDePlaylists();



    System.out.println("┌───────────────────────┐");
    System.out.println("│ Cadastro de Música    │");
    System.out.println("└───────────────────────┘");

    System.out.println("┌────────────────────────────────────────────┐");
    System.out.println("│[1] Bring Me The Horizon - Maybe            │");
    System.out.println("│[2] Nirvana - Something in The Way          │");
    System.out.println("│[3] Nirvana - Smells Like Teen Spirit       │");
    System.out.println("│[4] Nirvana - Come As You Are               │");
    System.out.println("│[5] Bring Me The Horizon - Throne           │");
    System.out.println("│[6] Bring Me The Horizon - SleepWalking     │");
    System.out.println("└────────────────────────────────────────────┘");

    System.out.print("Escolha uma música para adicionar em uma playlist (digite o número correspondente): ");
    String escolha = scanner.nextLine();

    int musicaEscolhida = Integer.parseInt(escolha);
    if (musicaEscolhida >= 1 && musicaEscolhida <= 6) {
        Musica musica = null;
        String titulo, artista;

        switch (musicaEscolhida) {
            case 1:
                titulo = "Maybe";
                artista = "Bring Me The Horizon";
                musica = new Musica(titulo, artista, musicaEscolhida);
                break;
            case 2:
                titulo = "Something in The Way";
                artista = "Nirvana";
                musica = new Musica(titulo, artista, musicaEscolhida);
                break;
            case 3:
                titulo = "Smells Like Teen Spirit";
                artista = "Nirvana";
                musica = new Musica(titulo, artista, musicaEscolhida);
                break;
            case 4:
                titulo = "Come As You Are";
                artista = "Nirvana";
                musica = new Musica(titulo, artista, musicaEscolhida);
                break;
            case 5:
                titulo = "Throne";
                artista = "Bring Me The Horizon";
                musica = new Musica(titulo, artista, musicaEscolhida);
                break;
            case 6:
                titulo = "SleepWalking";
                artista = "Bring Me The Horizon";
                musica = new Musica(titulo, artista, musicaEscolhida);
                break;
        }

        if (musica != null) {
            exibirPlaylists(listaDePlaylists);
            System.out.print("Digite o número da playlist na qual deseja adicionar a música: ");
            String escolhaPlaylist = scanner.nextLine();
            int playlistEscolhida = Integer.parseInt(escolhaPlaylist);

            if (playlistEscolhida >= 1 && playlistEscolhida <= listaDePlaylists.size()) {
                PlayList playlist = listaDePlaylists.get(playlistEscolhida - 1);
                playlist.adicionarMusica(musica);
                System.out.println("\nMúsica adicionada à playlist: " + playlist.getNome());
            } else {
                System.out.println("Playlist inválida. A música não foi adicionada a nenhuma playlist.");
            }
        }
    } else {
        System.out.println("Escolha de música inválida.");
    }
}

    public void exibirMusicasCadastradas() {
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
        }
    }

    public void exibirPlaylists(List<PlayList> playlists) {
        // System.out.println("\n┌─────────────────────────────────────┐");
        // System.out.println("│ Playlists Disponíveis               │");
        // System.out.println("└─────────────────────────────────────┘\n");

        if (playlists.isEmpty()) {
            System.out.println("Não há playlists disponíveis.\n");
        } else {
            for (int i = 0; i < listaDePlaylists.size(); i++) {
                PlayList playlist = listaDePlaylists.get(i);
                System.out.println("\n[" + (i + 1) + "] " + playlist.getNome());
            }
        }
    }
    public void adicionarPlaylist() {
        System.out.print("Digite o nome da playlist: ");
        String nomePlaylist = scanner.nextLine();
    
        PlayList novaPlaylist = new PlayList(nomePlaylist);
        listaDePlaylists.add(novaPlaylist);
    
        System.out.println("\nPlaylist adicionada com sucesso: " + nomePlaylist);
    }

public void tocarMusicas() {
    exibirPlaylists(listaDePlaylists);

    if (listaDePlaylists.isEmpty()) {
        System.out.println("Não há playlists disponíveis para reproduzir músicas.");
        return;
    }

    System.out.print("Digite o número da playlist que deseja reproduzir: ");
    String escolhaPlaylist = scanner.nextLine();
    int playlistEscolhida = Integer.parseInt(escolhaPlaylist);

    if (playlistEscolhida >= 1 && playlistEscolhida <= listaDePlaylists.size()) {
        PlayList playlist = listaDePlaylists.get(playlistEscolhida - 1);
        List<Musica> musicas = playlist.getMusicas();

        if (musicas.isEmpty()) {
            System.out.println("A playlist selecionada não possui músicas para reproduzir.");
            return;
        }

        System.out.println("Reproduzindo músicas da playlist: " + playlist.getNome());
        System.out.print("Escolha o modo de reprodução: ");
        System.out.println("[1] Reproduzir em ordem");
        System.out.println("[2] Reproduzir aleatoriamente");
        String escolhaModo = scanner.nextLine();

        if (escolhaModo.equals("1")) {
            System.out.println("Modo de reprodução: em ordem");
            for (int i = 0; i < musicas.size(); i++) {
                Musica musica = musicas.get(i);
                System.out.println("Tocando música: " + musica.getTitulo() + " - " + musica.getArtista());
            }
        } else if (escolhaModo.equals("2")) {
            System.out.println("Modo de reprodução: aleatório");
            List<Musica> musicasAleatorias = new ArrayList<>(musicas);
            Collections.shuffle(musicasAleatorias);
            for (Musica musica : musicasAleatorias) {
                System.out.println("Tocando música: " + musica.getTitulo() + " - " + musica.getArtista());
            }
        } else {
            System.out.println("Opção de modo inválida. A reprodução foi cancelada.");
        }
    } else {
        System.out.println("Playlist inválida. A reprodução foi cancelada.");
    }
}

    
}

    // public static void cadastrarMusica() {
    //     System.out.println("┌───────────────────────┐");
    //     System.out.println("│ Cadastro de Música    │");
    //     System.out.println("└───────────────────────┘");

    //     System.out.print("Digite o título da música: ");
    //     String titulo = scanner.nextLine();

    //     System.out.print("Digite o artista: ");
    //     String artista = scanner.nextLine();

    //     int duracaoMinutos = 0;
    //     int duracaoSegundos = 0;

    //     while (true) {
    //         System.out.print("Digite a duração da música (minutos:segundos): ");
    //         String duracao = scanner.nextLine();

    //         String[] partesDuracao = duracao.split(":");
    //         if (partesDuracao.length == 2) {
    //             try {
    //                 duracaoMinutos = Integer.parseInt(partesDuracao[0]);
    //                 duracaoSegundos = Integer.parseInt(partesDuracao[1]);
    //                 break;
    //             } catch (NumberFormatException e) {
    //                 System.out.println("Entrada inválida! Digite a duração no formato correto (minutos:segundos).");
    //             }
    //         }
    //     }

    //     int duracaoTotalSegundos = duracaoMinutos * 60 + duracaoSegundos;
    //     Musica novaMusica = new Musica(titulo, artista, duracaoTotalSegundos);
    //     listaDeMusicas.add(novaMusica);

    //     System.out.println("\n┌───────────────────────┐");
    //     System.out.println("│ Música Cadastrada !   │");
    //     System.out.println("└───────────────────────┘\n");
    // }