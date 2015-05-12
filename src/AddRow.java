import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class AddRow {

	private Text codArt;
	private Text numeArt;
	private Text pretArt;
	private Text tvaArt;
	private Text cantArt;

	int posY;

	private Shell shell;

	public AddRow(int nr, int posY) {
		shell = MainWindow.getShell();

		Label nrCrt = new Label(shell, SWT.NONE);
		nrCrt.setBounds(10, posY, 41, 21);
		nrCrt.setText(Integer.toString(nr));
		// Rectangle pozX = nrCrt.getBounds();

		codArt = new Text(shell, SWT.BORDER);
		codArt.setBounds(57, posY, 83, 21);
		codArt.setToolTipText("Codul articolului");

		numeArt = new Text(shell, SWT.BORDER);
		numeArt.setBounds(146, posY, 416, 21);
		numeArt.setToolTipText("Denumirea articolului");

		Label lblBuc = new Label(shell, SWT.NONE);
		lblBuc.setBounds(629, posY + 1, 28, 21);
		lblBuc.setText("BUC");

		pretArt = new Text(shell, SWT.BORDER);
		pretArt.setBounds(663, posY, 66, 21);
		pretArt.setToolTipText("Pretul de vanzare fara TVA");

		tvaArt = new Text(shell, SWT.BORDER);
		tvaArt.setBounds(735, posY, 68, 21);
		tvaArt.setToolTipText("Pretul de vanzare cu TVA");

		cantArt = new Text(shell, SWT.BORDER);
		cantArt.setBounds(568, posY, 55, 21);
	}

	public int codArt() {
		return Integer.parseInt(codArt.getText());
	}

	public String numeArt() {
		return numeArt.getText();
	}

	public double pretArt() {
		return Double.parseDouble(pretArt.getText());
	}

	public double tvaArt() {
		return Double.parseDouble(tvaArt.getText());
	}

	public int cantArt() {
		return Integer.parseInt(cantArt.getText());
	}

}
