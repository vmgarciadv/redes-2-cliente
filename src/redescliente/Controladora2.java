/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redescliente;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JTextField;
import redescliente.Login;

/**
 *
 * @author Dexter
 */
public class Controladora2 {
  JButton Ingresar;
  JTextField Usuario, Clave;
  Login log;
     public Controladora2(JButton Ingresar) {
        this.Ingresar = Ingresar;
      
    }
    
    public Controladora2 (JTextField Usuario, JTextField Clave){
        this.Usuario = Usuario;
        this.Clave = Clave;
    }
    
     public Controladora2 (){
        
    }
    
    public void iniciaLogin (){
        Usuario.setText(null);
        Clave.setText(null);
    }
    
    public void datosLogin(){
        log.setUsuario(Usuario.getText());
        log.setClave(Clave.getText());
    }
    
    
  
  
public void enviarInfo (String Usuario, String Clave) throws ClassNotFoundException, IOException{

    String hostName = "localhost";
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    try
    {
    System.out.println("Estableciendo conexion");
    Socket cliente = new Socket(hostName, 30001);        
        
    oos = new ObjectOutputStream(cliente.getOutputStream());// asociar buffer de envio
        System.out.println("Sending request to Socket Server");
        
       
//        try{
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//entrada por consola
//            input=br.readLine();  
        String input = Usuario + ";" + Clave;
     
//	}catch(IOException io){
//            io.printStackTrace();
//	}
  //    else{   
//        Random papa = new Random();
//        String papa2 = Integer.toString((int)(papa.nextDouble() * 10 + 0));
//        input = (input + ":" + papa2);
        //System.out.println(input); //+ papa2
        oos.writeObject(input); // mandar la info
        ois = new ObjectInputStream(cliente.getInputStream());// asociar buffer de entrada
        String message = (String) ois.readObject();
//        String [] parts = message.split(";");
//        String part1 = parts [0];
//        String part2 = parts [1];
//        System.out.println(part1);
//        System.out.println(part2);
        System.out.println(message);
        ois.close();
        oos.close();
        cliente.close();
//        String [] partir = part1.split(":");
//        String part3 = partir [1];
//        int r = Integer.parseInt(part3);
//        if (r == 0) {
//        cliente.close();
//        break;
   
        }
              //}
        
        
    
        catch(IOException io)
    {
        System.out.println("Error creando el socket "+io);
    }    
    }


}