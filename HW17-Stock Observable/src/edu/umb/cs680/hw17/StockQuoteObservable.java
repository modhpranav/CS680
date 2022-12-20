package edu.umb.cs680.hw17;

import java.util.HashMap;

public class StockQuoteObservable extends Observable<StockEvent>{
	HashMap<String, Double> stckValQuote;

	public StockQuoteObservable() {
		this.stckValQuote = new HashMap<>();
	}

	public void changeQuote(String ticker, double quote) {
		this.stckValQuote.put(ticker, quote);
		notifyObservers(new StockEvent(ticker, quote));
	}
}
