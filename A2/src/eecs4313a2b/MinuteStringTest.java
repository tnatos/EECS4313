package eecs4313a2b;

import org.junit.Assert;
import org.junit.Test;
import net.sf.borg.common.DateUtil;

/**
 * A weak robust equivalence class test case for the DateUtil.minuteString() method. 
 * 
 * Specification:
 * 
 * public String net.sf.borg.common.DateUtil.minuteString(int mins)
 * 
 * This method returns the number of minutes in a String readable format. (ie. "X Hour(s) X Minute(s))
 * The argument is the number of minutes represented as an integer.
 *
 * @author Kevin Arindaeng
 * @version 1.0
 * @since 2018-03-03
 */

/* Strategy: Weak robust equivalence class testing
	- WR1: Less than minimum time (negative) = -1 Minutes
	- WR2: Minimum possible time = 0 Minutes
	- WR3: No hour with a singular minute = 1 Minute
	- WR4: No hour with plural minutes = 59 Minutes
	- WR5: Singular hour with no minutes = 1 Hour
	- WR6: Singular hour with a singular minute = 1 Hour and 1 Minute
	- WR7: Singular hour with plural minutes = 1 Hour and 2 Minutes
	- WR8: Plural hour with a singular minute = 2 Hours and 1 Minute
	- WR9: Plural hours with plural minutes =  6 Hours and 30 Minutes
	- WR10: Maximum possible time = 35791394 Hours and 7 Minutes
	- WR11: Greater than maximum time = 35791394 Hours and 8 Minutes
 */
public class MinuteStringTest {
		
	/**
	* WR1: Tests for time less than the possible minimum.
	* 
	* Expected value: "-1 Minutes"
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-03
	*/
	@Test
	public void lessThanMinTime() {
		Assert.assertEquals("-1 Minutes", DateUtil.minuteString(-1));
	}
	
	/**
	* WR2: Tests for time equal to the possible minimum.
	* 
	* Expected value: "0 Minutes"
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-03
	*/
	@Test
	public void minTime() {
		Assert.assertEquals("0 Minutes", DateUtil.minuteString(0));
	}

	/**
	* WR3: Tests for time with no hour and a singular minute.
	* 
	* Expected value: "1 Minute"
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-03
	*/
	@Test
	public void noHoursSingularMinutesTime() {
		Assert.assertEquals("1 Minute", DateUtil.minuteString(1));
	}
	
	/**
	* WR4: Tests for time with no hour and plural minutes.
	* 
	* Expected value: "59 Minutes"
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-03
	*/
	@Test
	public void noHoursPluralMinutesTime() {
		Assert.assertEquals("59 Minutes", DateUtil.minuteString(59));
	}
	
	/**
	* WR5: Tests for time with a singular hour and no minutes.
	* 
	* Expected value: "1 Hour"
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-03
	*/
	@Test
	public void singularHoursNoMinutesTime() {
		Assert.assertEquals("1 Hour", DateUtil.minuteString(60));
	}
	
	/**
	* WR6: Tests for time with a singular hour and a singular minute.
	* 
	* Expected value: "1 Hour 1 Minute"
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-03
	*/
	@Test
	public void singularHoursSingularMinutesTime() {
		Assert.assertEquals("1 Hour 1 Minute", DateUtil.minuteString(61));
	}
	
	/**
	* WR7: Tests for time with a singular hour and plural minutes.
	* 
	* Expected value: "1 Hour 2 Minutes"
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-03
	*/
	@Test
	public void singularHoursPluralMinutesTime() {
		Assert.assertEquals("1 Hour 2 Minutes", DateUtil.minuteString(62));
	}
	
	/**
	* WR8: Tests for time with plural hours and a singular minute.
	* 
	* Expected value: "2 Hours 1 Minute"
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-03
	*/
	@Test
	public void pluralHoursSingularMinutesTime() {
		Assert.assertEquals("2 Hours 1 Minute", DateUtil.minuteString(121));
	}
	
	/**
	* WR9: Tests for time with plural hours and plural minutes.
	* 
	* Expected value: "6 Hours 30 Minutes"
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-03
	*/
	@Test
	public void pluralHoursPluralMinutesTime() {
		Assert.assertEquals("6 Hours 30 Minutes", DateUtil.minuteString(390));
	}
	
	/**
	* WR10: Tests for the maximum possible time.
	* 
	* Expected value: "35791394 Hours 7 Minutes"
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-03
	*/
	@Test
	public void maxTime() {
		Assert.assertEquals("35791394 Hours 7 Minutes", DateUtil.minuteString(Integer.MAX_VALUE));
	}
	
	/**
	* WR10: Tests for greater than the maximum possible time. (Expected to fail due to Integer overflow).
	* 
	* Expected value: "35791394 Hours 8 Minutes"
	* 
	* @author  Kevin Arindaeng
	* @version 1.0
	* @since 2018-03-03
	*/
	@Test
	public void greaterThanMaxTime() {
		Assert.assertEquals("Expected to fail due to Integer overflow.", "35791394 Hours 8 Minutes", DateUtil.minuteString(Integer.MAX_VALUE + 1));
	}
}
