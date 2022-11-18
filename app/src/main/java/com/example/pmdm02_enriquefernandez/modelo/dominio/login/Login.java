package com.example.pmdm02_enriquefernandez.modelo.dominio.login;

public class Login {

    private static final String user = "pirate@studio.com";
    private static final String pass = "1234";

    public static LoginStatus comprobarLogin(String tryUser, String tryPass){
        if (!tryUser.equals(user)){
            return LoginStatus.USER_FAIL;
        }
        if (!tryPass.equals(pass)) {
            return LoginStatus.PASS_FAIL;
        }
        return LoginStatus.OK;
    }

    public static boolean comprobarUsuario(String tryUser) {
        return tryUser.equals(user);
    }
}
