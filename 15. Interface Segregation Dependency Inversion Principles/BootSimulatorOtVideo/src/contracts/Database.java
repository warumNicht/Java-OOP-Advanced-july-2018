package contracts;

public interface Database {
    CrudRepository<Boat> getBoats();

    CrudRepository<BoatEngine> getEngines();
}
