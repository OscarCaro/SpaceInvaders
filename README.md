# TP-SpaceInvaders
First project for TP

## Controller.run() logic

1. Print game

2. Ask command

	- If move: Move UcmShip
	- If shoot: Create missile and place it on ucmShip's coordinates
	- If shockwave:	 
		1. Decrement enemies shields 
		2. Dheck for dead enemies (shield == 0)

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
		
