package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.SecurityJob.SecurityContext;

import java.time.LocalDateTime;

public class Link extends FSElement {
    FSElement target;
    int size;
    public Link(Directory parent, String name, int size, LocalDateTime creationtime, FSElement target){
        super(parent, name, size, creationtime);
        if(parent!=null){
            parent.appendChild(this);}
    }

    public FSElement getTarget(){
        return this.target;
    }

    public int getSize() {
        return size;
    }

    public void accept(FSVisitor v, SecurityContext ctx) throws Exception {
        if (ctx.getIsActive()){
        v.visit(this);
        }else{
            throw new Exception("Please login to visit.");
        }
    };

    public int getTargetSize() {
        if(target instanceof Link)
            return ((Link) target).getTargetSize();
        else
            return target.getSize();
    }
}
