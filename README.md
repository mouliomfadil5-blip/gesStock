# Lagerverwaltung REST API (gesStock)

Eine produktionsbereite Backend-Anwendung auf Basis von *Spring Boot 3* und *PostgreSQL* zur effizienten Verwaltung von Artikelbeständen. Das Projekt wurde nach einer professionellen Schichtenarchitektur (Controller-Service-Repository) entwickelt.

## Features & Architektur
* *Robustes Error-Handling:* Eigene Exceptions (ResourceNotFoundException) fangen Fehler ab und liefern saubere HTTP-Statuscodes (z.B. 404 Not Found) an den Client.
* *Automatisches Datenmapping:* Verwendung von Hibernate ORM zur nahtlosen Synchronisation von Java-Objekten mit der PostgreSQL-Datenbank.
* *Clean Code:* Strikte Trennung von Geschäftslogik (Service) und HTTP-Schnittstellen (Controller).

## Technologie-Stack
* *Java 21*
* *Spring Boot 3* (Spring Web, Spring Data JPA)
* *PostgreSQL* (Datenbank)
* *Maven* (Dependency Management)

## API-Endpunkte
* GET /DB/overview - Zeigt alle Artikel im System an
* GET /DB/{id} - Sucht einen spezifischen Artikel über die ID
* POST /DB/add - Legt einen neuen Artikel an
* PUT /DB/{id} - Aktualisiert die Daten eines bestehenden Artikels
* DELETE /DB/{id} - Löscht einen Artikel aus dem System
