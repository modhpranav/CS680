package edu.umb.cs680.hw07;
import java.time.LocalDateTime;

public class File extends FSElement{

    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        if(parent!=null){
            parent.appendChild(this);}
    }

    public boolean isDirectory() {
        return false;
    }

    public boolean isFile() {
        return true;
    }

//    public int getsize(){
//        return this.size;
//    }

}