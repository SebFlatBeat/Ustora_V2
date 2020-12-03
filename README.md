# Ustora - Bibliothèque

Ustora est une application pour la gestion des bibliothèques.


Le site web permettra aux usagers de suivre les prêts de leurs ouvrages. Ils pourront :

  - Rechercher des ouvrages et voir le nombre d’exemplaires disponibles.
  - Consulter leurs prêts en cours. Les prêts sont pour une période de 4 semaines.
  - Prolonger un prêt en cours. Le prêt d’un ouvrage n’est prolongeable qu’une seule fois. La prolongation ajoute une nouvelle période de prêt (4 semaines) à la période initiale.

la partie locigiel pour le personnel des bibliothèques permettra notamment de gérer les emprunts et les livres rendus. Un traitement batch permettra d’envoyer des mails de relance aux usagers n’ayant pas rendu les livres en fin de période de prêt. L’envoi est automatique à la fréquence d’un par jour.

# Description

Le projet a été fait avec l'IDE intelli J

Ustora est composé de 5 modules :
```sh
Un module : clientui
Deux modules : book
Deux modules : user
```

Api Gateway :
```sh
Zuul : zuul-server
```

Edge services utilisés :
```sh
  Spring-Cloud-Config : config-server
                Eureka : Eureka-server
                Ribbon
                Zipkin
                Spring-admin
```
### Installation

Depuis IntelliJ, importez le projet depuis GitHub

Une fois l'ensemble des modules importés, configurez le framework web.

Pour démarrer votre application correctement, voici les différentes étapes :

**Etape 1 : Zipkin** 
```sh
Vous avez deux possibilités.
Vous ouvrez le terminal de votre IDE et vous executez la commande suivante "java -jar yourPath/zipkin-server-2.6.1-exec.jar".
Ou depuis le panel gauche de IntelliJ, vous faites clique droit sur le fichier "zipkin-server-2.6.1-exec.jar" et vous choisissez "Run zipkin-server-2.6.1-exec.jar"
 ```
**Etape 2 : config-server** 
 ```sh
 Depuis l onglet "Services", vous selectionnez "ConfgServerApplication"
 Clique droit dessus et faites "Run"
  ```
  **Etape 3 : eureka** 
 ```sh
 Depuis l onglet "Services", vous selectionnez "EurekaApplication"
 Clique droit dessus et faites "Run"
  ```
  
  **Etape 4 : spring-admin** 
 ```sh
 Depuis l onglet "Services", vous selectionnez "SpringAdminApplication"
 Clique droit dessus et faites "Run"
  ```
  **Etape 5 : zuul-server** 
 ```sh
 Depuis l onglet "Services", vous selectionnez "ZuulServerApplication"
 Clique droit dessus et faites "Run"
  ```
**Etape 6 : book** 
 ```sh
 Depuis l onglet "Services", vous selectionnez "BookApplication(9002)" et "BookApplication(9022)"
 Clique droit dessus et faites "Run" pour chaque application
  ```
  **Etape 7 : user** 
 ```sh
 Depuis l onglet "Services", vous selectionnez "UserApplication(9003)" et "UserApplication(9033)"
 Clique droit dessus et faites "Run" pour chaque application
  ```
 **Etape 8 : clientui** 
 ```sh
 Depuis l onglet "Services", vous selectionnez "ClientuiApplication"
 Clique droit dessus et faites "Run"
  ```
  
  Maintenant rendez-vous sur localhost:/8095 pour accèder au site web
  
  Pour lancer les tests d'integration en CLI, il faut installer dans le dossier du projet l'outil developpé par Postman appelé Newman.
  
  Il faut donc faire dans le terminal la commande suivante :
  ```sh
  npm install -g newman
    ```
    ensuite faites la commande suivante pour executer les tests :
    ```sh
    newman run IntegrationTest.postman_collection.json
  ```
  
 
"# Ustora_V2" 
