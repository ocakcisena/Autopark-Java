import org.junit.Assert;
import org.junit.jupiter.api.Test;

class UnitTest1 {

	@Test
	void test() {
		RegularVehicle rg = new RegularVehicle(null);
		boolean x = rg.isSpecial();
		Assert.assertFalse(x);
	}

}
