package eecs4313a2b;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import net.sf.borg.common.DateUtil;

/**
 * A robust boundary value test case for the net.sf.borg.common.DateUtil.dayOfEpoch() method. 
 * 
 * This method returns the number of days since or past 1 Jan 1970 AD, 11:00:00.0 +0000
 *
 * @author Kevin Arindaeng
 * @version 1.0
 * @since 2018-03-02
 */

/*
 * <TODO> Manually check if the number of days is correct
 * Strategy: Robust boundary value testing
 * min- = Minimum possible value for a Date - 1 = Long.min - 1.0
 * min = Minimum possible value for a Date = Long.min
 * min+ = Minimum possible value for a Date + 1 = Long.min + 1.0
 * nom = 0
 * max- = Maximum value for a Date - 1 = Long.max - 1
 * max = Maximum value for a Date = Long.max
 * max+ = Maximum value for a Date + 1  = Long.max + 1
 * 
 */
public class DayOfEpochTest {
	
	/**
	* Tests that the number of days from (1 Dec 292269055 BC, 16:47:04.192 +0000) to (1 Jan 1970 AD, 11:00:00.0 +0000)
	* is correct.
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-02
	*/
	@Test
	public void minMinusDayOfEpoch() {
		// Expected (1 Dec 292269055 BC, 16:47:04.192 +0000) but it overflows to (17 Aug 292278994 AD, 07:12:55.807 +0000) which produces the same output.
		Date minMinusDate = new Date(Long.MIN_VALUE - 1l);
		Assert.assertEquals(622191234, DateUtil.dayOfEpoch(minMinusDate));
	}
	
	/**
	* Tests that the number of days from (2 Dec 292269055 BC, 16:47:04.192 +0000) to (1 Jan 1970 AD, 11:00:00.0 +0000)
	* is correct.
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-02
	*/
	@Test
	public void minDayOfEpoch() {
		Date minDate = new Date(Long.MIN_VALUE); // 2 Dec 292269055 BC, 16:47:04.192 +0000
		Assert.assertEquals(622191233, DateUtil.dayOfEpoch(minDate));
	}
	
	/**
	* Tests that the number of days from (3 Dec 292269055 BC, 16:47:04.192 +0000) to (1 Jan 1970 AD, 11:00:00.0 +0000)
	* is correct.
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-02
	*/
	@Test
	public void minPlusDayOfEpoch() {
		Date minPlusDate = new Date(Long.MIN_VALUE + 1l); // 3 Dec 292269055 BC, 16:47:04.192 +0000
		Assert.assertEquals(622191233, DateUtil.dayOfEpoch(minPlusDate));
	}
	
	/**
	* Tests that the number of days from (1 Jan 1970 AD, 11:00:00.0 +0000) to (1 Jan 1970 AD, 11:00:00.0 +0000)
	* is correct.
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
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
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-02
	*/
	@Test
	public void maxMinusDayOfEpoch() {
		Date maxMinuxDate = new Date(Long.MAX_VALUE - 1l); // 16 Aug 292278994 AD, 07:12:55.807 +0000
		Assert.assertEquals(622191234, DateUtil.dayOfEpoch(maxMinuxDate));
	}
	
	/**
	* Tests that the number of days from (1 Jan 1970 AD, 11:00:00.0 +0000) to (17 Aug 292278994 AD, 07:12:55.807 +0000)
	* is correct.
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-02
	*/
	@Test
	public void maxDayOfEpoch() {
		Date maxDate = new Date(Long.MAX_VALUE); // 17 Aug 292278994 AD, 07:12:55.807 +0000
		Assert.assertEquals(622191234, DateUtil.dayOfEpoch(maxDate));
	}
	
	/**
	* Tests that the number of days from (1 Jan 1970 AD, 11:00:00.0 +0000) to (18 Aug 292278994 AD, 07:12:55.807 +0000)
	* is correct.
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-02
	*/
	@Test
	public void maxPlusDayOfEpoch() {
		// Expected (18 Aug 292278994 AD, 07:12:55.807 +0000) but it overflows to (2 Dec 292269055 BC, 16:47:04.192 +0000) which produces the same output.
		Date maxPlusDate = new Date(Long.MAX_VALUE + 1);
		Assert.assertEquals(622191234, DateUtil.dayOfEpoch(maxPlusDate));
	}

}
