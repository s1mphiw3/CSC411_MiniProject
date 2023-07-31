/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject_csc411;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.*;
import java.io.File;
import java.nio.IntBuffer;
import java.util.concurrent.Semaphore;


/**
 *
 * @author Simphiwe
 */
public class MiniProject_CSC411 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        //initialize buffer
        IntBuffer  buffer = IntBuffer.allocate(10);
        
        
        int buf[] = new int[10];
        Producer p = new Producer();
        int current = 1;
        Consumer c = new Consumer();
        while(current > -1  )
        {    
            if(current == 0){
             System.out.println("Can not consume Buffer is empty");
             current ++;
             buf[current]=current;
            }
            else if(current > 0 && current<= 10 ){
              p.produce(current); 
              current++;
              buf[current]=current;
              c.consume(current-1);
              
              current--;
            }

            else{
            System.out.println("Can not produce Buffer is full");
            current--;
            }
        }
    }
    
}
