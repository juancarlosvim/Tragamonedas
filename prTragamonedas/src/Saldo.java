/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Saldo {
    private Double saldo;
    
    Saldo (){
        
    }
    
    Saldo(double saldo){
        this.saldo = saldo;
    }

    /**
     * @return the saldo
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    
    public double RestarSaldo(double sum){
        return this.saldo -= sum;
    }
    
    public double SumarSaldo(Double sum){
        return saldo+sum;
    }
    
    public double DobleSaldo(Double sum){
        
        sum = sum*2;
        
        
        return saldo+sum;
    }
    public double TripleSaldo(Double sum){
        sum = sum *3;
        
        return saldo+sum;
    }
    
    
    
}
