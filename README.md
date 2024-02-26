## SSM构建一个游戏后端笔记
### Maven相关
1. 在安装好Maven后，IDEA设置（这里设置了阿里云镜像）相关配置之后发现如下问题：
   1. 总有些POM文件无法下载，提示找不到对应的依赖
   2. 发现总是Maven镜像配置后仍然从 http://repo.maven.apache.org/maven2 下载
   3. 这样不仅需要在conf/setting进行镜像配置如下：
   ```xml
    <mirrors>
         <mirror>
              <id>alimaven</id>
              <mirrorOf>central</mirrorOf>
              <name>aliyun maven</name>
              <url>http://maven.aliyun.com/nexus/content/repositories/central/</url>
         </mirror>
    </mirrors>
    ```
    4. 还需要在IDEA的POM文件中进行配置，如下：
    ```xml
    <repositories>
        <repository>
            <id>nexus-aliyun</id>
            <name>nexus-aliyun</name>
            <url>https://maven.aliyun.com/nexus/content/groups/public/</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>
    ```
   5. 这样才能保证Maven从阿里云镜像下载依赖,(maven 3.8以后都改成了https，所以需要修改为https)
2. Maven自带的Tomcat
   1. maven自带的tomcat版本默认是 6的版本，目前升到了7，升到8可以体验一下tomcat热部署的功能（有机会再试试）
   2. 在pom.xml中添加如下配置：
   ```xml
    <plugin>
         <groupId>org.apache.tomcat.maven</groupId>
         <artifactId>tomcat7-maven-plugin</artifactId>
         <version>2.2</version>
         <configuration>
              <port>8080</port>
              <path>/</path>
         </configuration>
    </plugin>
    ```