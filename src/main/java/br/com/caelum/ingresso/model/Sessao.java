package br.com.caelum.ingresso.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sessao {
	@Id
	@GeneratedValue
	private Integer id;
	private LocalTime horario;
	
	@ManyToOne
	private Sala sala;
	
	@ManyToOne
	private Filme filme;

//Construtor Default para iniciar Hibernate
public Sessao(){}
	
public Sessao(LocalTime horario, Filme filme, Sala sala){
	this.horario = horario;
	this.filme = filme;
	this.sala = sala;
}

public LocalTime getHorarioTermino(){
	return this.horario.plusMinutes(filme.getDuracao().toMinutes());
}
}
