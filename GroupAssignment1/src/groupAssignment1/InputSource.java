package groupAssignment1;

import java.io.*;

public class InputSource extends IOException {
	
	public File[] getSource(String dirName) {
		File dir = new File(dirName);
		File[] sourceDir = dir.listFiles();
		return sourceDir;
			
		
	}
	

}
