package eecs4313a2b;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import net.sf.borg.common.DateUtil;

/**
 * A robust boundary value test case for the DateUtil.dayOfEpoch() method. 
 * 
 * Specification:
 * 
 * public int net.sf.borg.common.DateUtil.dayOfEpoch(Date d)
 * 
 * This method returns the number of days till or since epoch, which is 1 Jan 1970 AD, 00:00:00.0 +0000.
 * The first argument is the date in which it it calculates the number of days till or since epoch.
 *
 * @author Kevin Arindaeng
 * @version 1.1
 * @since 2018-03-02
 */

/*
 * Strategy: Robust boundary value testing
 * min- = Minimum possible value for a Date - 1 day = Long.min - 86400000l
 * min = Minimum possible value for a Date = Long.min
 * min+ = Minimum possible value for a Date + 1 day = Long.min + 86400000l
 * nom = 0
 * max- = Maximum value for a Date - 1 day = Long.max - 86400000l
 * max = Maximum value for a Date = Long.max
 * max+ = Maximum value for a Date + 1 day = Long.max + 86400000l
 * 
 */
public class DayOfEpochTest {
	
	private final static long DAY_IN_MS = 86400000l;
	
	/**
	* Tests that the number of days from (1 Dec 292269055 BC, 16:47:04.192 +0000) to (1 Jan 1970 AD, 11:00:00.0 +0000)
	* is correct.
	* 
	* Expected value:
	* |-9223372036854775808 - 86400000| = 9223372036941175808 milliseconds = 106751991168.30067444 days.
	* 
	* 106751991168 is undefined for an integer, so the expected value is null.
	* 
	* @author  Kevin Arindaeng
	* @version 1.1
	* @since 2018-03-02
	*/
	@Test
	public void minMinusDayOfEpoch() {
		// Expected (1 Dec 292269055 BC, 16:47:04.192 +0000) but it overflows to (16 Aug 292278994 AD, 07:12:55.808 +0000)
		Date minMinusDate = new Date(Long.MIN_VALUE - DAY_IN_MS);
		Assert.assertEquals(null, DateUtil.dayOfEpoch(minMinusDate));
	}
	
	/**
	* Tests that the number of days from (2 Dec 292269055 BC, 16:47:04.192 +0000) to (1 Jan 1970 AD, 11:00:00.0 +0000)
	* is correct.
	* 
	* Expected value:
	* |-9223372036854775808| = 9223372036854775808 milliseconds = 106751991167.30064392 days.
	* 
	* 106751991167 is undefined for an integer, so the expected value is null.
	* 
	* @author  Kevin Arindaeng
	* @version 1.1
	* @since 2018-03-02
	*/
	@Test
	public void minDayOfEpoch() {
		Date minDate = new Date(Long.MIN_VALUE); // 2 Dec 292269055 BC, 16:47:04.192 +0000
		Assert.assertEquals(null, DateUtil.dayOfEpoch(minDate));
	}
	
	/**
	* Tests that the number of days from (3 Dec 292269055 BC, 16:47:04.192 +0000) to (1 Jan 1970 AD, 11:00:00.0 +0000)
	* is correct.
	* 
	* Expected value:
	* |-9223372036854775808 + 86400000| = 9223372036768375808 milliseconds = 106751991166.30064392 days.
	* 
	* 106751991166 is undefined for an integer, so the expected value is null.
	* 
	* @author  Kevin Arindaeng
	* @version 1.1
	* @since 2018-03-02
	*/
	@Test
	public void minPlusDayOfEpoch() {
		Date minPlusDate = new Date(Long.MIN_VALUE + DAY_IN_MS); // 3 Dec 292269055 BC, 16:47:04.192 +0000
		Assert.assertEquals(null, DateUtil.dayOfEpoch(minPlusDate));
	}
	
	/**
	* Tests that the number of days from (1 Jan 1970 AD, 11:00:00.0 +0000) to (1 Jan 1970 AD, 11:00:00.0 +0000)
	* is correct.
	* 
	* Expected value: 0 milliseconds = 0 days
	* 
	* @author  Kevin Arindaeng
	* @version 1.1
	* @since 2018-03-02
	*/
	@Test
	public void nominalDayOfEpoch() {
		Date nominalDate = new Date(0l); // 1 Jan 1970 AD, 11:00:00.0 +0000
		Assert.assertEquals(0, DateUtil.dayOfEpoch(nominalDate));
	}
	
	/**
	* Tests that the number of days from (1 Jan 1970 AD, 11:00:00.0 +0000) to (16 Aug 292278994 AD, 07:12:55.807 +0000)
	* is correct.
	* 
	* Expected value:
	* |9223372036854775808 - 86400000| = 9223372036768375808 milliseconds = 106751991166.30064392 days.
	* 
	* 106751991166 is undefined for an integer, so the expected value is null.
	* 
	* @author  Kevin Arindaeng
	* @version 1.1
	* @since 2018-03-02
	*/
	@Test
	public void maxMinusDayOfEpoch() {
		Date maxMinuxDate = new Date(Long.MAX_VALUE - DAY_IN_MS); // 16 Aug 292278994 AD, 07:12:55.807 +0000
		Assert.assertEquals(null, DateUtil.dayOfEpoch(maxMinuxDate));
	}
	
	/**
	* Tests that the number of days from (1 Jan 1970 AD, 11:00:00.0 +0000) to (17 Aug 292278994 AD, 07:12:55.807 +0000)
	* is correct.
	* 
	* Expected value:
	* 9223372036854775807 milliseconds = 106751991167.30064392 days
	* 
	* 106751991167 is undefined for an integer, so the expected value is null.
	* 
	* @author  Kevin Arindaeng
	* @version 1.1
	* @since 2018-03-02
	*/
	@Test
	public void maxDayOfEpoch() {
		Date maxDate = new Date(Long.MAX_VALUE); // 17 Aug 292278994 AD, 07:12:55.807 +0000
		Assert.assertEquals(null, DateUtil.dayOfEpoch(maxDate));
	}
	
	/**
	* Tests that the number of days from (1 Jan 1970 AD, 11:00:00.0 +0000) to (18 Aug 292278994 AD, 07:12:55.807 +0000)
	* is correct.
	* 
	* Expected value:
	* |9223372036854775808 + 86400000| = 9223372036941175808 milliseconds = 106751991168.30067444 days.
	* 
	* 106751991168 is undefined for an integer, so the expected value is null.
	* 
	* @author  Kevin Arindaeng
	* @version 1.1
	* @since 2018-03-02
	*/
	@Test
	public void maxPlusDayOfEpoch() {
		// Expected (18 Aug 292278994 AD, 07:12:55.807 +0000) but it overflows to (3 Dec 292269055 BC, 16:47:04.191 +0000) which produces the same output.
		Date maxPlusDate = new Date(Long.MAX_VALUE + DAY_IN_MS);
		Assert.assertEquals(null, DateUtil.dayOfEpoch(maxPlusDate));
	}

}
