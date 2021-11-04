FROM openjdk:11
ENV artifact ${artifactid}-${version}.jar
COPY --from=1 /target/${artifact} /${artifact}
EXPOSE 8070
CMD ["java -jar ${artifact}"]
