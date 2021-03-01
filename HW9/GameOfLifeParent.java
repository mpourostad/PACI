import java.io.*;
import java.nio.charset.Charset;
public class GameOfLifeParent {
	public GameOfLifeParent(String filename) throws IOException {
		Charset encoding = Charset.defaultCharset();
		File file = new File(filename);
	    handleFile(file, encoding);
	}
    public void handleFile(File file, Charset encoding)
            throws IOException {
        try (InputStream in = new FileInputStream(file);
             Reader reader = new InputStreamReader(in, encoding);
             // buffer for efficiency
             Reader buffer = new BufferedReader(reader)) {
            handleCharacters(buffer);
        }
    }
    public void handleCharacters(Reader reader)
            throws IOException {
        int r;
        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            if(ch == 'x') {
            	System.out.println('.');
            }
            else {
            	System.out.print(ch);
            }	
        }
    }
}
