# Projet "Banque" Application Client

---

## Prérequis

- Jdk version 18
- Apache Tomcat version 9.0.60

---

## Installation

### Dans le terminal de votre choix tapper les instructions suivante

- `git clone https://github.com/ZinedineFerrouk/kalbBanq.git`
- `cd kalbBank`

### Pour récupèrer toutes les branches du projet

- `git fetch -v --all`

---

### Ensuite ouvrez le projet dans IntelliJ afin de lancer le serveur

- Dans le fichier `pom.xml`, qui se trouve à la racine du projet changer le driver correspondant à votre type de BDD `(MySQL, PostgresSQL ...)`
- Vous trouverez votre driver sur le site [https://mvnrepository.com/](https://mvnrepository.com/)
- Exemple pour la liste des drivers MySQL [https://mvnrepository.com/artifact/mysql/mysql-connector-java](https://mvnrepository.com/artifact/mysql/mysql-connector-java)


- Installer un serveur Tomcat sur votre machine [https://tomcat.apache.org/download-90.cgi](https://tomcat.apache.org/download-90.cgi)
- Configurer le serveur dans `Edit Configuration`, modifier le navigateur, l'url et le port sur lequel vous voulez lancer le serveur.
- Dans l'onglet `Deployment` ajouter un artifact pour permettre le lancement du serveur. 

- Retourner dans IntelliJ et lancer le server interne Tomcat
- Suivre les étapes du README.md pour l'installation et le lancement de l'API en local et lancer l'API : [https://github.com/medericcareil/kalbbank-api/](https://github.com/medericcareil/kalbbank-api/)
- Au lancement du server le jeu de fausse de données se lancera automatiquement (Utilisation uniquement en phase de développement)

---
