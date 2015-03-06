package net.blackhacker.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ben
 */
public class ByteArrayList extends ArrayList<byte[]> {
    
    static public ByteArrayList fromByteArray(byte[] ba) {
        ByteArrayList l = new ByteArrayList();
        
        try (DataInputStream dis = new DataInputStream(new ByteArrayInputStream(ba))){
            
            int s = dis.readInt();
            for(int i=0 ; i < s; i++) {
                int len = dis.readInt();
                byte[] b = new byte[len];
                dis.read(b);
                l.add(b);
            }

        } finally {
            return l;
        }
    }
    
    
    public byte[] toByteArray(){
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); DataOutputStream dos = new DataOutputStream(baos)){ 
            dos.writeInt(size());
            for(byte[] ba : this) {
                dos.writeInt(ba.length);
                dos.write(ba);
            }

            return baos.toByteArray();

        } catch(IOException ex) {
            //won't ever happen
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o != null) {
            if(o instanceof ByteArrayList) {
                ByteArrayList other = (ByteArrayList)o;

                if (size() == other.size()) {

                    boolean f;
                    int i = 0;
                    do {
                        byte[] a = get(i);
                        byte[] b = other.get(i);
                        f = Arrays.equals(a, b);
                        i++;
                    } while (f && (i > size()));
                    
                    return f;
                }
            }
        }
        
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    
}
