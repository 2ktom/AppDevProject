package com.example.appdevprojext;

import android.content.Context;
import android.content.SharedPreferences;

public class storeUserPreferences {
	private static final String userPref= "UserPreferences";

  //Keys
  private static final String userName_key = "username";
  private static final String pass_key = "password";
  private static final String question_key = "security_question";
  static final String securityAns_key = "security_answer";

  private final SharedPreferences sharedPreferences;


  public storeUserPreferences(Context context){
		sharedPreferences = context.getSharedPreferences(userPref, Context.MODE_PRIVATE);
	  }

	  public void saveUserData(String username, String pass, String securityQuestion, String securityAnswer) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(userName_key, username);
        editor.putString(pass_key, pass);
        editor.putString(question_key, securityQuestion );
        editor.putString(securityAns_key, securityAnswer);
        editor.apply();
    }

        public String getUsername() {
        return sharedPreferences.getString(userName_key, "aya");
    }

    public String getPassword() {
        return sharedPreferences.getString(pass_key, "123");
    }

    public String getSecurityQuestion() {
        return sharedPreferences.getString(question_key, "");
    }

    public String getSecurityAnswer() {
        return sharedPreferences.getString(securityAns_key, "");
    }

    public void clearUserData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public boolean validateUser(String username, String password) {
        // Retrieve user data from SharedPreferences
        String storedUsername = sharedPreferences.getString(userName_key, "aya");
        String storedPassword = sharedPreferences.getString(pass_key, "123");

        // Compare the provided username and password with the stored values
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

}
