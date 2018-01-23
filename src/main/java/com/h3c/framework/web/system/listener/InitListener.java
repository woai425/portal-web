package com.h3c.framework.web.system.listener;

import java.io.InputStream;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.h3c.framework.H3cException;
import com.h3c.framework.common.CodeManager;
import com.h3c.framework.util.GlobalNames;
import com.h3c.framework.util.LicenseUtil;
import com.h3c.framework.web.system.quartz.IPortalQuartzJob;

/**
 * 
 * 系统初始化监听器,在系统启动时运行,进行一些初始化工作
 * 
 * @author 周兆巍
 * @version 创建时间：2014年12月17日 上午10:36:03
 */
public class InitListener implements javax.servlet.ServletContextListener {
	private Logger log;

	public void contextDestroyed(ServletContextEvent arg0) {
		WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
		Scheduler job = (Scheduler) ctx.getBean("scheduler");
		try {
			if (job.isStarted()) {
				job.shutdown();
				log.info("Scheduler job shutdown!");
				Thread.sleep(1000);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("H3CPlatform has been stopped.");
	}

	public void contextInitialized(ServletContextEvent event) {
		log = Logger.getLogger(InitListener.class);
		log.info("H3CPlatform License cache...");
		Thread keyThread = new Thread(new Runnable() {
			public void run() {
				try {
					LicenseUtil.parseLicenseXml();
					LicenseUtil.initKeySeed();
				} catch (Exception e) {
					log.error("license 秘钥生成失败！", e);
					return;
				}
			}
		}, "keyThread");
		keyThread.start();
		log.info("H3CPlatform Starting...");
		// event.getServletContext().log("H3CPlatform Starting...");
		log.info("Loading Public Resources...");
		// event.getServletContext().log("Loading Public Resources...");
		log.info("Loading SysConfig.xml");
		// event.getServletContext().log("Loading SysConfig.xml");
		InputStream inputstream = this.getClass().getClassLoader().getResourceAsStream("/conf/sysconfig.xml");
		GlobalNames.readConfiguration(inputstream);
		GlobalNames.readConfiguration();
		// event.getServletContext().log("H3CPlatform is Started");

		log.info("Init SysCode");
		try {
			CodeManager.getCodeManager().initDdMap();
		} catch (H3cException e) {
			log.info("Init SysCode Error:" + e.getMessage());
		}
		
		log.info("Init QuartzJob");
		try {
			@SuppressWarnings("unchecked")
			Class<? extends IPortalQuartzJob> clazz = (Class<? extends IPortalQuartzJob>) Class
					.forName(GlobalNames.sysConfig.get("QUARTZ_JOB_INIT_CLASS"));
			IPortalQuartzJob job = (IPortalQuartzJob) clazz.newInstance();
			job.initQuartzJob();
		} catch (Exception e) {
			log.info("Init QuartzJob Error:" + e.getMessage());
		}
		log.info("H3CPlatform is Started");

	}

}
