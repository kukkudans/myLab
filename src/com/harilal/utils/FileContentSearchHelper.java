package com.harilal.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

public class FileContentSearchHelper {
	String[] tags = { "<definition" };
	private static FileWriter fw = null;
	private static int counter = 1;
	
	public static void main(String ar[]) throws IOException {
		fw = new FileWriter("c:/temp/z_op.txt");
		FileContentSearchHelper obj = new FileContentSearchHelper();
		File f = new File("y:/bills");
		try {
			obj.readFiles(f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void readFiles(File file) throws Exception {

		if (file.isDirectory()) {
			Arrays.asList(file.listFiles()).forEach((tempFile) -> {

				try {
					readFiles(tempFile);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});
		} else {
			Thread t = new Thread() {
				public void run() {
					try {
						checkFileContent(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				};
			};
			t.start();
		}

	}

	private void checkFileContent(File f) throws IOException {
		String content = FileUtils.readFileToString(f);
		for (String tag : tags) {
			if (checkTheContent(content, tag)) {
				System.out.println("---------------------\n" + content);
				fw.write("\n<file-tag path='" + f.getPath() + "'>" + content + "</file-tag>");
				// System.out.println(String.format("found %s	in %s", tag,
				// f.getAbsolutePath()));
			} 
			
			System.out.println((counter++)+" "+f.getPath() + " processed but no match found");
		}
	}

	private boolean checkTheContent(String content, String tag) {

		return StringUtils.contains(content, tag);

	}

}
