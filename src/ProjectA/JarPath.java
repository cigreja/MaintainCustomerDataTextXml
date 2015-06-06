/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectA;

import java.io.*;
import java.net.*;
import java.security.*;

/*
 * This class locates the location of the Jar Path. This is used to write the 
 * customers.txt file in the same directory.
 */
public class JarPath {
    
    public File getFolder() throws IOException {
        ProtectionDomain domain = getClass().getProtectionDomain();
        CodeSource source = domain.getCodeSource();
        URL url = source.getLocation();
        if (!"file".equals(url.getProtocol())){
            throw new IOException("Code source location not a file:" + url);
        }
        String path = url.getPath();
        //remove xxx.jar from path:
        return new File(path.substring(0, path.lastIndexOf('/')));
    }
}
