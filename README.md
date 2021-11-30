# Jeu de dames 

## Consigne
Un jeu de dames en mode console. Règles standard (https://fr.wikipedia.org/wiki/Dames). Le jeu pourra être à un joueur (contre une IA qui sera des mouvements aléatoires respectant les règles!) ou deux joueurs. 

Particularités : un nouveau fichier .txt sera généré à chaque partie, enregistrant tous les mouvements(Case départ et case arrivée), ainsi que l'état final du plateau. La façon dont les mouvements sont demandés au joueur est libre.

 Chaque joueur aura un pseudo(demandé en début de partie). Un fichier (format libre) de résultats reprenant les pseudos sera mis à jour à chaque partie avec les nombres de victoires et de défaites. Tout ce qui n'est pas imposé dans les instructions est libre.


## Principe du jeu de dames
Deux joueurs, le noir et le blanc, jouent sur un échiquier 8×8.
Chaque joueur dispose de 20 pions. Ils commencent la partie disposée sur les quatre lignes les plus proches du joueur respectif.

Les joueurs jouent à tour de rôle, les blancs commencent. Un pion ne peut se déplacer que d’une case, en diagonale vers l’avant (deux choix possibles). Lorsque l’une des deux cases en face d’un pion est occupée par un pion adverse, et qu’il y a une case libre derrière, le joueur peut prendre le pion adverse en le “sautant”, le pion est alors éliminé de l’échiquier.

## Mode de travail

Chaque membre du projet à participer à une tache différente.
Nous avons décidé de travailler essentiellement en local sur la même machine, ainsi qu'en live Share, ce qui explique les push d'un seul compte GitHub.

## Fonctionnalités
Lors de chaque partie un nouveau fichier texte est créée dans lequel sont inscrit tous les déplacements ainsi que l'état final du plateau.
Un fichier regroupe l'historique des gagnants de chaque partie.