package edu.umb.cs680.hw17;

public interface Observer<Target> {
	public void update(Observable<Target> sender, Target event);
}
