/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author evely
 */
public class Venda {
    private int id;
    private Date data_venda;
    private double valor_pagamento;
    private String forma_pagamento;
    private int cliente_id;
    private int funcionario_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_venda() {
        return data_venda;
    }
    
    public String getDataString(){
         SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
        return fd.format(data_venda);
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public double getValor_pagamento() {
        return valor_pagamento;
    }

    public void setValor_pagamento(double valor_pagamento) {
        this.valor_pagamento = valor_pagamento;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(int funcionario_id) {
        this.funcionario_id = funcionario_id;
    }
    
}
