
/**
 * Representa uma Pe�a do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Peca {

    public static final int TORRE = 0;
    public static final int CAVALO = 1;
    public static final int BISPO = 2;
    public static final int RAINHA = 3;
    public static final int REI = 4;
    public static final int PEAO = 5;
    
    //com as cores diferentes ha 12 tipos de pecas, somando o tipo de peca a cor chegamos aos 12 tipos. (Andre)
    
    public static final int PRETO = 6;
    public static final int BRANCO = 0;
    

    private Casa casa;
    private int tipo;
    //decidi colocar a variavel cor, pois acho que sera util quando implementarmos o jogo. (Andre)
    private int cor;
    
    private Rei rei;
    private Rainha rainha;
    private Torre torre;
    private Cavalo cavalo;    
    private Bispo bispo;
    private Peao peao;
    
    

    public Peca(Casa casa, int tipo, int cor) {
        
        this.casa = casa;
        this.tipo = tipo;
        this.cor = cor;
        
        //define o tipo de classe o objeto vai ter. (Andre)
        this.definirPeca(tipo);
        
        casa.colocarPeca(this);
    }
    
    
    /**
     * define o tipo de classe o objeto vai ter
     * dependento do tipo passado por parametro
     */
    
    public void definirPeca(int tipo) {
        
        switch(tipo){
            /*
            *   outro exemplo:
            *   case Peca.Torre:
            *       this.torre = new Torre(this.cor);
            *       break;
            */
       
            case Peca.TORRE:
                this.torre = new Torre(this.cor);
                break;
            case Peca.CAVALO:
                this.cavalo = new Cavalo(this.cor);
                break;
            case Peca.BISPO:
                this.bispo = new Bispo(this.cor);
                break;
            case Peca.RAINHA:
                this.rainha = new Rainha(this.cor);
                break;
            case Peca.REI:
                this.rei = new Rei(this.cor);
                break;
            case Peca.PEAO:
                this.peao = new Peao(this.cor);
        }
        
    }
    
    /**
     * Movimenta a peca para uma nova casa.
     * @param destino nova casa que ira conter esta peca.
     */
    public void mover(Casa destino, Tabuleiro tabuleiro) {
        //O movimento sera feito dependendo do tipo de peca (Andre)  
        
        if(this.verificaDestino(this, destino)){
            switch (this.getTipo()) {
                /*  exemplo
                 *  case Peca.TORRE:
                 *     this.casa = this.torre.mover(this.casa, destino, this);
                 *     break;
                 */
                case Peca.TORRE:
                    this.casa = this.torre.mover(this.casa, destino, this, tabuleiro);
                    break;
                case Peca.CAVALO:
                    this.casa = this.cavalo.mover(this.casa, destino, this);
                    break;
                case Peca.BISPO:
                    this.casa = this.bispo.mover(this.casa, destino, this);
                    break;
                case Peca.RAINHA:
                    this.casa = this.rainha.mover(this.casa, destino, this);
                    break;
                case Peca.REI:
                    this.casa = this.rei.mover(this.casa, destino, this);
                    break;    
                case Peca.PEAO:
                    this.casa = this.peao.mover(this.casa, destino, this);
                    break;
                default:
                    this.casa.removerPeca();
                    destino.colocarPeca(this);
                    this.casa = destino;
                    break;
            }
        }
    }
    
    /**
     * Verifica se a casa de destino não contém uma peça de sua cor.
     * 
     */
    public Boolean verificaDestino(Peca origem, Casa destino ) {

        Peca destinoPeca = destino.getPeca();
        int corOrigem = origem.getCor();

        if(destinoPeca instanceof Peca){
            int corDestino = destinoPeca.getCor();
            if(corOrigem != corDestino){
                return true;
            }
            return false;
        }
         return true;
    }
    
    /**
     * Valor    Tipo
     *   0      Torre
     *   1      Cavalo
     *   2      Bispo
     *   3      Rainha
     *   4      Rei
     *   5      Peao  
     *
     * @return o tipo da peca.
     */
    public int getTipo() {
        return tipo;
    }
    
    
    /**
     * Valor    Cor
     *   6      Preto
     *   0      Branco
          
     * @return o tipo da peca.
     */
    public int getCor() {
        return cor;
    }

    
}
