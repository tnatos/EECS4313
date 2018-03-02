package eecs4313a2b;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import net.sf.borg.common.DateUtil;

/**
 * This class is just used to play around with methods that will be used for testing.
 * 
 * @author Kevin Arindaeng
 */
public class Main {
	
	private final static long DAY_IN_MS = 86400000l;
	private final static long HOUR_IN_MS = 3600000l;
	
	public static void main(String args[]) {
		DateFormat df = new SimpleDateFormat("d MMM yyyy G, HH:mm:ss.S Z");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		/*
		 * DateUtil.dayOfEpoch():
		 * Expected: Returns the number of days since 1 Jan 1970 AD, 00:00:00.0 +0000 UTC
		 * Actual: Returns the number of days since 1 Jan 1970 AD, 11:00:00.0 +0000 UTC
		 */
		
		System.out.println("Min-");
		System.out.println(df.format(new Date(Long.MIN_VALUE - DAY_IN_MS)));
		System.out.println(DateUtil.dayOfEpoch(new Date(Long.MIN_VALUE - DAY_IN_MS)));
		
		System.out.println("\nMin");
		System.out.println(df.format(new Date(Long.MIN_VALUE)));
		System.out.println(DateUtil.dayOfEpoch(new Date(Long.MIN_VALUE)));
		
		System.out.println("\nMin+");
		System.out.println(df.format(new Date(Long.MIN_VALUE + DAY_IN_MS)));
		System.out.println(DateUtil.dayOfEpoch(new Date(Long.MIN_VALUE + DAY_IN_MS)));
		
		System.out.println("\nNom");
		System.out.println(df.format(new Date(0)));
		System.out.println(DateUtil.dayOfEpoch(new Date(0l)));
		
		System.out.println("\nMax-");
		System.out.println(df.format(new Date(Long.MAX_VALUE - DAY_IN_MS)));
		System.out.println(DateUtil.dayOfEpoch(new Date(Long.MAX_VALUE - DAY_IN_MS)));
		
		System.out.println("\nMax");
		System.out.println(df.format(new Date(Long.MAX_VALUE)));
		System.out.println(DateUtil.dayOfEpoch(new Date(Long.MAX_VALUE)));
		
		System.out.println("\nMax+");
		System.out.println(df.format(new Date(Long.MAX_VALUE + DAY_IN_MS)));
		System.out.println(DateUtil.dayOfEpoch(new Date(Long.MAX_VALUE + DAY_IN_MS)));
		
		System.out.println("\nOne day since Epoch = 1 day + 11 hours");
		System.out.println(df.format(new Date(DAY_IN_MS + (HOUR_IN_MS * 11))));
		System.out.println(DateUtil.dayOfEpoch(new Date(DAY_IN_MS + (HOUR_IN_MS * 11))));		
	
	}
}
