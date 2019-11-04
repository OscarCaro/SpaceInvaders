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

## GameElements Hierarchy

	- GameElements (Position + Shield + Game attribute + checkPos)
		- Ship (???)
			- UcmShip
			- EnemyShip (points)
				- UFO
				- AlienShip (alienCounter)
					- Carrier 
					- Destroyer
		- Weapon (???)
			- Bomb
			- Missile
			- ShockWave

## Controller.run() logic

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
		
