package com.example.ecorecicla.modelos;

public class Usuario {

    private String nombre;
    private String correo;
    private String nickname;
    private String pass1;

    public Usuario(String nombre, String correo, String nickname, String pass1){
        this.nombre = nombre;
        this.correo = correo;
        this.nickname = nickname;
        this.pass1 = pass1;
    }

    public Usuario(String correo){
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return pass1;
    }

    public void setPassword(String password) {
        this.pass1 = password;
    }
}
