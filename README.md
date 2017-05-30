# Huszonegy

## Leírás

A huszonegy nevű kártyajáték megvalósítása [Maven](https://maven.apache.org/)-nel, Java programozási nyelvben. A Projekt a [Debreceni Egyetem](https://www.inf.unideb.hu/) Programozási Környezetek kurzusrára készült.

## Használat

Készítsük el a `.jar` fájlt a következő parancscsal:

> mvn package

Ezután lépjünk be a target mappába:

> cd target

Majd a következő paranccsal futtassuk az elkészített jar fájunkkat:

> java -jar huszonegy-1.0-jar-with-dependencies.jar

## A játék menete

Először a Játékos kezd, megállásig húzza a lapokat.
Utána a Gép következik.
Majd ezután a program eldönti, hogy a Játékos, vagy a Gép nyert-e, és az eredményt a képernyőre írja.

## A program fordításához szükséges

> [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)

> [Apache Maven](https://maven.apache.org/) 3.0, vagy újabb verzió

## License

**Apache License, Version 2.0.**
