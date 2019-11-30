# TP-SpaceInvaders
First project for TP

## ToDo List

- [x] Organize delegator methods of classes in parts
- [x] Make packages
- [x] Win game method
- [x] Level parser
- [x] Command subclasses parser methods should return new Object if that class has arguments 
- [x] Don't pass Controller controller to parse methods of command subclasses
- [ ] Fix exception in minDist to side if there are no destroyers remaining
- [x] Enum with directions (up, down, left, right)
- [x] Generalize method move(Direction dir, int num) in GameElem (only shockWave doesn't need it)
- [x] Generalize method checkPos and place it on GameElem (only shockWave doesn't need it)
- [ ] Add every "implements interface"  according with script with corresponding implementation of their 		functions
- [ ] Final in methods and classes that shouldn't be overwritten

## GameElements Hierarchy

	- GameElements (Position + Shield + Game attribute + checkPos)
		- Ship (???)
			- UcmShip
			- EnemyShip (points + receiveMissileAttack)
				- UFO
				- AlienShip (carr/dest movement + alienCounter + inBottomRow + receiveShockWaveAttack)
					- Carrier 
					- Destroyer
		- Weapon (???)
			- Bomb
			- Missile
			- SuperMissile
			- ShockWave
			
## Board.update() + CheckAttacks()
The order should be as follows:

Iterate the elements[] array, and for each gameElem, try to attack each other element in the array.
This method performAttack() is only defined on the gameElements that can attack (the weapons)
For the rest it just returns false.

PerformAttack:
Try to attack each other element. To do that, it checks if the position of the other is correct, 
and if so, it decreases the other's shield by DAMAGE constant, and its own shield is reduced to 0.
Notice that IT DOESN'T REMOVE THE OTHER OBJECT FROM THE ARRAY, NEITHER IT REMOVES ITSELF.
That's because removing from array is done at the end of the update() loop, calling removeDead(), 
to avoid nullPointerException when shifting list to the left when removing.
That is also the reason why only gameElems that are alive (shield > 0) can attack in the performAttack() 
function

## Shockwave
The user inputs the ShockWave command.
The ShockWaveCommand class calls game.useShockWave()
If the shock attribute of the player is true (it means it has killed an ufo previously),
a new ShockWave object if temporarily created.
The board class is in charge of calling the performAttackFromCommand of the shockwave for every
gameElem.
Once finished, the shockWave object is lost in memory (garbage collector) and the shock
attribute of player is set to false.
Notice that the shockWave object is never introduced in the elements[] array, neither the common
performAttack method is called, because this object is only alive for a brief moment (just to attack)

## OLD Controller.run() logic

1. Print game

2. Ask command

	- If move: Move UcmShip
	- If shoot: Create missile and place it on ucmShip's coordinates
	- If shockwave:	 
		1. Decrement enemies shields 
		2. Check for dead enemies (shield == 0) (including UFO)

3. Computer Action

	1. Ufo: if prob. -> create Ufo and place it out of board on right side
	2. Destroyer: For all valid destroyers in destroyerList:
		If canShoot = true && probab:
			- Shoot Bomb and place it at destroyer's coordinates
			- CanShoot = false (done in Bomb constructor
			
4. Update (ucmShip already moved in Ask Command Part)

	1. Move carriers and destroyers
	2. Ufo
		1. Move Ufo
		2. Check OutOfBoard -> remove Ufo
	3. Bombs:
		1. Move bombs down
		2. Check for collitions with:
			- UcmShip -> decrement shield + remove bomb
			- Missile -> remove missile + remove bomb
		3. Check for out of board -> remove bomb
	4. Missiles (if exists):
		1. Move missile up
		2. Check for collitions with:
			- Ufo -> decrement shield + remove missile
			- Carrier -> decrement shield + remove missile
			- Destroyer -> decrement shield + remove missile
			- Bomb -> remove bomb + remove missile
		3. Check Out of board -> remove missile
	5. Check for dead enemies (shield == 0) (including UFO)
		
