package net.blackhacker.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ben
 */
public class ByteArrayList extends ArrayList<byte[]> {
    private static final int HEADER_ITEM_SIZE = Integer.SIZE / 8 * 2;
    private static final Logger LOG = Logger.getLogger(ByteArrayList.class.getName());
    
    
    
    static public ByteArrayList fromByteArray(byte[] ba) {
        ByteArrayList l = new ByteArrayList();
        DataInputStream dis=null;
        
        try {
        	dis = new DataInputStream(new ByteArrayInputStream(ba));
            
            int s = dis.readInt();
            for(int i=0 ; i < s; i++) {
                int len = dis.readInt();
                byte[] b = new byte[len];
                dis.read(b);
                l.add(b);
            }

        } catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			LOG.log(Level.SEVERE, "This should never happen ...", ex);
			
		} finally {
            if (dis!=null) try {
                dis.close();
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, "... and neither should this ", ex);
            }
        }
        
        return l;
    }
    
    
    public byte[] toByteArray(){
        
        byte[] retval = null;
        DataOutputStream dos = null;
        ByteArrayOutputStream baos=null;
        try { 
            dos = new DataOutputStream(baos = new ByteArrayOutputStream());
            dos.writeInt(size());
            for(byte[] ba : this) {
                dos.writeInt(ba.length);
                dos.write(ba);
            }

            retval = baos.toByteArray();

        } catch(IOException ex) { 
        	
        } finally {
            try {
                dos.close();
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }
            try {
                baos.close();
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }
        }
        return retval;
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
