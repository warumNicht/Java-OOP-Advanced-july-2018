package pr03Barracks1.core.factories;

import pr03Barracks1.contracts.Unit;
import pr03Barracks1.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr03Barracks1.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		// TODO: implement for problem 3
		String name=UNITS_PACKAGE_NAME+unitType;
		Class<?>  currentUnitClass=Class.forName(UNITS_PACKAGE_NAME+unitType);
		Constructor<?> constructor=currentUnitClass.getDeclaredConstructor();
		Unit unit=(Unit)constructor.newInstance();
		return unit;

	}
}
