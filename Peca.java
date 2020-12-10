
/**
 * Representa uma Pe�a do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 * @author Aurenívia Gomes da Costa
 */
abstract class Peca {

    protected Casa casa;
    protected TipoDaPeca tipo;   
    protected CorDaPeca cor;         
    
    public Peca(Casa casa, TipoDaPeca tipo, CorDaPeca cor) {
        
        this.casa = casa;
        this.tipo = tipo;
        this.cor = cor;
        
        casa.colocarPeca(this);
    }
    
    
    /**
     * Movimenta a peca para uma nova casa.
     * @param destino nova casa que ira conter esta peca.
     */
    public Boolean mover(Casa destino, Tabuleiro tabuleiro) {
        
        //Default
        
        Casa novaCasa;
        
        novaCasa = this.casa;
        this.casa.removerPeca();
        destino.colocarPeca(this);
        this.casa = destino;
             
        if(this.casa != novaCasa) {
            this.casa = novaCasa;
            return true;
        }
        
        return false;
                
    }
    
    /**
     * Verifica se a casa de destino não contém uma peça de sua cor.
     * 
     */
    public Boolean verificaDestino(Peca origem, Casa destino ) {

        Peca destinoPeca = destino.getPeca();
        CorDaPeca corOrigem = origem.getCor();

        if(destinoPeca instanceof Peca){
            CorDaPeca corDestino = destinoPeca.getCor();
            if(corOrigem != corDestino){
                return true;
            }
            return false;
        }
         return true;
    }
    
    /**
     * @return o tipo da peca.
     */
    public TipoDaPeca getTipo() {
        return tipo;
    }    
    
    
    /**
     * @return a cor da peca.
     */
    public CorDaPeca getCor() {
        return cor;
    }

    
}
