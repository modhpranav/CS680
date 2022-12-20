package edu.umb.cs680.hw17;

public class TableObserver implements Observer {
	private StockEvent stckevent;

	public StockEvent getS() {
		return stckevent;
	}

	@Override
	public void update(Observable sender, Object event) {
		if (sender instanceof StockQuoteObservable) {
			StockEvent ticker = new StockEvent((((StockEvent) event).getTicker()),
					((StockEvent) event).getQuote());


			this.stckevent = ticker;
		}

	}

}
