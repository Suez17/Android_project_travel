# Android_project_travel

Prérequis pour faire fonctionner le projet "Trip With Me"

1. Lancer UWamp (ou WampServer).
2. Copier le dossier "TestBDAndroid" contenu dans le dossier "Projet TravelApp Android (Script PHP + SQL)" dans le repertoire
   "www" de Uwamp.
3. Dans ce même dossier éditer le fichier "init.php" pour renseigner le nom de la base de votre choix et les informations
   de connexion.
4. Ouvrez "phpMyAdmin" et créer une nouvelle base du même nom puis importer le fichier "travel_app.sql" contenu dans le dossier
   "Projet TravelApp Android (Script PHP + SQL)".
5. Dans le projet android, ouvrir la classe bddRequest/BackgroundTask.java puis modifier la ligne 48 pour mettre votre propre
   adresse IP --> "String destinationUrl = "http://192.168.1.11:80/testbdandroid/" + method + ".php";".
