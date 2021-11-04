FROM openjdk:11
ENV artifact ${artifactid}-${version}.jar
COPY --from=1 /TimeSheetDevops/target/${artifact} /TimeSheetDevops/${artifact}
EXPOSE 8070
CMD ["java -jar ${artifact}"]
