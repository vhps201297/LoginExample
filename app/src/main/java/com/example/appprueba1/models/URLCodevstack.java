package com.example.appprueba1.models;

/**
 * Clase que se encarga exclusivamente del url de la aplicación, para tener en privado el host y el puerto
 */
public class URLCodevstack {

    private static String HOST = "http://167.99.151.252";
    private static String PORT = "4000";

    public static String REGISTRO = HOST + ":" + PORT + "/createUser";
    public static String LOGIN = HOST + ":" + PORT + "/login";
    public static String INFO_USER = HOST + ":" + PORT + "/getUser/";

    public static String infoUser(String idUser){
        return INFO_USER + idUser;
    }
}
