package todolist.entity.impl;

import todolist.entity.AbstractEntity;
import todolist.model.SocialAccount;

import java.util.List;

public class Account extends AbstractEntity<Integer> implements SocialAccount {

    private String name;
    private String email;
    private List<Task> tasks;

    public Account(Integer id, String name, String email, List<Task> tasks) {
        this.name = name;
        this.email = email;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
