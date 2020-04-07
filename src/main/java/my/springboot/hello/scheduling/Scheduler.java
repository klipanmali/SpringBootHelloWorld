package my.springboot.hello.scheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	private static final Logger logger = LoggerFactory
			.getLogger(Scheduler.class);

	// Cron job
	@Scheduled(cron = "0 * 15 * * ?")
	public void chronJobSch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		logger.info("Cron job started at:" + strDate);

	}

	// FixedRate job in milliseconds
	@Scheduled(fixedRate = 20000)
	public void fixdRateSch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		logger.info("Fixed rate job started at:" + strDate);

		// this obviously is not the correct way to start a job, it blocks the
		// next fixed rate job
		// maybe with help of threads

		// try {
		// Thread.sleep(30000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// logger.info("fixedrate Slept some time");

	}

	// >>>> It looks like one scheduled job can block another one <<<<
	// >>>> if they are run this way. FixedDelay blocks FixedRate job <<<<
	// >>>> although FixedRate job should not wait for the completion of the
	// previous execution <<<<

	// FixedDelay job in milliseconds
	@Scheduled(fixedDelay = 75000, initialDelay = 75000)
	public void fixedDelaySch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		logger.info("Fixed delay job started at:" + strDate);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Slept some time");

	}
}
