package auth;

import at.favre.lib.crypto.bcrypt.BCrypt;

public record Account (String name, String password) {
    public String getHashedPassword () {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }
    //to zahashowane haslo bedziemy przekazywac do bazy danych
    // przy weryfikacji uztownkia musimy uzyc metody BCrypt co porownoje dwa hash

    public boolean authenticate(String password) {
        return BCrypt.verifyer().verify(password.toCharArray(), getHashedPassword()).verified;
    }
    //second way to do it

}
