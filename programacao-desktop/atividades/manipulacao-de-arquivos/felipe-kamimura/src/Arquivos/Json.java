/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos;

import Classes.Cliente;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author kamimuraf
 */
public class Json {
    
    public void saveJSON (String file, String json){
        try{
            FileWriter w;
            w = new FileWriter(file);
            w.write(json);
            w.close();
        }
        catch (FileNotFoundException ex){
               System.out.println("Erro: " + ex.getMessage());
        }
        catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    } 
    
    public String loadJSON (String file){
        try{
            FileReader r;
            r = new FileReader(file);
            BufferedReader in = new BufferedReader(r);
            String buffer = in.readLine();
            String all = "";
            while(buffer != null){
                all += buffer;
                buffer = in.readLine();
            }
            return all;
        }catch (FileNotFoundException ex){
               System.out.println("Erro: " + ex.getMessage());
        }
        catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }
    
    
   public String convertToJSON(Cliente c){
       String json = new Gson().toJson(c, Cliente.class);
       return json;      
}
   
public Cliente convertToCliente(String json){
    Cliente c = new Gson().fromJson(json, Cliente.class);
    return c;
}}
