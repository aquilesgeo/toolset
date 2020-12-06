package pe.ec.mibatis;

import org.junit.Test;

public class StormConfig  extends Mapping{
	public StormConfig(){
		super("com.qsi.util.storm.config");
	}
	@Test
	public void generateTopology() {
		table("SOURCE_TOPOLOGY").alias("topology").entity("Topology")
			.id("SOURCE_TOPOLOGY_ID", "id")
			.col("TOPOLOGY_NAME", "name")
			.col("GROUP_ID", "groupId")
			.col("STATUS", "status");
		form("Edit Topic").object("topic")
			.hidden("id").prop()
			.input("Name", "name").prop()
			.input("Group", "groupId").prop();
		form("Add Topic")
			.input("Name", "name")
			.input("Group", "groupId");
	}

	@Test
	public void generateConfig() {
		table("SOURCE_TOPOLOGY_CONFIG").alias("config").entity("TopologyConfig")
			.id("SOURCE_TOPOLOGY_CONFIG_ID", "id")
			.col("KEY", "key")
			.col("VALUE", "value");
	}
	
	@Test
	public void generateTopic() {
		table("SOURCE_TOPIC").alias("topic").entity("Topic")
			.id("SOURCE_TOPIC_ID", "id")
			.col("SOURCE_TOPOLOGY_ID", "topologyId")
			.col("TOPIC_NAME", "name")
			.col("STATUS", "status");
	}
	
	@Test
	public void generateTable() {
		
	}
}
