package pe.ec.mibatis;

import org.junit.Test;

public class Multitenant extends Mapping{
	
	public Multitenant(){
		super("com.qsi.util.multitenant");
	}
	@Test
	public void generateSystem() {
		table("MULTITENANTSYSTEM")
			.alias("system")
			.entity("System")
			.col("CODE","code")
			.col("STATUS","status");
	}

	@Test
	public void generateConnection() {
		table("MULTITENANTCONNECTION")
			.alias("connection")
			.entity("Connection")
			.col("CODE","code")
			.col("JDBCURL", "jdbcUrl")
			.col("USERNAME", "userName")
			.col("PASSWORD", "password")
			.col("DRIVERCLASSNAME", "driverClassName")
			.col("CONNECTIONPOOLTYPE", "connectionPoolType")
			.col("STATUS", "status");
	}
	
	@Test
	public void generateConnectionDetail() {
		table("MULTITENANTCONNECTIONDETAIL")
			.alias("detail")
			.entity("ConnectionDetail")
			.col("MULTITENANTCONNECTIONID", "connectionId")
			.col("CONNECTIONKEY", "connectionKey")
			.col("CONNECTIONVALUE", "connectionValue")
			.col("STATUS", "status");
	}
}
