/**
 * Classe Bispo, Define as regras e movimento para essa peca.
 *
 * @author (Laura Franccine)
 * @version (001 10/11/2020)
 */
public class Bispo extends Peca
{
    /**
     * Constructor for objects of class Cavalo
     */
    public Bispo(Casa casa, CorDaPeca cor)
    {
        //public static final int BISPO = 2;        
        super(casa, TipoDaPeca.BISPO, cor);
        
    }
    
    /**
     * movimenta  a peca para o local de destino caso esteja correto.
     */
    public Boolean mover(Casa destino, Tabuleiro tabuleiro) {
        
        if(this.verificaDestino(this, destino)) {
            
            if(this.podeMover(this.casa, destino, tabuleiro)){
                
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
    private Boolean podeMover(Casa casa, Casa destino, Tabuleiro tabuleiro) {
        
            // variaveis para simplificar o codigo (Laura)
            // tabuleiro.getCasa(casa.x + i, casa.y + i).getPeca() instanceof Peca
            int x = destino.x;
            int y = destino.y; 
             
       
            //Verifica se o destino está nas diagonais (Laura)
            for(int i = -7; i <= 7; i++) {
                if(casa.x + i == x && casa.y + i == y){
                   if(!this.pulouPeca(1, casa, destino, tabuleiro)) { 
                       return true;
                   }
                   return false;
                   
                }
                if(casa.x + i == x && casa.y + (i * -1) == y){
                    if(!this.pulouPeca(2, casa, destino, tabuleiro)) { 
                       return true;
                   }
                   return false;
                    
                }
            }
            
            return false;
          
       
    }
    
    /**
     * Verifica se ha uma outra peca na tragetoria de movimentacao da peca
     */
    private Boolean pulouPeca(int diagonal, Casa casa, Casa destino, Tabuleiro tabuleiro ){
        
        int x = destino.x;
        int y = destino.y;
        
        switch(diagonal){
            case 1:
                if(x > casa.x){
                   //verifica se pulou peca
                   for(int j = 1; j < x - casa.x; j++){
                       if(tabuleiro.getCasa(casa.x + j, casa.y + j).getPeca() instanceof Peca){
                           return true;
                        }
                   }
                }
               if(casa.x > x){
                   //verifica se pulou peca
                  for(int j = 1; j < casa.x - x; j++){
                       if(tabuleiro.getCasa(x + j, y + j).getPeca() instanceof Peca){
                           return true;
                        }
                   } 
               }
               return false; 
            case 2:
                if(y > casa.y){
                   //verifica se pulou peca
                   for(int j = 1; j < y - casa.y; j++){
                       if(tabuleiro.getCasa(casa.x - j, casa.y + j).getPeca() instanceof Peca){
                           return true;
                        }
                   }
               }
               if(casa.y > y){
                   //verifica se pulou peca
                  for(int j = 1; j < casa.y - y; j++){
                       if(tabuleiro.getCasa(casa.x + j, casa.y - j).getPeca() instanceof Peca){
                           return true;
                        }
                   } 
               }
               return false;
        }
        
        return true;
    }
}
