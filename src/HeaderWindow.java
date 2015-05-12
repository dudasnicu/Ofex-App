import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class HeaderWindow {

	private Shell shell;
	public Text denumTxt;
	public Text cuiTxt;
	public Text JTxt;
	public Text telTxt;
	public Text sediuTxt;
	public Text faxTxt;
	public Text mailTxt;
	public Text contBancTxt;
	public Text capSocTxt;

	public HeaderWindow() {
		shell = new Shell(Display.getCurrent());
		shell.setText("Editare antet");
		shell.setSize(600, 350);
		shell.setLayout(null);
		shell.setLocation(400, 200);

		Button saveButton = new Button(shell, SWT.NONE);
		saveButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String denTxt = denumTxt.getText();
				String codTxt = cuiTxt.getText();
				String jTxt = JTxt.getText();
				String tTxt = telTxt.getText();
				String sedTxt = sediuTxt.getText();
				String fTxt = faxTxt.getText();
				String mTxt = mailTxt.getText();
				String cbTxt = contBancTxt.getText();
				String csTxt = capSocTxt.getText();
			}
		});
		saveButton.setBounds(400, 279, 75, 25);
		saveButton.setText("Salveaza");
		saveButton.setToolTipText("Salveaza antet");

		Button exitButton = new Button(shell, SWT.NONE);
		exitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});
		exitButton.setBounds(481, 279, 75, 25);
		exitButton.setText("Inchide");
		exitButton.setToolTipText("Inchide antet");
		exitButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int style = SWT.ICON_QUESTION | SWT.YES | SWT.NO;
				MessageBox messageBox = new MessageBox(shell, style);
				if (denumTxt.toString() != "") {
					messageBox
							.setMessage("Doriti sa iesiti fara sa terminati antetul?");
					int rc = messageBox.open();
					switch (rc) {
					case SWT.YES:
						shell.close();
						System.out.println("SWT.YES");
						break;
					case SWT.NO:
						System.out.println("SWT.NO");
						break;
					}

				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		Label lblDenumireFirma = new Label(shell, SWT.NONE);
		lblDenumireFirma.setBounds(10, 10, 150, 21);
		lblDenumireFirma.setText("Denumire Firma/Furnizor:");

		Label lblCui = new Label(shell, SWT.NONE);
		lblCui.setBounds(10, 35, 150, 21);
		lblCui.setText("Codul de inregistrare fiscala:");

		Label lblJ = new Label(shell, SWT.NONE);
		lblJ.setBounds(10, 62, 150, 21);
		lblJ.setText("Nr.ord.registru com./an:");

		Label lblTelefon = new Label(shell, SWT.NONE);
		lblTelefon.setBounds(10, 89, 150, 21);
		lblTelefon.setText("Telefon:");

		Label lblSediu = new Label(shell, SWT.NONE);
		lblSediu.setBounds(10, 116, 150, 21);
		lblSediu.setText("Sediul:");

		Label lblFax = new Label(shell, SWT.NONE);
		lblFax.setBounds(10, 143, 150, 21);
		lblFax.setText("Fax:");

		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(10, 172, 150, 21);
		lblEmail.setText("E-mail:");

		Label lblContBancar = new Label(shell, SWT.NONE);
		lblContBancar.setBounds(10, 199, 150, 21);
		lblContBancar.setText("Cont bancar:");

		Label lblCapSocial = new Label(shell, SWT.NONE);
		lblCapSocial.setBounds(10, 226, 150, 21);
		lblCapSocial.setText("Capital social:");
		//
		// Label lblLogo = new Label(shell, SWT.NONE);
		// lblLogo.setBounds(10, 267, 86, 15);
		// lblLogo.setText("Poza logo firma:");

		denumTxt = new Text(shell, SWT.BORDER);
		denumTxt.setBounds(166, 10, 408, 21);

		cuiTxt = new Text(shell, SWT.BORDER);
		cuiTxt.setBounds(166, 37, 408, 21);

		JTxt = new Text(shell, SWT.BORDER);
		JTxt.setBounds(166, 64, 408, 21);

		telTxt = new Text(shell, SWT.BORDER);
		telTxt.setBounds(166, 91, 408, 21);

		sediuTxt = new Text(shell, SWT.BORDER);
		sediuTxt.setBounds(166, 116, 408, 21);

		faxTxt = new Text(shell, SWT.BORDER);
		faxTxt.setBounds(166, 143, 408, 21);

		mailTxt = new Text(shell, SWT.BORDER);
		mailTxt.setBounds(166, 172, 408, 21);

		contBancTxt = new Text(shell, SWT.BORDER);
		contBancTxt.setBounds(166, 199, 408, 21);

		capSocTxt = new Text(shell, SWT.BORDER);
		capSocTxt.setBounds(166, 226, 408, 21);

	}

	public void open() {
		shell.open();
	}

	public void close() {
		shell.setVisible(true);
	}
}
