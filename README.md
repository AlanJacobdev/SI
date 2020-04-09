# Projet de synthèse en Si 

#### Auteur : Alan JACOB

Le but de ce projet étant le développement d’un langage spécifique pour des animations graphiques simples 

----------------

Le projet est découpé en **5 exercices** majeurs déclinés en plusieurs mineurs:

*  [Exercice 1 : Prise en main de la couche graphique](##exercice-1--prise-en-main-de-la-couche-graphique)

*  [Exercice 2 : Première version d’un interpréteur de script](#exercice-2--première-version-dun-interpréteur-de-script)
	* [2.1 Script de configuration](#21-script-de-configuration-)
  	* [2.2 Script d’animation](#22-script-danimation-)
  
* [Exercice 3 : Introduction des commandes](#exercice-3--introduction-des-commandes)

* [Exercice 4 : Sélection et exécution des commandes](#exercice-4--sélection-et-exécution-des-commandes)
  	* [4.1 Référencement des objets et enregistrement des commandes](#41-référencement-des-objets-et-enregistrement-des-commandes-)
  	* [4.2 Ajout et suppression dynamique d’éléments graphiques](#42-ajout-et-suppression-dynamique-déléments-graphiques-)
  	* [4.3 Ajouter des éléments a des conteneurs](#43-ajouter-des-éléments-à-des-conteneurs-)
  	* [4.4 Création et exécution de scripts](#44-création-et-exécution-de-scripts-)
  

----------------

## Exercice 1 : Prise en main de la couche graphique<a id="Ex1"></a>

**Aucuns problèmes rencontrés**

Mise en place d'un cube circulant sur les bords de la fenêtre tout en changeant de couleur (*adaptation responsive*).


![GIF du cube](https://alanjacob.fr/cube.gif)


----------------

## Exercice 2 : Première version d’un interpréteur de script<a id="Ex2"></a>

Début de l'interprétation de script (dites S-expression)

   ### 2.1 Script de configuration <a id="Ex21"></a>
   
   **Aucuns problèmes rencontrés**
   
   Ce script permet de modifier la couleur du conteneur principal nommé space et celle de robi.
   
     (script (space color black)(robi color yellow))
     
   Donnant ce résultat.
   
   ![IMG rendu fond noir | cube yellow](https://alanjacob.fr/ex2.png)     

   ### 2.2 Script d’animation <a id="Ex22"></a>
   
   **Aucuns problèmes rencontrés**
    
   Compléter votre interpréteur pour permettre l’exécution du script suivant:
   
    (script (space color white)(robi color red) (robi translate 10 0)(space sleep 100)(robi translate 0 10)(space sleep 100)(robi translate -10 0)(space sleep 100)(robi translate 0 -10))
    
   * translate permet de déplacer avec un décalage en x et y passé en argument
   * sleep provoque une mise en sommeil pour un nombre de millisecondes passé en argument 
   
   Résultat : 
   
   ![GIF du cube](https://alanjacob.fr/ex22.gif)     
   
----------------

## Exercice 3 : Introduction des commandes<a id="Ex3"></a>

**Aucuns problèmes rencontrés**

Mise en œuvre de l’interface Command ainsi que des classes correspondant aux commandes. utilisation de la méthode run de l'interface

```java
abstract public void run();
```

Script suivant :

    (script (space color cyan)(robi color blue)(space sleep 1000) (robi translate 10 0)(space sleep 100)(robi translate 0 10)(space sleep 100)(robi translate -10 0)(space sleep 100)(robi translate 0 -10) )

Résultat :  

   ![GIF du cube](https://alanjacob.fr/ex3.gif)    



----------------

## Exercice 4 : Sélection et exécution des commandes<a id="Ex4"></a>

Intégration d'un interpreteur afin de créer une interaction avec l'utilisateur.

   ### 4.1 Référencement des objets et enregistrement des commandes <a id="Ex41"></a>
   
   **Aucuns problèmes rencontrés**
   
   Ajout des classes Environment et Réference
   
   La commande run() de la classe Référence gérant les commandes à effectuer.
   
   ```java
   public Expr run(ExprList expr) {
        System.out.println(expr);
        Command cmd = getCommandByName(expr.get(1).getValue());
        cmd.run(receiver, expr);
        return expr;
	}
```
   Les classes n'étant toujours pas universelles et fixées à un objet.
      
   
   ### 4.2 Ajout et suppression dynamique d’éléments graphiques <a id="Ex42"></a>
   
   **Problème de compréhension du NewImage et Add**
   
   Ajout d'une méthode AddElement et d'une méthode DelElement.
   
   Classes devenues universelles et gérées par les classes NewElement NewImage et NewString.
   
   Test d'erreurs renforcés.
   
   
   
   
   
   ### 4.3 Ajouter des éléments à des conteneurs <a id="Ex43"></a>
   
   
   
   


   ### 4.4 Création et exécution de scripts <a id="Ex44"></a>




