package com.qf.util;

import junit.framework.TestCase;

public class Dependencies extends TestCase {

	protected void compile(String artifact, String... exclusions) {
		String[] tokens = artifact.split(":");
		String groupId = tokens[0];
		String artifactId = tokens[1];
		String version = tokens[2];
		String scope = tokens.length == 4 ? ("<scope>" + tokens[3] + "</scope>") : "";
		System.out.println(
				String.format("<dependency><groupId>%s</groupId><artifactId>%s</artifactId><version>%s</version>%s",
						groupId, artifactId, version, scope));
		if (exclusions != null && exclusions.length > 0) {
			System.out.println("\t<exclusions>");
			for (String exclusion : exclusions) {
				tokens = exclusion.split(":");
				groupId = tokens[0];
				artifactId = tokens[1];
				System.out.println(
						String.format("\t\t<exclusion><groupId>%s</groupId><artifactId>%s</artifactId></exclusion>",
								groupId, artifactId));
			}
			System.out.println("\t</exclusions>");
		}
		System.out.println("</dependency>");
	}

	public void testWebApp() {
		

	    compile("ca.uhn.hapi:hapi-base:2.2"
	        ,"commons-logging:commons-logging"
	        ,"commons-lang:commons-lang"
	    		);

	    compile("ca.uhn.hapi:hapi-structures-v251:2.2");
	    compile("ca.uhn.hapi:hapi-structures-v231:2.2");
	    compile("ca.uhn.hapi:hapi-structures-v23:2.2");
	    compile("ca.uhn.hapi:hapi-structures-v21:2.2");

	    compile("org.apache.poi:poi-ooxml:3.9","commons-codec:commons-codec");
	    compile("commons-codec:commons-codec:1.9");
	    compile("commons-dbcp:commons-dbcp:1.4");
	    compile("commons-net:commons-net:3.0.1");
	    compile("org.apache.cxf:cxf-rt-frontend-jaxws:2.6.1","org.apache.geronimo.specs:geronimo-javamail_1.4_spec","javax.xml.stream:stax-api");

	    compile("org.apache.httpcomponents:httpclient:4.5.2","commons-codec:commons-codec","commons-logging:commons-logging");

	    compile("org.codehaus.jackson:jackson-core-asl:1.9.5");
	    compile("org.codehaus.jackson:jackson-mapper-asl:1.9.5");
	    compile("com.fasterxml.jackson.core:jackson-annotations:2.3.0");

	    compile("org.apache.cxf:cxf-rt-transports-http:2.6.1", "org.apache.geronimo.specs:geronimo-javamail_1.4_spec", "javax.xml.stream:stax-api");
		
	    compile("org.apache.cxf:cxf-rt-ws-security:2.6.1"
	        ,"org.apache.geronimo.specs:geronimo-javamail_1.4_spec"
	        ,"javax.xml.stream:stax-api"
	        ,"joda-time:joda-time"
	        ,"org.apache.santuario:xmlsec"
	        ,"org.slf4j:slf4j-api"
	    );
		
	    compile("org.apache.santuario:xmlsec:1.5.2");

	    // Hibernate dependencies
	    compile("org.hibernate:hibernate-core:4.1.8.Final"
	        ,"org.jboss.logging:jboss-logging"
	    );
	    compile("org.jboss.logging:jboss-logging:3.1.0.GA");

	    compile("org.springframework:spring-jdbc:3.2.8.RELEASE");
	    compile("org.springframework:spring-orm:3.2.8.RELEASE");
	    compile("org.springframework.security.oauth:spring-security-oauth2:1.0.5.RELEASE"
	        ,"commons-codec:commons-codec"
	        ,"org.springframework:spring-webmvc"
	        ,"org.codehaus.jackson:jackson-mapper-asl"
	    );
	    compile("org.codehaus.jackson:jackson-mapper-asl:1.9.5");
	    compile("org.springframework:spring-webmvc:3.2.8.RELEASE");
	    compile("org.springframework.security:spring-security-core:3.2.8.RELEASE");
	    compile("org.springframework:spring-oxm:3.2.8.RELEASE");
	    compile("org.springframework.security:spring-security-web:3.2.8.RELEASE");
	    compile("org.springframework.security:spring-security-config:3.2.8.RELEASE");

	    // Uses Castor for XML
	    compile("org.codehaus.castor:castor:1.2");
	    // Castor needs this
	    compile("xerces:xercesImpl:2.11.0");

	    compile("org.springframework:spring-tx:3.2.8.RELEASE");
	    compile("org.springframework:spring-context-support:3.2.8.RELEASE");
	    compile("org.jadira.usertype:usertype.jodatime:2.0.1");
	    compile("org.drools:drools-core:5.5.0.Final"
	        ,"org.slf4j:slf4j-api"
	    );
	    compile("org.drools:drools-compiler:5.5.0.Final"
	        ,"org.slf4j:slf4j-api"
	    );
	    compile("javax.mail:mail:1.4.7");
	    compile("dom4j:dom4j:1.6.1");
	    compile("javax.servlet:servlet-api:2.5");
	    compile("javax.xml.ws:jaxws-api:2.2.6");
	    compile("com.sun.xml.messaging.saaj:saaj-impl:1.3");
	    compile("commons-discovery:commons-discovery:0.2");
	    compile("javax.xml:jaxrpc-api:1.1");
	    compile("wsdl4j:wsdl4j:1.6.2");
	    compile("org.apache.axis:axis:1.4");
	    compile("org.springframework.ws:spring-ws-core:2.2.0.RELEASE"
	        ,"org.springframework:spring-aop"
	        ,"org.springframework:spring-beans"
	        ,"org.springframework:spring-context"
	        ,"org.springframework:spring-core"
	        ,"org.springframework:spring-oxm"
	        ,"org.springframework:spring-web"
	        ,"org.springframework:spring-webmvc"
	    );
	    compile("jaxen:jaxen:1.1.3"
	        ,"xml-apis:xml-apis"
	        ,"xerces:xercesImpl"
	        ,"xom:xom"
	        ,"maven-plugins:maven-cobertura-plugin"
	        ,"maven-plugins:maven-findbugs-plugin"
	        ,"jdom:jdom"
	    );

	    compile("com.oracle:ojdbc6:11.2.0.2.0:provided");
	    compile("com.oracle:ojdbc6:11.2.0.2.0");
	}
}
