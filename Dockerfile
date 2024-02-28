FROM openjdk:20-oracle
WORKDIR /app
COPY out/artifacts/student_records_jar/student_records.jar app.jar
CMD ["java", "-jar", "app.jar"]