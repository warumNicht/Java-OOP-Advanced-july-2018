package pr03Barracks1;

import pr03Barracks1.contracts.Repository;
import pr03Barracks1.contracts.Runnable;
import pr03Barracks1.contracts.UnitFactory;
import pr03Barracks1.core.Engine;
import pr03Barracks1.core.factories.UnitFactoryImpl;
import pr03Barracks1.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
