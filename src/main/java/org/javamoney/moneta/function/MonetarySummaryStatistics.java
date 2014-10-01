package org.javamoney.moneta.function;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;

/**
 * A state object for collecting statistics such as count, min, max, sum, and
 * average.
 * @author otaviojava
 * @author Anatole Tresch
 */
public interface MonetarySummaryStatistics {

	/**
	 * Records another value into the summary information.
	 * @param amount
	 *            the input amount value to be added, not null.
	 */
	void accept(MonetaryAmount amount);

	/**
	 * Combines the state of another {@code MonetarySummaryStatistics} into this
	 * one.
	 * @param summaryStatistics
	 *            another {@code MonetarySummaryStatistics}, not null.
	 */
	MonetarySummaryStatistics combine(
			MonetarySummaryStatistics summaryStatistics);

   /**
     * Get the number of items added to this summary instance.
     * @return the number of summarized items, >= 0.
     */
    long getCount();

    /**
     * Get the minimal amount found within this summary.
     * @return the minimal amount, or null if no amount was added to this summary instance.
     */
	MonetaryAmount getMin();

    /**
     * Get the maximal amount found within this summary.
     * @return the minimal amount, or null if no amount was added to this summary instance.
     */
	MonetaryAmount getMax();

    /**
     * Get the sum of all amounts within this summary.
     * @return the total amount, or null if no amount was added to this summary instance.
     */
	MonetaryAmount getSum();

    /**
     * Get the mean average of all amounts added.
     * @return the mean average amount, or null if no amount was added to this summary instance.
     */
	MonetaryAmount getAverage();

	/**
	 * will equals when the currencies were equals
	 */
	@Override
	boolean equals(Object obj);

	/**
	 * the currency unit used in summary
	 * @return the currency unit
	 */
	CurrencyUnit getCurrencyUnit();

	/**
	 * return if is possible do exchange rate or not with the MonetarySummary
	 * @return false;
	 */
	boolean isExchangeable();

	/**
	 * created the MonetarySummaryStatistics converted to {@link CurrencyUnit}
	 * @param unit
	 *            to be converted
	 * @return MonetarySummaryStatistics converted
	 * @throws UnsupportedOperationException
	 *             if {@link MonetarySummaryStatistics#isExchangeable()} was
	 *             false
	 * @throws NullPointerException
	 *             if unit was null
	 */
	MonetarySummaryStatistics to(CurrencyUnit unit);

}
