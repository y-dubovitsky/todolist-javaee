package todolist.model.impl;

import todolist.model.SocialAccount;

public class VkAccount implements SocialAccount {

    private String name;
    private String email;

    public VkAccount() {
    }

    public VkAccount(String name, String email) {
        this.name = name;
        this.email = email;
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
}
