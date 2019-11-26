# 基于SpringCloud微服务搭建
## 一、版本兼容性问题：

| Spring Cloud             | Spring Boot                                    |
| ------------------------ | ---------------------------------------------- |
| Angel版本                | 兼容Spring Boot 1.2.x                          |
| Brixton版本              | 兼容Spring Boot 1.3.x，也兼容Spring Boot 1.4.x |
| Camden版本               | 兼容Spring Boot 1.4.x，也兼容Spring Boot 1.5.x |
| Dalston版本、Edgware版本 | 兼容Spring Boot 1.5.x，不兼容Spring Boot 2.0.x |
| Finchley版本             | 兼容Spring Boot 2.0.x，不兼容Spring Boot 1.5.x |
| Greenwich版本            | 兼容Spring Boot 2.1.x                          |

## 二、版本介绍

| 版本号        | 版本意义     | 介绍                                                         |
| ------------- | ---------- | ------------------------------------------------------------ |
| BUILD-XXX     | 开发版     | 开发团队内部使用，不是很稳定                                 |
| GA            | 稳定版     | 相比于开发版，基本上可以使用了                               |
| PRE（M1、M2） | 里程碑版   | 主要是修复了一些BUG的版本，一个GA后通常有多个里程碑版        |
| RC            | 候选发布版 | 该阶段的软件类似于最终版的一个发行观察期，基本只修复比较严重的BUG |
| SR            | 正式发布版 | 正式                                                         |

## 三、工程创建

### 1、创建父工程

 父工程主要用来统一管理相关jar的版本，防止各个子工程乱引入不同版本的jar

#### 1）创建 project File > New > Project

![image](https://github.com/liyi828328/microservice-springcloud/raw/master/screenshot/parent_1.png)

#### 2）创建maven项目

![image](https://github.com/liyi828328/microservice-springcloud/raw/master/screenshot/parent_2.png)

#### 3）填写groupid以及artifactid，然后创建完成

![image](https://github.com/liyi828328/microservice-springcloud/raw/master/screenshot/parent_3.png)

#### 4）修改pom文件

```.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>perseverance.li</groupId>
    <artifactId>microservice-springcloud</artifactId>
    <version>1.0.0</version>
    <packaging>pom</packaging> <!-- 父工程指定packaging为pom -->

    <properties>
        <!-- 配置jdk版本,编码等 -->
        <java.version>1.8</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <maven.compiler.encoding>UTF-8</maven.compiler.encoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <!-- 指定相关依赖的版,公共依赖可在父pom中指定 -->
        <spring-boot.version>2.1.10.RELEASE</spring-boot.version>
        <spring-cloud.version>Greenwich.SR4</spring-cloud.version>
        <mybatis.version>2.1.1</mybatis.version>
        <druid.version>1.1.20</druid.version>
        <mysql.connector.version>5.1.48</mysql.connector.version>
    </properties>

    <!-- 声明所有子项目 -->
    <modules>
        <module>eureka-server-8760</module>
        <module>eureka-server-8761</module>
        <module>eureka-server-8762</module>
        <module>provider-books</module>
        <module>consumer-books</module>
        <module>base-api</module>
    </modules>

    <!-- 公共的依赖需要在dependencyManagement中声明,
        子项目引入时则只需要使用dependencies.dependency引入即可,不用再指定版本,会继承父pom中指定的版本 -->
    <dependencyManagement>
        <dependencies>
            <!-- boot -->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <!-- cloud -->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <!-- mybatis starter -->
            <dependency>
                <groupId>org.mybatis.spring.boot</groupId>
                <artifactId>mybatis-spring-boot-starter</artifactId>
                <version>${mybatis.version}</version>
            </dependency>
            <!-- druid starter -->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid-spring-boot-starter</artifactId>
                <version>${druid.version}</version>
            </dependency>
            <!-- mysql connector -->
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql.connector.version}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>
```

### 2、创建 Eureka server集群注册中心

 #### 1）创建module  File > New > Module

![image](https://github.com/liyi828328/microservice-springcloud/raw/master/screenshot/child_1.png)

 #### 2）使用Spring Initializr创建工程

![image](https://github.com/liyi828328/microservice-springcloud/raw/master/screenshot/child_2.png)

![image](https://github.com/liyi828328/microservice-springcloud/raw/master/screenshot/child_3.png)

 #### 3）修改子工程pom文件

```.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <!-- 继承父工程 -->
    <parent>
        <groupId>perseverance.li</groupId>
        <artifactId>microservice-springcloud</artifactId>
        <version>1.0.0</version>
        <relativePath>../pom.xml</relativePath>
    </parent>

    <!-- 因为继承了父工程,这里可以去掉GV两个设置,保留A即可 -->
    <artifactId>eureka-server-8760</artifactId>
    <description>eureka server port 8760</description>

    <!-- 打包为可执行的jar或者war包 -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>2.1.0.RELEASE</version>
                <configuration>			          
                    <mainClass>perseverance.li.eureka.server.EurekaServer8760Application</mainClass>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

    <dependencies>
        <!-- 引入依赖,如果已经父工程中声明,这里引入时不需要指定version -->
        <!-- 引入非父工程声明的依赖时,需要指定版本 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
    </dependencies>
</project>
```

#### 4） 修改Eureka 注册中心工程文件application.yml

```.yml
# >>>>> 8760注册中心 application.yml <<<<<
server:
  port: 8760
eureka:
  instance:
    hostname: eureka8760.com
  client:
    register-with-eureka: false #不将自己注册到eureka
    fetch-registry: false #不从eureka上获取服务的注册信息
    service-url:
      defaultZone: http://eureka8761.com:8761/eureka/,http://eureka8762.com:8762/eureka/ #集群
  server:
    enable-self-preservation: true #开启自我保护机制

# >>>>> 8761注册中心 application.yml <<<<<
server:
  port: 8761
eureka:
  instance:
    hostname: eureka8761.com
  client:
    register-with-eureka: false #不将自己注册到eureka
    fetch-registry: false #不从eureka上获取服务的注册信息
    service-url:
      defaultZone: http://eureka8760.com:8760/eureka/,http://eureka8762.com:8762/eureka/
  server:
    enable-self-preservation: true #开启自我保护机制

# >>>>> 8762注册中心 application.yml <<<<<
server:
  port: 8762
eureka:
  instance:
    hostname: eureka8762.com
  client:
    register-with-eureka: false #不将自己注册到eureka
    fetch-registry: false #不从eureka上获取服务的注册信息
    service-url:
      defaultZone: http://eureka8760.com:8760/eureka/,http://eureka8761.com:8761/eureka/
  server:
    enable-self-preservation: true #开启自我保护机制
```

 如果是本地测试可通过修改host文件添加相关域名指向

#### 5）添加启动方法（@EnableEurekaServer）

```.java
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer8760Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer8760Application.class, args);
    }
}
```

### 3、创建服务提供者（provider-books）

#### 1）工程创建

  	 同上注册中心创建

#### 2）编写相关 Service Dao Controller 等相关代码

#### 3）修改application.yml，添加注册中心相关配置

```.yml
server:
  port: 8001
spring:
  application:
    name: provider-books #这个name很重要，用于服务注册
#... 省略其他配置 ...
eureka:
  client:
    service-url:
      defaultZone: http://eureka8760.com:8760/eureka/,http://eureka8761.com:8761/eureka/,http://eureka8762.com:8762/eureka/
  instance:
    instance-id: provider-books8001
    prefer-ip-address: true
#... 省略其他配置 ...
```

#### 4）启动服务 

  启动服务后即可完成注册，可到eureka后台查看。

![image](https://github.com/liyi828328/microservice-springcloud/raw/master/screenshot/eureka_1.png)

 ### 4、创建服务消费者（consumer-books）

#### 1）工程创建

  同上注册中心创建 

#### 2）修改application.yml

```.yml
server:
  port: 9001
spring:
  application:
    name: consumer-books
  jackson:
    default-property-inclusion: non_null   #如果返回的对象为空则不展示
eureka:
  client:
    service-url:
      defaultZone: http://eureka8760.com:8760/eureka/,http://eureka8761.com:8761/eureka/,http://eureka8762.com:8762/eureka/
  instance:
    instance-id: consumer-books9001
    prefer-ip-address: true
```

####3）创建RestTemplate配置文件 

  消费者访问服务通过RestTemplate发送http请求的方式访问

```.java
@Configuration
public class ConsumerConfig {
    @Bean
    @LoadBalanced //TODO:集群情况下需要加负载
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
```

#### 4）服务访问

```.java
@RestController
public class ConsumerController {

    private static final String REST_PREFIX = "http://PROVIDER-BOOKS/";

    @Autowired //注入RestTemplate
    private RestTemplate restTemplate;


    @PostMapping("/consumer/book/add")
    public Boolean add(@RequestBody Book book) {
        //服务访问需要使用相关连接,url拼接方式为http://服务提供者名称/服务相关接口
        ResponseEntity<Boolean> reponse = restTemplate.postForEntity(REST_PREFIX + "/book/add",
                book, Boolean.class);
        System.out.println(reponse.toString());
        return reponse.getBody();
    }

    @GetMapping("/consumer/book/list")
    public List<Book> list() {
        String url = REST_PREFIX + "/book/list";
        List forObject = restTemplate.getForObject(url, List.class);
        return forObject;
    }
    
    //其它接口访问

}
```



#### 我在这里有几个坑点 ，需要踩一下 

- 子工程继承父工程后，IDEA没有报错，可正常引入相关依赖，但是在使用mvn package时报xx.jar找不到，这里需要在子工程parent中加入 

​       <relativePath>../pom.xml</relativePath> 

- 父工程通过dependencyManagement声明了相关依赖的版本信息，但是在子工程引入时如果不加version会出现xx依赖版本unknown的情况，这个问题可能是IDEA的maven配置引起的。 

- 第一种是可以使用IDEA内置的maven 

- 第二种是将 User settings file & Local repository 勾选 （这个是我这里遇到的） 

  ![image](https://github.com/liyi828328/microservice-springcloud/raw/master/screenshot/other_1.png)