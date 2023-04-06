FROM maven
WORKDIR /app
COPY pom.xml ./
RUN mvn dependency:resolve
COPY src ./src
CMD ["mvn", "clean", "test", "-Dsuite=${SUITE}"]