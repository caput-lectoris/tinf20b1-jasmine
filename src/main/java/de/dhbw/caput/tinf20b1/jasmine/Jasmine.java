package de.dhbw.caput.tinf20b1.jasmine;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import jasmin.ClassFile;

public class Jasmine {
	
	public static String execute( InputStream assembly ) throws IOException, Exception {
		Path directory = Files.createTempDirectory( "tinf20b1-jasmine" );
		String className = createClassFile( directory, assembly );
		String result = runJavaClass( directory, className );
		deleteRecursively( directory.toFile() );
		return result;
	}
	
	private static String createClassFile( Path directory, InputStream assembly ) throws Exception {
		ClassFile classFile = new ClassFile();
		classFile.readJasmin( assembly, "", false );
		Path outputPath = directory.resolve( classFile.getClassName() + ".class" );
		try( OutputStream output = Files.newOutputStream(outputPath) ){
			classFile.write( output );
		}
		return classFile.getClassName();
	}
	
	private static String runJavaClass( Path directory, String className ) throws Exception {
		Process process = Runtime.getRuntime().exec(
				new String[]{ "java", "-cp", directory.toString(), className });
		try( InputStream in = process.getInputStream() ){
			return new String( in.readAllBytes(), StandardCharsets.UTF_8 );
		}
	}
	
	private static void deleteRecursively( File node ){
		if( node.isDirectory() ){
			for( File child : node.listFiles() ){
				deleteRecursively( child );
			}
		}
		if( !node.delete() ){
			throw new Error( String.format("Could not delete file \"%s\".", node.getAbsolutePath()) );
		}
	}

}
