     # Usa un'immagine di base con Java e JRE
     FROM openjdk:23-jdk-slim

     # Copia il file JAR nell'immagine
	 COPY ./BootJpaHibernate.jar /app/
	 COPY ./BootJpaHibernate-0.0.1-SNAPSHOT.rar /app/

     # Imposta la directory di lavoro
     WORKDIR /app

     # Comando per eseguire l'applicazione Spring Boot al momento dell'avvio del container
     CMD ["java", "-jar", "BootJpaHibernate.jar"]

