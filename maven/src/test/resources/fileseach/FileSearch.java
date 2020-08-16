package fileseach;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FileSearch {

	String path = "C:\\Users\\kriss\\OneDrive\\Desktop\\Files";
	
	public void method1() throws IOException {

		long starttime = System.currentTimeMillis();
		Path configFilePath = FileSystems.getDefault().getPath(path);

		List<Path> fileWithName = Files.walk(configFilePath).filter(s -> s.toString().endsWith("sample.txt"))
				.map(Path::getFileName).sorted().collect(Collectors.toList());

		for (Path name : fileWithName) {
			// printing the name of file in every sub folder
			System.out.println(name);
		}
		long endtime = System.currentTimeMillis();
		System.out.println("Execution time : " + (endtime - starttime) / 1000 + " s");

	}

	public ArrayList<String> method2() throws IOException {
		long starttime = System.currentTimeMillis();
		ArrayList<String> a = new ArrayList<String>();
		Files.walk(Paths.get(path)).filter(Files::isRegularFile)
				.forEach((a1) -> {
					if(a1.toAbsolutePath().toString().endsWith("sample.txt") && a1.toAbsolutePath().toString().contains("sub11") ) {
						a.add(a1.toAbsolutePath().toString());
						System.out.println(a1.toAbsolutePath().toString());
					}					
				});
		long endtime = System.currentTimeMillis();
		System.out.println("Execution time : " + (endtime - starttime) / 1000 + " s");
		return a;
		
	}
	
	public void method3() throws IOException {
		Files.find(Paths.get(path),
		           Integer.MAX_VALUE,
		           (filePath, fileAttr) -> fileAttr.isRegularFile())
		        .forEach(System.out::println);
	}

	public static void main(String args[]) throws IOException {
		FileSearch fs = new FileSearch();
		fs.method2();
		
	}

}
