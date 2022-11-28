package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;


public class Directory extends FSElement{
    LinkedList<FSElement> children = new LinkedList<FSElement>();
    LinkedList<Directory> directory = new LinkedList<Directory>();
    LinkedList<File> file = new LinkedList<File>();

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        if(parent!=null){
            parent.appendChild(this);}
    }

    public boolean isDirectory() {
        return true;
    }

    public LinkedList<FSElement> getChildren(){
        return this.children;
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
    }

    public int countChildren() {
        return children.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> listdir = new LinkedList<>();
        for (FSElement fsElement : children) {
            if (fsElement.isDirectory())
                listdir.add((Directory)fsElement);
        }
        return listdir;
    }

    public LinkedList<File> getFiles(){
        LinkedList<File> listfiles = new LinkedList<>();
        for (FSElement fsElement : children) {
            if (!fsElement.isDirectory()) {
                listfiles.add((File)fsElement);
            }
        }
        return listfiles;
    }

    public int getTotalSize(){
        FSElement dirs = this;
        Directory dir =(Directory) dirs;
        int totalsize = 0;
        for(int child=0;child<dir.getChildren().size();child++){
            totalsize += dir.getChildren().get(child).getSize();
        }
        return totalsize;
    }


}