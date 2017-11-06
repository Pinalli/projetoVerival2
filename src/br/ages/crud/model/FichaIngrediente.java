package br.ages.crud.model;

/**
 * Created by thialves
 * On 29/09/17
 * For fichatecnicapreparo
 **/
public class FichaIngrediente {

    private Ingrediente ingrediente;
    private UnidadeMedida unidadeMedida;
    private UnidadeMedidaCaseira unidadeMedidaCaseira;

    private Double quantidadeMedida, quantidadeMedidaCaseira;
    private Double gorduraTrans;


//    private FichaItem fichaItem;

    public FichaIngrediente(){
        super();
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente){
        this.ingrediente = ingrediente;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida){
        this.unidadeMedida = unidadeMedida;
    }

    public UnidadeMedidaCaseira getUnidadeMedidaCaseira(){
        return unidadeMedidaCaseira;
    }

    public void setUnidadeMedidaCaseira(UnidadeMedidaCaseira unidadeMedidaCaseira){
        this.unidadeMedidaCaseira = unidadeMedidaCaseira;
    }

    public Double getQuantidadeMedida(){
        return quantidadeMedida;
    }

    public void setQuantidadeMedida(Double quantidadeMedida){
        this.quantidadeMedida = quantidadeMedida;
    }

    public Double getQuantidadeMedidaCaseira() {
        return quantidadeMedidaCaseira;
    }

    public void setQuantidadeMedidaCaseira(Double quantidadeMedidaCaseira){
        this.quantidadeMedidaCaseira = quantidadeMedidaCaseira;
    }

	public Double getGorduraTrans() {
		return gorduraTrans;
	}

	public void setGorduraTrans(Double gorduraTrans) {
		this.gorduraTrans = gorduraTrans;
	}

    //    public FichaItem getFichaItem(){
//        return fichaItem;
//    }
//
//    public void setFichaItem(FichaItem fichaItem){
//        this.fichaItem = fichaItem;
//    }
}
