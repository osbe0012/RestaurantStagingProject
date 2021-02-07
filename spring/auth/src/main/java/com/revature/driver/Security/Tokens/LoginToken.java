package com.revature.driver.Security.Tokens;

public class LoginToken {
    public String username;
    public String password;

    /**This method allows consumers of the login token to quickly identify whether the token is valid. 
     * An invalid token is one whose username or password fields are empty or null.
     * @returns boolean indicating whether or not the LoginToken is valid.
     */
    public boolean validateSelf() {
        boolean hasNonNullFields = username != null && password != null;
        boolean hasNonEmptyFields = false;

        if(hasNonEmptyFields)
            hasNonEmptyFields = !this.username.equals("") && !this.password.equals("");

        return hasNonNullFields && hasNonEmptyFields;
    }
}
