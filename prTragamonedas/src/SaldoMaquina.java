

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juancarlosvim
 */
public class SaldoMaquina {
    private double saldoMaq;

    public SaldoMaquina(double saldMaq) {
        this.saldoMaq = saldMaq;
    }
    
    public void grabarSaldoMaquina(DataOutputStream fichero) throws IOException {
        fichero.writeDouble(saldoMaq);
      
    }
    
    public void LeerSaldoMaquina(DataInputStream fichero) throws IOException{
        
        saldoMaq = fichero.readDouble();
    }
    
    
    public double SumarSaldoMaquina(double suma){
        return saldoMaq += suma;
    }
    
     public double RestarSaldoMaquina(double suma){
       
         return saldoMaq -= suma;
    }
    
     public double actualizarMaquinaPremioDoble(double suma){
         
        suma = suma *2;
        
        return (saldoMaq - suma);
     }
     
      public double actualizarMaquinaPremioTriple(double suma){
         
        suma = suma *3;
        
        return (saldoMaq - suma);
     }
    
    
    public double  MostrarSaldoMaquina(){
        return saldoMaq;
    }
    
    
    
    
}
