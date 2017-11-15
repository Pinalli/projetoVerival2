package br.ages.crud.model;

import java.util.ArrayList;
import java.util.List;

public class DadosRotulo {

	private double qntMedida;
	private double qntMedidaCaseira;
    private UnidadeMedida unidadeMedida;
    private UnidadeMedidaCaseira unidadeMedidaCaseira;
    private List<FichaIngrediente> fichaIngredientes;

    public DadosRotulo(){
        super();
    }

    public double getQntMedida() {
		return qntMedida;
	}

	public void setQntMedida(double qntMedida) {
		this.qntMedida = qntMedida;
	}

	public double getQntMedidaCaseira() {
		return qntMedidaCaseira;
	}

	public void setQntMedidaCaseira(double qntMedidaCaseira) {
		this.qntMedidaCaseira = qntMedidaCaseira;
	}

	public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida){
        this.unidadeMedida = unidadeMedida;
    }

	public UnidadeMedidaCaseira getUnidadeMedidaCaseira() {
		return unidadeMedidaCaseira;
	}

	public void setUnidadeMedidaCaseira(UnidadeMedidaCaseira unidadeMedidaCaseira) {
		this.unidadeMedidaCaseira = unidadeMedidaCaseira;
	}

	public List<FichaIngrediente> getFichaIngredientes() {
		return fichaIngredientes;
	}

	public void setFichaIngredientes(List<FichaIngrediente> fichaIngredientes) {
		this.fichaIngredientes = fichaIngredientes;
	}
    
	public void addFichaIngredientes(FichaIngrediente fichaIngrediente) {
		if(this.fichaIngredientes == null) {
			this.fichaIngredientes = new ArrayList<>();
		}
		this.fichaIngredientes.add(fichaIngrediente);
	}
}
