/**
 * Classe Rainha, Define as regras e movimento para essa peca.
 *
 * @author (Matheus Franccine)
 * @version (001 10/11/2020)
 */
public class Rainha extends Peca
{
    
    /**
     * Constructor for objects of class Rainha
     */
    public Rainha(Casa casa, CorDaPeca cor)
    {
        // public static final int RAINHA = 3;
        super(casa, TipoDaPeca.RAINHA, cor);
        
    }
    
    /**
     * movimenta  a peca para o local de destino caso esteja correto.
     */
    @Override
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
        
            // variaveis para simplificar o codigo (Matheus)
            
            int x = destino.x;
            int y = destino.y;        
  
       
            //Verifica se o destino está nas diagonais e horizontal e vertical (Matheus)
            //combinação dos movimetos do Bispo e da Torre
            
            if(casa.x == x && !this.pulouPeca("reta",1, casa, destino, tabuleiro) ) {
                return true;
            }
            if(casa.y == y && !this.pulouPeca("reta",2, casa, destino, tabuleiro)) {
                return true;
            }
            
            for(int i = -7; i <= 7; i++) {                    
                if( (casa.x + i == x && casa.y + i == y) && !this.pulouPeca("diagonal",1, casa, destino, tabuleiro)){
                    return true;
                }
                if( (casa.x + i == x && casa.y + (i * -1) == y) && !this.pulouPeca("diagonal",2, casa, destino, tabuleiro)){
                    return true;
                }
            }
            return false;
          
       
    }
    
    /**
     * Verifica se a rainha pulou outra peca e retorna o true caso seja verdadeiro (andre)
     */
    private Boolean pulouPeca(String posicao, int eixo, Casa casa, Casa destino, Tabuleiro tabuleiro) {
         
            int x = destino.x;
            int y = destino.y;
            
            if(posicao == "reta") {
                switch(eixo) {
                    case 1:
                       if(y > casa.y){               
                           for(int i = casa.y + 1; i < y; i++){                       
                               if (tabuleiro.getCasa(casa.x, i).getPeca() instanceof Peca ) {                           
                                   return true; }
                           }                           
                       }               
                       if(y < casa.y){                   
                           for(int i = casa.y - 1; i > y; i--){                               
                               if (tabuleiro.getCasa(casa.x, i).getPeca() instanceof Peca ) {
                                   return true; }
                           }
                       }
                       return false;
                    case 2:
                        if(x > casa.x){
                           for(int i = casa.x + 1; i < x; i++){
                               if (tabuleiro.getCasa(i, casa.y).getPeca() instanceof Peca ) {
                                   return true; }
                           }                           
                       }
                       if(x < casa.x){
                           for(int i = casa.x - 1; i > x; i--){
                               
                               if (tabuleiro.getCasa(i, casa.y).getPeca() instanceof Peca ) {
                                   return true; }
                           }                          
                       }
                       return false;
                }               
                
            }
            
            if(posicao == "diagonal") {
                
                switch(eixo) {
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
            }
            
            return false;
    }
}
