/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class LoginTest {
    
   private static Login util;

    
    @BeforeAll
    public static void setUp(){
       util = new Login("", "", "ky_1", "Ch&&sec@ke99!", "+27838968976");
      
    }
    
   

    @Test
    public void testGetUsername() {
         assertEquals("kyl_1",util.getUsername());
      
        util.setUsername("kyl_1");
               
    }

 
    @Test
    public void testGetPassword() {
        assertEquals("Ch&&sec@ke99!",util.getPassword());
        
        util.setPassword("Ch&&sec@ke99!");
        
    }
    
    

    @Test
    public void testGetCellphoneNumber() {
       util.setCellphoneNumber("+27838968976");
        assertEquals("+27838968976",util.getCellphoneNumber());

    }
    
    @Test
    public void testRegisterUser() {
        util.setUsername("kyl_1");
        assertEquals("kyl_1",util.getUsername());
        util.setPassword("Ch&&sec@ke99!");
        assertEquals("Ch&&sec@ke99!",util.getPassword());
    }
      
    @Test
    public void testloginUser(){
    assertTrue(util.checkUsername("kyl_1")); 
    assertFalse(util.checkPasswordComplexity("Ch&&sec@ke99!"));
    }    
    
   
}

    
   
    

