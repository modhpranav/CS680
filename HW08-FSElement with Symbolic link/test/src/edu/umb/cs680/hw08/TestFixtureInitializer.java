package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class TestFixtureInitializer {

    static LocalDateTime localTime = LocalDateTime.now();

    public FileSystem createFS(){

        Directory root = new Directory(null, "root", 0, localTime);  // directory has size 0
        Directory Apps = new Directory(root, "Apps", 0, localTime);  // directory has size 0
        Directory bin = new Directory(root, "bin", 0, localTime);  // directory has size 0
        Directory home = new Directory(root, "home", 0, localTime);  // directory has size 0

        File x = new File(Apps, "x", 50, localTime);

        File y = new File(bin, "y", 50, localTime);

        File c = new File(home, "c", 50, localTime);
        Directory pictures = new Directory(home, "pictures", 0, localTime);
        File a = new File(pictures, "a", 50, localTime);
        File b = new File(pictures, "b", 50, localTime);


        FileSystem fs = FileSystem.getFileSystem();
        fs.appendRootDir(root);
        return fs;
    };

    public void main(String[] args){};

}
