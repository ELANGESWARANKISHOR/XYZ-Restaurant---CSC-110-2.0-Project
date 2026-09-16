/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XYZClasses;

/**
 *
 * @author us
 */
public class Admin {
    
    private static Admin admin = null;
    
    private String username = "admin";
    private String password = "xyz1234";
    
    public boolean adminLogin(String Username, String Password){
        
        if(username.equals(Username) && password.equals(Password)){
            return true;
        }else{
            return false;
        }
    }
    
    public static Admin getAdmin(){
        
        if(admin == null){
            admin = new Admin();
        }
        
        return admin;
    }
}
