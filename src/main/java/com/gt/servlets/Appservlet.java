package com.gt.servlets;

import java.io.IOException;

import java.sql.Date;

import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gt.beans.Tache;
import com.gt.dao.DaoFactory;
import com.gt.dao.TacheDaoImpl;



public class Appservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Appservlet() {
		super();

	}
	public void init() throws ServletException{


	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory daofactory = DaoFactory.getInstance();

		TacheDaoImpl t= new TacheDaoImpl(daofactory);
		String id = request.getParameter("id");
		String opr = request.getParameter("opr");
		
		if(opr !=null) {
			if(opr.equals("supprimer")) {
				System.out.println("from supprimer");
				int i = Integer.parseInt(id);
				t.supprimer(i);

			}
			
			if(opr.equals("chercher") ){
				int i = Integer.parseInt(id);
				
				
				
				request.setAttribute("EditTache", t.chercher(i));
			}
		}
		request.setAttribute("taches", t.lister());
		
		this.getServletContext().getRequestDispatcher("/app.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory daofactory = DaoFactory.getInstance();
		TacheDaoImpl t= new TacheDaoImpl(daofactory);
		
		System.out.println("from post");
		System.out.println(request.getParameter("form"));
		
		System.out.println(request.getParameter("id"));
		
		
		
		if(request.getParameter("form").equals("Addform")) {
			//Add 
			
			String nom = request.getParameter("nom");
			Date datedebut =null ;
			Date datefin =null ;
	
			datefin =Date.valueOf(request.getParameter("datedebut"));
			datedebut = Date.valueOf(request.getParameter("datefin"));
			String tag = request.getParameter("tag");
			String tache = request.getParameter("tache");
			Tache tacheInfo = new Tache(nom,datedebut,datefin,tag,tache);
			t.ajouter(tacheInfo);
		}
		if(request.getParameter("form").equals("Editform")) {
			//Edit
			String id = request.getParameter("id");
			int i = Integer.parseInt(id);
			String nom = request.getParameter("Enom");
			Date datedebut =null ;
			Date datefin =null ;
			datefin =Date.valueOf(request.getParameter("Edatedebut"));
			datedebut = Date.valueOf(request.getParameter("Edatefin"));
			String tag = request.getParameter("Etag");
			String tache = request.getParameter("Etache");
			Tache tacheInfo = new Tache(i,nom,datedebut,datefin,tag,tache);
			
			t.modifier(tacheInfo);
		}
		

		request.setAttribute("taches", t.lister());
		this.getServletContext().getRequestDispatcher("/app.jsp").forward(request, response);


	}

}
