# Atelier 1 — Gestion des comptes bancaires

Spring Boot • REST • Swagger / OpenAPI • Spring Data REST • DTO • GraphQL

Dans ce dépôt, j'ai mis le code de mon TP, mon rapport et les captures d'écran de tous les tests que j'ai faits.

## Objectif

Le but de ce TP est de créer une application Spring Boot pour gérer des comptes bancaires, et d'essayer plusieurs manières de construire et tester une API : REST, OpenAPI/Swagger, Spring Data REST, DTO avec couche Service, et enfin GraphQL.

## Ce que j'ai fait

- Modélisation des comptes et accès aux données avec Spring Data JPA et la base H2.
- CRUD sur les comptes, testé dans le navigateur, avec Postman et avec Swagger.
- Spring Data REST avec les liens HATEOAS et une projection.
- Utilisation des DTO, d'une couche Service et de GraphQL (requêtes et mutations).

## Lancer le projet

1. Ouvrir le dossier `Code_Source/gestion-comptes` dans IntelliJ IDEA.
2. Charger le projet Maven et choisir Java 17.
3. Lancer la classe principale Spring Boot.
4. Les adresses que j'ai utilisées pour les tests :
   - API REST : `http://localhost:8080/api/comptes`
   - Swagger : `http://localhost:8080/swagger-ui/index.html`
   - GraphiQL : `http://localhost:8080/graphiql`
   - Spring Data REST : `http://localhost:8080/data-rest/comptes`

> Ces adresses peuvent changer selon la configuration du projet dans `gestion-comptes`.

## Ce que ça donne

- Consultation et création de comptes en REST, puis modification et suppression testées sur Postman.
- La documentation Swagger / OpenAPI s'affiche bien.
- La projection Spring Data REST et les opérations GraphQL marchent aussi (voir les captures).

Les captures montrent les tests qui ont réussi, mais elles ne prouvent pas que toutes les règles métier sont vérifiées.

## Captures d'écran

Il y a 35 captures dans le dossier `captures/`, chacune correspond à une étape ou à un test.

### 1. Préparation de l'environnement

Java 17 reconnu par Windows
![Java 17 reconnu par Windows](captures/01_Preparation/01_Java_17_detecte.png)

Javac 17 fonctionne
![Javac 17 fonctionne](captures/01_Preparation/02_Compilateur_Javac.png)

Maven n'est pas installé globalement, j'ai donc utilisé le Maven Wrapper
![Maven global non disponible ; Maven Wrapper utilisé](captures/01_Preparation/03_Verification_Maven.png)

Git reconnu par Windows
![Git reconnu par Windows](captures/01_Preparation/04_Git.png)

Postman installé
![Postman installé et accessible](captures/01_Preparation/05_Postman.png)

JAVA_HOME configuré
![JAVA_HOME configuré](captures/01_Preparation/06_Java_Home.png)

### 2. Initialisation du projet Spring Boot

IntelliJ IDEA ouvert
![IntelliJ IDEA ouvert](captures/02_Projet_Spring_Boot/01_IntelliJ.png)

Création du projet gestion-comptes
![Initialisation du projet gestion-comptes](captures/02_Projet_Spring_Boot/02_Configuration_initiale.png)

Les quatre dépendances choisies
![Les quatre dépendances sélectionnées](captures/02_Projet_Spring_Boot/03_Dependances.png)

Structure du projet
![Structure du projet Spring Boot](captures/02_Projet_Spring_Boot/04_Structure_Maven.png)

pom.xml corrigé, l'erreur XML a disparu
![pom.xml corrigé, erreur XML supprimée](captures/02_Projet_Spring_Boot/05_POM_corrige.png)

### 3. Entités et accès aux données

Création du package entities
![Création package entities](captures/03_Entites_DAO/01_Package_entities.png)

Classes Compte et TypeCompte
![Classes Compte et TypeCompte créées](captures/03_Entites_DAO/02_Classes_Compte_TypeCompte.png)

Repository JPA
![Repository JPA créé](captures/03_Entites_DAO/03_CompteRepository.png)

Trois comptes insérés puis lus dans H2
![Trois comptes insérés et lus dans H2](captures/03_Entites_DAO/04_Test_DAO_reussi.png)

### 4. API REST et tests avec Postman

Contrôleur REST (GET)
![Contrôleur REST GET](captures/04_API_REST_Postman/01_CompteController.png)

GET dans le navigateur, les trois comptes s'affichent
![GET navigateur, trois comptes](captures/04_API_REST_Postman/02_GET_navigateur.png)

GET sur Postman, 200 OK
![GET Postman, 200 OK](captures/04_API_REST_Postman/03_GET_Postman_200.png)

POST sur Postman, 201 Created, compte 4
![POST Postman, 201 Created, compte 4](captures/04_API_REST_Postman/04_POST_Postman_201.png)

PUT sur Postman, 200 OK, solde à 9000
![PUT Postman, 200 OK, solde 9000](captures/04_API_REST_Postman/05_PUT_Postman_200.png)

DELETE sur Postman, 204 No Content
![DELETE Postman, 204 No Content](captures/04_API_REST_Postman/06_DELETE_Postman_204.png)

GET après le DELETE : le compte 4 n'est plus là, le compte 5 est toujours présent
![GET après DELETE, compte 4 absent, compte 5 toujours présent](captures/04_API_REST_Postman/07_GET_apres_DELETE_200.png)

### 5. Documentation Swagger / OpenAPI

Ajout de la dépendance Swagger dans le pom.xml
![Dépendance Swagger ajoutée au pom.xml](captures/05_Swagger_OpenAPI/01_Dependance_springdoc_pom.png)

La documentation Swagger UI est accessible
![Documentation OpenAPI / Swagger UI accessible](captures/05_Swagger_OpenAPI/02_Swagger_documentation.png)

Essai de GET /api/comptes/200 (code HTTP 200, mais ça ne prouve pas qu'un compte a été trouvé)
![Essai GET /api/comptes/200 (HTTP 200, sans preuve de compte trouvé)](captures/05_Swagger_OpenAPI/03_Swagger_GET_par_id_200.png)

### 6. Spring Data REST

Liste des comptes avec les liens HAL, l'API Spring Data REST fonctionne
![Liste des comptes et liens HAL, API Spring Data REST disponible](captures/06_Spring_Data_REST/01_Liste_HATEOAS.png)

Projection resume : on récupère seulement l'id et le solde, avec les _links
![Projection resume : seulement id et solde, avec métadonnées _links](captures/06_Spring_Data_REST/02_Projection_ID_Solde.png)

### 7. DTO et mapping

POST avec les DTO : HTTP 201, solde 15000
![POST utilisant les DTOs : HTTP 201, solde 15000](captures/07_DTO_Mapper/01_POST_DTO_201_Created.png)

### 8. Couche service métier

POST via la couche Service : HTTP 201, solde 25000
![POST via la couche Service : HTTP 201, solde 25000](captures/08_Service_Metier/01_POST_Service_201_Created.png)

### 9. GraphQL (requêtes et mutations)

Interface GraphiQL sur localhost:8080/graphiql
![Interface GraphiQL accessible sur localhost:8080/graphiql](captures/09_GraphQL/01_GraphiQL_interface.png)

Query comptes : les 3 comptes avec id, solde, type et dateCreation
![GraphQL Query comptes : 3 comptes renvoyés avec id, solde, type et dateCreation](captures/09_GraphQL/02_Query_comptes_complets.png)

Query comptes : seulement id et solde
![GraphQL Query comptes : sélection id et solde uniquement](captures/09_GraphQL/03_Query_projection_champs.png)

Mutation creerCompte : compte 4 créé, solde 8000, type COURANT
![GraphQL Mutation creerCompte : création du compte 4 solde 8000 type COURANT](captures/09_GraphQL/04_Mutation_creerCompte.png)

Mutation modifierCompte : compte 1, nouveau solde 9500
![GraphQL Mutation modifierCompte : compte 1, solde 9500](captures/09_GraphQL/05_Mutation_modifierCompte.png)

Mutation supprimerCompte sur l'id 4 : renvoie true
![GraphQL Mutation supprimerCompte id 4 : true](captures/09_GraphQL/06_Mutation_supprimerCompte.png)

