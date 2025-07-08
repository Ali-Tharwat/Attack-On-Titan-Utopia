package game.engine.interfaces;

public interface Mobil
{
	double getDistance();

	void setDistance(double distance);

	double getSpeed();

	void setSpeed(double speed);

	default boolean hasReachedTarget() // returns true if arrived at the intended target
	{
		return getDistance() <= 0;
	}

	default boolean move() // returns true if arrived at the intended target
	{
		setDistance(getDistance() - getSpeed());
		return hasReachedTarget();
	}

}
