package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class TestFixtureInitializer {

    static LocalDateTime localTime = LocalDateTime.now();

    public FileSystem createFS(){

        Directory root = new Directory(null, "root", 0, localTime);  // directory has size 0
        Directory apps = new Directory(root, "apps", 0, localTime);  // directory has size 0
        Directory lib = new Directory(root, "lib", 0, localTime);  // directory has size 0
        Directory home = new Directory(root, "home", 0, localTime);  // directory has size 0

        File x = new File(apps, "x", 50, localTime);
        File y = new File(apps, "y", 50, localTime);

        File z = new File(lib, "z", 50, localTime);
        File d = new File(home, "d", 50, localTime);
        Directory code = new Directory(home, "code", 0, localTime);
        File a = new File(code, "a", 50, localTime);
        File b = new File(code, "b", 50, localTime);
        File c = new File(code, "c", 25, localTime);
        FileSystem fs = FileSystem.getFileSystem();
        fs.appendRootDir(root);
        System.out.println(FileSystem.getFileSystem().getRootDirs().get(0).getChildren().get(0));
        System.out.println(FileSystem.getFileSystem().getRootDirs().get(0).getChildren().get(1).name);
        System.out.println(FileSystem.getFileSystem().getRootDirs().get(0).getChildren().get(2).name);
        return fs;
    };

    public void main(String[] args){};

}
