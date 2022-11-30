package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.FSVisitor;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;

public class CountingVisitor implements FSVisitor {
    int dirNum = 0;
    int fileNum = 0;
    int linkNum = 0;

    public CountingVisitor(int dirNum,int fileNum,int linkNum){
        super();
        this.dirNum = dirNum;
        this.fileNum = fileNum;
        this.linkNum = linkNum;
    }

    public void visit(Link link) {
        this.linkNum ++;
    }

    public void visit(Directory dir){
        this.dirNum ++;
    };
    public void visit(File file){
        System.out.println(file.getName());
        this.fileNum ++;
    };

    public int getDirNum(){
        return this.dirNum;
    }

    public int getLinkNum() {
        return this.linkNum;
    }

    public int getFileNum() {
        return this.fileNum;
    }
}
