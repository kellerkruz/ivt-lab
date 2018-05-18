package hu.bme.mit.spaceship;

/**
 * Created by meres on 5/17/18.
 */
public interface WeaponStore {
    public boolean fire(int numberOfShots);

    public boolean isEmpty();

    public int getAmmoCount();
}
