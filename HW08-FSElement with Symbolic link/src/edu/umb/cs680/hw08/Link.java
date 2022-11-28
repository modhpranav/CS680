package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class Link extends FSElement {
    FSElement target;
    int size;
    public Link(Directory parent, String name, int size, LocalDateTime creationtime, FSElement target){
        super(parent, name, size, creationtime);
        this.size=0;
        this.target=target;}

    public FSElement getTarget(){
        return this.target;
    }

    public int getSize() {
        return size;
    }

    public int getTargetSize() {
        if(target instanceof Link)
            return ((Link) target).getTargetSize();
        else
            return target.getSize();
    }
}
