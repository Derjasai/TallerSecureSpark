package edu.eci.arep.app;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        port(getPort());
        secure(getKeStore(), getPasswordKeyStore(), null,null);
        get("/hello", (req, res) -> "Hello Heroku");
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    static String getKeStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "certificados/ecikeystore.p12"; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    static String getPasswordKeyStore() {
        if (System.getenv("PASSWORDKEYSTORE") != null) {
            return System.getenv("PASSWORDKEYSTORE");
        }
        return "password1234"; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}