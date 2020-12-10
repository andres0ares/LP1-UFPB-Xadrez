import javax.swing.JOptionPane;

/**
 * Classe Torre, Define as regras e movimento para essa peca.
 *
 * @author (Andre Soares)
 * @author (Laura Franccine)
 * @version (001 08/11/2020)
 */
public class Torre extends Peca
{
    
    /**
     * Constructor for objects of class Torre
     */
    public Torre(Casa casa, CorDaPeca cor)
    {
        // public static final int TORRE = 0;
        super(casa, TipoDaPeca.TORRE, cor);
        
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
        
            // variaveis para simplificar o codigo (Andre)
            
            int x = destino.x;
            int y = destino.y;
            
           //Verifica se o movimento foi no eixo y. (Andre)
            
           if(casa.x == x){
               //Verifica se o movimento no eixo y foi para cima, ou seja y maior que casa.y . (Andre)
               if(y > casa.y){               

                   //percorre casa por casa verificando se ha uma peca 
                   for(int i = casa.y + 1; i < y; i++){
                       //verifica se a casa possui uma peca 
                       //tabuleiro é um objeto da classe Tabuleiro criado na classe jogo, passado como parametro no metodo
                       //Peca.mover() que por sua vez passa como parametro para torre.mover() 
                       if (tabuleiro.getCasa(casa.x, i).getPeca() instanceof Peca ) { 
                           // tabuleiro.getCasa() -> retorna um objeto do tipo Casa
                           // .getPeca() -> retorna a peca caso haja nessa casa
                           // instanceof Peca -> verifica se de fato ha um objeto do tipo peca ou nao
                           return false; }
                   }
                   return true;
               }
               // outro meio de escrever -> if (tabuleiro.getCasa(casa.x, i).getPeca() instanceof Peca )<-
               // Casa casa = tabuleiro.getCasa(casa.x, i);
               // Peca peca = casa.getPeca();
               // if (peca instanceof Peca)
               
               //Verifica se o movimento no eixo y foi para baixo, ou seja y menor que casa.y . (Andre)
               if(y < casa.y){
                   //percorre casa por casa verificando se ha uma peca (Andre)
                   for(int i = casa.y - 1; i > y; i--){
                       
                       if (tabuleiro.getCasa(casa.x, i).getPeca() instanceof Peca ) {
                           return false; }
                   }
                   return true;
               }
            }
            
           //Verifica se o movimento foi no eixo x. (Andre)
           if(casa.y == y){
                if(x > casa.x){
                   for(int i = casa.x + 1; i < x; i++){
                       if (tabuleiro.getCasa(i, casa.y).getPeca() instanceof Peca ) {
                           return false; }
                   }
                   return true;
               }
               if(x < casa.x){
                   for(int i = casa.x - 1; i > x; i--){
                       
                       if (tabuleiro.getCasa(i, casa.y).getPeca() instanceof Peca ) {
                           return false; }
                   }
                   return true;
               }
           }       
           
           return false;
    } 
        
}
