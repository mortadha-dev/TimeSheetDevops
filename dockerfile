FROM openjdk:11
COPY --from=1 /target/${artifact} /${artifact}
EXPOSE 8070
CMD ["java -jar ${artifact}"]
