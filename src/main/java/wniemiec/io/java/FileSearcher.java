/**
 * Copyright (c) William Niemiec.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package wniemiec.io.java;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

/**
 * Searches for files.
 */
public class FileSearcher {
	
	//-------------------------------------------------------------------------
	//		Attributes
	//-------------------------------------------------------------------------
	private Path searchFile;
	private final Path workingDirectory;

	
	//-------------------------------------------------------------------------
	//		Constructor
	//-------------------------------------------------------------------------
	/**
	 * Searches for files starting from the specified working directory.
	 * 
	 * @param		workingDirectory 
	 * 
	 * @throws		IllegalArgumentException If working directory is null
	 */
	public FileSearcher(Path workingDirectory) {
		if (workingDirectory == null)
			throw new IllegalArgumentException("Working directory cannot be null");
		
		
		this.workingDirectory = workingDirectory;
	}
	
	/**
	 * Searches for files starting from the current directory.
	 */
	public FileSearcher() {
		this(Path.of(".").normalize().toAbsolutePath());
	}
	
	
	//-------------------------------------------------------------------------
	//		Methods
	//-------------------------------------------------------------------------
	/**
	 * Searches for all files with an extension starting from the specified
	 * working directory.
	 *
	 * @param		extension File extension (without dot)
	 *
	 * @return		Files with the specified extension or empty set if no files
	 * are found
	 *
	 * @throws		IOException If an error occurs while searching for the file
	 * @throws		IllegalArgumentException If extension is blank or null
	 */
	public Set<Path> searchAllFilesWithExtension(String extension) throws IOException {
		if ((extension == null) || extension.isBlank())
			throw new IllegalArgumentException("Extension cannot be empty");

		Set<Path> paths = new HashSet<>();
		String normalizedExtension = (extension.charAt(0) == '.')
				? extension.substring(1)
				: extension;

		Files.walkFileTree(workingDirectory, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
				if (file.toString().endsWith("." + normalizedExtension)) {
					paths.add(file.toAbsolutePath().normalize());
				}

				return FileVisitResult.CONTINUE;
			}
		});

		return paths;
	}

	/**
	 * Searches for a file starting from the specified working directory.
	 * 
	 * @param		filename Name of the file to be searched File (including 
	 * its extension)
	 * 
	 * @return		File with the specified filename or null if it cannot find
	 * the file
	 * 
	 * @throws		IOException If an error occurs while searching for the file
	 * @throws		IllegalArgumentException If filename is blank or null
	 */
	public Path search(String filename) throws IOException {
		if ((filename == null) || filename.isBlank())
			throw new IllegalArgumentException("Filename cannot be empty");
		
		searchFile = null;
		
		Files.walkFileTree(workingDirectory, new SimpleFileVisitor<Path>() {
			@Override
		    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		        if (file.toString().endsWith(filename)) {
		        	file = fixOrg(file);
		        	searchFile = file;
		        }
		        
		        return FileVisitResult.CONTINUE;
			}
		});
		
		return searchFile;
	}
	
	private static Path fixOrg(Path file) {
		return Path.of(file.toAbsolutePath().toString().replaceAll(
				"(\\/|\\\\)org(\\/|\\\\)org(\\/|\\\\)", 
				"/org/"
		));
	}
}
