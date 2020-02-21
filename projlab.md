Game class
Játékosokat tárol [3...n]
Pályát tárolja


Player class:
van (Energy) attribútuma, ami ha 4, kör vége, minden körnél reset
tárolja egy tömbben a nála lévő tárgyakat (Item[] Items)
látja a jégtáblát, amin áll (Tile currentTile)
látja a csapattársait(Player[] Team)
van testhő attribútuma (BodyTemp)
van Step(Tile) metódusa
van PickUp(Item) metódusa
van FallInWater() metódusa
	Tile hívja rajta
	megnézi, hogy van-e DivingSuite és van-e közelben csapattárs kötéllel (Rope)
van HasRope() metódusa
	vízbeesik() metódus hívja rajta, gondolom egyértelmű miért
Chill() metódus:
	BodyTemp--
EatFood() metódus:
	tárgyai közül egy kaja eltűnik, BodyTemp nő 1-gyel
AssembleFlare() metódus:
	ellenőrzi, hogy megvannak-e a darabok és hogy egy helyen állnak-e az emberek


Player classból leszármaz:
igluépítés és megnézés esetleg lehet a Játékos abstract metódusa, amit másképp overrideol a két leszármazott

Eskimo class:
(5 BodyTemp)
BuildIgloo(Tile):
	az adott jégtáblán lesz iglu
	Tile.setIgloo()

PolarExplorer class:
(4 testhő)
Examine(Tile):
	lekérdezi a teherbírását (WeightLimit)


Board class
Jégmezőket tárol(heterogén kollekció)
2d tömb? -- mivan ha nem 4 oldala van egy Tilenak?


Tile class
Snow attribútum (konstruktorban valami randomra inicializáljuk)
WeightLimit atribútum
Weight (hány van rajta) attribútum
ismeri az embereket, akik rajta állnak. Player[] players (lehet üres)
Tárgyakat tároló tömb (Item[] Items) -- Collection.pop kesobb
van egy StepInto() metódusa, amit egy Játékos objektum hív rajta, amikor rálép
	Weight++
	players.add(Player)
van Dig(Player) metódusa
	ellenőrzi, hogy a Játékos rajta áll-e
	megkérdezi a Játékostól, hogy van-e lapátja, majd Snow -1 vagy -2
SnowStorm() metódus:
	a rajta lévő emberek fázik() metódusát hívja(if van iglu, nem hívja)
	hómennyiség++
setIglu() metódus
getWieghtLimit() metódus
getWeight() -- De settergetter ne legyen felsorolva szerintem

Tile bol leszármaz:
StrongIce class:

Ice class:
StepInto() metódust overrideolja
	Weight++ és ellenőrzi, hogy átforduljon-e
Break() metódus:
	minden rajta lévő embert vízbe ejt

Water class:
StepInto() metódust overrideolja
	minden rajta állót vízbe ejt
WeightLimit mindig 0 (getter ezt adja vissza)

Item class:
kaja vagy pisztoly elem vagy rope

SnowStorm class:
tárolja, hogy mely jégtáblákon tombol épp(Jégtábla tömb)
Storm() metódus:
	a Jégtáblákon, amiket lát, meghívja a Storm() metódust
	

napló:
Kiss Andor 2020.02.12. 21:40-22:00
Kiss Andor 2020.02.13. 20:30-21:50
Lant Gábor 2020.02.21. 14.40-15.50 