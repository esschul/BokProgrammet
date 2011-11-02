package controllers;

import models.*;
import play.Logger;

public class Security extends Secure.Security {
	
	private static Long authorId = null;

    static boolean authenticate(String email, String password) {
		authorId = Author.connect(email, password).id;
		return (authorId != null);
    }

    static void onDisconnected() {
        Unauthorized.index();
    }

    static void onAuthenticated() {
        Authorized.myPage();
    }

}
