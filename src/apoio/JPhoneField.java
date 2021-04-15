/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import javax.swing.JFormattedTextField;

/**
 *
 * @author evely
 */
public class JPhoneField extends JFormattedTextField
{

    public JPhoneField()
    {
        try
        {
            setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }
    }
      
} 
    

