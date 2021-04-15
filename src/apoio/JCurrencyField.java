/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;

public class JCurrencyField extends JFormattedTextField
{

    public JCurrencyField()
    {
        setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###,###,###.00"))));
        setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        NumberFormatter nf = (NumberFormatter)this.getFormatter();
        nf.setAllowsInvalid(false);
    }
    
    /**
     * Retorna o valor digitado pelo usuário no campo.
     * @return o valor double digitado
     */
    public double getDouble()
    {
        double r = 0;
        if (this.getValue() instanceof Double)
        {
            r = (Double)this.getValue();
        }
        else if (this.getValue() instanceof Long)
        {
            Long aux = (Long)this.getValue();
            r = aux.doubleValue();
        }
        return r;
    }
    
    /**
     * Define um valor inicial para o campo.
     * @param value valor double a ser atribuido ao campo
     */
    public void setDouble( double value )
    {
        this.setValue(value);
    }
    
    
}