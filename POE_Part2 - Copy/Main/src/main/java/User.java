/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public class User {
    private String username;
    private String password;
    private String cellNumber;
    private String firstName;
    private String lastName;
    
   public User (String username, String password, String cellNumber, String firstName, String lastName){
    this.username = username;
    this.password = password;
    this.cellNumber = cellNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    
}
    //Getters
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getCellNumber(){
        return cellNumber;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
}
