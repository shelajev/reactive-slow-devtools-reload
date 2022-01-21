Sample project to explore reload time with devtools. 

Using Java 17, application starts very fast: 
```
2022-01-21 21:14:48.494  INFO 96273 --- [  restartedMain] com.example.demo.DemoApplication         : Started DemoApplication in 0.65 seconds (JVM running for 0.992)
```

When changing source in the IDE, I used to change the String value in the controller, application stops for around 2s when closing: 

```
2022-01-21 21:15:15.545 DEBUG 96273 --- [       Thread-5] o.s.boot.devtools.restart.Restarter      : Stopping application
2022-01-21 21:15:15.545 DEBUG 96273 --- [       Thread-5] o.s.b.a.ApplicationAvailabilityBean      : Application availability state ReadinessState changed from ACCEPTING_TRAFFIC to REFUSING_TRAFFIC
2022-01-21 21:15:15.545 DEBUG 96273 --- [       Thread-5] onfigReactiveWebServerApplicationContext : Closing org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext@5a555b15, started on Fri Jan 21 21:14:48 EET 2022
2022-01-21 21:15:15.550 DEBUG 96273 --- [       Thread-5] ySourcesPropertyResolver$DefaultResolver : Found key 'spring.liveBeansView.mbeanDomain' in PropertySource 'systemProperties' with value of type String
2022-01-21 21:15:17.691 DEBUG 96273 --- [       Thread-5] o.s.b.d.r.c.RestartClassLoader           : Created RestartClassLoader org.springframework.boot.devtools.restart.classloader.RestartClassLoader@63aaaaf3
```

This is using webflux, allegedly if it doesn't use reactive stack, the restart is instant. 
