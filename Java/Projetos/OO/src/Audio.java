import java.util.Scanner;
import java.util.ArrayList;

public class Audio {
    protected String nome;
    protected double tempoDeReproducao;
    protected boolean disponivelNoSpotify;
    protected boolean disponivelNoYoutube;
    protected int totalCurtidas;
    protected int totalComentarios;
    protected int totalAvaliacoes;
    protected ArrayList<String> comentarios = new ArrayList<String>();
    protected ArrayList<Double> avaliacoes = new ArrayList<Double>();


    //sobrecarga de construtor
    public Audio(String nome, double tempoDeReproducao, boolean disponivelNoSpotify, boolean disponivelNoYoutube) {
        this.nome = nome;
        this.tempoDeReproducao = tempoDeReproducao;
        this.disponivelNoSpotify = disponivelNoSpotify;
        this.disponivelNoYoutube = disponivelNoYoutube;
    }

    public Audio(String nome, String autor, double tempoDeReproducao, boolean disponivelNoSpotify, boolean disponivelNoYoutube) {
        this.nome = nome;
        this.tempoDeReproducao = tempoDeReproducao;
        this.disponivelNoSpotify = disponivelNoSpotify;
        this.disponivelNoYoutube = disponivelNoYoutube;
    }

    //getters e stters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTempoDeReproducao() {
        return tempoDeReproducao;
    }

    public boolean getDisponivelNoSpotify() {
        return disponivelNoSpotify;
    }
    public void setDisponivelNoSpotify(boolean disponivelNoSpotify) {
        this.disponivelNoSpotify = disponivelNoSpotify;
    }

    public boolean getDisponivelNoYoutube() {
        return disponivelNoYoutube;
    }
    public void setDisponivelNoYoutube(boolean disponivelNoYoutube) {
        this.disponivelNoYoutube = disponivelNoYoutube;
    }

    public int getTotalCurtidas() {
        return totalCurtidas;
    }

    public int getTotalComentarios() {
        return totalComentarios;
    }

    public int getTotalAvaliacoes() {
        return totalAvaliacoes;
    }
            
    Scanner s = new Scanner(System.in);

    public void mostraFichaTecnica() {
        System.out.println(String.format("""
                   --- Ficha Técnica ---
                Nome:       %s
                Tempo de Reprodução:    %.2f
                Disponível no Spotify:  %s
                Disponível no Youtube:  %s
                """, nome, tempoDeReproducao, disponivelNoSpotify, disponivelNoYoutube));
    }

    public void curteAudio() {
        totalCurtidas++;
    }

    public void comentaAudio(){
        System.out.println("Digite seu comentário: ");
        String comentario = s.nextLine();
        
        comentarios.add(comentario);
        totalComentarios++;
    }

    public void mostraComentarios() {
        for (int i = 0; i < comentarios.size(); i++) {
            System.out.println(comentarios.get(i));
        }
    }

    public void avaliaAudio() {
        System.out.println("Digite sua avaliação de 1 a 5: ");
        double avaliacao = s.nextDouble();

        avaliacoes.add(avaliacao);
        totalAvaliacoes++;
    }
    
    public void mostraAvaliacoes() {
        for (int i = 0; i < avaliacoes.size(); i++) {
            System.out.println(avaliacoes.get(i));
        }
    }

    public void menu() {
        System.out.println("""
                Escolha uma das opções abaixo:

                1 - Curtir 
                2 - Comentar
                3 - Ver curtidas e comentários
                4 - Avaliar 
                5 - Ver avaliações
                6 - Exibir ficha técnica
                7 - Sair
                """);
                int resposta = s.nextInt();

        while(resposta != 7) {
            System.out.println("""
                Escolha uma das opções abaixo:

                1 - Curtir 
                2 - Comentar
                3 - Ver curtidas e comentários
                4 - Avaliar 
                5 - Ver avaliações
                6 - Exibir ficha técnica
                7 - Sair
                """);
                resposta = s.nextInt();

                if (resposta == 1) {
                    curteAudio(); 
                } if (resposta == 2) {
                    comentaAudio();
                } if (resposta == 3) {
                    System.out.println("Total de curtidas: " + getTotalCurtidas());
                    System.out.println("Comentários: ");
                    mostraComentarios();
                } if (resposta == 4) {
                    avaliaAudio();
                } if (resposta == 5) {
                    System.out.println("Avaliações: ");
                    mostraAvaliacoes();
                } else if (resposta == 6) {
                    mostraFichaTecnica();
                }
                
        }
    }  
}

