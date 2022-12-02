package edu.umb.cs680.hw13.fs;

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

    public void accept(FSVisitor v){
        v.visit(this);
    };

    public int getTargetSize() {
        if(target instanceof Link)
            return ((Link) target).getTargetSize();
        else
            return target.getSize();
    }
}
