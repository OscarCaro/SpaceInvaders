package tp.p1.model.gameElements;

public interface IAttack {
	default boolean performAttack(GameElements other) {return false;};
	default boolean receiveMissileAttack(int damage) {return false;};
	default boolean receiveSuperMissileAttack(int damage) {return false;};
	default boolean receiveBombAttack(int damage) {return false;};
	default boolean receiveSmartBombAttack(int damage) {return false;};
	default boolean receiveShockWaveAttack(int damage) {return false;};
	default boolean receiveExplosiveShipAttack(int damage) { return false;}
	default boolean receiveSniperAttack(int damage) { return false;}
}