package de.dhbw.caput.tinf20b1.jasmine;

public class JasminDefault {
	
	private final JasminClass CLASS;
	public final JasminMethod MAIN_METHOD;
	
	public JasminDefault( ){
		this( "GeneratedBytecode" );
	}
	
	public JasminDefault( String className ){
		JasminMethodSignature signature = new JasminMethodSignature(
				"main",
				"[Ljava/lang/String;" );
		JasminMethodDeclaration declaration = new JasminMethodDeclaration(
				signature,
				"V",
				JvmModifier.PUBLIC,
				JvmModifier.STATIC );
		JasminMethodBody body = new JasminMethodBody( );
		
		CLASS = new JasminClass( JvmModifier.PUBLIC, className );
		MAIN_METHOD = CLASS.addMethod( declaration, body );
	}
	
	@Override
	public String toString( ){
		return CLASS.toString( );
	}

}
