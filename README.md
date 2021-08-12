![](https://github.com/wniemiec-io-java/file-searcher/blob/master/docs/img/logo/logo.jpg)

<h1 align='center'>File Searcher</h1>
<p align='center'>Searches for files.</p>
<p align="center">
	<a href="https://github.com/wniemiec-io-java/file-searcher/actions/workflows/windows.yml"><img src="https://github.com/wniemiec-io-java/file-searcher/actions/workflows/windows.yml/badge.svg" alt=""></a>
	<a href="https://github.com/wniemiec-io-java/file-searcher/actions/workflows/macos.yml"><img src="https://github.com/wniemiec-io-java/file-searcher/actions/workflows/macos.yml/badge.svg" alt=""></a>
	<a href="https://github.com/wniemiec-io-java/file-searcher/actions/workflows/ubuntu.yml"><img src="https://github.com/wniemiec-io-java/file-searcher/actions/workflows/ubuntu.yml/badge.svg" alt=""></a>
	<a href="https://codecov.io/gh/wniemiec-io-java/file-searcher"><img src="https://codecov.io/gh/wniemiec-io-java/file-searcher/branch/master/graph/badge.svg?token=R2SFS4SP86" alt="Coverage status"></a>
	<a href="http://java.oracle.com"><img src="https://img.shields.io/badge/java-11+-D0008F.svg" alt="Java compatibility"></a>
	<a href="https://mvnrepository.com/artifact/io.github.wniemiec-io-java/file-searcher"><img src="https://img.shields.io/maven-central/v/io.github.wniemiec-io-java/file-searcher" alt="Maven Central release"></a>
	<a href="https://github.com/wniemiec-io-java/file-searcher/blob/master/LICENSE"><img src="https://img.shields.io/github/license/wniemiec-io-java/file-searcher" alt="License"></a>
</p>
<hr />

## ❇ Introduction
File Searcher searches for files simply and easily. 

## ❓ How to use
1. Add one of the options below to the pom.xml file: 

#### Using Maven Central (recomended):
```
<dependency>
  <groupId>io.github.wniemiec-io-java</groupId>
  <artifactId>file-searcher</artifactId>
  <version>LATEST</version>
</dependency>
```

#### Using GitHub Packages:
```
<dependency>
  <groupId>wniemiec.io.java</groupId>
  <artifactId>file-searcher</artifactId>
  <version>LATEST</version>
</dependency>
```

2. Run
```
$ mvn install
```

3. Use it
```
[...]

import wniemiec.io.java.FileSearcher;

[...]

Path workingDirectory = Path.of(".", "src", "test", "java");
FileSearcher searcher = new FileSearcher(workingDirectory);

Path file = searcher.search("FileSearcherTest.java");

System.out.println( file.toAbsolutePath() );

[...]
```


## 📖 Documentation
|        Property        |Parameter type|Return type|Description|Default parameter value|
|----------------|-------------------------------|-----|------------------------|--------|
|searchAllFilesWithExtension |`extension: String`|`Set<Path>`|Searches for all files with an extension starting from the specified working directory| - |
|search |`filename: String`|`Path`|Searches for a file starting from the specified working directory| - |

## 🚩 Changelog
Details about each version are documented in the [releases section](https://github.com/williamniemiec/wniemiec-io-java/file-searcher/releases).

## 🤝 Contribute!
See the documentation on how you can contribute to the project [here](https://github.com/wniemiec-io-java/file-searcher/blob/master/CONTRIBUTING.md).

## 📁 Files

### /
|        Name        |Type|Description|
|----------------|-------------------------------|-----------------------------|
|dist |`Directory`|Released versions|
|docs |`Directory`|Documentation files|
|src     |`Directory`| Source files|
