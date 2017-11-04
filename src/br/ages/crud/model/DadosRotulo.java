package br.ages.crud.model;

import java.util.ArrayList;
import java.util.List;

public class DadosRotulo {

	private double qntMedida;
    private UnidadeMedida unidadeMedida;
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

	public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida){
        this.unidadeMedida = unidadeMedida;
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
