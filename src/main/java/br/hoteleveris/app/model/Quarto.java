package br.hoteleveris.app.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Quarto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int noQuarto;
	private int andar;
	private String situacao;
	
	
	@ManyToOne
    @JoinColumn(name = "tipoQuartoId")
    private TipoQuarto tipoQuartoId;
    
    @ManyToOne
    @JoinColumn(name = "ocupacaoId")
    private Ocupacao ocupacaoId;
	
	@ManyToMany(mappedBy = "quarto")
    Set<Comodidade> comododidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNoQuarto() {
		return noQuarto;
	}

	public void setNoQuarto(int noQuarto) {
		this.noQuarto = noQuarto;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public TipoQuarto getTipoQuartoId() {
		return tipoQuartoId;
	}

	public void setTipoQuartoId(TipoQuarto tipoQuartoId) {
		this.tipoQuartoId = tipoQuartoId;
	}

	public Ocupacao getOcupacaoId() {
		return ocupacaoId;
	}

	public void setOcupacaoId(Ocupacao ocupacaoId) {
		this.ocupacaoId = ocupacaoId;
	}

	public Set<Comodidade> getComododidade() {
		return comododidade;
	}

	public void setComododidade(Set<Comodidade> comododidade) {
		this.comododidade = comododidade;
	}
	
	
	
	
}
