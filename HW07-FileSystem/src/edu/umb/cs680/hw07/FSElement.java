package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public abstract class FSElement {
    protected Directory parent;
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public Directory getParent() {
        return parent;
    }

    public LinkedList<FSElement> getChildren() {
        return this.getChildren();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        FSElement dirs = this;
        if(dirs.isFile()) {
            return size;}
        else{
            Directory dir = (Directory) dirs;
            LinkedList<File> subfiles = dir.getFiles();
            LinkedList<Directory> subDir = dir.getSubDirectories();
            int totalsizefiles = 0;
            int totalsizedir = 0;
            for(int i=0;i<subfiles.size();i++){
                totalsizefiles += subfiles.get(i).size;
            }
            for(int i=0; i<subDir.size();i++){
                totalsizedir = subDir.get(i).getSize();
            }
            return totalsizefiles+totalsizedir;
        }
    }

    private boolean isFile() {
        if(this instanceof File)
            return true;

        else return false;
    }

    public boolean isDirectory() {
        return false;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public static void main(String[] args) {
    }

}