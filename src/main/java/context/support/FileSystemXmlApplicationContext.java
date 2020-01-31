package context.support;


import io.FileSystemResource;
import io.Resource;

public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

	public FileSystemXmlApplicationContext(String path) {
		super(path);		
	}

	@Override
	protected Resource getResourceByPath(String path) {
		return new FileSystemResource(path);
	}	

}
