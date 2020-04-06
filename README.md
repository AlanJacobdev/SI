# Projet de synthèse en Si

Le but de ce projet étant le développement d’un langage spécifique pour des animations graphiques simples 

----------------

Le projet est découpé en **5 exercices** majeurs déclinés en plusieurs mineurs:

*  [Exercice 1 : Prise en main de la couche graphique](#Ex1)

*  [Exercice 2 : Première version d’un interpréteur de script](#Ex2)
  * [2.1 Script de configuration](#Ex21)
  * [2.2 Script d’animation](#Ex22)
  
* [Exercice 3 : Introduction des commandes](#Ex3)

* [Exercice 4 : Sélection et exécution des commandes](#Ex4)
  * [4.1 Référencement des objets et enregistrement des commandes](#Ex41)
  * [4.2 Ajout et suppression dynamique d’éléments graphiques](#Ex42)
  * [4.3 Ajouter des éléments a des conteneurs](#Ex43)
  
* [Exercice 5 :Eléments de base de notre langage à objet](#Ex5)

----------------

## Exercice 1 : Prise en main de la couche graphique<a id="Ex1"></a>

**Aucuns problèmes rencontrés**

Mise en place d'un cube circulant sur les bords de la fenêtre tout en changeant de couleur (*adaptation responsive*).


![GIF du cuve](https://alanjacob.fr/cube.gif)


----------------

## Exercice 2 : Première version d’un interpréteur de script<a id="Ex2"></a>

Début de l'interprétation de script (dites S-expression)

   ### 2.1 Script de configuration <a id="Ex2"></a>
   
   **Aucuns problèmes rencontrés**
   
   Ce script permet de modifier la couleur du conteneur principal nommé space et celle de robi.
   
     (script (space color black)(robi color yellow))
     
   Donnant ce résultat.
   
   ![GIF du cuve](https://alanjacob.fr/ex2.png)     

   ### 2.2 Script d’animation <a id="Ex2"></a>
   
   Compléter votre interpréteur pour permettre l’exécution du script suivant:
   
    (script (space color white)(robi color red) (robi translate 10 0)(space sleep 100)(robi translate 0 10)(space sleep 100)(robi translate -10 0)(space sleep 100)(robi translate 0 -10))
    
   * translate permet de déplacer avec un décalage en x et y passé en argument
   * sleep provoque une mise en sommeil pour un nombre de millisecondes passé en argument 
   
   
----------------

## Exercice 3 : Introduction des commandes<a id="Ex3"></a>

----------------

## Exercice 4 : Sélection et exécution des commandes<a id="Ex4"></a>

   ### 4.1 Référencement des objets et enregistrement des commandes <a id="Ex2"></a>
   ### 4.2 Ajout et suppression dynamique d’éléments graphiques <a id="Ex2"></a>
   ### 4.3 Ajouter des éléments a des conteneurs <a id="Ex2"></a>

----------------

## Exercice 5 :Eléments de base de notre langage à objet<a id="Ex5"></a>




