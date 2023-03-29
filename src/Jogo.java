public class Jogo {
    private Tabuleiro tabuleiro;
    private int rodada = 1, vez = 1;
    private Jogador jogador1;
    private Jogador jogador2;
    private boolean jogoTerminado = false;


    public Jogo() {
        tabuleiro = new Tabuleiro();
        iniciarJogadores();

        while (!jogoTerminado){
            Jogar();
        };
    }

    public void iniciarJogadores() {
        System.out.println("Jogador 1 será X");
        this.jogador1 = new Jogador(1);

        System.out.println("----------------------");
        System.out.println("Jogador 2 será 0");

        this.jogador2 = new Jogador(2);
    }

    public boolean Jogar() {
        if (ganhou() != 0) {
            jogoTerminado = true;
            if (ganhou() == -1)
                System.out.println("Jogador 1 ganhou!");
            else
                System.out.println("Jogador 2 ganhou!");

            return false;
        }

        System.out.println("----------------------");
        System.out.println("\nRodada " + rodada);
        System.out.println("É a vez do jogador " + vez());

        if (vez() == 1)
            jogador1.jogar(tabuleiro);
        else
            jogador2.jogar(tabuleiro);

        if (ganhou() != 0) {
            jogoTerminado = true;
            if (ganhou() == -1)
                System.out.println("Jogador 1 ganhou!");
            else
                System.out.println("Jogador 2 ganhou!");

            return false;
        }

        if (tabuleiro.tabuleiroCompleto()) {
            jogoTerminado = true;
            System.out.println("Deu velha");
            return false;
        }

        vez++;
        rodada++;

        return true;
    }

    public int vez() {
        if (vez % 2 == 1)
            return 1;
        else
            return 2;
    }

    public int ganhou() {
        int resultado = tabuleiro.checaLinhas();

        if (resultado != 0)
            return resultado;

        resultado = tabuleiro.checaColunas();

        if (resultado != 0)
            return resultado;

        resultado = tabuleiro.checaDiagonais();

        return resultado;
    }
}
