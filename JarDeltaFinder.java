
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

    public class JarDeltaFinder {
    	
    	Map<String, String> replaceMentMap = new HashMap<String, String>();

        public void recurseAndAddJars( String path , String intialPath ,Map<String, Set<String>> moduleJarMap ) {

            File root = new File( path );
            File[] list = root.listFiles();

            if (list == null) return;

            for ( File f : list ) {
                if ( f.isDirectory() ) {
                	String pathDir = f.getAbsolutePath();
                	if(pathDir.contains(".metadata") || pathDir.contains("ZDrools") || pathDir.contains("Ztest") || pathDir.contains(".svn") 
                			|| pathDir.contains("build") || pathDir.contains("target") || pathDir.contains("src")){
                		continue;
                	}
                	if(pathDir.contains("dist") && pathDir.endsWith("lib")){
                		String module = pathDir.substring(intialPath.length()+1);
                		module = module.substring(0,module.indexOf("\\"));
//                		System.out.println("Dir:"+module);
                		File rootDir = new File(pathDir);
                		moduleJarMap.put(module, new TreeSet<String>());
                		File[] jars = rootDir.listFiles();
                		for(File jar : jars){
                			String name = jar.getName();
                			
                			moduleJarMap.get(module).add(name);
//                			System.out.println(jar.getName());
                		}
                		continue;
                	}
                    recurseAndAddJars( f.getAbsolutePath(),intialPath, moduleJarMap );
                }
                else {
                    
                }
            }
        }
        
        public static void main(String[] args) {
        	JarDeltaFinder ju = new JarDeltaFinder();
        	ju.replaceMentMap.put("US_export_policy.jar", "US_export_policy-cv-1.0.jar");
        	ju.replaceMentMap.put("apache-solr-solrj-1.4.1.jar", "solr-solrj-1.4.1.jar");
        	ju.replaceMentMap.put("ejb3-persistence-1.0.2.jar", "ejb3-persistence-1.0.2.GA.jar");
        	ju.replaceMentMap.put("frdoc.jar", "frdoc-Provided.jar");
        	ju.replaceMentMap.put("hadoop-0.19.1-core.jar", "hadoop-core-0.19.1.jar");
        	ju.replaceMentMap.put("hibernate-annotations-3.4.0.jar", "hibernate-annotations-3.4.0.GA.jar");
        	ju.replaceMentMap.put("hibernate-commons-annotations-3.1.0.jar", "hibernate-commons-annotations-3.1.0.GA.jar");
        	ju.replaceMentMap.put("hibernate-entitymanager-3.4.0.jar", "hibernate-entitymanager-3.4.0.GA.jar");
        	ju.replaceMentMap.put("hibernate3-3.3.1.jar", "hibernate-core-3.3.1.GA.jar");
        	ju.replaceMentMap.put("isorelax.jar", "isorelax-20030108.jar");
        	ju.replaceMentMap.put("jakarta-oro.jar", "oro-2.0.8.jar");
        	ju.replaceMentMap.put("javassist-3.4.jar", "javassist-3.19.0-GA.jar");
        	ju.replaceMentMap.put("javassist-3.4.jar", "javassist-3.4.GA.jar");
        	ju.replaceMentMap.put("jce1_2_2.jar", "jce-1.2.2.jar");
        	ju.replaceMentMap.put("jdbc2_0-stdext.jar", "jdbc-stdext-2.0.jar");
        	ju.replaceMentMap.put("jstl.jar", "jstl-1.1.2.jar");
        	ju.replaceMentMap.put("junit-4.7.jar", "junit-4.12.jar");
        	ju.replaceMentMap.put("junit-4.7.jar","junit-4.12.jar");
        	ju.replaceMentMap.put("language-identifier.jar", "language-identifier-0.jar");
        	ju.replaceMentMap.put("local_policy.jar", "local_policy-cv-1.0.jar");
        	ju.replaceMentMap.put("mail.jar", "mail-1.3.1.jar");
        	ju.replaceMentMap.put("msv.jar", "msv-20030225.jar");
        	ju.replaceMentMap.put("mysql-connector-java-5.1.6-bin.jar", "mysql-connector-java-5.1.6.jar");
        	ju.replaceMentMap.put("org.springframework.aop-3.0.1.RELEASE-A.jar", "spring-aop-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.asm-3.0.1.RELEASE-A.jar", "spring-asm-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.aspects-3.0.1.RELEASE-A.jar", "spring-aspects-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.beans-3.0.1.RELEASE-A.jar", "spring-beans-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.context-3.0.1.RELEASE-A.jar", "spring-context-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.context.support-3.0.1.RELEASE-A.jar", "spring-context-support-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.core-3.0.1.RELEASE-A.jar", "spring-core-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.expression-3.0.1.RELEASE-A.jar", "spring-expression-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.instrument-3.0.1.RELEASE-A.jar", "spring-instrument-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.instrument.tomcat-3.0.1.RELEASE-A.jar", "spring-instrument-tomcat-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.jdbc-3.0.1.RELEASE-A.jar", "spring-jdbc-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.jms-3.0.1.RELEASE-A.jar", "spring-jms-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.orm-3.0.1.RELEASE-A.jar", "spring-orm-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.oxm-3.0.1.RELEASE-A.jar", "spring-oxm-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.test-3.0.1.RELEASE-A.jar", "spring-test-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.web-3.0.1.RELEASE-A.jar", "spring-web-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.web.portlet-3.0.1.RELEASE-A.jar", "spring-webmvc-portlet-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("org.springframework.web.struts-3.0.1.RELEASE-A.jar", "spring-struts-3.0.1.RELEASE.jar");
        	ju.replaceMentMap.put("qazi.jar", "qazi-Provided.jar");
        	ju.replaceMentMap.put("relaxngDatatype.jar", "relaxngDatatype-20020414.jar");
        	ju.replaceMentMap.put("standard.jar", "standard-1.1.2.jar");
        	ju.replaceMentMap.put("sunjce_provider.jar", "sunjce_provider-cv-1.0.jar");
        	ju.replaceMentMap.put("xercesImpl.jar", "xercesImpl-0.jar");
        	ju.replaceMentMap.put("xml-apis.jar", "xml-apis-0.jar");
        	ju.replaceMentMap.put("xsdlib.jar", "xsdlib-20030225.jar");
		ju.replaceMentMap.put("apache-solr-core-1.4.1.jar", "solr-solrj-1.4.1.jar");
		ju.replaceMentMap.put("Jamsel.jar", "Jamsel-1.0.0.jar");
		


//        	ju.replaceMentMap.put("commons-lang-2.1.jar", "commons-lang-2.6.jar");
//        	ju.replaceMentMap.put("infinispan-core-5.2.1.Final.jar", "infinispan-core-6.0.0.Final.jar");
//        	ju.replaceMentMap.put("infinispan-core.jar", "infinispan-core-6.0.0.Final.jar");
        	
        	
        	Map<String, Set<String>> moduleJarMapAnt = new TreeMap<String, Set<String>>();
        	String path1 = "C:\\Users\\vpathak\\Desktop\\Build Comparision\\Old\\Trunk";
        	String path2 = "C:\\Users\\vpathak\\Desktop\\Build Comparision\\maven\\Trunk";
        	ju.recurseAndAddJars(path1,path1, moduleJarMapAnt);
        	System.out.println("Ant map:"+moduleJarMapAnt.keySet());
//        	for(Entry<String, Set<String>> entry : moduleJarMapTrunk.entrySet()){
//        		System.out.println(entry.getKey()+" - "+entry.getValue());
//        	}
//        	System.exit(0);
//            System.out.println(moduleJarMapTrunk);
            Map<String, Set<String>> moduleJarMapMaven = new HashMap<String, Set<String>>();
            ju.recurseAndAddJars(path2,path2,moduleJarMapMaven);
            System.out.println("Maven map:"+moduleJarMapMaven.keySet());
            for(String modules : moduleJarMapAnt.keySet()){
            	Set<String> AntJar  = moduleJarMapAnt.get(modules);
            	Set<String> mavenJars = moduleJarMapMaven.get(modules);
            	System.out.println("\n---------------------------------\nModule:"+modules+"\n---------------------------------");
            	for(String jar : AntJar){
            		String jarVer = jar.substring(0,jar.lastIndexOf("."))+"-1.0-Trunk.jar";
            		String jarAltName = ju.replaceMentMap.containsKey(jar)?ju.replaceMentMap.get(jar):jar;
            		if(mavenJars!=null && !(mavenJars.contains(jar) || mavenJars.contains(jarVer) || mavenJars.contains(jarAltName))){
            			System.out.println(jar);
            		}
            	}
            	System.out.println("---------------------------------");
//            	if(mavenJars == null){
//            		System.out.println("Module "+modules+" not in branch");
//            		continue;
//            	}
//            	for(String jar : mavenJars){
//            		if(AntJar!= null && !AntJar.contains(jar)){
//            			if(jar.contains("infinispan-commons-6.0.0.Final.jar")){
//            				continue;
//            			}
//            			System.out.println(jar+"  -  "+modules+"  -  Trunk");
//            		}
//            	}
            }
            
        }
    }