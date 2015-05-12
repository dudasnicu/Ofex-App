import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MainWindow {

	private static Shell shell;
	private Text codArt;
	private Text numeArt;
	private Text pretArt;
	private Text tvaArt;
	private ViewWindow viewShell;
	private HeaderWindow headerShell;
	private Text text;
	private int nr = 1;

	private int posY = 0;
	private static ArrayList<AddRow> oferte;

	public static void main(String[] args) {

		oferte = new ArrayList<AddRow>();

		try {
			MainWindow window = new MainWindow();
			window.open();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		Display display = Display.getDefault();
		createMainContents();
		viewShell = new ViewWindow();
		headerShell = new HeaderWindow();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public static Shell getShell() {
		return shell;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createMainContents() {

		shell = new Shell();
		shell.setSize(1009, 530);
		shell.setText("Ofex");
		shell.setLayout(null);
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		// crearea meniurilor si submeniurilor
		MenuItem mntmMeniu = new MenuItem(menu, SWT.CASCADE);
		mntmMeniu.setText("Meniu");

		Menu menu_1 = new Menu(mntmMeniu);
		mntmMeniu.setMenu(menu_1);
		new MenuItem(menu_1, SWT.SEPARATOR);

		MenuItem mntmAdaugaOferta = new MenuItem(menu_1, SWT.PUSH
				| SWT.SEPARATOR);
		mntmAdaugaOferta.setText("Adauga oferta");
		new MenuItem(menu_1, SWT.SEPARATOR);

		MenuItem mntmVizualizareOferta = new MenuItem(menu_1, SWT.PUSH
				| SWT.SEPARATOR);
		mntmVizualizareOferta.setText("Vizualizare ofere");
		new MenuItem(menu_1, SWT.SEPARATOR);
		mntmVizualizareOferta.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					viewShell.open();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		MenuItem mntmIesireProgram = new MenuItem(menu_1, SWT.PUSH
				| SWT.SEPARATOR);
		mntmIesireProgram.setText("Iesire program");
		new MenuItem(menu_1, SWT.SEPARATOR);
		mntmIesireProgram.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int style = SWT.ERROR;

				MessageBox messageBox = new MessageBox(shell, style);
				messageBox.setMessage("Nu exista directorul C:\\Casyst\\ ");
				int rc = messageBox.open();

				switch (rc) {
				case SWT.YES:
					System.out.println("DA");
					System.exit(1);
					break;
				case SWT.NO:
					System.out.println("NU");
					break;
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		MenuItem mntmOptiuni = new MenuItem(menu, SWT.CASCADE);
		mntmOptiuni.setText("Optiuni");

		Menu menu_2 = new Menu(mntmOptiuni);
		mntmOptiuni.setMenu(menu_2);
		new MenuItem(menu_2, SWT.SEPARATOR);

		MenuItem mntmModificareAntet = new MenuItem(menu_2, SWT.PUSH
				| SWT.SEPARATOR);
		mntmModificareAntet.setText("Editare antet");
		new MenuItem(menu_2, SWT.SEPARATOR);
		mntmModificareAntet.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					headerShell.open();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		MenuItem mntmSetariAplicatie = new MenuItem(menu_2, SWT.PUSH
				| SWT.SEPARATOR);
		mntmSetariAplicatie.setText("Setari aplicatie");
		new MenuItem(menu_2, SWT.SEPARATOR);

		MenuItem mntmSalvareBD = new MenuItem(menu_2, SWT.PUSH | SWT.SEPARATOR);
		mntmSalvareBD.setText("Salvare baza de date");
		new MenuItem(menu_2, SWT.SEPARATOR);

		MenuItem mntmAjutor = new MenuItem(menu, SWT.CASCADE);
		mntmAjutor.setText("Ajutor");

		Menu menu_3 = new Menu(mntmAjutor);
		mntmAjutor.setMenu(menu_3);
		new MenuItem(menu_3, SWT.SEPARATOR);

		MenuItem mntmDespre = new MenuItem(menu_3, SWT.NONE);
		mntmDespre.setText("Despre");
		new MenuItem(menu_3, SWT.SEPARATOR);

		MenuItem mntmContact = new MenuItem(menu_3, SWT.NONE);
		mntmContact.setText("Contact");
		new MenuItem(menu_3, SWT.SEPARATOR);

		MenuItem mntmLicenta = new MenuItem(menu_3, SWT.NONE);
		mntmLicenta.setText("Licenta");
		new MenuItem(menu_3, SWT.SEPARATOR);

		MenuItem mntmActualizare = new MenuItem(menu_3, SWT.NONE);
		mntmActualizare.setText("Actualizare");
		new MenuItem(menu_3, SWT.SEPARATOR);
		// pana aici

		// labelurile principale
		Label lblPozitie = new Label(shell, SWT.NONE);
		lblPozitie.setBounds(10, 10, 41, 15);
		lblPozitie.setText("Pozitie");

		Label lblCodArticol = new Label(shell, SWT.NONE);
		lblCodArticol.setBounds(57, 10, 83, 15);
		lblCodArticol.setText("Cod articol");

		Label lblDenumireArticol = new Label(shell, SWT.NONE);
		lblDenumireArticol.setBounds(146, 10, 416, 15);
		lblDenumireArticol.setText("Denumire articol");

		Label lblUm = new Label(shell, SWT.NONE);
		lblUm.setBounds(629, 10, 28, 15);
		lblUm.setText("U.M.");

		Label lblPretNet = new Label(shell, SWT.NONE);
		lblPretNet.setBounds(663, 10, 66, 15);
		lblPretNet.setText("Pret net");

		Label lblPretTva = new Label(shell, SWT.NONE);
		lblPretTva.setBounds(737, 10, 66, 15);
		lblPretTva.setText("Pret + TVA");

		// Creeaza primul rand
		posY += 31;
		AddRow ar = new AddRow(nr, posY);
		nr++;

		// Label nrCrt = new Label(shell, SWT.NONE);
		// nr++;
		// nrCrt.setBounds(10, 31, 41, 21);
		// nrCrt.setText(Integer.toString(nr));
		// Rectangle pozX = nrCrt.getBounds();
		// Label nrCrtNou = new Label(shell, SWT.NONE);
		// int p = 21;
		// nrCrtNou.setBounds(10, 31 + p, 41, 21);
		// Rectangle pozY = nrCrtNou.getBounds();

		// editTexturile principale
		// codArt = new Text(shell, SWT.BORDER);
		// codArt.setBounds(57, 31, 83, 21);
		// codArt.setToolTipText("Codul articolului");
		//
		// numeArt = new Text(shell, SWT.BORDER);
		// numeArt.setBounds(146, 31, 416, 21);
		// numeArt.setToolTipText("Denumirea articolului");
		//
		// Label lblBuc = new Label(shell, SWT.NONE);
		// lblBuc.setBounds(629, 31, 28, 21);
		// lblBuc.setText("BUC");
		//
		// pretArt = new Text(shell, SWT.BORDER);
		// pretArt.setBounds(663, 31, 66, 21);
		// pretArt.setToolTipText("Pretul de vanzare fara TVA");
		//
		// tvaArt = new Text(shell, SWT.BORDER);
		// tvaArt.setBounds(735, 31, 68, 21);
		// tvaArt.setToolTipText("Pretul de vanzare cu TVA");
		//
		// text = new Text(shell, SWT.BORDER);
		// text.setBounds(568, 31, 55, 21);

		// butonul de adaugarea a unui nou articol
		Button addButton = new Button(shell, SWT.NONE);
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				posY += 31;
				AddRow ar = new AddRow(nr, posY);
				oferte.add(ar);
				nr++;
			}
		});
		addButton.setBounds(949, 27, 34, 25);
		addButton.setText("+");
		addButton.setToolTipText("Adauga articol");

		Label lblCantitate = new Label(shell, SWT.NONE);
		lblCantitate.setBounds(568, 10, 55, 15);
		lblCantitate.setText("Cantitate");

	}

	// crearea unui ferestre noi pentru vizualizarea ofertelor
	public void createViewContents(final Composite parent) {
		Display display = new Display();
		Shell shell = new Shell(display);
		viewShell = new ViewWindow();

		shell.pack();
		shell.open();
	}

	// crearea unei ferestre noi pentru modificarea antetului firmei
	public void createHeaderContents(final Composite parent) {
		Display display = new Display();
		Shell shell = new Shell(display);
		viewShell = new ViewWindow();

		shell.pack();
		shell.open();

	}

}
