# Jeu de dames
## Consigne

Un jeu de dame en mode console. Règles standards (https://fr.wikipedia.org/wiki/Dames). Le jeu pourra être à un joueur (contre une IA qui sera des mouvements aléatoires-respectant les règles!) ou deux joueurs. Particularités : un nouveau fichier .txt sera généré à chaque partie, enregistrant tous les mouvements(case départ et case arrivée), ainsi que l'état final du plateau. La façon dont les mouvements sont demandés au joueur est libre. Chaque joueur aura un pseudo(demandé en début de partie). Un fichier (format libre) de résultats reprenant les pseudo sera mis à jour à chaque partie avec les nombres de victoires et de défaites. Tout ce qui n'est pas imposé dans les instructions est libre.

## Présentation



## Principe du jeu de dames

Deux joueurs, le noir et le blanc, jouent sur un échiquier 8×8.

Chaque joueur dispose de 20 pions. Ils commencent la partie disposés sur les quatres lignes les plus proches du joueur respectif.

Les joueurs jouent à tour de rôle, les blancs commencent. Un pion ne peut se déplacer que d’une case, en diagonal vers l’avant (deux choix possibles). Lorsque l’une des deux cases en face d’un pion est occupée par un pion adverse, et qu’il y a une case libre derrière, le joueur peut prendre le pion adverse en le “sautant”, le pion est alors éliminé de l’échiquier.

Lorsqu’un pion arrive sur la ligne opposée de l’échiquier, il est promu en dame. Une dame se comporte comme un pion, mais en plus elle peut se déplacer en arrière.