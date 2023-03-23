/*
 * User.java
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package scheduleme;

import java.util.Date;

public class User extends Entity {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String username;
    private String password;
    private Date lastLogin;
    private String resetPasswordCode;
    private Date resetPasswordDeadline;

    public User(String aFirstName, String aLastName, String aEmail, String aPhone, String aUsername, String aPassword) {
        firstName = aFirstName;
        lastName = aLastName;
        email = aEmail;
        phone = aPhone;
        username = aUsername;
        password = aPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String aFirstName) {
        firstName = aFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String aLastName) {
        lastName = aLastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String aEmail) {
        email = aEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String aPhone) {
        phone = aPhone;
    }

    public void sendResetPasswordEmail() {
        // TO DO
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String aUsername) {
        username = aUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String aPassword) {
        password = aPassword;
    }

    public void login() {
        // TO DO
    }

    public void logout() {

    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date aLastLogin) {
        lastLogin = aLastLogin;
    }

    public void generateResetPasswordCode() {
        resetPasswordCode = String.format("%06d", (int)(Math.random()*1000000));
        // TO DO: set reset password deadline
    }

    public String getResetPasswordCode() {
        return resetPasswordCode;
    }

    public Date getResetPasswordDeadline() {
        return resetPasswordDeadline;
    }

    public void setResetPasswordDeadline(Date aResetPasswordDeadline) {
        resetPasswordDeadline = aResetPasswordDeadline;
    }
}