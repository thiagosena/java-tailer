import java.io.File;

/**
 * Implements console-based log file tailing, or more specifically, tail following:
 * it is somewhat equivalent to the unix command "tail -f"
 */
public class App implements LogFileTailerListener {
	private LogFileTailer tailer;

	public App( String filename ) {
		System.out.println("Start app!!");
		tailer = new LogFileTailer( new File( filename ), 500, false );
		tailer.addLogFileTailerListener( this );
		tailer.start();
	}

	public void newLogFileLine(String line) {
		System.out.println( line );
	}

	/**
	 * Command-line launcher
	 */
	public static void main( String[] args ) {
		if( args.length < 1 ){
			// in Mac OS X: "/var/log/apache2/access_log"
			System.out.println( "Usage: Tail <filename>" );
			System.exit( 0 );
		}
		
		new App( args[ 0 ] );	
	}
}