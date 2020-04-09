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

* [Bilan](#Bilan)

----------------

## Exercice 1 : Prise en main de la couche graphique

**Aucuns problèmes rencontrés**

Mise en place d'un cube circulant sur les bords de la fenêtre tout en changeant de couleur (*adaptation responsive*).


![GIF du cube](https://alanjacob.fr/cube.gif)


----------------

## Exercice 2 : Première version d’un interpréteur de script

Début de l'interprétation de script (dites S-expression)

   ### 2.1 Script de configuration 
   
   **Aucuns problèmes rencontrés**
   
   Ce script permet de modifier la couleur du conteneur principal nommé space et celle de robi.
   
     (script (space color black)(robi color yellow))
     
   Donnant ce résultat.
   
   ![IMG rendu fond noir | cube yellow](https://alanjacob.fr/ex2.png)     

   ### 2.2 Script d’animation 
   
   **Aucuns problèmes rencontrés**
    
   Compléter votre interpréteur pour permettre l’exécution du script suivant:
   
    (script (space color white)(robi color red) (robi translate 10 0)(space sleep 100)(robi translate 0 10)(space sleep 100)(robi translate -10 0)(space sleep 100)(robi translate 0 -10))
    
   * translate permet de déplacer avec un décalage en x et y passé en argument
   * sleep provoque une mise en sommeil pour un nombre de millisecondes passé en argument 
   
   Résultat : 
   
   ![GIF du cube](https://alanjacob.fr/ex22.gif)     
   
----------------

## Exercice 3 : Introduction des commandes

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

## Exercice 4 : Sélection et exécution des commandes

Intégration d'un interpreteur afin de créer une interaction avec l'utilisateur.

   ### 4.1 Référencement des objets et enregistrement des commandes 
   
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
      
   
   ### 4.2 Ajout et suppression dynamique d’éléments graphiques 
   
   **Problème de compréhension du NewImage et Add**
   
   Ajout d'une méthode AddElement et d'une méthode DelElement.
   
   Classes devenues universelles et gérées par les classes NewElement NewImage et NewString.
   
   Test d'erreurs renforcés.
   
   
   
   
   
   ### 4.3 Ajouter des éléments à des conteneurs 
   
   **Problème de compréhension du à l'ajout dans un GOval qui se verra inutile**
    
   **Problème des environnements afin de supprimer des élements sans récursivité**
   
   Adaptation des méthode AddElement et DelElement:
   
   * Ajout possible uniquement dans un GRect ou GSpace
   * Suppresion dans un GContainer
   
   Adaptation de l'interpreter permettant de gérer le dernier environnement de la référence 
   
	Par exemple, space.robi.momo, on ira chercher l'environnement de momo 
   
   ```java
   class Interpreter {

	public Expr compute(Environment env, ExprList expr) {
		if (expr.size() < 2)
			return null;

		String[] path = expr.get(0).getValue().split("\\.");
		Reference receiver = env.getReferenceByName(expr.get(0).getValue());

		
		// Récupération du dernier environnement
		
		for (int i = 0; i < path.length; i++) {
			receiver = env.getReferenceByName(path[i]);

			if (receiver.environment != null) {
				env = receiver.environment;
			} else if (i > path.length - 1) {
				return null;
			}

		}

		if (receiver == null) {
			return null;
		}

		return receiver.run(expr);
	}
}
   
   ```
   


   ### 4.4 Création et exécution de scripts 



## Bilan
