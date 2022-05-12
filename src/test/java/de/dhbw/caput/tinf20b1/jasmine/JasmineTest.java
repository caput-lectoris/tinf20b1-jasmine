package de.dhbw.caput.tinf20b1.jasmine;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

class JasmineTest {
	
	private InputStream load( String filename ) throws Exception {
		InputStream in = JasmineTest.class.getResourceAsStream(filename);
		if( null == in ){
			throw new IllegalArgumentException( String.format("No such test \"%s\".", filename) );
		}
		return in;
	}
	
	private String execute( String filename ) throws Exception {
		try( InputStream in = load(filename) ){
			return Jasmine.execute( in );
		}
	}
	
	@Test
	void executePredefinedJasminFile() throws Exception {
		String result = execute( "HelloWorld.j" );
		assertThat( result ).isEqualTo( "Hello World!" );
	}
	
	@Test
	void generateJasminFile() throws Exception {
		JasminDefault jasmin = new JasminDefault( );
		jasmin.BODY.appendLine( "getstatic java/lang/System/out Ljava/io/PrintStream;" );
		jasmin.BODY.appendLine( "ldc \"This is generated bytecode!\"" );
		jasmin.BODY.appendLine( "invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V" );
		jasmin.BODY.appendLine( "return" );
		InputStream in = load( "GeneratedBytecode.j" );
		String expectedOutput = new String( in.readAllBytes(), StandardCharsets.UTF_8 );
		assertThat( jasmin.toString() ).isEqualTo( expectedOutput );
	}

}
