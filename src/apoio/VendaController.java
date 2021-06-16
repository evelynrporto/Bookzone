/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import dao.VendaDAO;
import entidade.Venda;

/**
 *
 * @author evely
 */
public class VendaController {
    
    public int obterUltima() {
        
        //Instancia venda para retornar no fim da funcao
        int idvenda = 0;
        
        try 
        {
            //tenta obter o venda procurado
            //venda = VendaMock.obterUltima();
            
        } 
        catch (Exception e) 
        {
            //em caso de erro imprime erro 
            //e.printStackTrace();
        }

        return idvenda;
        
    }
}
