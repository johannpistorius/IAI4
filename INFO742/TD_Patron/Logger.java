
public class Logger {
	private static Logger logger;
	private Logger() {
	}
	public static Logger getInstance() {
		if(logger == null) {
			logger = new Logger();
		}
		return logger;
		
	}
	public void info(String message) {
		System.out.println("info: "+message);
	}
	public void warning(String message) {
		System.out.println("warning: "+message);
	}
}
