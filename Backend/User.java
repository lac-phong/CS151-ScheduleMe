/*
 * User.java
 * 
 * Represents a user of the system.
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package Backend;

import java.util.Date;

public class User extends Entity {
    private String firstName;   // first name
    private String lastName;    // last name
    private String email;       // email address
    private String phone;       // phone number
    private String username;    // username
    private String password;    // password
    private Date lastLogin;     // last login date
    private String resetPasswordCode; // reset password code
    private Date resetPasswordDeadline; // reset password deadline/expiration

    /**
     * constructor
     * 
     * @param aFirstName - first name
     * @param aLastName - last name
     * @param aEmail - email address
     * @param aPhone - phone number
     * @param aUsername - username
     * @param aPassword - password
     * @param aRole - role
     * @param aIsDisabled - whether the user is disabled
     */
    public User(String aFirstName, String aLastName, String aEmail, String aPhone, String aUsername, String aPassword, Role aRole, Boolean aIsDisabled) {
        super(aUsername, aRole, aIsDisabled);
        firstName = aFirstName;
        lastName = aLastName;
        email = aEmail;
        phone = aPhone;
        username = aUsername;
        password = aPassword;
    }

    /**
     * getFirstName
     * 
     * @return String - first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setFirstName
     * 
     * @param aFirstName - first name
     */
    
    public void setFirstName(String aFirstName) {
        firstName = aFirstName;
    }

    /**
     * getLastName
     * 
     * @return String - last name
     */
    
    public String getLastName() {
        return lastName;
    }

    /**
     * setLastName
     * 
     * @param aLastName - last name
     */
    public void setLastName(String aLastName) {
        lastName = aLastName;
    }

    /**
     * getFullName
     * 
     * @return String - full name
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * getEmail
     * 
     * @return String - email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * setEmail
     * 
     * @param aEmail - email address
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * getPhone
     * 
     * @return String - phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * setPhone
     * 
     * @param aPhone - phone number
     */
    public void setPhone(String aPhone) {
        phone = aPhone;
    }

    /**
     * sendResetPasswordEmail - Sends an email to the user with a reset password code.
     */
    public void sendResetPasswordEmail() {
        // TO DO
    }

    /**
     * getUsername
     * 
     * @return String - username
     */
    public String getUsername() {
        return username;
    }

    /**
     * setUsername
     * 
     * @param aUsername - username
     */
    public void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * getPassword
     * 
     * @return String - password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword
     * 
     * @param aPassword - password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * login - Logs the user in.
     */
    public void login() {
        // TO DO
    }

    /**
     * logout - Logs the user out.
     */
    public void logout() {
        // TO DO
    }

    /**
     * getLastLogin
     * 
     * @return Date - last login date
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * setLastLogin
     * 
     * @param aLastLogin - last login date
     */
    public void setLastLogin(Date aLastLogin) {
        lastLogin = aLastLogin;
    }

    /**
     * generateResetPasswordCode - Generates a reset password code.
     */
    public void generateResetPasswordCode() {
        resetPasswordCode = String.format("%06d", (int)(Math.random()*1000000));
        // TO DO: set reset password deadline
    }

    /**
     * getResetPasswordCode
     * 
     * @return String - reset password code
     */
    public String getResetPasswordCode() {
        return resetPasswordCode;
    }

    /**
     * setResetPasswordCode
     * 
     * @param aResetPasswordCode - reset password code
     */
    public Date getResetPasswordDeadline() {
        return resetPasswordDeadline;
    }

    /**
     * setResetPasswordDeadline
     * 
     * @param aResetPasswordDeadline - reset password deadline/expiration
     */
    public void setResetPasswordDeadline(Date aResetPasswordDeadline) {
        resetPasswordDeadline = aResetPasswordDeadline;
    }

    /**
     * resetPassword - Resets the user's password.
     * 
     * @param aNewPassword - new password
     */
    public void resetPassword(String aNewPassword) {
        // TO DO
    }
}