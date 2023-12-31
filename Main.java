import java.util.Scanner;
import GerenciadorMusica.GerenciadorMusica;
import GerenciadorPlayList.GerenciadorPlayList;

public class Main{

    public static void main(String[] args) {

        GerenciadorPlayList gerenciador = new GerenciadorPlayList(); 
        GerenciadorMusica gerenciadorm = new GerenciadorMusica();
        Scanner scanner = new Scanner(System.in);

        boolean rodando = true;
        while (rodando == true){
            System.out.println("┌─────────────────────────────────────┐");
            System.out.println("│Gerenciamento de Músicas e Playlists.│");
            System.out.println("└─────────────────────────────────────┘");
            System.out.println("[ 1 ] - Cadastrar Musica");
            System.out.println("[ 2 ] - Criar PlayList");
            System.out.println("[ 3 ] - Reproduzir");
            System.out.println("[ 4 ] - Lista de PlayList");
            System.out.println("[ 5 ] - Mesclar Playlist");
            System.out.println("[ 0 ] - Sair\n");


            System.out.print("O que deseja fazer? ");

            String escolha = scanner.nextLine();

            switch (escolha) { 

                case "1":
                gerenciadorm.cadastrarMusica(gerenciador);
                break;

                case "2":
                gerenciador.criarPlaylist();
                break;

                case "3":
                gerenciadorm.tocarMusicas();
                break;

                case "4":
                gerenciador.listaPlaylist();
                break;

                case "5":
                gerenciador.mesclar();
                break;

                case "0":
                rodando = false;
                break;

                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
                    break;
            }
        }
        scanner.close();
    }
}