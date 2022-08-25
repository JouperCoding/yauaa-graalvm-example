Swagger
```
http://localhost:[randomPort]/swagger/views/swagger-ui/index.html
```
# Requires GraalVM 22.2.0 + native-image

#### Installing with choco
```
choco install graalvm-java11
choco install visualstudio2017-workload-vctools
choco install vcredist2017

gu install native-image
```

#### Scan
In /build/libs run the following to scan
```
java -agentlib:native-image-agent=config-output-dir=META-INF/native-image -jar yauaa-example-0.1-all.jar
```

#### Build
In /build/libs run the following to build .exe
```
set USE_NATIVE_IMAGE_JAVA_PLATFORM_MODULE_SYSTEM=false
native-image -jar yauaa-example-0.1-all.jar
```
