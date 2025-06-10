# Foo Bar Quix – Kata Java Spring Boot

Ce projet est une implémentation du kata **Foo Bar Quix** en Java avec Spring Boot.  
Il fournit :
- Une API REST permettant de transformer un nombre selon des règles précises,
- Un batch déclenchable via une API qui lit un fichier texte et génère un fichier de sortie.

---

## Technologies utilisées

- Java 12
- Spring Boot
- Maven
- Spring Web

---

## Lancer l'application

### 1. Prérequis

- Java 21
- Maven 

### 2. Cloner le projet

```bash
git clone https://github.com/<nom utilisateur>/kata-foo-bar-quix.git
cd foo-bar-quix

4. Démarrer l'application
./mvnw spring-boot:run

API REST
Transformer un nombre
GET /api/transform/{0<=number<=100}
Exemples :

/api/transform/53 → BARFOO

/api/transform/15 → FOOBARBAR

Lancer le batch fichier lors du demarage de l'app
Lit le fichier : src/main/resources/input.txt

Produit le fichier : src/main/resources/output.txt


Exemple de transformation
Entrée	Résultat
3	     FOOFOO
5	     BARBAR
15	    FOOBARBAR
53	     BARFOO
33	     FOOFOOFOO