package org.input;

import java.io.*;

public class InputTester {
    public static void main(String args[]) {
        InputStream in = null;
        int c;

        try {
            String sourceString = "I know the Decorator Pattern therefore I RULE!";
            InputStream stringStream = new ByteArrayInputStream(sourceString.getBytes("UTF-8"));

            in = new LowerCaseInputStream(new BufferedInputStream(stringStream));

            while((c = in.read()) >= 0) {
                System.out.print((char)c);
            }

            in.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            if(in != null) {
                in = null;
            }
        }
    }
}
