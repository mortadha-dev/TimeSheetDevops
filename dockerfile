FROM openjdk:11
COPY --from=1 /app/target/${artifact} /app
EXPOSE 8070
CMD ["java -jar ${artifact}"]
