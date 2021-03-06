# javaee-legacy-app-example

# Stack

- JBoss 4.0.5
- JSP
- Struts 1.1
- EJB 2.1

# Glossary

- JSP - Java Server Pages (https://pt.wikipedia.org/wiki/JavaServer_Pages)
- JAR - Java Archive (https://en.wikipedia.org/wiki/JAR_(file_format))
- WAR - Web Application Resource or Web application ARchive (https://en.wikipedia.org/wiki/WAR_(file_format))
- EAR - Enterprise Application aRchive (https://en.wikipedia.org/wiki/EAR_(file_format))
- EJB - Enterprise Java Beans (https://en.wikipedia.org/wiki/Enterprise_JavaBeans)
- JAAS - Java Authentication & Authorization Service

# Getting started

We should add a new "Application Policy" into the jboss/server/default/conf/login-config.xml.

```
<application-policy name = "app-security-domain">
    <authentication>
        <login-module code = "com.example.jaas.MyLoginModule" flag = "required">
        </login-module>
    </authentication>
</application-policy>
```

# Structure

- /app-ear/META-INF/application.xml - [Java EE Deployment Descriptor](http://www.oracle.com/webfolder/technetwork/jsc/xml/ns/javaee/index.html)
- /app-web/WebRoot/META-INF/MANIFEST.MF
- /app-web/WebRoot/WEB-INF/web.xml
- /app-web/WebRoot/index.jsp

# Libraries

## Struts 1.1

```
/app-web/WebRoot/WEB-INF/lib/commons-beanutils.jar
/app-web/WebRoot/WEB-INF/lib/commons-collections.jar
/app-web/WebRoot/WEB-INF/lib/commons-digester.jar
/app-web/WebRoot/WEB-INF/lib/commons-fileupload.jar
/app-web/WebRoot/WEB-INF/lib/commons-lang.jar
/app-web/WebRoot/WEB-INF/lib/commons-logging.jar
/app-web/WebRoot/WEB-INF/lib/commons-validator.jar
/app-web/WebRoot/WEB-INF/lib/jakarta-oro.jar
/app-web/WebRoot/WEB-INF/lib/struts.jar
/app-web/WebRoot/WEB-INF/lib/struts-legacy.jar
```

# References

- [Creating JSP in Eclipse with Tomcat server](https://www.javatpoint.com/creating-jsp-in-eclipse-ide)
- [Version of Tomcat in JBossAS](https://developer.jboss.org/wiki/VersionOfTomcatInJBossAS)
- [Java para Desenvolvimento Web](https://www.caelum.com.br/apostila-java-web/)
- [Struts Tools Tutorial](https://docs.jboss.org/tools/4.0.1.Final/en/struts_tools_tutorial/html_single/index.html)
- [Desenvolvendo um cadastro simples com Struts](https://www.devmedia.com.br/desenvolvendo-um-cadastro-simples-com-struts/6365)
