import java.util.Scanner;
import GerenciadorMusica.GerenciadorMusica;
import GerenciadorPlayList.GerenciadorPlayList;

public class Main{

    private static Scanner scanner = new Scanner(System.in);
  //private static GerenciadorMusica gerenciadormusica = new GerenciadorMusica();

    public static void main(String[] args) {
        boolean rodando = true;
        while (rodando == true){
            System.out.println("┌─────────────────────────────────────┐");
            System.out.println("│Gerenciamento de Músicas e Playlists.│");
            System.out.println("└─────────────────────────────────────┘");
            System.out.println("[ 1 ] - Cadastrar Musica");
            System.out.println("[ 2 ] - Criar PlayList");
            System.out.println("[ 3 ] - Tocar Musica");
            System.out.println("[ 4 ] - Lista de PlayList");
            System.out.println("[ 5 ] - Mesclar Playlist");
            System.out.println("[ 0 ] - Sair\n");


            System.out.print("O que deseja fazer? ");

            String escolha = scanner.nextLine();

            switch (escolha) { 

                case "1":


                GerenciadorMusica.cadastrarMusica();
                break;

                case "2":
                GerenciadorPlayList.criarPlaylist();
                break;

                case "3":
                //tocarMusica();
                break;

                case "4":
                GerenciadorPlayList.listaPlaylist();
                break;

                case "5":
                //mesclar
                break;

                case "0":
                rodando = false;
                break;

                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
                    break;
            }
        }
    }
}