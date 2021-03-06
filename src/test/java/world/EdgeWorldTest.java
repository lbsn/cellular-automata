package world;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.AbstractMap;
import org.junit.Before;
import org.junit.Test;

public class EdgeWorldTest {
	private World w = null;
	private int rows = 4;
	private int cols = 4;
	
	@Before
	public void init(){
		this.w = WorldBuilder.INSTANCE.makeWorld(
				this.rows, 
				this.cols, 
				WorldType.EDGE
				);
	}
	
	@Test
	public void testCheckCoordinates() {
		// Valid coordinates (2,3)
		AbstractMap.SimpleImmutableEntry<Integer, Integer> validCoordinates = 
				this.w.checkCoordinates(2, 3);
		AbstractMap.SimpleImmutableEntry<Integer, Integer> expected = 
				new AbstractMap.SimpleImmutableEntry<Integer, Integer>(2, 3);
		assertNotNull(validCoordinates);
		assertEquals(expected, validCoordinates);
		
		// Not valid coordinates (5,7)
		AbstractMap.SimpleImmutableEntry<Integer, Integer> notValidCoordinates = 
				this.w.checkCoordinates(5, 7);
		assertNull(notValidCoordinates);
	}

}
