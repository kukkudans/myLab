package com.harilal;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

public class XMLToString {
	public static void main(String ar[]) throws IOException {

		File f = new File("c:/temp/test.xml");
		System.out.println("private String getChunk() {\nreturn new StringBuilder()");
		FileUtils.readLines(f).forEach(line -> {
			if (StringUtils.isNotBlank(line)) {
				line = line.replace("\"", "\\\"");
				System.out.println(".append(\"" + line + "\")");
			}
		});
		System.out.println(".toString(); \n}");
	}
}
