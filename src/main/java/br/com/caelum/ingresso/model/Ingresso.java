package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.caelum.ingresso.model.descontos.Desconto;

@Entity
public class Ingresso {
	@ManyToOne
	private Sessao sessao;
	@Id
	@GeneratedValue
	private Integer id;
	private BigDecimal preco;
	@Enumerated(EnumType.STRING)
	private TipoDeIngresso tipoDeIngresso;
	@ManyToOne
	private Lugar lugar;
	
public Ingresso(){}





public Ingresso(Sessao sessao, TipoDeIngresso tipoDeIngresso, Lugar lugar){
	this.sessao = sessao;
	this.tipoDeIngresso = tipoDeIngresso;
	this.preco = this.tipoDeIngresso.aplicaDesconto(sessao.getPreco());
	this.setLugar(lugar);
}

public BigDecimal getPreco(){
	return preco.setScale(2, RoundingMode.HALF_UP);
}

public void setPreco(BigDecimal preco){
	this.preco = preco;
}

public Lugar getLugar() {
	return lugar;
}

public void setLugar(Lugar lugar) {
	this.lugar = lugar;
}

}
