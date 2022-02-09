# Installation

- cloner le dépôt
- sur rest.todo, choisir Properties, puis Java Build Path, puis libraries
- Add Jar -> rest.todo -> libs et sélectionner toutes les librairies
- Add Library -> Web App Libraries -> sélectionner rest.todos

# Lancer le client

- cd front
- npm install
- ng serve --open

# Creer la base de données local 

- installez Sqlite3
- ouvrez une nouvelle cmd à la racine du projet et éxecutez les lignes de commandes suivantes 
- sqlite3 HightTechDB.db (Création bd)
- sqlite3 HighTechDB.db .dump < HighTech.sql (Alimente la bd)
