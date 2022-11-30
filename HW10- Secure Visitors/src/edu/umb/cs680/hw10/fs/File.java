package edu.umb.cs680.hw10.fs;
import edu.umb.cs680.hw10.fs.SecurityJob.SecurityContext;

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

    public void accept(FSVisitor v, SecurityContext ctx) throws Exception {
        if (ctx.getIsActive()){
            v.visit(this);
        }else{
            throw new Exception("Please login to visit.");
        }
    };

//    public int getsize(){
//        return this.size;
//    }

}