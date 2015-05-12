import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class ViewWindow {

	// ==================== 2. Instance Fields ============================

	private Shell shell;

	// ==================== 4. Constructors ===============================

	public ViewWindow() {

		shell = new Shell(Display.getCurrent());
		FillLayout fillLayout = new FillLayout();
		shell.setText("Vizualizare oferte");
		shell.setLayout(fillLayout);
		// optiunea de stergere item din tabel
		final Table tableView = new Table(shell, SWT.BORDER);
		Menu menu = new Menu(shell, SWT.POP_UP);
		tableView.setMenu(menu);
		MenuItem item = new MenuItem(menu, SWT.PUSH);
		item.setText("Sterge selectie");
		item.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				tableView.remove(tableView.getSelectionIndices());
			}
		});
		tableView.setLinesVisible(true);
		tableView.setHeaderVisible(true);
		TableColumn pozColumn = new TableColumn(tableView, SWT.BORDER);
		pozColumn.setText("Nr.Oferta");
		pozColumn.setWidth(62);
		pozColumn.setMoveable(true);
		pozColumn.setAlignment(SWT.CENTER);

		for (int i = 0; i < 50; i++) {
			TableItem items = new TableItem(tableView, 0);
			items.setText("Item " + i);
		}
		TableColumn nameOfColumn = new TableColumn(tableView, SWT.BORDER);
		nameOfColumn.setText("Nume oferta");
		nameOfColumn.setWidth(300);
		nameOfColumn.setMoveable(true);
		nameOfColumn.setAlignment(SWT.CENTER);

		TableColumn nameClientColumn = new TableColumn(tableView, SWT.BORDER);
		nameClientColumn.setText("Nume client");
		nameClientColumn.setWidth(300);
		nameClientColumn.setMoveable(true);
		nameClientColumn.setAlignment(SWT.CENTER);

		TableColumn dateCreatedColumn = new TableColumn(tableView, SWT.BORDER);
		dateCreatedColumn.setText("Data crearii");
		dateCreatedColumn.setWidth(171);
		dateCreatedColumn.setMoveable(true);
		dateCreatedColumn.setAlignment(SWT.CENTER);

		TableColumn dateModifiedColumn = new TableColumn(tableView, SWT.BORDER);
		dateModifiedColumn.setText("Data modificarii");
		dateModifiedColumn.setWidth(171);
		dateModifiedColumn.setMoveable(true);
		dateModifiedColumn.setAlignment(SWT.CENTER);

		// Listener paintListener = new Listener() {
		//
		// @Override
		// public void handleEvent(Event event) {
		// switch (event.type) {
		// case SWT.MeasureItem: {
		// TableItem items = (TableItem) event.item;
		// String text = getText(items, event.index);
		// Point size = event.gc.textExtent(text);
		// event.width = size.x;
		// event.height = Math.max(event.height, size.y);
		// break;
		// }
		// case SWT.PaintItem: {
		// TableItem items = (TableItem) event.item;
		// String text = getText(items, event.index);
		// Point size = event.gc.textExtent(text);
		// int offset2 = event.index == 0 ? Math.max(0,
		// (event.height - size.y) / 2) : 0;
		// event.gc.drawText(text, event.x, event.y + offset2, true);
		// break;
		// }
		// case SWT.EraseItem: {
		// event.detail &= ~SWT.FOREGROUND;
		// break;
		// }
		// }
		// }
		//
		// String getText(TableItem item, int column) {
		// String text = item.getText(column);
		// return text;
		//
		// }
		// };
		// tableView.addListener(SWT.MeasureItem, paintListener);
		// tableView.addListener(SWT.PaintItem, paintListener);
		// tableView.addListener(SWT.EraseItem, paintListener);
	}

	// ==================== 6. Action Methods =============================

	public void open() {
		shell.open();

	}

	public void close() {
		// Don't call shell.close(), because then
		// you'll have to re-create it
		shell.setVisible(true);
	}
}