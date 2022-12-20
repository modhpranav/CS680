package edu.umb.cs680.hw17;

public class LineChartObserver implements Observer {
	private StockEvent stckevent;

	public StockEvent getS() {
		return stckevent;
	}

	@Override
	public void update(Observable sender, Object event) {
		if (sender instanceof StockQuoteObservable) {
			StockEvent curr_ticker = new StockEvent((((StockEvent) event).getTicker()),
					((StockEvent) event).getQuote());

			stckevent = curr_ticker;

			System.out.println("Processing Stock event LineChartObserver");
		}


	}


}
