import javax.swing.JOptionPane;

/**
 * Classe Cavalo, Define as regras e movimento para essa peca.
 *
 * @author (Andre Soares)
 * @author Aurenívia Gomes da Costa
 * @version (002 12/09/2020)
 */
public class Rei extends Peca
{
    
    /**
     * Construtor da Classe Rei
     */
    public Rei (Casa casa, CorDaPeca cor)
    {
        super(casa, TipoDaPeca.REI, cor);
        
    }
    
    /**
     * movimenta  a peca para o local de destino caso esteja correto.
     */
    @Override
    public Boolean mover(Casa destino, Tabuleiro tabuleiro) {
        
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
        
           if((x <= casa.x + 1 && x >= casa.x - 1) && (y <= casa.y + 1 && y >= casa.y - 1)){
             
            //Verifica se o destino nao esta no mesmo eixo x e y. (Andre)
            if(casa.x == x || casa.y == y){
                
                //Verifica se o destino nao esta nas diagonais. (Andre)
                for(int i = -2; i <= 2; i++) {                    
                    if( (casa.x + i == x && casa.y + i == y) || (casa.x + i == x && casa.y + (i * -1) == y)){
                        return true;
                    }
                }
                return true;
            }else{
                return true;
            }           
        }else { 
            return false;
        }       
       
    }
}
