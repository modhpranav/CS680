package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.FSVisitor;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;

import java.util.LinkedList;

public class FileSearchVisitor implements FSVisitor {

    public String fileName;
    LinkedList<File> foundFiles = new LinkedList<File>();

    public FileSearchVisitor(String fileName) {
        super();
        this.fileName = fileName;
    }

    public void visit(Link link) {}

    public void visit(Directory dir){};

    public void visit(File file){
        if(file.getName().equals(this.fileName)){
            foundFiles.add(file);
        }
    };

    public LinkedList<File> getFoundFiles(){
        return foundFiles;
    }

}
