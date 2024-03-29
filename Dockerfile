## 基础镜像
#FROM openjdk:8-jdk-alpine
## 对应pom.xml文件中的dockerfile-maven-plugin插件buildArgs配置项JAR_FILE的值
#ARG JAR_FILE
## 复制打包完成后的jar文件到/opt目录下
#COPY ${JAR_FILE} /opt/app.jar
## 启动容器时执行
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]
## 使用端口80
##EXPOSE 80


FROM java:8
VOLUME /tmp
COPY target/demo-0.0.1-SNAPSHOT.jar /usr/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/app.jar"]


#FROM openjdk:8-jre
#MAINTAINER kaiser <kaiser9413@126.com>

#ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/myservice.jar"]

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
#ADD target/lib           /usr/share/myservice/lib
# Add the service itself
#ARG JAR_FILE
#ADD target/${JAR_FILE} /usr/share/myservice/myservice.jar