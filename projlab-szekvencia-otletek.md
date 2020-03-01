sd init:
lehetne egy main, ami megkérdezi, hogy hány Eskimo és PolarExplorer játékos lesz
utána megkonstruálja a Game classt, a ctor feltölti a Players tömböt

sd kör:
game class egy loopban minden Player-t egymás után felszólít cselekvésvégzésre
ez megreferálja a következő szekvenciadiagrammot

sd cselekszik:
egy adott játékos lép, ás, stb függvényeket hív a Tile-n
Tile visszatér, játékos újra cselekszik
ezt 4 cselekvéssel eljátssza

sd lép:
Player Tile-ra lép, itt lehetne erről több szekvencia, hogy hogy kezelik le egyes jégtáblatípusok(stabil, instabil, lyuk) ezt
itt lehetne opt, hogy sarkkutató meg tudja nézni a jégtbla stabilitását(vagy valahogy ezt a képességét jelezni kéne a szekvenciákon, esetleg egy újat adni neki)
vízbeesés után Gamenek metódushívással szól, hogy Game over

sd ás:
altként jelezni, hogy van lapát, vagy nincs lapát
jégtábláról hó tűnik el

sd hóvihar:
valami osztály(mondjuk a game) konstruál egy hóvihart
hóvihar néhány jégtáblát hóval beborít, jégtáblán álló játékosok testhőjét csökkenti
itt lehetne opt, hogy ha igluban van a játékos, akkor nem fázik
ha valaki kihűl(testhő==0), Game over metódus itt is

sd pisztolytosszerak:
pisztolytosszerak metódust meghívja egy játékos magán, majd ez szól a Gamenak, hogy Game over(mondjuk egy metódushívással)
vagy ez akár lehet része a cselekszik sd-nek

Use-casekre szekvenciák:

sd lép:
controller hívja a player step metódusát
Player megkérdezi a tilet amin áll, hogy d directionben milyen tile van
Tile ad neki egy referenciát arról a tileről
Player hív egy tile.stepon(player) metódust, így a tile tudni fogja, hogy ki lépett rá
Ez a metódus hozzáadja a currentplayershez az aktuális playert az új tileon

sd examine tile:
controller hívja a player specialability() metódusát
Player megkérdezi a tilet amin áll, hogy d directionben milyen tile van
Tile ad neki egy referenciát arról a tileről
Player hív egy tile.examine() metódust
ez kiírja mondjuk stdoutra a tile teherbírását
(ezt a playernek nem kell eltárolni, elég ha csak a játékos látja-source:SB konzin)

sd build igloo:
controller hívja a player specialability() metódusát


Kiss Andor 2020.02.15 17:30-17:44
Lant Gabor 20202.02.21. 15.51-15.55