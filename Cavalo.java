import javax.swing.JOptionPane;

/**
 * Classe Cavalo, Define as regras e movimento para essa peca.
 *
 * @author (Andre Soares)
 * @author Aurenivia Gomes da Costa
 * @version (001 08/11/2020)
 */
public class Cavalo extends Peca
{
    
    /** 
     * Constructor for objects of class Cavalo
     */
    public Cavalo(Casa casa, CorDaPeca cor)
    {
        //public static final int CAVALO = 1;
        super(casa, TipoDaPeca.CAVALO, cor);
        
    }
    
    /**
     * movimenta  a peca para o local de destino caso esteja correto.
     */
    @Override
    public Boolean mover(Casa destino, Tabuleiro tabuleiro) {        
         
        // verifica pelo metodo podeMover(), se o destino esta na posicao permitida para o tipo de peca. (Andre)
        if(this.verificaDestino(this, destino)) {
            
            if(this.podeMover(this.casa, destino)){
                
                this.casa.removerPeca();
                destino.colocarPeca(this);
                this.casa = destino;
                
                return true;
                
            }
            return false;
        }
        
            
        return false;
    }
    
    
    /**
    * Verifica se o movimento e valido, retorna um boolean. 
    */
    private Boolean podeMover(Casa casa, Casa destino) {
        
        // variaveis para simplificar o codigo (Andre)
        
        int x = destino.x;
        int y = destino.y;
        
        // verifica se o destino esta em um quadrado de area 10 da origem. (Andre)
        if((x <= casa.x + 2 && x >= casa.x - 2) && (y <= casa.y + 2 && y >= casa.y - 2)){
             
            //Verifica se o destino nao esta no mesmo eixo x e y. (Andre)
            if(casa.x != x && casa.y != y){
                
                //Verifica se o destino nao esta nas diagonais. (Andre)
                for(int i = -2; i <= 2; i++) {                    
                    if( (casa.x + i == x && casa.y + i == y) || (casa.x + i == x && casa.y + (i * -1) == y)){
                        return false;
                    }
                }
                return true;
            }else{
                return false;
            }           
        }else { 
            return false;
        }       
       
    }
}
