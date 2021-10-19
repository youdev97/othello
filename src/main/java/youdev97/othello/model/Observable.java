package youdev97.othello.model;

/**
 *
 * @author aro
 */
public interface Observable {

    public void registerObserver(Observer obs);

    public void removeObserver(Observer obs);

    public void notifyObservers();

}
