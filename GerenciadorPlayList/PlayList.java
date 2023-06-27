package GerenciadorPlayList;

import GerenciadorMusica.Musica; 
import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private String nome;
    private List<Musica> musicas;

    public PlayList(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public List<Musica> getMusicas() {
        return musicas;
    }
}
