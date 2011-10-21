package gui;

/**
 * Interfaz para los eventos que pueden ocurrir en un {@code BoardPanel}.
 */
public interface BoardPanelListener {

	/**
	 * Este método se invoca cuando el usuario hace clic en una celda.
	 */
	public void cellClicked(int row, int column);
	
	/**
	 * Este método se invoca cuando el usuario arrastra el contenido de una celda a otra.
	 */
	public void cellDragged(int sourceRow, int sourceColumn, int targetRow, int targetColumn);
}
