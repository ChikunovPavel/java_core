FROM bellsoft/liberica-openjdk-alpine:16.0.1
COPY ./src ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d out src/Runer.java
CMD java -classpath ./out Runer