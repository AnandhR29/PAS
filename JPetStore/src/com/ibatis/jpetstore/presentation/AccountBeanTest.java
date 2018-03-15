package com.ibatis.jpetstore.presentation;

import java.io.File;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkHistoryChart;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;
import com.carrotsearch.junitbenchmarks.annotation.LabelType;
import com.carrotsearch.junitbenchmarks.h2.H2Consumer;

@AxisRange(min = 0, max = 1)
@BenchmarkMethodChart(filePrefix = "/Benchmark-barchart")
@BenchmarkHistoryChart(filePrefix = "/Benchmark-history-chart", labelWith = LabelType.TIMESTAMP,maxRuns = 20)

public class AccountBeanTest {

	AccountBean accountBean=new AccountBean();
	private static final H2Consumer consumer = new H2Consumer(

	            new File("D:/ContinousIntegration/WorkingDirectory/Benchmarkchart"),

	            new File("D:/ContinousIntegration/WorkingDirectory/Benchmarkchart"),

	            "custom-build-key");
    @Rule   
    public TestRule benchmarkRun = new BenchmarkRule(consumer);
    
	@Test
	public void testSignon() {
		accountBean.setUsername("j2ee");
		accountBean.setPassword("j2ee");
	Assert.assertEquals("success", accountBean.signon());
	}

}
