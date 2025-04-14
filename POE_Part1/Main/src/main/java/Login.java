/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public class Login {
    //Attributes
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellphoneNumber;
   

    
    //Constructor
    public Login(String firstName, String lastName, String Username, String Password, String cellphoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = Username;
        this.password = Password;
        this.cellphoneNumber = cellphoneNumber;
      
    }
    //Getters
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
     public String getUsername(){
        return username;
    }  
     public String getCellphoneNumber(){
         return cellphoneNumber;
     }
       public boolean checkUsername(String Username){
        return Username.contains("_")&& Username.length()<=5;
    }
     public String getPassword(){
        return password;
    }
   //Setters
     
      public void setUsername(String Username){
        this.username = Username;
    }
     public void setPassword(String Password){
        this.password = Password;
    }
    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }
    public static boolean checkCellphoneNumber(String cellphoneNumber) {
        return cellphoneNumber .contains("+27") && cellphoneNumber.length()==12;
            
    }
 
    //checks if passwords matches
    public boolean checkPasswordComplexity(String Password){
       return Password.length() >= 8 &&
              Password.matches(". *[A-Z].*") &&
              Password.matches(".*[a-z].*") &&
              Password.matches(".*[0-8].*") &&
              Password.matches(".*[!@#$%^&*()].*");
    }
    
        
    public String registerUser(String checkUsername, String Password, String cellphoneNumber) {
        if(checkUsername(username)){
            System.out.print("“Welcome <user first name> ,<user last name>it is great to see you.”");
    }else {
            System.out.print("“Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length");
} 
        if(checkPasswordComplexity(password)) {
            System.out.print("Password successfully captured.");
        }else {
            System.out.print("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character."
);
        }
        
        return "User registered successfully!";
    }
        
    public boolean loginUser(String Username, String Password){
        return this.username.equals(Username) && this.password.equals(Password);
    } 
   
   public String returnLoginStatus(boolean checkUsername, String Password){
     if (checkUsername(username)){
           return "A successful login";
      }else{ 
           return "A failed login";
       }
  
       
     }            
        
       
      
        
    } 

