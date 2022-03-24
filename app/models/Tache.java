package models;

import play.db.jpa.*;
import javax.persistence.*;

@Entity
public class Tache extends Model {
    @Id
    @GeneratedValue
    public transient long id;
    public String title;
    public boolean isValidate;

    public Tache(String title){
        this.title = title;
        this.isValidate = false;
    }

    public String toString(){
        return this.id + " : " + this.title;
    }
	
}
