package edu.umb.cs680.hw17;

import java.util.LinkedList;
import java.util.List;

public abstract class Observable<Target> {
	private LinkedList<Observer<Target>> observers = new LinkedList<>();
	
	public void addObserver(Observer<Target> obsvr) {
		observers.add(obsvr);
	}

	public void clearObservers() {
		observers.clear();
		
	}
	public List<Observer<Target>> getObservers(){
		return observers;
	}
	
	public int countObservers() {
		return observers.size();
		
	}
	public void removeObserver(Observer<Target> obsvr) {
		observers.remove(obsvr);
	}

	public void notifyObservers(Target event) {
		observers.forEach( (observer)->{observer.update(this, event);} );
	}

	public static void main(){};
	
}
