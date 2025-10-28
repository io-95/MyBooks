# MyBooks

**MyBooks** ist eine Software, die im Auftrag der **Engelhardt Softwareentwicklung GmbH** entwickelt wurde.

Die Anwendung ermöglicht es Nutzern, Bücher in einer Datenbank zu speichern.  
Auf der Landingpage werden alle Bücher angezeigt, die sich aktuell in der Datenbank befinden.

Ein Buch besitzt die Attribute: `ID`, `Titel`, `Autor`, `Erscheinungsjahr` und `ISBN`.

## Aufbau der Software

Die Software besteht aus einer **Frontend-** und einer **Backend-Komponente**.  
Das **Frontend** wurde mit `Angular` implementiert, das **Backend** mit `Spring Boot`.  
Als Datenbank wird die In-Memory-Datenbank `H2` verwendet.  
Zur Kommunikation zwischen Backend und Datenbank kommt `JPA/Hibernate` zum Einsatz.  
Die Kommunikation zwischen Frontend und Backend erfolgt über eine `REST API`, die in der Datei  
`Backend/MyBook_api.yml` näher beschrieben ist.

Beim Start des Backend-Servers werden automatisch Mock-Daten in die Datenbank geladen.  
Diese können bei Bedarf manuell über das Webinterface unter `http://localhost:8080/h2-console` gelöscht werden.

## Starten der Software

- **Frontend:** `npm install && ng serve`
- **Backend:** `./gradlew bootRun`

## Annmerkung

Als REST URL wurde `/api/v1/books` verwendet. Es wurde auch eine Versionsnummer hinzugefügt, um die API um sie nach aktuellem Best Practice zu designen.

## Bekannte Einschränkungen

Aufgrund von Zeitmangel konnten die Bonusaufgaben, die in der Datei  
`Fullstack Coding Challenge.pdf` definiert sind, nicht umgesetzt werden.

Bei den grundlegenden Funktionen besteht derzeit das Problem, dass im Frontend die Button-Click-Events  
nicht ausgelöst werden. Dadurch kann die Formularseite zum Anlegen eines neuen Buchs nicht über das UI erreicht werden.  
Sie ist jedoch direkt unter `http://localhost:4200/form` aufrufbar.  
Die Event-Bindings der Buttons auf der Formular Seite konnten ebenfalls nicht implementiert werden.
