package todolist.entity.impl;

import todolist.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Task extends AbstractEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Timestamp creationTime;
    private String description;
    private int id_importance;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_importance() {
        return id_importance;
    }

    public void setId_importance(int id_importance) {
        this.id_importance = id_importance;
    }
}
