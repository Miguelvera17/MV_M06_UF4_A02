package com.iticbcn.mywebapp.llibresapp.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuaris")
public class Usuaris {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuari;

    @Column(nullable = false, unique = true)
    private String usuari;

    @Column(nullable = false)
    private String password;

    public Usuaris() {}

    public Usuaris(String usuari, String password) {
        this.usuari = usuari;
        this.password = password;
    }

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
