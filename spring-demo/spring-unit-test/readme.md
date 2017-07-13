maven：
	在 src/main/asciidoc 下创建 *.adoc
	
gradle：
	在 src/docs/asciidoc	下创建 *.adoc
	maven 会影响 gradle 的生成，需要 mvn clean 并把 pom.xml 移走