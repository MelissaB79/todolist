package controllers;

import models.Tache;
import play.mvc.*;
import java.util.*;
import play.db.jpa.JPA;
import javax.persistence.Query;
import play.data.validation.*;

public class Application extends Controller {

    // Affiche toutes les tâches (voir variable taches) dans le template views/listTache.html
    public static void listTache() {
        //List<Tache> taches = null;
        //try {
        //    Query query = JPA.em().createQuery("select from Tache");
        //    taches = query.getResultList();
        //} catch (Exception e) {
        //    System.err.println(e);
        //}
        //EntityManager em =  play.db.jpa.JPA.em();
        List<Tache> taches = Tache.findAll();
        render(taches);
    }

    // Affiche le template views/ajouterTacheForm.html (formulaire d'ajout d'une tâche)
    public static void ajouterTacheForm() {
        render();
    }

    // Ajoute une nouvelle tâche en base de données et affiche le template views/ajouterTache.html
    public static void ajouterTache(Tache tache) {
        validation.required(tache.title);
        if(validation.hasErrors()) {
            params.flash(); // add http parameters to the flash scope
            validation.keep(); // keep the errors for the next request
            render();
        }
        tache.save();
        render();
    }

    // Change le statut d'une tâche en base de données
    public static void validerTache(Long id) {
    	// A COMPLETER
        // ...
    }

    // Supprime une tâche en base de données
    public static void supprimerTache(Long id) {
        Tache tache = Tache.findById(id);
        tache.delete();
        listTache();
    }

    // Modifie une tâche en base de données
    public static void editTache(Long id, String title) {
        System.out.println(title);
    }

}