package com.controller;

public class Admin {
    private final String adminName = "admin";
    private final String adminPassword = "admin";

    public boolean loginInfoRight(String name, String adminPassword){
        return  (name.equals(this.adminName) && adminPassword.equals(this.adminPassword));
    }
    public String getAdminName() {
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
}
