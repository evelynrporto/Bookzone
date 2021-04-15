/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import javax.swing.JTextField;

/**
 *
 * @author mouriac
 */
public class JNumberField extends JTextField
{

    public JNumberField()
    {
        addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                if (!Character.isDigit(evt.getKeyChar()))
                {
                    evt.consume();
                }
            }
        });
    }
    
    public int getInteger()
    {
        int num = 0;
        if (!this.getText().isEmpty())
        {
            num = Integer.parseInt( this.getText() );
        }
        return num;
    }
    
    public void setInteger(int num)
    {
        this.setText(num+"");
    }

}
