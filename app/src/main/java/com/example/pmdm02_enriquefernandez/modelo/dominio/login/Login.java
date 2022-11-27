package com.example.pmdm02_enriquefernandez.modelo.dominio.login;

//CLASE PARA TRABAJAR LA LOGICA DE LA PANTALLA DE LOGIN
public class Login {
    //VALORES ACEPTADOS POR DEFECTO
    private static final String user = "pirate@studio.com";
    private static final String pass = "1234";
    //METODO PARA COMPROBAR EL LOGIN, SIRVE EN ESTE CASO. PARA UNA SITUACION REAL
    //SERÍA DIFERENTE
    public static LoginStatus comprobarLogin(String tryUser, String tryPass){
        if (!tryUser.equals(user)){
            return LoginStatus.USER_FAIL;
        }
        if (!tryPass.equals(pass)) {
            return LoginStatus.PASS_FAIL;
        }
        return LoginStatus.OK;
    }

    public static boolean usuarioExistente(String correo) {
        /*AQUI IMPLEMENTARIAMOS EL CODIGO PARA COMPROBAR SI EL USUARIO YA ESTA REGISTRADO*/
        return  correo.equals(user);
    }
}
