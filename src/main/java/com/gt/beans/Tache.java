package com.gt.beans;

import java.sql.Date;

public class Tache {
	private int id;
	private String nomcomplet;
	private Date datedebut;
	private Date datefin;
	private String tag;
	private String tache;
	public Tache(String nomcomplet, Date datedebut, Date datefin, String tag, String tache) {
		super();
		this.nomcomplet = nomcomplet;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.tag = tag;
		this.tache = tache;
	}
	public Tache(int id, String nomcomplet, Date datedebut, Date datefin, String tag, String tache) {
		super();
		this.id=id;
		this.nomcomplet = nomcomplet;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.tag = tag;
		this.tache = tache;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomcomplet() {
		return nomcomplet;
	}
	public void setNomcomplet(String nomcomplet) {
		this.nomcomplet = nomcomplet;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTache() {
		return tache;
	}
	public void setTache(String tache) {
		this.tache = tache;
	}


	
}
