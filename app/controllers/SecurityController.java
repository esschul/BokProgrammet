package controllers;

import models.*;
import play.Logger;

public class SecurityController extends Secure.Security {
	
	private static Long authorId = null;

    static boolean authenticate(String email, String password) {
		authorId = Author.connect(email, password).id;
		return (authorId != null);
    }

    static void onDisconnected() {
        Application.index();
    }

    static void onAuthenticated() {
        AuthorController.myPage(authorId);
    }

}
