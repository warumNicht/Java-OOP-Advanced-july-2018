package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		// TODO: implement for problem 3

		Class<?>  currentUnitClass=Class.forName(UNITS_PACKAGE_NAME+unitType);
		Constructor<?> constructor=currentUnitClass.getDeclaredConstructor();
		Unit unit=(Unit)constructor.newInstance();
		return unit;

	}
}
