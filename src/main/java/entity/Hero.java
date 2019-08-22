package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hero {
    @Id
    private String name;
    private String description;
    private String image;

    public Hero() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
