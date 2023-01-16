package com.joselara.sockets;
import java.io.DataOutputStream;
import java.io.IOException;

public class Cliente extends Conexion
{
    //Se usa el constructor para cliente de Conexion
    public Cliente() throws IOException{super("cliente");} 
    public void startClient() //M�todo para iniciar el cliente
    {
        try{
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());
            //Se enviarán dos mensajes
            for (int i = 0; i < 2; i++)
            {
                //Se escribe en el servidor usando su flujo de datos
                salidaServidor.writeUTF("Este es el mensaje " + (i+1) + "\n");
            }
            cs.close();//Fin de la conexi�n
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Fin de la conexión");
    }
}
