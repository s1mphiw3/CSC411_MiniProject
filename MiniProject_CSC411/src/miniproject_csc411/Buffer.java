/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject_csc411;

import java.io.File;

/**
 *
 * @author Simphiwe
 */
public class Buffer {
    int size ;
    int Maxsize = 10;

    File file;

    public Buffer(File file) {
        //this.size = 0;
        this.file = file;
    }

    public Buffer(int maxsize) {
        this.Maxsize = maxsize;
       }
    
    public boolean IsFull() {return (size == Maxsize);}
    public boolean IsEmpty () { return (this.size==0);}
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxsize() {
        return Maxsize;
    }

    public void setMaxsize(int Maxsize) {
        this.Maxsize = Maxsize;
    }

    @Override
    public String toString() {
        return "Buffer{" + "size=" + size + ", Maxsize=" + Maxsize + ", file=" + file + '}';
    }
    
}
