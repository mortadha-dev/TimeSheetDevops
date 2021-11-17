FROM openjdk:11
ENV artifact = Timesheet-spring-boot-core-data-jpa-mvc-REST-1-0.0.1-SNAPSHOT.jar
COPY --from=1 /target/${artifact} /${artifact}
EXPOSE 8070
CMD ["java -jar /${artifact}"]
