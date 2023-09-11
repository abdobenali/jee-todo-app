package com.gt.dao;

import java.util.List;

import com.gt.beans.Tache;

public interface TacheDao {
	 void ajouter( Tache tache );
	 void supprimer(int id);
	 Tache chercher(int id);
	 void modifier(Tache tache);
	 List<Tache> lister();
}

