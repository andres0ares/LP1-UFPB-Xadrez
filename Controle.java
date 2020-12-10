
/**
 * Escreva a descrição da classe Controle aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Controle
{
    //se jogador = 0 - turno das brancas
    //se jogador = 6 - turno das pretas
    private int jogador;

    /**
     * COnstrutor para objetos da classe Controle
     */
    public Controle()
    {
        //O jogo inicia no turno das brancas
        this.jogador = 0;       
    }

    //Essa função muda a jogada para o outro jogador
    public void jogada()
    {
        if(this.jogador == 0){
            this.jogador = 6;
        }
        else{
            this.jogador = 0;
        }
    
    }
    
    //Retorna a cor do jogador atual
    public int getCor(){
        return this.jogador;
    }
}
