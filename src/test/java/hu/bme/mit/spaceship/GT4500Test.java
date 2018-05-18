package hu.bme.mit.spaceship;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class GT4500Test {

  private GT4500 ship;
  private WeaponStore mockStore1;
  private WeaponStore mockStore2;

  @Before
  public void init(){
    WeaponStore store1 = mock(TorpedoStore.class);
    WeaponStore store2 = mock(TorpedoStore.class);
    //WeaponStore store1 = new TorpedoStore(10);
    //WeaponStore store2 = new TorpedoStore(10);

    when(store1.fire(1)).thenReturn(true);
    when(store2.fire(1)).thenReturn(true);

    this.ship = new GT4500(store1, store2);
    this.mockStore1 = store1;
    this.mockStore2 = store2;
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange

    // Act
    boolean empty = false;
    while (!empty) {
      ship.fireTorpedo(FiringMode.SINGLE);
      empty = mockStore1.isEmpty() || mockStore2.isEmpty();
    }
    boolean result = verify(mockStore1, times(10)).fire(1);

    // Assert
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
  }

}
